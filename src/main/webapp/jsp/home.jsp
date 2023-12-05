<%@ page import="by.itclass.constants.ApplicationConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
<p>
    <a href="<%= ApplicationConstants.LOGOUT_CONTROLLER%>">Logout</a>
</p>
 <h2>User Info: </h2>
    <p>login: ${user.login}</p>
    <p>name: ${user.name}</p>
    <p>email: ${user.email}</p>
</body>
</html>
