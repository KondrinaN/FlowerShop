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
            <% String login=request.getParameter("Login"); %>
            <% String cashBalance=request.getParameter("CashBalance"); %>
            <% String discount=request.getParameter("Discount"); %>

            <h4>You are logged in as: <%= login %> Balance: <%= cashBalance %> Discount: <%= discount %>%</h4>

    <p><a href="/">LogOut</a></p>
</body>
</html>
