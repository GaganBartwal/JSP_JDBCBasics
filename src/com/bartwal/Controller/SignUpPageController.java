package com.bartwal.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SignUpPageController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String gender =  request.getParameter("gender");
        Date age = null;
        try {
            age = dateFormat.parse(request.getParameter("dob"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String bio = request.getParameter("bio");

        System.err.println(firstname+" : " +lastname+" : " +gender+" : " +age+" : " +bio);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WelcomePage.jsp");
        requestDispatcher.forward(request, response);

    }
}
