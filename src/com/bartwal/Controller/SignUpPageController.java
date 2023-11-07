package com.bartwal.Controller;

import com.bartwal.DAO.UserDAO;
import com.bartwal.Utilities.MySQLDataServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SignUpPageController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Connection connection = new MySQLDataServices().mySQLConnection();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String gender =  request.getParameter("gender");
        Date DOB = Date.valueOf(request.getParameter("dob"));
        String bio = request.getParameter("bio");

        String filter = "user_name = ?";

        Boolean isUserExists = new UserDAO().getUserExists(connection, filter, email);

        if(isUserExists){
            response.getWriter().write("exists");
        }else{
            response.getWriter().write("success");
            new UserDAO().setUserData(connection, email, password, firstname, lastname, gender, DOB, bio);

            System.err.println(firstname+" : " +lastname+" : " +gender+" : " +DOB+" : " +bio);
        }

    }
}
