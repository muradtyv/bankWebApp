
<%@ page import="com.company.entity.BankAccount" %>
<%@ page import="java.util.List" %>
<%@ page import="com.company.dao.inter.BankDaoInter" %>
<%@ page import="main.Context" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/6/2021
  Time: 12:48 PM
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
    <title>Searching page</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br>
<br>
<br>
<%
   String email = request.getParameter("email");
    BankDaoInter b = Context.instanceBankDao();
    List<BankAccount> list = b.getAccounts(email);
%>
<div class="container">
    <div class="row">
        <div class="col-4">
            <form action="searchingaccount" method="get">
                <div class="form-group">
                    <label >Email:</label>
                    <input placeholder="Enter Email" class="form-control" type="text" name="email" value=""/>
                </div>
                <input class="btn btn-primary" type="submit" name="search" value="Search" id="btnsearch"/>
            </form>
        </div>
    </div>
</div>
<div>

    <table class="table">
        <THEAD class="thead-dark">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Email</th>
            <th scope="col">Customer Name</th>
            <th scope="col">Exchange</th>
            <th scope="col">Account Number</th>
            <th scope="col">Balance</th>
            <th scope="col">Status</th>
            <th scope="col"></th>
        </tr>
        </THEAD>

        <%
            for(BankAccount l:list){
        %>
        <tr>
            <td><%=l.getId()%></td>
            <td><%=l.getEmail()%></td>
            <td><%=l.getCustomerNAme()%></td>
            <td><%=l.getExchange()%></td>
            <td><%=l.getAccountNumber()%></td>
            <td><%=l.getBalance()%></td>
            <td>
                <form action="status" method="post">
                    <input type="hidden" name="element" value="searchStatus"/>
                    <input type="hidden" name="email" value="<%=request.getParameter("email")%>"/>
                    <input type="hidden" name="id" value="<%=l.getId()%>"/>
                    <button type="submit" class="btn btn-primary" name="btn_status"><%=l.getStatus()%></button>
                </form>

                <input type="hidden" name="element" value="delete"/>
                <input type="hidden" name="email" value="<%=request.getParameter("email")%>"/>
                <input type="hidden" name="id" value="<%=l.getId()%>"/>
                <button class="btn btn-danger"  type="submit" name="delete"
                        data-toggle="modal" data-target="#exampleModal"
                        onclick="setIdForDelete(<%=l.getId()%>)">Delete</button>
            </td>
            <td>
                <form action="transfer" method="get">
                    <input type="hidden" name="accNumber" value="<%=l.getAccountNumber()%>"/>
                    <button class="btn btn-success">Transfer</button>
                </form>
            </td>
        </tr>
        <%}%>
    </table>
</div>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure?
            </div>
            <div class="modal-footer">
                <form action="allview" method="post">
                    <input type="hidden" name="element" value="searchDelete"/>
                    <input type="hidden" name="email" value="<%=request.getParameter("email")%>"/>
                    <input type="hidden" name="id"  value="" id="idForDelete"/>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-danger" value="Delete">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
