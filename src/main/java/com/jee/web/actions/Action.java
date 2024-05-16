package com.jee.web.actions;

import com.jee.business.facade.ApplicationFacade;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class Action {

    protected ApplicationFacade facade;

    public abstract String execute(HttpServletRequest request, HttpServletResponse response);

}
