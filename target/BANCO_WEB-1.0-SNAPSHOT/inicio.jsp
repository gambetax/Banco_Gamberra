<%-- 
    Document   : inicio
    Created on : 16-may-2021, 4:56:50
    Author     : Marian Gambetax
--%>
<%@page import="com.mycompany.banco_web_mvn.Entidades.Cliente"%>
<%@page import="java.util.*" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="h-100">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous"><!-- comment -->
    </head>
    
    
    <body class="h-100">
        <main class="h-100">
            <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark h-100" style="width: 280px;">
                <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
                    <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
                    <span class="fs-4">GAMBERRA</span>
                </a>
                <hr>
                <ul class="nav nav-pills flex-column mb-auto">
                    <li class="nav-item">
                        <a href="inicio.jsp" class="nav-link active" aria-current="page">
                            <svg class="bi me-2" width="16" height="16"><use xlink:href="#home"></use></svg>
                            INICIO
                        </a>
                    </li>
                    <li>
                        <a href="consultar.jsp" class="nav-link text-white">
                            <svg class="bi me-2" width="16" height="16"><use xlink:href="#speedometer2"></use></svg>
                            Consultar cliente
                        </a>
                    </li>
                    <li>
                        <a href="insertar.jsp" class="nav-link text-white">
                            <svg class="bi me-2" width="16" height="16"><use xlink:href="#table"></use></svg>
                            Insertar Cliente
                        </a>
                    </li>
                    <li>
                        <a href="editar.jsp" class="nav-link text-white">
                            <svg class="bi me-2" width="16" height="16"><use xlink:href="#grid"></use></svg>
                            Editar Cliente
                        </a>
                    </li>
                    <li>
                        <a href="eliminar.jsp" class="nav-link text-white">
                            <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"></use></svg>
                            Eliminar Cliente
                        </a>
                    </li>
                </ul>
                <hr>
                <div class="dropdown">
                    <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                        <img src="https://github.com/mdo.png" alt="" width="32" height="32" class="rounded-circle me-2">
                        <strong>mdo</strong>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
                        <li><a class="dropdown-item" href="#">New project...</a></li>
                        <li><a class="dropdown-item" href="#">Settings</a></li>
                        <li><a class="dropdown-item" href="#">Profile</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Sign out</a></li>
                    </ul>
                </div>
            </div>

        </main>
        <!--JavaScript at end of body for optimized loading-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script><!-- comment --> 
    </body>
</html>
