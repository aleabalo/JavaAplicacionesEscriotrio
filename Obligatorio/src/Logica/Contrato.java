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
public class Contrato {
    
    private int numero;
    private double sueldo;
    private Date fechaInicio;
    private Date fechaCaducidad;
    private Entrevista entrev;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Entrevista getEntrev() {
        return entrev;
    }

    public void setEntrev(Entrevista entrev) {
        this.entrev = entrev;
    }
    
    

    /**
    * Devuelve la comision que se va a cobrar
     * @return dobule comision
    */
    public double comision(){
        double comision;
        comision = (sueldo / 100) * 10;
        return comision;
    }
    
    
    /**
    * Se fija si hay que cobrar comision o no
    * @return boolean
    */
    public boolean cobraComision(){
    
        Calendar fehainicio = Calendar.getInstance();
        Calendar fechafin = Calendar.getInstance();
        
        fehainicio.setTime(fechaInicio);
        fechafin.setTime(fechaCaducidad);
        fechafin.add(Calendar.MONTH, -3);
        return !fehainicio.before(fechafin);
    }
    
    
    /**
    * Devuelve el sueldo posta
    * Cobra comision si hay que cobrar
    * @return double
    */
    public double sueldoSinComision(){
        double sueldoFinal;
        if (cobraComision()){
           sueldoFinal = this.getSueldo() - comision();
        } else {
            sueldoFinal = this.getSueldo();
        }
        return sueldoFinal;
    }
    
    public Contrato(int numero, double sueldo, Date fechaInicio, Date fechaCaducidad, Entrevista _entrevista) {
        this.numero = numero;
        this.sueldo = sueldo;
        this.fechaInicio = fechaInicio;
        this.fechaCaducidad = fechaCaducidad;
        this.entrev = _entrevista;
    }

    public Contrato() {
    }
    
    
    
}
