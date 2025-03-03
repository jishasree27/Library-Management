package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Dao;
import com.pojo.Emp;

import java.io.IOException;

public class UpdateServlet extends HttpServlet {

	    private static final long serialVersionUID = 1L;

	    // Fetch user for updating
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String id = request.getParameter("id");
	        System.out.println("Fetching user with ID: " + id);

	        if (id != null && !id.isEmpty()) {
	            try {
	                int userId = Integer.parseInt(id);
	                Dao empDao = new Dao();
	                Emp user = empDao.getUserById(userId);

	                if (user != null) {
	                    request.setAttribute("user", user);
	                    RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
	                    rd.forward(request, response);
	                } else {
	                    System.out.println("User with ID: " + userId + " not found.");
	                    response.sendRedirect("error.html");
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid ID format");
	                response.sendRedirect("error.html");
	            }
	        } else {
	            System.out.println("ID is required for updating");
	            response.sendRedirect("error.html");
	        }
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        System.out.println("Update page");

	        String id = request.getParameter("id");
	        String name = request.getParameter("name");
	        String dept = request.getParameter("dept");
	        String clg = request.getParameter("clg");

	        if (id != null && !id.isEmpty()) {
	            try {
	                int empId = Integer.parseInt(id);

	                Emp updatedEmp = new Emp();
	                updatedEmp.setId(empId);
	                updatedEmp.setName(name);
	                updatedEmp.setDept(dept);
	                updatedEmp.setClg(clg);

	                Dao empDao = new Dao();
	                empDao.update(updatedEmp);

	                response.sendRedirect("success.html");
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid ID format");
	                response.sendRedirect("error.html");
	            }
	        } else {
	            System.out.println("ID is required for updating");
	            response.sendRedirect("error.html");
	        }
	    }
	}
