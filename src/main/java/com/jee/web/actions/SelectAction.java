package com.jee.web.actions;

import com.jee.Models.Document;
import com.jee.business.facade.ApplicationFacade;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SelectAction  extends Action{

	public SelectAction(ApplicationFacade facade) {
		super(facade);
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int documentId = Integer.parseInt(request.getParameter("documentId"));
		try {
	      Document d = facade.selDocument(documentId);
	      if ( d!=null) {
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
