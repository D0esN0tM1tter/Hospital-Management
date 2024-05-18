package com.jee.web.actions;

import java.sql.SQLException;

import com.jee.business.facade.ApplicationFacade;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class Action {

    protected ApplicationFacade facade;

    public Action(ApplicationFacade facade) throws SQLException {
        this.facade = new ApplicationFacade();
    }

    public abstract String execute(HttpServletRequest request, HttpServletResponse response);

}
