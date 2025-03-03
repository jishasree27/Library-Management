package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.*;
import org.hibernate.Transaction;

import com.dao.Dao;
import com.pojo.Emp;
import com.session.SessionProvider;

/**
 * Servlet implementation class DeleteServlet
 */

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  public DeleteServlet() {
	        super();
	    }
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    int empId = Integer.parseInt(request.getParameter("id"));
		    Dao dao = new Dao();
		    dao.delete(empId);
		    List<Emp> empList = dao.getAllUsers();
		    request.setAttribute("empList", empList);
		    RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
		    rd.forward(request, response);
		}


	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }
	}      
