<%-- 
    Document   : addUser
    Created on : May 7, 2017, 10:20:15 PM
    Author     : Chandra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AddUser Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    </head>
    <body>
        <div style="margin-left: 70px; margin-top: 100px"> 
        <h1>Add User</h1>
       <form method="post" action="${pageContext.request.contextPath}/save">
           <div class="form-group">
                <label>UserName</label>
                <input type="text" name="userName" class="form-control">
            </div>

            <div  class="form-group">
                <label>Password</label>
                <input type="text" name="password" class="form-control">
            </div>

            <div class="form-group">
                <label>Email</label>
                <input type="text" name="email" class="form-control">
            </div>

            <div  class="checkbox">
                <label><input type="checkbox" name="status" class="form-control">Status</label>
               
            </div>
            <button type="submit" >Add</button>

        </form>
        </div>
    </body>
</html>
