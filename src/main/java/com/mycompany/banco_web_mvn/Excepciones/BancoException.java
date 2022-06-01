<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banco_web_mvn.Excepciones;

/**
 *
 * @author Marian
 */
public class BancoException extends Exception  {
	private static String mensaje = "Ha ocurrido un problema, intente más tarde";
	
	@Override
	public String getMessage() {
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
 * @author Marian
 */
public class BancoException extends Exception  {
	private static String mensaje = "Ha ocurrido un problema, intente más tarde";
	
	@Override
	public String getMessage() {
		return mensaje;
	}

}
>>>>>>> e5e6dfc7f168ea1f1fd44422a845917a9237fb13
