<%-- 
    Document   : editar
    Created on : 11-may-2021, 15:44:24
    Author     : Marian
--%>
<%@page import="com.mycompany.banco_web_mvn.Entidades.Cliente" %>
<%@page import="java.util.*" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

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


        <div class="row">
            <div class="col s12 m6">
                <div class="card blue-grey darken-1">
                    <div class="card-content white-text">
                        <span class="card-title">Card Title</span>
                        <form action="ConsultaUpdateServlet" method="post">
                            DNI: <input type="text" name="dni"><br>
                            <input type="submit" value="ENVIAR">
                        </form>



                    </div>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="col s12 m6">
                <div class="card blue-grey darken-1">
                    <div class="card-content white-text">
                        <%
                            if (request.getAttribute("Cliente") != null) {
                                Cliente c = (Cliente) request.getAttribute("Cliente");
                        %>

                        <form action="UpdateServlet" method="post">
                            <tr> <input type="text" name="nombre" value="<%= c.getNombre()%>" > </tr>
                            <tr> <input type="text" name="apellido" value="<%= c.getApellido()%>"  > </tr>
                            <tr> <input type="text" name="dni" value="<%= c.getDni()%>"  > </tr>
                            <tr> <input type="text" name="direccion" value="<%= c.getDireccion()%>"   > </tr>
                            <tr> <input type="text" name="codigoPostal" value="<%= c.getCodigoPostal()%>"   > </tr>
                            <tr> <input type="text" name="numeroCuenta" value="<%= c.getNumCuenta()%>"   > </tr>
                            <tr> <input type="text" name="Sucursal" value="<%= c.getSucursal()%>"   > </tr>
                            <input type="submit" value="ENVIAR">
                        </form>
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>
        </div>


        <!--JavaScript at end of body for optimized loading-->
        <script type="text/javascript" src="js/materialize.min.js"></script>
    </body>
</html>