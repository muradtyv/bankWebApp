<%@ page import="com.company.entity.BankAccount" %>
<%@ page import="com.company.entity.User" %>

  Created by IntelliJ IDEA.
  User: User
  Date: 8/27/2021
  Time: 7:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
    <title>All View</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br>
<br>
<br>
<%
    User user = (User) request.getSession().getAttribute("loggedUser");
    BankAccount account = (BankAccount)request.getSession().getAttribute("bankAccount");
%>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <td scope="col">id</td>
        <td scope="col">name</td>
        <td scope="col">surname</td>
        <td scope="col">email</td>
        <td scope="col">Customer Name</td>
        <td scope="col">Exchange</td>
        <td scope="col">Account Number</td>
        <td scope="col">Balance</td>
        <td scope="col">Status</td>
        <td></td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><%=user.getId()%></td>
        <td><%=user.getName()%></td>
        <td><%=user.getSurname()%></td>
        <td><%=user.getEmail()%></td>
        <td><%=account.getCustomerNAme()%></td>
        <td><%=account.getExchange()%></td>
        <td><%=account.getAccountNumber()%></td>
        <td><%=account.getBalance()%></td>
        <td><%=account.getStatus()%></td>
    </tr>
    </tbody>
</table>
<br>
</body>
</html>
