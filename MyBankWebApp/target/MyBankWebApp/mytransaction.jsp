
<%@ page import="com.company.entity.Transaction" %>
<%@ page import="java.util.List" %>
<%@ page import="com.company.entity.User" %>
<%@ page import="com.company.dao.inter.TransactionDaoInter" %>
<%@ page import="main.Context" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/6/2021
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script src="assets/js/user.js"></script>
    <title>My Transaction</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br>
<br>
<br>
<%
    User user = (User) request.getSession().getAttribute("loggedUser");
    TransactionDaoInter transactionDao = Context.instanceTransactionDao();
   List<String> accNumbers = transactionDao.getAccountNumbers(user.getEmail());
   List<Transaction> list = transactionDao.getTransactions(accNumbers);
%>

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
