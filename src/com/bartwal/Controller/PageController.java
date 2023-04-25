package com.bartwal.Controller;

import com.bartwal.BusinessLogic.UserDataBusinessLogic;
import com.bartwal.DAO.UserDAO;
import com.bartwal.Utilities.MySQLDataServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.LinkedList;

public class PageController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

//        System.out.println("email : " +email +" : password : " +password);

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
