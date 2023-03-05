<%--
  Created by IntelliJ IDEA.
  User: sport
  Date: 3/5/2023
  Time: 11:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Home</title>
  </head>
  <body>
  <%

      ServletContext servletContext = request.getServletContext();
      String user = servletContext.getInitParameter("user");
      String pass = servletContext.getInitParameter("pass");

  %>

  <%= user%>
  <%= pass%>

  </body>
</html>
