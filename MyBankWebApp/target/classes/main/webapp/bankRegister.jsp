<%@ page import="com.company.entity.BankAccount" %>
<%@ page import="com.company.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/23/2021
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="assets/css/register.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="assets/js/user.js"></script>
    <title>Bank Register</title>
</head>

<body>

<%
    User u = (User)request.getSession().getAttribute("loggedUser");
    BankAccount bankAccount = new BankAccount();

%>

<div class="container register-form justify-content-center">
    <div class="form">
        <div class="note">
            <p>Bank Register:</p>
        </div>
        <form action="bregister" method="post" name="form">
            <div class="form-content">
                <div class="row">
                    <div class="col-md-6">
                        <div>
                            <input type="hidden" name="Nemail" value="<%=u.getEmail()%>">
                        </div>
                        <div class="form-group">
                            <input type="text" name="customer_name" class="form-control" placeholder=" Name *" value=""/>
                        </div>
                        <div class="form-group">
                            <input type="text" name="exchange" class="form-control" placeholder="Exchange *" value="<%=bankAccount.getExchange()%>"/>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" name="account_number" class="form-control" placeholder="Account Number *" value=""/>
                        </div>
                        <div class="form-group">
                            <input type="text" name="balance" class="form-control" placeholder="Balance *" value="<%=bankAccount.getBalance()%>"/>
                        </div>
                        <div class="form-group">
                            <input type="text" name="status" class="form-control" placeholder="Status *" value="<%=bankAccount.getStatus()%>"/>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btnSubmit" onclick="return bankRegister_takes()">Submit</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
