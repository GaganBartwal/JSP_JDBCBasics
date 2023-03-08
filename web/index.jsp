<%--
  Created by IntelliJ IDEA.
  User: sport
  Date: 3/5/2023
  Time: 11:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.bartwal.Controller.PageController" %>
<%
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    request.setAttribute("email", email);
    request.setAttribute("password", password);
%>

<html lang="en">
<script>
    function myFunction() {

        <%--if(document.getElementsByName("login")){--%>
            <%--<%= PageController%>--%>
        <%--}--%>

    }
</script>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Sign In or Sign Up</title>
</head>

<body>
<h2>Sign Up</h2>
<p>Please Fill Out the Required Information.</p>
<form action="login">
    <fieldset class="fil_1">
        <input type="email" name="email" required placeholder="Enter Your Email:"/>
        <input type="password" name="password" placeholder="Enter Your Password:"/>
        <button type="login" name="login" onclick="myFunction()">login</button>
    </fieldset>


</form>
<h2>Sign Up</h2>
<p>Please Fill Out the Required Information.</p>
<form action="#">
    <fieldset class="fil_1">
        <label>Enter Your First Name: <input type="text" name="name" required/></label>
        <label>Enter Your Last Name: <input type="text" name="name" required/></label>
        <label>Enter Your Email: <input type="email" name="email" required/></label>
        <label>Create a New Password: <input type="password" pattern="[a-z0-5]{8,}"
                                             required/></label>
    </fieldset>
    <fieldset class="fil_2">
        <p class="inline">Please Select Your Gender:</p>
        <label><input type="radio" name="Gender" class="inline" required/> Male</label>
        <label><input type="radio" name="Gender" class="inline"/> Female</label>
        <label><input type="radio" name="Gender" class="inline"/> Other</label>
        <label><input type="checkbox" name="terms" class="inline" required/> I accept <a href="#">terms and
            Conditions.</a></label>
    </fieldset>
    <fieldset class="fil_3">
        <label>Upload a profile picture: <input type="file" name="file"/></label>
        <label>Input your age (years): <input type="number" name="Gender" min="16" max="60"/></label>
        <label>We would Like to know about You More:
            <textarea name="bio" rows="3" cols="30" placeholder="I like to make new friends...."></textarea>
        </label>
    </fieldset>
    <button type="submit">Submit</button>
</form>

</body>

</html>