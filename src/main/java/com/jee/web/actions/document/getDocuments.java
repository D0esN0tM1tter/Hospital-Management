package com.jee.web.actions.document;

import java.sql.SQLException;
import java.util.List;

import com.jee.Models.Document;
import com.jee.business.facade.ApplicationFacade;
import com.jee.web.actions.AbstractAction;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class getDocuments extends AbstractAction {

    public getDocuments(ApplicationFacade facade) throws SQLException {
        super(facade);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            // Retrieve and validate the patientId parameter
            String patientIdParam = request.getParameter("patientId");
            if (patientIdParam == null || patientIdParam.isEmpty()) {
                return "/webapp/html/error.html";
            }

            int patientId;

            try {
                patientId = Integer.parseInt(patientIdParam);
            } catch (NumberFormatException e) {
                return "/webapp/html/error.html";
            }

            // Retrieve and validate the type parameter
            String type = request.getParameter("type");
            if (type == null || type.isEmpty()) {
                return "/webapp/html/error.html";
            }

            // Call the facade method to get the documents
            List<Document> docs = facade.selectDocByIdAndType(patientId, type);

            // Set the documents as a request attribute
            request.setAttribute("documents", docs);

            // Return the view
            return "/webapp/views/selectedDocs.jsp";

        } finally {
        }
    }
}
