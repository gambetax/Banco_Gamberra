<%-- 
    Document   : inicio
    Created on : 16-may-2021, 4:56:50
    Author     : Marian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>BANCO GAMBERRA</title>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <body>

        <table>
            <tbody>
                <tr>
                    <td><a href="consultar.jsp"> Consultar Clientes </a></td>
                </tr>
                <tr>
                    <td> <a href="insertar.jsp" > Insertar Cliente </a></td>
                </tr>
                <tr>
                    <td><a href="editar.jsp" > Editar Cliente </a></td>
                </tr>
                <tr>
                    <td> <a href="eliminar.jsp" > Eliminar Cliente </a></td>
                </tr>
            </tbody>
        </table>

        <!--JavaScript at end of body for optimized loading-->
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <%@include file="footer.jsp" %>
    </body>
</html>
