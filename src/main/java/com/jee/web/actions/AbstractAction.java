package com.jee.web.actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.jee.business.facade.ApplicationFacade;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class AbstractAction {

    protected ApplicationFacade facade;

    public AbstractAction(ApplicationFacade facade) throws SQLException {
        this.facade = new ApplicationFacade();
    }

    public abstract String execute(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, IOException;

}
