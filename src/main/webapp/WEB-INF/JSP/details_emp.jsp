<%-- 
    Document   : details
    Created on : 17 oct. 2019, 22:42:30
    Author     : willi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" media="all" href="css/stylesheet.css"/>
        <title>Details</title>
    </head>
    <body>
        <h1>Details about ${employee.firstname} ${employee.lastname}</h1>
        <div class='container details'>
            <form method='post' action='Controller'>
                <div form-group>
                        <input type=hidden value="${employee.idemp}" name='id'/>
                    </div>
                <div>
                    <label for=name>Nom</label>
                    <input type=text name=name value="${employee.lastname}" size='35' disabled/>
                </div>
                <div>
                    <label for="first_name">Prénom</label>
                    <input type="text" name="first_name" value="${employee.firstname}" size="35" disabled/>
                </div>
                <div>
                    <label for="homePhone">Tél dom</label>
                    <input type="text" name="homePhone" value="${employee.homephone}" size="35" disabled/>
                </div>
                <div>
                    <label for="mobilePhone">Tél mob</label>
                    <input type="text" name="mobilePhone" value="${employee.mobilephone}" size="35" disabled/>
                </div>
                <div>
                    <label for="workPhone">Tél pro</label>
                    <input type="text" name="workPhone" value="${employee.workphone}" size="35" disabled/>
                </div>
                <div>
                    <label for="address">Adresse</label>
                    <input type="text" name="address" value="${employee.address}" size="35"disabled/>
                </div>
                <div>
                    <label for="postalCode">Code Postal</label>   
                    <input type="text" name="postalCode" value="${employee.postalcode}" size="35" disabled/> 
                </div>
                <div>
                    <label for="city">Ville</label>    
                    <input type="text" name="city" value="${employee.city}" size="35" disabled/>
                </div>
                <div>
                    <label for="email">Email</label>    
                    <input type="text" name="email" value="${employee.email}" size="35" disabled/>
                </div>
                <div class="error">
                    <c:out value="${ERR_MAIL}"/>
                    <c:out value="${ERR_WORKPHONE}"/>
                    <c:out value="${ERR_HOMEPHONE}"/>
                    <c:out value="${ERR_MOBPHONE}"/>
                </div>
                <div class='change'>
                    <input type="submit" class="btn btn-danger" name="detailAction" value="Cancel"/>
                </div>
            </form> 
        </div>
    </body>
</html>
