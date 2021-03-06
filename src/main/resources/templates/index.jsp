<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Manager</title>
</head>
<body>
<div align="center">
    <h2>Customer Manager</h2>
    <form method="get" action="search">
        <input type="text" name="keyword" />
        <input type="submit" value="Search" />
    </form>
    <h3><a href="/user">New User</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Last Name</th>
            <th>Gender</th>
            <th>E-mail</th>
            <th>Password</th>
            <th>Role ID</th>

            <th>Action</th>
        </tr>
        <:forEach items="${listUser}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.last_name}</td>
                <td>${user.gender}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>${user.role_id}</td>

                <td>
                    <a href="/user?id=${user.id}">Edit</a>

                    <a href="/delete?id=${user.id}">Delete</a>
                </td>
            </tr>
        </:forEach>
    </table>
</div>
</body>
</html>