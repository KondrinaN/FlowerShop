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

            <c:if test="${not empty sessionScope.customer}">
                <h4>You are logged in as: ${sessionScope.customer.login} Balance: ${sessionScope.customer.cashBalance} Discount: ${sessionScope.customer.discount}</h4>
            </c:if>


    <p><a href="/logOut" action="/logOut" method="GET">LogOut</a></p>


</body>
</html>
