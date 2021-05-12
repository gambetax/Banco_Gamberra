/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banco_web_mvn.Entidades;

/**
 *
 * @author Marian PC
 */
public class Cliente extends Persona {
    
    String numCuenta;
    boolean vip;

    public Cliente() {
    }
    
    public Cliente(String nombre, String apellido, String dni, String direccion, String codigo_postal){
        super(nombre,apellido,dni,direccion,codigo_postal);
        init(numCuenta, false);
    }
    
    public Cliente(String nombre, String apellido, String dni){
        super(nombre,apellido,dni);
        init(numCuenta,false);
    }
    
    public Cliente(String nombre,String apellido, String dni, String numCuenta){
        super(nombre,apellido,dni);
        init(numCuenta,false);
    }
    

    public Cliente(String numCuenta, String nombre, String apellido, String dni, int edad) {
        super(nombre, apellido, dni, edad);
        init (numCuenta,false);
    }

    public Cliente(String numCuenta, boolean vip, String nombre, String apellido, String dni, int edad) {
        super(nombre, apellido, dni, edad);
        init(numCuenta,vip);
    }
    
    public void init(String numCuenta, boolean vip){
        this.numCuenta = numCuenta;
        this.vip = vip;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }
    
    

    @Override
    public String toString() {
        return "\n Cliente:" + super.toString() + 
                "\n Numero Cuenta: " + numCuenta;
    }
}
