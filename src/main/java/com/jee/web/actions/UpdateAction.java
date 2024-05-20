package com.jee.web.actions;

import java.util.List;

import com.jee.Models.Document;
import com.jee.business.facade.ApplicationFacade;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateAction extends Action {

    public UpdateAction(ApplicationFacade facade) {
        super(facade);
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String patientIdStr = request.getParameter("patientId");
            if (patientIdStr == null || patientIdStr.isEmpty()) {
                return "error.html";
            }
            int patientId = Integer.parseInt(patientIdStr);

            String type = request.getParameter("options");
            String path = request.getParameter("path");

            List<Document> documents = facade.selectDocByIdAndType(patientId, type);

            request.setAttribute("documents", documents);
            request.setAttribute("path", path);

            return "AfterUpdate.jsp";
        } catch (NumberFormatException e) {
            return "error.html";
        }
    }

	
}
