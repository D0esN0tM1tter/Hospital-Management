package com.jee.web;

import java.io.IOException;

import com.jee.Models.Doctor;
import com.jee.business.models.CrudInterface;
import com.jee.business.models.DoctorBusiness;
import com.jee.dao.connection.MySQLDataSource;
import com.jee.dao.connection.SQLDataSource;
import com.jee.dao.manager.CrudInterfaceDao;
import com.jee.dao.manager.DoctorManager;
import com.jee.dao.manager.DocumentManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GestionDoctorServlet  extends HttpServlet{
private CrudInterface business;
	private CrudInterfaceDao dao;
   private  SQLDataSource ds;
	public void init() throws ServletException {
		  ds = new MySQLDataSource();
		dao = new DoctorManager(ds);
		business = new DoctorBusiness(dao);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.contains("sign in")) {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
            if(business.verify(login, password)) {
            	request.getRequestDispatcher("/jsp/homepage.jsp").forward(request, resp);

            }
            else {
            	request.getRequestDispatcher("/html/authenDoctorEror.html").forward(request, resp);
            }
		}
		else if ( uri.contains("sign up")) {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String name = request.getParameter("Firstname");
			String lastname = request.getParameter("Lastname");
			 Doctor d = new Doctor( lastname,name, login, password);
			business.insert(d);
			
		}		
			
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
