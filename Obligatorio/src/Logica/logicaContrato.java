/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import DataTypes.DataContrato;
import Persistencia.persistenciaContrato;

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
        if (c.getClass().getName() == "ContratoTermino") {
            cn.setTipoContrato("Termino");
        } else {
            cn.setTipoContrato("Efectivo");
        }
        return cn;
    }

    public Contrato convertirDatatypeEnContrato(DataContrato c) {
        if (c.getTipoContrato() == "Termino") {
            Contrato cn = new ContratoTermino();
            cn.setEntrev(logicaEntrevista.getInstance().convertirDatatypeEnEntrevista(c.getEntrev()));
            cn.setFechaCaducidad(c.getFechaCaducidad());
            cn.setFechaInicio(c.getFechaInicio());
            cn.setNumero(c.getNumero());
            cn.setSueldo(c.getSueldo());
            return cn;
        } else {
            Contrato cn = new Contrato();
            cn.setEntrev(logicaEntrevista.getInstance().convertirDatatypeEnEntrevista(c.getEntrev()));
            cn.setFechaCaducidad(c.getFechaCaducidad());
            cn.setFechaInicio(c.getFechaInicio());
            cn.setNumero(c.getNumero());
            cn.setSueldo(c.getSueldo());
            return cn;
        }       
    }
    
    //Busco si existe constato para una Oferta y un Aspirante Dado
    public DataContrato buscarContratoAsp(DataContrato dc) throws Exception {
        try{
            DataContrato cont = persistenciaContrato.getInstance().buscarContratoAsp(dc);
            return cont;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    
    //Alta de Contrato    
    public void altaContrato(DataContrato c) throws Exception {
        try {
            DataContrato dc = this.buscarContratoAsp(c);
            persistenciaContrato.getInstance().altaContrato(c);
        } catch (Exception ex) {
            throw ex;
        }
    }

}
