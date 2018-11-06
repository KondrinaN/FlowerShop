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
          <br>

     </c:if>

    <br>
    <p><a href="/logOut" action="/logOut" method="GET">LogOut</a></p>


</body>
</html>
