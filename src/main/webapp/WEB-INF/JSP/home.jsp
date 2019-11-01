<%-- 
    Document   : home
    Created on : 15 oct. 2019, 08:43:43
    Author     : willi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <title>Home</title>
        <link rel="stylesheet" type="text/css" media="all" href="css/stylesheet.css"/>
        
    </head>
    <body>
        <div class="container"> 
            <div id="title">Login</div>
                <form action="Controller" method="post">
                    <div class="form-group">
                        <label data-validate = "Enter login"></label>
                        <input type="text" name="username" placeholder="Username" size="35">
                    </div>

                    <div class="form-group">
                        <label data-validate="Enter password"></label>
                        <input type="password" name="password" placeholder="Password" size="35">
                    </div>
                    <div class="error">
                        <c:out value="${ERR_LOGIN_PWD}"/>
                        <c:out value="${ERR_MESSAGE}"/>
                    </div>
                    <div class="loginBtn"> 
                        <button type="submit" class="btn btn-primary" value="Validate" name="submit_btn">Login</button>
                    </div>
                </form>
        </div>
    </body>
</html>


