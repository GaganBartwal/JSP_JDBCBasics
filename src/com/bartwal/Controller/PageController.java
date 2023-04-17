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

        System.out.println("email : " +email +" : password : " +password);

        Connection connection = new MySQLDataServices().mySQLConnection();

        LinkedList<UserDataBusinessLogic> userDataList = new UserDAO().getUsersData(connection);

        System.err.println("userDataList: " +userDataList);

        Boolean isEmailCorrect = null;
        Boolean isPasswordCorrect = null;

        for(UserDataBusinessLogic userDataBusinessLogic : userDataList){

            isEmailCorrect = email.equals(userDataBusinessLogic.getUser_name());
            isPasswordCorrect = password.equals(userDataBusinessLogic.getUser_password());

        }

        if(isEmailCorrect && isPasswordCorrect){
            RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage.jsp");
            dispatcher.forward(request, response);
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }

    }

}
