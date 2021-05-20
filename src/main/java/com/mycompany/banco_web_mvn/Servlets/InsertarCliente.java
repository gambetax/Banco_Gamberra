/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banco_web_mvn.Servlets;

import com.mycompany.banco_web_mvn.BaseDatos.ClienteDAO;
import com.mycompany.banco_web_mvn.Entidades.Cliente;
import com.mycompany.banco_web_mvn.Excepciones.BancoException;
import com.mycompany.banco_web_mvn.Excepciones.ClienteException;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Marian
 */
@WebServlet(name = "InsertarCliente", urlPatterns = {"/InsertarCliente"})
public class InsertarCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertarCliente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertarCliente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");

        /* Si es necesario se crea una variable para convertir un valor al necesario
            por ejemplo, pasar de String a int o Double o viceversa con:
            try{ codigo } catch(excepction e){ precio=0.00 }
         */
        
        System.out.println(dni+ " "+ nombre +" " + apellido);
        
        Cliente c1 = new Cliente(nombre,apellido,dni);
        System.out.println(c1);
        try {
            if (!ClienteDAO.insertClienteBasico(c1)) {
                request.setAttribute("mensaje", "El Cliente ya existe");
            } else {
                request.setAttribute("mensaje", "El Cliente se ha insertado correctamente");
            }

        } catch (ClienteException e) {
            e.getStackTrace();
            request.setAttribute("mensaje", e.getMessage());
        } catch (BancoException e) {
            request.setAttribute("mensaje", "Estamos realizando tareas de mantenimiento"
                    + "por favor intente mas tarde");
            e.printStackTrace();
        }

        request.getRequestDispatcher("insertar.jsp").forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
