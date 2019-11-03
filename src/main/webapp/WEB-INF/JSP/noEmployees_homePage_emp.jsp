<%-- 
    Document   : homePage
    Created on : 15 oct. 2019, 15:40:26
    Author     : willi
--%>

<%@page import="jee.pj.beans.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <title>List of Employees</title>
        <link rel="stylesheet" type="text/css" media="all" href="css/stylesheet.css"/>
    </head>
    <body> 
        <h1>This is your ${user.login}'s page</h1>
        <h2>List of Employees</h2>
        <h3>Welcome ${user.login}</h3>
       
        <form action='Controller' method='post'>

            <div class='error'>
                <c:out value="${ERR_EMP}" />
                <c:out value="${ERR_SELECTION}" />
                <c:out value="${ERR_ADD}" />
            </div>

            <div class='choice'>
                <input type="submit" class="btn btn-primary" name="action" value="Details"/>
            </div>
            <button type="submit" name="action" value="Logout" class="logoutButtonContainer"><img src="css/logout.png" class="logoutIcon" /></button>
        </form> 
    </body>
</html>
