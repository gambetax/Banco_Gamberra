/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banco_web_mvn.BaseDatos;

import com.mycompany.banco_web_mvn.Excepciones.ClienteException;
import com.mycompany.banco_web_mvn.Entidades.Cliente;
import com.mycompany.banco_web_mvn.Excepciones.BancoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marian PC
 */
public class ClienteDAO {

    //Metodo para insertar un nuevo cliente en la bd
    public static boolean insertCliente(Cliente c) throws ClienteException, BancoException, Exception {
        PreparedStatement st = null;
        try (Connection con = AdministradorDeConexiones.obtenerConexion()) {
            if (existCliente(c.getDni())) {
                return false;
            } else {
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
                if (st.execute()) {
                    System.out.println("CLIENTE INSERTADO");
                } else {
                    System.out.println("FAILED TO INSERT");
                    return false;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static boolean insertClienteBasico(Cliente c) throws ClienteException, BancoException {

        PreparedStatement st = null;
        try (Connection con = AdministradorDeConexiones.obtenerConexion()) {

            String sql = "insert into Clientes (nombre,apellido,dni) values (?,?,?)";
            st = con.prepareStatement(sql);
            st.setString(1, c.getNombre());
            st.setString(2, c.getApellido());
            st.setString(3, c.getDni());

            return st.executeUpdate() == 1;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /*METODO PARA CONSULTAR SI EXISTE EL CLIENTE, NO ES EXACTAMENTE A getCliente*/
    public static boolean existCliente(String dni) throws ClienteException {

        PreparedStatement st = null;
        ResultSet rs = null;
        boolean exist = false;
        try (Connection con = AdministradorDeConexiones.obtenerConexion()) {
            String sql = "select dni from Clientes where dni = ? ";
            st = con.prepareStatement(sql);
            st.setString(1, dni);
            rs = st.executeQuery();

            if (rs.next()) {
                exist = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exist;
    }

    /*Metodo para consultar datos de cliente si existe por el dni consultado
        Requiere modificación ya que utiliza la misma consulta de dni
     */
    public static Cliente getCliente(String dni_cliente) throws ClienteException {

        Cliente c = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        int aux = 0;

        try (Connection con = AdministradorDeConexiones.obtenerConexion()) {
            String sql = "select * from Clientes where dni = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, dni_cliente);

            rs = ps.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                String direccionCliente = rs.getString("direccion_cliente");
                String codigoPostal = rs.getString("cp_cliente");
                String NumCuenta = rs.getString("cuenta");
                String sucursal = rs.getString("sucursal_cliente");
                c = new Cliente();
                c.setNombre(nombre);
                c.setApellido(apellido);
                c.setDni(dni);
                c.setDireccion(direccionCliente);
                c.setCodigoPostal(codigoPostal);
                c.setNumCuenta(NumCuenta);

                c.toString();

                System.out.println(c.toString());
            } else {
                System.out.println("No existe el cliente");
            }

        } catch (Exception e) {
            if (aux != 1) {
                e.printStackTrace();
            }
        }
        return c;
    }

    public static ArrayList<Cliente> getListClientes() {

        ArrayList<Cliente> Clientes = new ArrayList<Cliente>();
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean exist = false;
        try (Connection con = AdministradorDeConexiones.obtenerConexion()) {
            Cliente cliente_2_list = null;
            String sql = "select * from Clientes";
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            int cont = 1;
            while (rs.next()) {
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
        }
        return Clientes;
    }

    public static boolean updateCliente(Cliente cliente) throws ClienteException {
        System.out.println(cliente);
        Cliente cli = cliente;

        PreparedStatement ps = null;
        try (Connection con = AdministradorDeConexiones.obtenerConexion()) {

            String sql = "update clientes set nombre=?,apellido=?,direccion_cliente=?,cp_cliente=?,cuenta=?,sucursal_cliente=? where dni=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getApellido());
            ps.setString(3, cli.getDireccion());
            ps.setString(4, cli.getCodigoPostal());
            ps.setString(5, cli.getNumCuenta());
            ps.setString(6, cli.getSucursal());
            ps.setString(7, cli.getDni());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return true;
        }
    }

    public static boolean deshabilitarCliente(Cliente cliente) throws ClienteException {

        Cliente cli = cliente;
        PreparedStatement ps = null;

        try (Connection con = AdministradorDeConexiones.obtenerConexion()) {
            String sql = "update clientes set habilitado=? where dni=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "0");
            ps.setString(2, cli.getDni());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            return true;
        }

    }

    public static boolean habilitarCliente(Cliente cliente) throws ClienteException {

        Cliente cli = cliente;
        PreparedStatement ps = null;

        try (Connection con = AdministradorDeConexiones.obtenerConexion()) {
            String sql = "update clientes set habilitado=? where dni=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "1");
            ps.setString(2, cli.getDni());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            return true;
        }

    }

    public static boolean eliminarCliente(Cliente cliente) throws ClienteException {

        int eliminarApartirMeses = 6;
        
        Cliente cli = cliente;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection con = AdministradorDeConexiones.obtenerConexion()) {
            String sqlEliminar = "delete from clientes where dni=? and habilitado=0";
            String sqlConsultar = "SELECT TIMESTAMPDIFF(MONTH,(select fechaDeshabilitacion from clientes where dni=?), (SELECT current_date()))";

            ps = con.prepareStatement(sqlConsultar);
            ps.setString(1, cli.getDni());
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt(1) > eliminarApartirMeses) {
                    ps = con.prepareCall(sqlEliminar);
                } else {
                    return false;
                }
            }
            ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            return true;
        }
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
