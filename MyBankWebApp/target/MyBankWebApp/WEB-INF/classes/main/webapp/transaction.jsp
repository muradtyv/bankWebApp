<%@ page import="com.company.entity.Transaction" %>
<%@ page import="java.util.List" %>
<%@ page import="com.company.dao.inter.TransactionDaoInter" %>
<%@ page import="main.Context" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/3/2021
  Time: 1:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
    <title>Transactions</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br>
<br>
<br>
<%
  TransactionDaoInter transactionDao = Context.instanceTransactionDao();
    List<Transaction> list = transactionDao.getAllTransactions();

%>
<div>
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <td scope="col">id</td>
                <td scope="col">From Account</td>
                <td scope="col">To Account</td>
                <td scope="col">Amount</td>
            </tr>
        </thead>
        <tbody>
        <%
            for(Transaction tr: list){
        %>
            <TR>
                <th><%=tr.getId()%></th>
                <th><%=tr.getFromAccount()%></th>
                <th><%=tr.getToAccount()%></th>
                <th><%=tr.getAmount()%></th>
            </TR>
        <%}%>
        </tbody>
    </table>
</div>
</body>
</html>
