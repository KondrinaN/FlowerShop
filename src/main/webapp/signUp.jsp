<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Flower Shop</title>
    </head>
<body>
    <jsp:include page="index.jsp" />

         <form id="main" action="/signUp" method="POST">
             <p><input type='text' name="Login" placeholder="Login"/></p>
             <p><input type='password' name='Password' placeholder="Password"/></p>
             <p><input type='text' name='Surname' placeholder="Surname"/></p>
             <p><input type='text' name='Name' placeholder="Name"/></p>
             <p><input type='text' name='Patronymic' placeholder="Patronymic"/></p>
             <p><input type='text' name='Address' placeholder="Address"/></p>
             <p><input type='submit' name='OK' value="OK" align="center" onclick="openPage('mainPage')"/></p>
             <p></p>
         </form>
        <script>
                function openPage(pageURL)
                {
                    window.location.href = pageURL;
                }
        </script>
</body>
</html>
