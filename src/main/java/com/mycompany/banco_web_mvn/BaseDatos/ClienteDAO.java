/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banco_web_mvn.BaseDatos;

import com.mycompany.banco_web_mvn.Excepciones.ClienteException;
import com.mycompany.banco_web_mvn.Entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.UUID;

/**
 *
 * @author Marian PC
 */
public class ClienteDAO {

    
    //Metodo para insertar un nuevo cliente en la bd
    
    public static void insertCliente(Cliente c) throws ClienteException, Exception {

        Connection con = null;
        PreparedStatement st = null;
        try {
            con = AdministradorDeConexiones.obtenerConexion();
            if (existCliente(c.getDni())) {
                throw new ClienteException("El cliente ya existe.");
            }
            String sql = "insert into Clientes (nombre,apellido,dni,direccion_cliente,"
                    + "cp_cliente,cuenta,sucursal_cliente,fechaCreacion) values (?,?,?,?,?,?,?,?)";
            st = con.prepareStatement(sql);
            st.setString(1, c.getNombre());
            st.setString(2, c.getApellido());
            st.setString(3, c.getDni());
            st.setString(4, c.getDireccion());
            st.setString(5, c.getCodigoPostal());
            System.out.println(UUID.randomUUID().toString());
            st.setString(6, UUID.randomUUID().toString());
            
            st.setInt(7, 0001); // CREAR METODO DONDE SE ASIGNA SURCURSAL
            st.setString(8, "2020-12-19 00:01:00"); //CREAR METODO DONDE SE ASIGNE LA FECHA DEL MOMENTO
            st.execute();

            System.out.println("CLIENTE INSERTADO");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }
    
        /*Metodo para consultar datos de cliente si existe por el dni consultado
        Requiere modificación ya que utiliza la misma consulta de dni
        */

    public static Cliente getCliente(String dni_cliente) {

        Connection con = null;
        Cliente c = null;
        ResultSet rs = null;
        PreparedStatement st = null;
        int aux = 0;

        try {
            con = AdministradorDeConexiones.obtenerConexion();
            String sql = "select * from Clientes where dni = ?";
            st = con.prepareStatement(sql);
            st.setString(1, dni_cliente);

            rs = st.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                String NumCuenta = rs.getString("cuenta");
                c = new Cliente();
                c.setNombre(nombre);
                c.setApellido(apellido);
                c.setDni(dni);
                c.setNumCuenta(NumCuenta);

                c.toString();

                System.out.println(c.toString());
            } else {
                aux = 1;
                throw new ClienteException("No existe ese cliente");
            }

        } catch (Exception e) {
            if (aux != 1) {
                e.printStackTrace();
            }
        } finally {
            if (rs != null) {

                try {
                    rs.close();
                    st.close();
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }

        return c;
    }

    public static boolean existCliente(String dni) {

        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean exist = false;
        try {
            try {
                con = AdministradorDeConexiones.obtenerConexion();

            } catch (Exception e) {
                e.printStackTrace();
            }

            String sql = "select dni from Clientes where dni = ?";
            st = con.prepareStatement(sql);
            st.setString(1, dni);
            rs = st.executeQuery();

            if (rs.next()) {
                exist = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return exist;
        }
    }
    
    
    public static ArrayList<Cliente> getListClientes(){
        Connection con =null;
        ArrayList<Cliente> Clientes = new ArrayList<Cliente>();
        PreparedStatement st= null;
        ResultSet rs = null;
        boolean exist = false;
        try{
            try{
                con = AdministradorDeConexiones.obtenerConexion();
            } catch (Exception e){
                    e.printStackTrace();
            }
            Cliente cliente_2_list =  null;
            String sql = "select * from Clientes";
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            int cont=1;
            while(rs.next()){
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                String NumCuenta = rs.getString("cuenta");
                cliente_2_list = new Cliente();
                cliente_2_list.setNombre(nombre);
                cliente_2_list.setApellido(apellido);
                cliente_2_list.setDni(dni);
                cliente_2_list.setNumCuenta(NumCuenta);
                
                Clientes.add(cliente_2_list);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try{
                con.close();
            } catch (SQLException Esql) {
            Esql.printStackTrace();
        }
            return Clientes;
        }
    }

    /*public static boolean existCuenta(double cuenta) {

        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean exist = false;
        try {
            try {
                con = administradorDeConexiones.obtenerConexion();

            } catch (Exception e) {
                e.printStackTrace();
                throw new ClienteException();
            }

            String sql = "select * from Clientes where cuenta = ?";
            st = con.prepareStatement(sql);
            st.setString(1, String.valueOf(cuenta));
            rs = st.executeQuery();

            if (rs.next()) {
                exist = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return exist;
        }
    }*/

    /*public static String randomNumeroCuenta() throws SQLException {

        int numCuenta = 0;
        double n = 0;
        boolean flag = true;

        int max = 9999999;
        int min = 1111111;

        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            try {
                con = administradorDeConexiones.obtenerConexion();
            } catch (Exception e) {
                e.printStackTrace();
                throw new ClienteException();
            }

            while (flag) {
                n = (Math.random() * ((max - min) + 1)) + min; //numero aleatorio de cuenta, donde se incluye maximo y minimo
                System.out.println(n);
                numCuenta = (int) n;
                System.out.println(numCuenta);

                if (existCuenta(numCuenta)) {
                    flag = false;

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                st.close();
            } catch (Exception e) {
            }

        }

        numCuenta = 100000000 + numCuenta;

        return String.valueOf(numCuenta);
    }*/
}
