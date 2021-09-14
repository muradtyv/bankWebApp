<%@ page import="com.company.dao.inter.UserDaoInter" %>
<%@ page import="com.company.dao.impl.UserDaoImpl" %>
<%@ page import="com.company.entity.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="assets/js/user.js"></script>
    <title>Login Page</title>

</head>
<body class="login_background">
       <form action="login" method="post" name="form" class="px-4 py-3" >
           <div class="col-4 container login_fix_">
               <center>
                   <h1>Login:</h1>
               </center>
               <div class="form-group">
                   <label class="form-label">Email</label>
                   <input type="email" class="form-control" name="email" placeholder="email@example.com"/>
               </div>
               <div class="form-group">
                   <label class="form-label" >Password</label>
                   <input type="password"  class="form-control" name="password" placeholder="Password">
               </div>
               <button type="submit" class="btn btn-primary" onclick="return login_takes()">Sign in</button>
               <div class="dropdown-divider"></div>
               <a class="dropdown-item" href="register">New around here? Sign up</a>
           </div>
       </form>
</body>
</html>
