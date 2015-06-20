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
public class ExisteOfertaException extends Exception{    
    @Override
    public String getMessage() {
        return "La oferta ya existe";
    }
    
}
