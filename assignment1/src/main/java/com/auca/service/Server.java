package com.auca.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Server extends HttpServlet {
	String Email, password;
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String Email = req.getParameter("email");
        String password = req.getParameter("password");

        
        if ("Mutezintare".equals(Email) && "webtec".equals(password)) {
            try {
            	HttpSession session = req.getSession(true);
            	session.setAttribute("email", Email);
                res.sendRedirect("admission.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
           
            res.sendRedirect("ForgetPassword.html"); 
        }
    }

}
