package com.bartwal.Controller;

import com.bartwal.BusinessLogic.UserDataBusinessLogic;
import com.bartwal.DAO.UserDAO;
import com.bartwal.Utilities.MySQLDataServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

public class PageController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Set the response headers to prevent caching
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0
        response.setHeader("Vary", "Cookie");
        response.setDateHeader("Expires", 0); // Proxies

        HttpSession session = request.getSession(true);

        if(session.getAttribute("email") != null){
            response.getWriter().write("success");
        }else{

            String email = request.getParameter("email");
            String password = request.getParameter("password");

            Connection connection = new MySQLDataServices().mySQLConnection();

            String filter = "user_name = ? and user_password = ?";

            Boolean isUser = new UserDAO().getValidated(connection, filter, email, password);

            System.err.println(email + " : " +isUser);

            if(isUser){
                session.setAttribute("email", email);
                session.setMaxInactiveInterval(60);

                response.getWriter().write("success");
            }else{
                response.getWriter().write("error");
            }

        }
    }

}
