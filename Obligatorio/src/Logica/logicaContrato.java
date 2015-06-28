/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import DataTypes.DataComision;
import DataTypes.DataContrato;
import Persistencia.persistenciaContrato;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
            if(dc == null){
                 Contrato con = convertirDatatypeEnContrato(c);
                persistenciaContrato.getInstance().altaContrato(c);                
            } else {
                Contrato co = this.convertirDatatypeEnContrato(dc);
                if(co.getClass().getName()=="Contrato"){
                    //Si es un contrato efectivo entonces no puede tener otro
                    throw new Exception("El Aspirante ya tiene un contrato para la Oferta");
                } else {
                    ContratoTermino ct = (ContratoTermino)co;
                    Date fecha = ct.getFechaCaducidad();
                    Date actual = new Date();
                    if(fecha.after(actual)){
                        //Si es un contrato a termino pero aun no finalizo entonces no puede tener otro
                        throw new Exception("El Aspirante ya tiene un contrato para la Oferta");
                    } else {
                        //Si es un contrato a termino pero ya finalizo puede tener otro
                        persistenciaContrato.getInstance().altaContrato(c); 
                    }
                }
            }            
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    //Listo los contratos existentes
    public List<DataContrato> listaContrato() throws Exception{
        try {
            return persistenciaContrato.getInstance().listaContrato();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    //Metodo para listar las comisiones para cobrar dado un mes y un anio
    public ArrayList<DataComision> listaComisiones(int mes, int anio) throws Exception{
        try {
            //Seteo una fecha como el primer dia del mes y anio ingresados y otra sumando 1 mes
            Calendar cal = Calendar.getInstance();
            cal.set(anio, mes, 01);
            Calendar calfinEfectivo = Calendar.getInstance();
            calfinEfectivo = cal;
            calfinEfectivo.add(Calendar.MONTH, 3);
            Calendar calfinTermino = Calendar.getInstance();
            calfinTermino = cal;
            calfinTermino.add(Calendar.MONTH, 1);            
            ArrayList<DataComision> comisiones = new ArrayList<DataComision>();
            //traigo toda la lista de los contratos existentes
            List<DataContrato> contratos = this.listaContrato();
            //Para cada contrato tengo que verificar que si es a termino la fecha de inicio este entre la fecha ingresada y +30 dias
            //Y si es Efectivo tengo que verificar que la fecha de inicio est
            for(DataContrato dc: contratos){                
                if(dc.getTipoContrato()=="Termino"){
                    Calendar ter = Calendar.getInstance();
                    ter.setTime(dc.getFechaInicio());
                    if(ter.after(cal)&& ter.before(calfinTermino)){
                        DataComision com = new DataComision();
                        com.setNombreAspirante(dc.getEntrev().getAspirante().toString());
                        com.setMontoComision(dc.getSueldo()*0.1);
                        comisiones.add(com);
                    }
                } else if(dc.getTipoContrato()=="Efectivo"){
                    Calendar term = Calendar.getInstance();
                    term.setTime(dc.getFechaInicio());
                    if(term.after(cal)&& term.before(calfinEfectivo)){
                        DataComision com = new DataComision();
                        com.setNombreAspirante(dc.getEntrev().getAspirante().toString());
                        com.setMontoComision(dc.getSueldo()*0.1);
                        comisiones.add(com);
                    }
                }
            }            
            return comisiones;
        } catch (Exception ex) {
            throw ex;
        }
    }

}
