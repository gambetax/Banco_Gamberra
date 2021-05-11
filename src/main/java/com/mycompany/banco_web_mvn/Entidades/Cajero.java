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
public class Cajero extends Persona {
    
    String idCajero;
    boolean atender=false;
    boolean atendiendo=false;
    double chance=0.01;
    
    Banco banco;

    public Cajero() {
    }

    public Cajero(String idCajero, String caja) {
        this.idCajero = idCajero;
    }

    public Cajero(String idCajero, String nombre, String apellido, String dni, int edad) {
        super(nombre, apellido, dni, edad);
        this.idCajero = idCajero;
    }

    public String getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(String idCajero) {
        this.idCajero = idCajero;
    }
    
    public void update(boolean atender){
        this.atender=atender;
    }
    
    public void solicitar(){
        if(atender && !atendiendo){
            this.banco.atender();
            atendiendo=true;
            chance=0.01;
        }
        if(atendiendo){
            atendiendo=Math.random()<0.5;
        }
        chance+=0.05;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
