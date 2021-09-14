<%@ page import="com.company.dao.impl.UserDaoImpl" %>
<%@ page import="com.company.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/5/2021
  Time: 1:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

    <title>Information Page</title>
</head>
<body>
<%
    User user = (User) request.getSession().getAttribute("loggedUser");
%>
<jsp:include page="header.jsp"></jsp:include>
<br>
<br>
<div>
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th scope="col">id</th>
                <th scope="col">Name</th>
                <th scope="col">surname</th>
                <th scope="col">email</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><%=user.getId()%></td>
                <td><%=user.getName()%></td>
                <td><%=user.getSurname()%></td>
                <td><%=user.getEmail()%></td>
            </tr>
        </tbody>
    </table>
</div>
</body>
</html>
