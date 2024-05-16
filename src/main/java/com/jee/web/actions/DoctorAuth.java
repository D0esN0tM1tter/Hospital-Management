package com.jee.web.actions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoctorAuth extends Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login") ; 
        String password = request.getParameter("password"); 

        if (this.facade.verifyAdmin(login, password)) {
            return "/webapp/views/home.html" ; 
        }

        else {
            return "/webapp/views/AuthError.html";
        }
    }

}
