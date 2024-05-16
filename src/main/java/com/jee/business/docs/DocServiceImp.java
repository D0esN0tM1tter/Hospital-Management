package com.jee.business.docs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.List;

import com.jee.Models.Document;
import com.jee.dao.manager.DaoLogic;

import java.awt.Desktop;

public class DocServiceImp implements DocBusinessLogic {

    private DaoLogic docManager ;
    public DocServiceImp(DaoLogic docManager) {
        this.docManager = docManager;
    }

    @Override
    public Document selectDocument(int docId) throws FileNotFoundException, IOException {
        
        //1 : Retrieve document's path using its  Id
        Document doc = (Document) this.docManager.select(docId) ;
        String path = doc.getPath() ; 
        
        try {
            // Creating a file : 
            File file = new File(path) ; 
            //Open the file : 
            Desktop.getDesktop().open(file);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return doc ; 
    }

    @Override
    public int insertDocument(Document document) {
            try {
	        // Déclarer la variable target en dehors des blocs if/else if
	        java.nio.file.Path target = null;

	        // Déplacer le fichier vers le répertoire cible en fonction du type de document
	        java.nio.file.Path source = Paths.get(document.getPath());
            
	        if(document.getDocType().equals("report")) {
	            target = Paths.get(Directories.PDF_DIRECTORY, source.getFileName().toString());

	        } else if(document.getDocType().equals("imagery")) {
	            target = Paths.get(Directories.IMAGE_DIRECTORY, source.getFileName().toString());
                
	        } else if(document.getDocType().equals("measurements")) {
	            target = Paths.get(Directories.EXCEL_DIRECTORY, source.getFileName().toString());
	        }
	        
	        Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
	
	        // Dupliquer les '\' dans le chemin du fichier
	        String duplicatedPath = target.toString().replace("\\", "\\\\");
	        
	        // Mettre à jour le chemin du document avec le chemin dupliqué
	        document.setPath(duplicatedPath);
	        
	        // Vous pouvez également ajouter ici la logique pour insérer les détails du document dans la base de données
	        docManager.insert(document);

	        // Retourner un code de succès ou un identifiant de document inséré
	        System.out.println("document deplacé et inseré dans la base de données");
	        return 1; // Ou tout autre code de succès que vous préférez
	    } catch (IOException e) {
	        e.printStackTrace();
	        // Gérer les exceptions en cas d'échec du déplacement du fichier
	        return -1; // Ou tout autre code d'erreur que vous préférez
	    }
    
    }

    public  void updateDocument(int documentid, Document updatedDocument) throws SQLException {
		 
		String oldDocType = docManager.getDocumentType(documentid);
		if (oldDocType != null && oldDocType.equals(updatedDocument.getDocType())) {

            // here i m not sure if i have to do the delete method or not because in the next update i do delete the doc
            //  in that case it will be String oldFilePath = docManager.selectPath(documentid) and we should then add it to the CrudInterfaceDao
			String oldFilePath = docManager.delete(documentid);

			if (oldFilePath != null) {
				File fileToDelete = new File(oldFilePath);
				if (fileToDelete.exists() && fileToDelete.isFile()) {
					if (fileToDelete.delete()) {
						System.out.println("File deleted: " + oldFilePath);
					} else {
						System.out.println("Failed to delete file: " + oldFilePath);
					}
				} else {
					System.out.println("File not found: " + oldFilePath);
				}
				docManager.updateDocument(documentid, updatedDocument);
			} else {
				System.out.println("File path not found for  ID: " + documentid );
			}
		} else {
			System.out.println("Updated document type does not match the type of the oldest document.");
		}
}

    public int deleteDocument(int docId) throws SQLException {
        // 1: Delete the file from the database : 
        String path = this.docManager.delete(docId) ; 
        // 2 : Delete file from the local drive : 
        File fileToDelete = new File(path) ; 

        if (fileToDelete.exists() && fileToDelete.isFile()) {
            if (fileToDelete.delete()) {
                System.err.println("File deleted successfully");
                return 1 ; 
            }
        }

        System.err.println("Failed to delete file ");
        return -1 ;
    }

	
    public List<Document> selecByPidAndType(int patientId, String docType){
    	 return this.docManager.selecByPidAndType(patientId, docType);
    }
   
}
