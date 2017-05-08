<%-- 
    Document   : hello
    Created on : May 1, 2017, 5:16:51 PM
    Author     : Chandra
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
        <script src="../js/myjavascript.js" type="text/javascript"></script>
    </head>
    <body>
        <%--     <h1>Data Inserted: ${Message}</h1>--%>
    <center><h3>Simple Search Application-With CRUD Operation</h3></center>

    <div style="margin-left: 120px; margin-top: 70px"> 
        <a href="${pageContext.request.contextPath}/add/" class="btn btn-primary btn-md">Add User</a>
    </div>
    <div style="margin-left: 100px ; margin-top:70px" >
        
        <form method="GET" action="${pageContext.request.contextPath}/search">
            <div class="form-group">
                <label>Enter Text To Search:  </label><input type="text" name="pattern" class="form-control">
                <button type="submit" id="btn-serarch" onclick="SearchResult()">Search</button>
            </div>
        </form>
    </div>
 <div id="searchresult" style="margin-left: 100px;">
        <h1>Search Result</h1>
        <table class="table table-bordered">
            <tr>
                <th>ID</th>
                <th>UserName</th>
                <th>Password</th>
                <th>Email</th>
                <th>Status</th>
                <th>Action</th>
            </tr>

            <c:forEach var="user" items="${users}">
                <tr> 
                    <td>${user.id}</td>
                    <td>${user.userName}</td>
                    <td>${user.password}</td>
                    <td>${user.email}</td>
                    <td>${user.status}</td>
                    <td><a href="${pageContext.request.contextPath}/edit/${user.id}">Edit</a>
                        <a href="${pageContext.request.contextPath}/delete/${user.id}">Delete</a></td>

                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>
