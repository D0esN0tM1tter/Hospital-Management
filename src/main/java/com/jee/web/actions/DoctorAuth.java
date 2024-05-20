package com.jee.web.actions;

import com.jee.business.facade.ApplicationFacade;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoctorAuth extends Action {

    public DoctorAuth(ApplicationFacade facade) {
		super(facade);
		// TODO Auto-generated constructor stub
	}

	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("usernameOrEmail") ; 
        String password = request.getParameter("password"); 

        if (this.facade.authDoctor(login, password)) {
            return "home2.html" ; 
        }
        
        else {
            return "error.html";
        }
    }
	public Object select(int id) {
		return this.facade.selectDoctor(id) ;
	}

}
