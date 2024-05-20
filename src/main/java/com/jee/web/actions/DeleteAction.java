package com.jee.web.actions;

import com.jee.business.facade.ApplicationFacade;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteAction  extends Action{

	public DeleteAction(ApplicationFacade facade) {
		super(facade);
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int documentId = Integer.parseInt(request.getParameter("documentId"));
		try {
	      int i = facade.deleteDocument(documentId);
	      if ( i==1) {
	    	  return "succes.html";
	      }
	      else {
	    	  return "Eror404.html";
	      }
		}
		catch (Exception e) {
        return null;
}
	  
	}

	

}
