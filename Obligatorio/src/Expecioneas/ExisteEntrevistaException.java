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
public class ExisteEntrevistaException extends Exception{    
    @Override
    public String getMessage() {
        return "Ya tiene Entrevista registrada para esta Oferta";
    }
    
}
