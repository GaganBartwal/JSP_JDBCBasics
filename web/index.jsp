<%@ page import="com.bartwal.DAO.UserDAO" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="com.bartwal.BusinessLogic.UserDataBusinessLogic" %>
<%@ page import="com.bartwal.Utilities.MySQLDataServices" %>
<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: sport
  Date: 3/5/2023
  Time: 11:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    Connection connection = new MySQLDataServices().mySQLConnection();

    LinkedList<UserDataBusinessLogic> userDataList = new UserDAO().getUsersData(connection);

    String email = request.getParameter("email");
    String password = request.getParameter("password");

    request.setAttribute("email", email);
    request.setAttribute("password", password);
%>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Sign In or Sign Up</title>
</head>

<body>
<h2>Login</h2>
<p>Please Fill Out the Required Information.</p>
<form action="/HomePage" method="post">
    <fieldset class="fil_1">
        <input type="email" name="email" required placeholder="Enter Your Email:"/>
        <input type="password" name="password" placeholder="Enter Your Password:"/>
        <button type="submit">login</button>
    </fieldset>
</form>

<h2>Sign Up</h2>
<p>Please Fill Out the Required Information.</p>
<form action="/WelcomePage" method="post">
    <fieldset class="fil_1">
        <label>Enter Your First Name: <input type="text" name="firstname" required/></label>
        <label>Enter Your Last Name: <input type="text" name="lastname" required/></label>
        <label>Enter Your Email: <input type="email" name="email" required/></label>
        <label>Create a New Password: <input type="password" pattern="[a-z0-9]{8,}" required/></label>
    </fieldset>
    <fieldset class="fil_2">
        <p class="inline">Please Select Your Gender:</p>
        <label><input type="radio" name="gender" value="Male" class="inline" required/> Male</label>
        <label><input type="radio" name="gender" value="Female" class="inline"/> Female</label>
        <label><input type="radio" name="gender" value="Others" class="inline"/> Other</label>
        <label><input type="checkbox" name="terms" class="inline" required/> I accept <a href="#">terms and
            Conditions.</a></label>
    </fieldset>
    <fieldset class="fil_3">
        <label>Upload a profile picture: <input type="file" name="file"/></label>
        <label>Input your age (years): <input type="date" name="dob"/></label>
        <label>We would Like to know about You More:
            <textarea name="bio" rows="3" cols="30" placeholder="I like to make new friends...."></textarea>
        </label>
        <button type="submit">SignUp</button>
    </fieldset>
</form>

</body>

</html>