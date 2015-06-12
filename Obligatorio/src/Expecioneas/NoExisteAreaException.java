/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Expecioneas;

/**
 *
 * @author sistemas
 */
public class NoExisteAreaException extends Exception{    
    @Override
    public String getMessage() {
        return "El Área no existe";
    }
}
