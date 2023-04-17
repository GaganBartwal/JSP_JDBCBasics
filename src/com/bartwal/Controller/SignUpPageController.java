package com.bartwal.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpPageController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstname = (String) request.getAttribute("firstname");
        String lastname = (String) request.getAttribute("lastname");
        String gender = (String) request.getAttribute("gender");
        Integer age = (Integer) request.getAttribute("age");
        String bio = (String) request.getAttribute("bio");

        System.err.println(firstname+" : " +lastname+" : " +gender+" : " +age+" : " +bio);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WelcomePage.jsp");
        requestDispatcher.forward(request, response);

    }

}
