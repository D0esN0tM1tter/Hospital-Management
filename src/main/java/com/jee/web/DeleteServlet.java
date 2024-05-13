package com.jee.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jee.Models.Document;
import com.jee.business.docs.DocServiceImp;
import com.jee.business.docs.DocumentService;
import com.jee.dao.connection.MySQLDataSource;
import com.jee.dao.connection.SQLDataSource;
import com.jee.dao.manager.CrudInterfaceDao;
import com.jee.dao.manager.DocumentManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {
    private DocumentService docservice;
    private CrudInterfaceDao docdao;
    private SQLDataSource ds;

    public void init() throws ServletException {
        ds = new MySQLDataSource();
        docdao = new DocumentManager(ds);
        docservice = new DocServiceImp(docdao);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("form")) {
            int patientId = Integer.parseInt(request.getParameter("patientId"));
            String type = request.getParameter("type");

            List<Document> documents = new ArrayList<>();
            try {
                documents = docservice.selecByPidAndType(patientId, type); // Corrected method call
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("documents", documents);
            request.getRequestDispatcher("/WEB-INF/views/delete.jsp").forward(request, response);

        } else if (uri.contains("bouton")) {
            int documentId = Integer.parseInt(request.getParameter("documentId"));
            try {
                docservice.deleteDocument(documentId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("documents");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
