<%-- 
    Document   : consultar
    Created on : 11-may-2021, 15:44:51
    Author     : Marian
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CONSULTAS</title>
    </head>
    <body>
        
        <hr><!-- comment -->
            
        <form action="ConsultarServlet" method="post">
        DNI: <input type="text" name="dni" /><br>
        NOMBRE: <input type="text" name="nombre" /><br>
        APELLIDO: <input type="text" name="apellido" /><br>
        <input type="submit" value="Enviar">
        </form>
        
        
        <hr><!-- comment -->
        <br><h1> Resultado </h1><!-- comment -->
        
        <% if(request.getAttribute("mensaje") !=null) 
        {out.print(request.getAttribute("mensaje"));} %>
        
        
    </body>
</html>
