/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ale
 */
public class ContratoTermino extends Contrato {

    @Override
    public boolean cobraComision() {
        Calendar fehainicio = Calendar.getInstance();
        Calendar fechafin = Calendar.getInstance();
        fehainicio.setTime(super.getFechaInicio());
        fechafin.setTime(super.getFechaCaducidad());
        fechafin.add(Calendar.MONTH, -1);
        return !fehainicio.before(fechafin);
    }
    
    
    @Override
        public double comisionSegunFecha(Date fechaCalcular) {
        double comision = 0;
        Calendar fehainicio = Calendar.getInstance();
        Calendar fechafin = Calendar.getInstance();;
        Calendar fehainicioControl = Calendar.getInstance();;
        fehainicio.setTime(fechaCalcular);
        fehainicioControl.setTime(fechaCalcular);
        fechafin.setTime(super.getFechaInicio());
        fehainicio.add(Calendar.MONTH, -1);
        if (fehainicio.before(fechafin) && fehainicioControl.after(fechafin)){
            comision = comision();
        }

        return comision;
    }

    public ContratoTermino(int numero, double sueldo, Date fechaInicio, Date fechaCaducidad, Entrevista _entrevista) {
        super(numero, sueldo, fechaInicio, fechaCaducidad, _entrevista);
    }

    public ContratoTermino() {
    }

}
