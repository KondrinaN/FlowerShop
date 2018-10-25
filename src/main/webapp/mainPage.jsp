<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Flower Shop</title>
        <link href="styleMainPage.css" rel="stylesheet" type="text/css"/>
                <style>
                 body{
                    background: lavender;
                 }
                </style>
    </head>
<body>
    <h2>Home Flower Shop</h2>
            <h4>You are logged in as:  <%= request.getParameter("Login") %></h4>

            <c:if test="${Login == null}" >
                 <div>"Login can't be empty!"</div>
            </c:if>
    <p><a href="LogOut">LogOut</a></p>
</body>
</html>
