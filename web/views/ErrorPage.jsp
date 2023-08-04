<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28-04-2023
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
    <style>
        /* CSS styling for error message */
        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
            font-size: 16px;
            line-height: 1.5;
        }
        .error {
            background-color: #f44336;
            color: white;
            padding: 20px;
            margin-top: 20px;
            border-radius: 5px;
        }
        .error h1 {
            font-size: 24px;
            margin-top: 0;
        }
    </style>
</head>
<body>
<div class="error">
    <h1>Error</h1>
    <p><%=request.getAttribute("javax.servlet.error.message")%></p>
</div>
</body>
</html>
