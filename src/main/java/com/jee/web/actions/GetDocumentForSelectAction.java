package com.jee.web.actions;

import java.util.List;

import com.jee.Models.Document;
import com.jee.business.facade.ApplicationFacade;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetDocumentForSelectAction extends Action{

	public GetDocumentForSelectAction(ApplicationFacade facade) {
		super(facade);
	}
@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	    try {
	    	System.out.println("dkhlna");
	        int patientId = Integer.parseInt(request.getParameter("patientId"));
	        if (patientId <= 0) {
	            throw new IllegalArgumentException("Le patientId doit être un nombre positif.");
	        }
	        
	        String type = request.getParameter("options");

	        List<Document> documents = facade.selectDocByIdAndType(patientId, type);
	        request.setAttribute("documents", documents);
	        return "Select.jsp";
	    } catch (NumberFormatException e) {
	        request.setAttribute("errorMessage", "Le patientId doit être un nombre entier.");
	        return "Eror404.html";
	    } catch (IllegalArgumentException e) {
	        request.setAttribute("errorMessage", e.getMessage());
	        return "Eror404.html";
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("errorMessage", "Une erreur s'est produite lors du traitement de la demande.");
	        return "Eror404.html";
	    }
}



	
	

}
