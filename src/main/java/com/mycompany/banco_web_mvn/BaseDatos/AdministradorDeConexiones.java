/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banco_web_mvn.BaseDatos;

import com.mycompany.banco_web_mvn.Entidades.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Marian PC
 */
public class AdministradorDeConexiones {
    
   /* public static void main(String[] args) throws Exception{
        

        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection con = AdministradorDeConexiones.obtenerConexion()) {
           /* String sql = "delete from clientes where dni=? and habilitado=1 and fechaDeshabilitación=";*/
           /* String sql2 = "SELECT TIMESTAMPDIFF(MONTH,(select fechaDeshabilitacion from clientes where idCliente = 10), (SELECT current_date())) as cantidad";
            
            ps = con.prepareStatement(sql2);
            
            rs = ps.executeQuery(sql2);

            while(rs.next()){
                
                int resultado = rs.getInt(1);
                System.out.println(resultado);
            }*/

            
            /*if(true)
            {
                System.out.println("OK");
            }*/
            /*
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDni());

            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

}*/
    public static Connection obtenerConexion() throws Exception{
        
        String dbDriver="com.mysql.cj.jdbc.Driver"; //NOMBRE DRIVER SQL
    
        //Establece url y base de datos a utilizar
        String dbConnString="jdbc:mysql://localhost/banco?serverTimezone=UTC"; //URL CONEXIÓN
    
        String dbUser = "root"; //USUARIO
                
        String dbPassword = "root"; //CONTRASEÑA
    
       //Establece el driver de conexión
       Class.forName(dbDriver).newInstance();
       
       //Retorna la conexión:
       Connection conn = DriverManager.getConnection(dbConnString, dbUser, dbPassword);
       return conn;
       
       
    
       
    }
    
}
