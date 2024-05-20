package com.jee.web.actions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;

import com.jee.Models.Document;
import com.jee.business.facade.ApplicationFacade;


public class InsertFile extends Action {

    public InsertFile(ApplicationFacade facade) {
        super(facade);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            // Récupérer les paramètres du formulaire
            String patientIdStr = request.getParameter("patientId");
            String fileType = request.getParameter("fileType");
            Part filePart = request.getPart("fileUpload");
            String Descripyoon = request.getParameter("description") ;

            // Convertir patientId en entier
            int patientId = Integer.parseInt(patientIdStr);

            // Créer un nouvel objet Document avec les informations fournies
            Document document = new Document();
            document.setPatientId(patientId);
            document.setDocType(fileType);
            document.setPath(null); // Le chemin sera défini après le déplacement du fichier
            document.setToc(new Timestamp(System.currentTimeMillis()));
            document.setDescription(Descripyoon);
            String message = null ;

            // Appeler la méthode insertDocument pour déplacer le fichier et insérer les détails
            System.out.println(document);
            int result = facade.insertDocument(document, filePart);
            if (result > 0) {
            	message  = "File upload successful.." ;
            	request.setAttribute("message", message);
                return "insert.jsp"; // Retourner null pour indiquer que l'action s'est terminée avec succès
            } else {
                // En cas d'échec, ajouter un message d'erreur à la requête
                request.setAttribute("message", message);
                return "insert.jsp"; // Ou une autre page d'erreur selon votre configuration
            }

        } catch (IOException | ServletException | NumberFormatException e) {
            // En cas d'erreur, imprimer la trace de la pile et renvoyer un message d'erreur
            e.printStackTrace();
            request.setAttribute("messageerr", "File upload failed: " + e.getMessage());
            return "insert.jsp"; // Ou une autre page d'erreur selon votre configuration
        }
    }
}