package com.jee.web.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.jee.business.facade.ApplicationFacade;
import com.jee.web.actions.Action;
import com.jee.web.actions.AfterUpdateAction;
import com.jee.web.actions.DeleteAction;
import com.jee.web.actions.DoctorAuth;
import com.jee.web.actions.GetDocumentForDeleteAction;
import com.jee.web.actions.GetDocumentForSelectAction;
import com.jee.web.actions.InsertFile;
import com.jee.web.actions.SelectAction;
import com.jee.web.actions.UpdateAction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@MultipartConfig
public class ActionServlet extends HttpServlet {
    private ApplicationFacade facade;
    private Map<String, Action> actions;

    public void init() throws ServletException {
        try {
            facade = new ApplicationFacade();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        actions = new HashMap<>();
        actions.put("AuthentificationDocto", new DoctorAuth(facade));
        actions.put("upload", new InsertFile(facade));
        
		actions.put("ListerDocumentForDelete", new GetDocumentForDeleteAction(facade));
		actions.put("ListerDocumentForSelect", new GetDocumentForSelectAction(facade));

		actions.put("DeleteDocument", new DeleteAction(facade));
		actions.put("SelectDocument", new SelectAction(facade));

        actions.put("UpdateAction", new UpdateAction(facade));
        actions.put("AfterUpdateAction", new AfterUpdateAction(facade));

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("dkhlna doget");
        String uri = req.getRequestURI();
        System.out.println(uri);
        int x = uri.lastIndexOf('/');
        int y = uri.lastIndexOf(".do");
        String key = uri.substring(x + 1, y);
        Action action = actions.get(key);
        System.out.println("action : " + action.getClass().getSimpleName());
        String view = action.execute(req, resp);
		req.getRequestDispatcher(view).forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
