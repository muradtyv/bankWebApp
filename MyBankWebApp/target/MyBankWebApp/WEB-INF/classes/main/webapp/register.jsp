<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/21/2021
  Time: 1:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="assets/js/user.js"></script>
    <title>Register Page</title>
</head>
<body class="login_background">
   <form action="register" method="post" class="px-4 py-3" name="form">

      <div class="col-4 container " style="color: white">
          <center>
              <h1>Register:</h1>
          </center>
          <div class="form-group">
              <label class="form-label">Name</label>
              <input type="text" class="form-control" name="name" placeholder="Enter Name"/>
          </div>
          <div class="form-group">
              <label class="form-label">Surname</label>
              <input type="text" class="form-control" name="surname" placeholder="Enter Surname"/>
          </div>
          <div class="form-group">
              <label class="form-label">Email</label>
              <input type="email" class="form-control" name="email" placeholder="Enter Email"/>
          </div>
          <div class="form-group">
              <label class="form-label">Password</label>
              <input type="password" class="form-control" name="password" placeholder="Enter Password"/>
          </div>
          <div class="form-group">
              <label class="form-label">RePassword</label>
              <input type="password" class="form-control" name="rePassword" placeholder="Re-Enter Password"/>
          </div>
          <button type="submit" class="btn-secondary" name="submit" onclick="return register_takes()">Register</button>
      </div>
   </form>
</body>

</html>
