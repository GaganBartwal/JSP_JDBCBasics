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
import java.util.LinkedList;

public class PageController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if(session.getAttribute("email") != null && session.getAttribute("password") != null){
            response.getWriter().write("success");
        }else{
            session = request.getSession(true);

            String email = request.getParameter("email");
            String password = request.getParameter("password");

            if(email != null && password != null){
                session.setAttribute("email", email);
                session.setAttribute("password", password);
                session.setMaxInactiveInterval(60);
            }
            System.out.println("email : " +email +" : password : " +password);

            Connection connection = new MySQLDataServices().mySQLConnection();

            String filter = "user_name = ? and user_password = ?";

            Boolean isUser = new UserDAO().getValidated(connection, filter, email, password);

            System.err.println(email + " : " +isUser);

            if(isUser){
                response.getWriter().write("success");
            }else{
                response.getWriter().write("error");
            }

        }


    }

}
