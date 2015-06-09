/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesCompartidas;

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

    public ContratoTermino(int numero, double sueldo, Date fechaInicio, Date fechaCaducidad) {
        super(numero, sueldo, fechaInicio, fechaCaducidad);
    }

    public ContratoTermino() {
    }

}