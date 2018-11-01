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
                 table, th, td{
                     border: 1px solid black;
                 }
                </style>
    </head>
<body>

    <h2>Home Flower Shop</h2>


    <c:if test="${not empty sessionScope.customer}">
         <h4>You are logged in as: ${sessionScope.customer.login} Balance: ${sessionScope.customer.cashBalance} Discount: ${sessionScope.customer.discount}%</h4>
    </c:if>

    <br>
    <table border="5">
    <thead>
        <tr>
             <th>NameFlower</th>
             <th>Balance</th>
             <th>Price</th>
             <th>Available</th>
             <th class="button">Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${flowers}" var="flowers">
            <tr>
                <td>${flowers.nameFlower}</td>
                <td>${flowers.balance}</td>
                <td>${flowers.price}</td>
                <td>${flowers.flowerAvailability}</td>

                <c:if test="${flowers.balance ne 0}">
                    <c:if test="${flowers.flowerAvailability eq 'areAvailable'}">
                        <td class="button"><button>In basket</button></td>
                    </c:if>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <br>
    <p><a href="/logOut" action="/logOut" method="GET">LogOut</a></p>


</body>
</html>
