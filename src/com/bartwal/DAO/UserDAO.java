package com.bartwal.DAO;

import com.bartwal.BusinessLogic.UserDataBusinessLogic;
import com.bartwal.Utilities.MySQLDataServices;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class UserDAO {

    public LinkedList<UserDataBusinessLogic> getUsersData(Connection connection){

        UserDataBusinessLogic userDataBusinessLogic = new UserDataBusinessLogic();

        LinkedList<UserDataBusinessLogic> userDataList = new LinkedList<>();

        String query = "SELECT * FROM user_authentication";

        try{

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){

                Integer user_id = resultSet.getInt("user_id");
                String user_name = resultSet.getString("user_name");
                String user_password = resultSet.getString("user_password");
                String user_firstname = resultSet.getString("user_firstname");
                String user_lastname = resultSet.getString("user_lastname");
                String user_dob = resultSet.getString("user_dob");
                String user_gender = resultSet.getString("user_gender");

                userDataBusinessLogic.setUser_id(user_id);
                userDataBusinessLogic.setUser_name(user_name);
                userDataBusinessLogic.setUser_password(user_password);
                userDataBusinessLogic.setUser_firstname(user_firstname);
                userDataBusinessLogic.setUser_lastname(user_lastname);
                userDataBusinessLogic.setUser_dob(user_dob);
                userDataBusinessLogic.setUser_gender(user_gender);

                userDataList.add(userDataBusinessLogic);

            }


        }catch(Exception e){
            e.printStackTrace();
        }

        return userDataList;
    }



}
