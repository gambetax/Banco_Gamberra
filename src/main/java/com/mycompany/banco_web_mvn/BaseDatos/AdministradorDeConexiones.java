/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banco_web_mvn.BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Marian PC
 */
public class AdministradorDeConexiones {
    
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
