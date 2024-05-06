package com.jee.business.docs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;

import com.jee.Models.Document;
import com.jee.dao.manager.CrudInterfaceDao;
import com.jee.dao.manager.DocumentManager;

import java.awt.Desktop;

public class DocServiceImp implements DocumentService {

    private CrudInterfaceDao docManager ;
    private Directories directories ;
    
    public DocServiceImp(DocumentManager docManager) {
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
	            target = Paths.get(directories.PDF_DIRECTORY, source.getFileName().toString());

	        } else if(document.getDocType().equals("imagery")) {
	            target = Paths.get(directories.IMAGE_DIRECTORY, source.getFileName().toString());
                
	        } else if(document.getDocType().equals("measurements")) {
	            target = Paths.get(directories.EXCEL_DIRECTORY, source.getFileName().toString());
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

    @Override
    public int updateDocument(int docId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateDocument'");
    }

    @Override
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

}
