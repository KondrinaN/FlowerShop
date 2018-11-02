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
                 table, tr {
                     border: 1px solid black;
                 }
                </style>
    </head>
<body>

    <h2>Home Flower Shop</h2>

     <c:if test="${Error ne null}">
        ${Error}
     </c:if>
     <c:if test="${Error eq null}">

    <c:if test="${not empty sessionScope.customer}">
         <h4>You are logged in as: ${sessionScope.customer.login} Balance: ${sessionScope.customer.cashBalance} Discount: ${sessionScope.customer.discount}%</h4>
    </c:if>


    <form id="SearchByName" action="/search" method="GET">

         <table>
             <tr align="center">
                <td>Search flower by name:</td>
                <td><input type='text' name='NameFlower' placeholder="Name flower" align="right" valign="top"/></td>
                <td><input type='submit' name='Search' value="Search by name" align="right" /></td>
             </tr>
         </table>
         <p></p>
    </form>

    <form id="SearchByRangePrice" action="/search" method="GET">
             <table>
                 <tr align="center">
                    <td>Search flower by range price (>=min price and <=max price): </td>
                    <td><input type='text' name='minPrice' placeholder="min price" align="right" valign="top" size="5"/></td>
                    <td><input type='text' name='maxPrice' placeholder="max price" align="right" valign="top" size="5"/></td>
                    <td><input type='submit' name='Search' value="Search by range price" align="right" /></td>
                 </tr>
             </table>
             <p></p>
    </form>


    <br>
    <form id="Flowers" action="/basket" method="POST">

    <table border="5">
    <thead>
        <tr>
             <th>NameFlower</th>
             <th>Balance</th>
             <th>Price</th>
             <th>Available</th>
             <th>To take in quantity</th>
             <th>Actions</th>
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
                        <td><input type='text' name="Count" placeholder="Count"/></td>
                        <td><input type='submit' name='Basket' value="In basket" align="right" /></td>
                    </c:if>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
   </form>
</c:if>

    <br>
    <p><a href="/logOut" action="/logOut" method="GET">LogOut</a></p>


</body>
</html>
