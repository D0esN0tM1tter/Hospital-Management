package com.jee.web.actions.document;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.jee.Models.Document;
import com.jee.business.facade.ApplicationFacade;
import com.jee.web.actions.AbstractAction;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class selectDocument extends AbstractAction {

    public selectDocument(ApplicationFacade facade) throws SQLException {
        super(facade);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, IOException {
        
        String IdParam = request.getParameter("documentId");

        if (IdParam == null || IdParam.isEmpty()) {
            return "/webapp/html/error.html";
        }

        try {
            int id = Integer.parseInt(IdParam); 
            facade.selectDocument(id); 
            return "";

        } catch (NumberFormatException e) {
            return "/webapp/html/error.html";
       }
       
      
    }

}
