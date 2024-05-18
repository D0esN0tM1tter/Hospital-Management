package com.jee.web.actions.doctor;

import java.sql.SQLException;

import com.jee.business.facade.ApplicationFacade;
import com.jee.web.actions.Action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddAction extends Action {

    

    public AddAction(ApplicationFacade facade) throws SQLException {
        super(facade);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        String name = request.getParameter("name");
        String fname = request.getParameter("firstname");

    }

}
