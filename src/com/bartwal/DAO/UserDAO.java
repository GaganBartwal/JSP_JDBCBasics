package com.bartwal.DAO;

import com.bartwal.BusinessLogic.UserDataBusinessLogic;

import java.sql.*;
import java.util.LinkedList;

public class UserDAO {

    public void setUserData(Connection connection, String email, String password, String firstname, String lastname, String gender, Date dob, String bio){

        String query = "INSERT INTO user_authentication(user_name, user_password, user_firstname, user_lastname, user_dob, user_gender, user_bio) VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, email);
            statement.setString(2, password);
            statement.setString(3, firstname);
            statement.setString(4, lastname);
            statement.setDate(5, dob);
            statement.setString(6, gender);
            statement.setString(7, bio);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

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

    public Boolean getValidated(Connection connection, String filter, String filterMail, String filterPass){

        Boolean isUser = false;

        UserDataBusinessLogic userDataBusinessLogic = new UserDataBusinessLogic();

        String query = "SELECT * FROM user_authentication WHERE " +filter;
        System.err.println(query);

        if(filterMail != null && filterPass != null){
            try {
                PreparedStatement statement = connection.prepareStatement(query);

                statement.setString(1, filterMail);
                statement.setString(2, filterPass);

                ResultSet resultSet = statement.executeQuery();

                if(resultSet.next()){
                    isUser = true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isUser;

    }

    public Boolean getUserExists(Connection connection, String filter, String filterData){

        Boolean isUserExist = false;

        UserDataBusinessLogic userBL = new UserDataBusinessLogic();

        String email = userBL.getUser_name();

        String query = "SELECT user_name FROM user_authentication WHERE " +filter;

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, filterData);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                isUserExist = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isUserExist;

    }


}
