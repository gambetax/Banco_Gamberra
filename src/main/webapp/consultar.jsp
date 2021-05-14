<%-- 
    Document   : consultar
    Created on : 11-may-2021, 15:44:51
    Author     : Marian
--%>

<%@page import="com.mycompany.banco_web_mvn.Entidades.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*"%>


<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>

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
        <input type="submit" value="Enviar">
        
        <%
            if(request.getAttribute("Cliente") != null)
            { Cliente c = (Cliente) request.getAttribute("Cliente");
                out.print("Se ha encontrado el" + c);
            }
        %>
        
        <%
            if(request.getAttribute("Clientes") != null)
            { ArrayList<Cliente> clientes = (ArrayList) request.getAttribute("Clientes");
                    out.print("Se ha encontrado el " + clientes);
            }
        %>

        
        
    </body>
</html>
