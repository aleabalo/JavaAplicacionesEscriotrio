/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Expecioneas;

/**
 *
 * @author Estefanía
 */
public class NoExisteOfertaException extends Exception{    
    @Override
    public String getMessage() {
        return "La Oferta no existe";
    }
    
}
