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
    <p><a href="/logOut" action="/logOut" method="GET">LogOut</a></p>

  <br><h5>Orders</h5>
   <c:if test="${message2 ne null}">
              ${message2}
      </c:if>


   <c:if test="${message2 eq null}">
        <form id="Orders" action="/admin" method="POST" >
        <table border="5">
        <thead>
            <tr>
                 <th>Id Order</th>
                 <th>Status</th>
                 <th>Amount</th>
                 <th>Date Create</th>
                 <th>Date Close</th>
                 <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${orders}" var="orders">
                <tr>
                    <td>${orders.idOrder}</td>
                    <td>${orders.status}</td>
                    <td>${orders.amount}</td>
                    <td>${orders.dateCreate}</td>
                    <td>${orders.dateClose}</td>


                    <c:if test="${orders.status eq 'paid'}">
                        <td><input type='submit' name='Order${orders.idOrder}' value="Close!" align="right" /></td>
                    </c:if>

                </tr>


                <c:if test="${message3 eq null}">
                <thead>
                <tr></tr>
                <tr>
                                 <th></th>
                                 <th>Id Order</th>
                                 <th>Name Product</th>
                                 <th>Count</th>
                                 <th>Price</th>
                </tr>
                </thead>
                <tbody>

                           <c:forEach items="${rowOrders2}" var="rowOrders2">
                                <c:if test="${orders.idOrder eq rowOrders2.orderId.idOrder}">
                                      <tr>
                                           <td></td>

                                           <td>${rowOrders2.orderId.idOrder}</td>
                                           <td>${rowOrders2.nameProduct}</td>
                                           <td>${rowOrders2.count}</td>
                                           <td>${rowOrders2.price}</td>
                                      </tr>
                                </c:if>
                           </c:forEach>
                </tbody>
                </c:if>
            </c:forEach>


        </tbody>


        </table>
       </form>
</c:if>
</body>
</html>