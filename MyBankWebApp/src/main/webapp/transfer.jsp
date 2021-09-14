<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/2/2021
  Time: 11:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js"
            integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/"
            crossorigin="anonymous"></script>
    <script src="assets/js/user.js"></script>
    <title>Transfer page</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br><br><br>
<%
String accNumber = request.getParameter("accNumber");
%>
<form action="transfer" method="post" name="form">
    <div class="row g-3">
        <div>
            <input type="hidden" name="id" value="<%=0%>"/>
        </div>
        <div class="col">
            <label>From Account</label>
            <input type="number"  class="form-control" size="6" name="fAccount" value=""/>
        </div>
        <div class="col">
            <label>To Account</label>
            <input type="number" class="form-control" size="6" name="tAccount" value=""/>
        </div>
        <div class="col">
            <label>Amount</label>
            <input type="number" class="form-control" name="amount" value=""/>
        </div>
        <div>
            <button type="submit"  class="btnSubmit" name="btnTransfer" onclick="return transfer_takes()">Transfer</button>
        </div>
    </div>
</form>
</body>
</html>
