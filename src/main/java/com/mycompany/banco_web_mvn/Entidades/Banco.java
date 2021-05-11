/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banco_web_mvn.Entidades;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * @author Marian PC
 */
public class Banco {
    
    private Queue<Cliente> fila = new ArrayDeque<>();
    private Queue<Cliente> filaPrioridad = new ArrayDeque<>();
    
    Cajero c1;
    
    boolean flag=false;
    
    public Banco(Cajero c1){
     this.c1=c1;   
    }
    
    //private ArrayList<Cajero> caja = new ArrayList(5);
    
    /*public void ingresaCajero(Cajero cajero){
        caja.add(cajero);
    }*/
    
    public Cliente atender(){
       
        Cliente cli = !filaPrioridad.isEmpty()?filaPrioridad.poll():fila.poll();
        check();
        return cli;
    }
    
    public void check(){
        if(filaPrioridad.isEmpty() && fila.isEmpty()){
            if(flag)
               notificar();
        }else if(!(filaPrioridad.isEmpty() && fila.isEmpty())){
                if(!flag)
                    notificar();
            }
    }
    
    public void notificar(){
        flag=!flag;
        c1.update(flag);
        if(flag)
            System.out.println("atendiendo");
        else
            System.out.println("en espera");
    }
    
    public int largoFila(){
        return fila.size();
    }
    
    public void ingresaPersona(Cliente cliente){
       
       boolean x = cliente.edad>65? filaPrioridad(cliente): filaRegular(cliente);
       
       check();
       
    }
    
    public void dejaFila(Cliente cliente){
        fila.remove(cliente);
    }
    
    public boolean filaPrioridad(Cliente cliente){
        return filaPrioridad.add(cliente);
        
    }
    
        public boolean filaRegular(Cliente cliente){
        return fila.add(cliente);
        
    }
    
}
