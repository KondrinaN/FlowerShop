<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Flower Shop</title>
        <link href="styleStart.css" rel="stylesheet" type="text/css"/>
        <style>
         body{
            background: lavender;
         }
        </style>
    </head>
<body>
    <h2>Home Flower Shop</h2>

    <ul class="menu-main">

        <li><h4 name="signIn">Sign in</h4></li>
        <li><h4 name="signUp" onclick="openPage('signUp')">Sign up</h4></li>
    </ul>

    <div id="dialog" class="modalDialog">
        <form id="main" action="/mainPage" method="POST">
            <p><input type='text' name='Login' placeholder="Login" /></p>
            <p><input type='password' name='Password' placeholder="Password" /></p>
            <p><input type='submit' name='OK' value="OK" align="center" onclick="openPage('mainPage')" /></p>
            <p></p>
        </form>
    </div>

    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/eggplant/jquery-ui.css">

    <script>
    	var dialog = $("#dialog").dialog({autoOpen: false});
    	$("h4[name=signIn]").click(function ()
    	{
    		dialog.dialog( "open" );
    	});
    </script>
    <script>
        function openPage(pageURL)
        {
            window.location.href = pageURL;
        }
    </script>

</body>
</html>
