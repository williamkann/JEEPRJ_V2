<%-- 
    Document   : gooebye
    Created on : 25 oct. 2019, 19:06:28
    Author     : willi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Good Bye</title>
        <link rel="stylesheet" type="text/css" media="all" href="css/stylesheet.css">
    </head>
    <body>
        <h1>Good Bye ! My Love !</h1>
        <img src-data="goodbye" src="css/goodbye.png"/>
        <form action="Controller" method="post">
            <div class='choice'>
                <input type="submit" class="btn btn-success" name="actionConnect" value="Connect"/>
            </div>
        </form>
    </body>
</html>
