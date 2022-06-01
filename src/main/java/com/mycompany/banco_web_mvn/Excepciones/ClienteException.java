<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banco_web_mvn.Excepciones;

/**
 *
 * @author Marian PC
 */
public class ClienteException extends Exception {
    private String mensaje;
    
    public ClienteException(String mensaje){
        this.mensaje = mensaje;
        getMessage();
    }

   /* public ClienteException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    @Override
    public String getMessage(){
        System.out.println("\n******************" + mensaje 
                + "******************\n");
        
        return mensaje;
    }
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banco_web_mvn.Excepciones;

/**
 *
 * @author Marian PC
 */
public class ClienteException extends Exception {
    private String mensaje;
    
    public ClienteException(String mensaje){
        this.mensaje = mensaje;
        getMessage();
    }

   /* public ClienteException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    @Override
    public String getMessage(){
        System.out.println("\n******************" + mensaje 
                + "******************\n");
        
        return mensaje;
    }
    
}
>>>>>>> e5e6dfc7f168ea1f1fd44422a845917a9237fb13
