<%-- 
    Document   : insertar
    Created on : 11-may-2021, 16:13:22
    Author     : Marian
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INSERTAR CLIENTE</title>
    </head>
    <body>
        
        <hr><!-- comment -->
            
        <form action="InsertarCliente" method="POST">
        DNI: <input type="text" name="dni" /><br>
        NOMBRE: <input type="text" name="nombre" /><br>
        APELLIDO: <input type="text" name="apellido" /><br>
        <input type="submit" value="Enviar">
        </form>

        <hr><!-- comment -->
        <br><h1> Resultado </h1><!-- comment -->
        
        <% if(request.getAttribute("mensaje") !=null){
            out.print(request.getAttribute("mensaje"));} %>
        
        
            <br>
            
            <input type="button" href="index.html" value="VOLVER">
            
    </body>
</html>
