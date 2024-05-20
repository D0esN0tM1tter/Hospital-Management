package com.jee.web.actions;

import com.jee.business.facade.ApplicationFacade;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AfterUpdateAction  extends Action{

	public AfterUpdateAction(ApplicationFacade facade) {
		super(facade);
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int documentId = Integer.parseInt(request.getParameter("documentId"));
        String path = request.getParameter("path");

		try {
	    facade.updateDocument(documentId, path);
		}
		catch (Exception e) {
            e.printStackTrace(); 
            return "error.html"; 
}
	   return "succes.html";
	}

	

}