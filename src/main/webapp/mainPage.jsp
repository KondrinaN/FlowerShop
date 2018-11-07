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
                 td{
                    text-align: center;
                 }
                 h5 {
                   font-size: 14pt;
                   text-align: left;
                   color: darkblue;
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
         <br>
         <p><a href="/logOut" action="/logOut" method="GET">LogOut</a></p>
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


    <br><h5>Flowers</h5>
    <form id="Flowers" action="/mainPage" method="POST" >
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
                        <td><input type='text' name="Count${flowers.idFlower}" placeholder="Count" value="1"/></td>
                        <td><input type='submit' name='Basket${flowers.idFlower}' value="In basket" align="right" /></td>
                    </c:if>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
   </form>

   <br><h5>Basket</h5>
    <c:if test="${message ne null}">
            ${message}
    </c:if>
    <c:if test="${message eq null}">
       <form id="Basket" action="/orders" method="POST" >
       <table border="5">
       <thead>
           <tr>
                <th>NameFlower</th>
                <th>Count</th>
                <th>Price</th>
           </tr>
       </thead>
       <tbody>
           <c:forEach items="${rowOrders}" var="rowOrders">
               <tr>
                   <td>${rowOrders.nameProduct}</td>
                   <td>${rowOrders.count}</td>
                   <td>${rowOrders.price}</td>
               </tr>
           </c:forEach>


           <c:if test="${countProducts ne 0}">
                <br>
                <tr><td>Total:</td><td>${priceFull}</td></tr>
                <tr><td> <input type='submit' name='SaveOrder' value="Save order" align="center" /></td></tr>
           </c:if>
       </tbody>
       </table>
      </form>
    </c:if>




</c:if>
</body>
</html>
