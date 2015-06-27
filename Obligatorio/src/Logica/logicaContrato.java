/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import DataTypes.DataContrato;

/**
 *
 * @author Estefanía
 */
public class logicaContrato {

    //Singleton
    private static logicaContrato lg = null;

    public logicaContrato() {
    }

    public static logicaContrato getInstance() {
        if (lg == null) {
            lg = new logicaContrato();
        }
        return lg;
    }

    public DataContrato convertirContratoEnDatatype(Contrato c) {
        DataContrato cn = new DataContrato();
        cn.setEntrev(logicaEntrevista.getInstance().convertirEntrevistaEnDatatype(c.getEntrev()));
        cn.setFechaCaducidad(c.getFechaCaducidad());
        cn.setFechaInicio(c.getFechaInicio());
        cn.setNumero(c.getNumero());
        cn.setSueldo(c.getSueldo());
//        if ()   
    
        cn.setTipoContrato(c.getClass().toString());
        return cn;
    }

}
