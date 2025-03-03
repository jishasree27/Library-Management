package com.servlet;
import java.util.List;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Dao;
import com.pojo.Emp;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Servlet implementation class servletpage
 */

public class servletpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private Map<String, Emp> hello = new HashMap<>();

    /**
     * Default constructor. 
     */
    public servletpage() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("inside get");
		Dao dao=new Dao();
		List<Emp> empList=dao.getAllUsers();
		request.setAttribute("empList", empList);
		request.setAttribute("name", "hello");
		RequestDispatcher rs=request.getRequestDispatcher("view.jsp");
		rs.forward(request, response);
		
        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
    public static final String ACCOUNT_SID = "AC293281e16ad2126888a97c32d9660005";
    public static final String AUTH_TOKEN = "15abee44bb7fe440f9391b0015c908ce";
    public static final String TWILIO_PHONE_NUMBER = "+12184964658";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Inside doPost");

        String name = request.getParameter("uname");
        String dept = request.getParameter("udept");
        String clg = request.getParameter("uclg");  // Ensure this parameter is included in the form
        String phone = "+91" + request.getParameter("uphone");

        System.out.println("Phone Number: " + phone);
        System.out.println("Name: " + name);
        System.out.println("Dept: " + dept);
        System.out.println("College: " + clg);

        // Create Emp object to insert into the database
        Emp emp = new Emp();
        emp.setName(name);
        emp.setDept(dept);
        emp.setClg(clg);

        // Insert the record into the database first
        Dao dao = new Dao();
        boolean isInserted = dao.insert(emp);

        if (isInserted) {
            System.out.println("User inserted successfully.");

            // Format date and time for SMS
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);

            try {
                Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                Message message = Message.creator(
                        new PhoneNumber(phone),  
                        new PhoneNumber(TWILIO_PHONE_NUMBER),
                        "Library Attendance Confirmation\n" +
                                "Hello " + name + ",\n" +
                                "Your attendance is recorded.\n" +
                                "Date & Time: " + formattedDateTime + "\n" +
                                "Dept: " + dept + "\n" +
                                "Happy Reading!")
                        .create();

                System.out.println("SMS sent successfully. SID: " + message.getSid());
                response.sendRedirect("index.html"); // Redirect after success
            } catch (Exception e) {
                System.err.println("Error sending SMS: " + e.getMessage());
                e.printStackTrace();
                response.sendRedirect("error.html"); // Handle SMS failure
            }
        } else {
            System.out.println("Failed to insert user into the database.");
            response.sendRedirect("error.html"); // Handle DB failure
        }
    }

}



   

