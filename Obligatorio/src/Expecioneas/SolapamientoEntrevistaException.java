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
public class SolapamientoEntrevistaException extends Exception{    
    @Override
    public String getMessage() {
        return "El horario seleccionado se encuentra en conflicto con otra entrevista (Debe tener al menos 2 horas de diferencia entre una entrevista y otra)";
    }
    
}
