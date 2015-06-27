/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataTypes;

import java.util.Date;

/**
 *
 * @author Estefanía
 */
public class DataContrato {
    
    private int numero;
    private double sueldo;
    private Date fechaInicio;
    private Date fechaCaducidad;
    private DataEntrevista entrev;
    private String tipoContrato;

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

    public DataEntrevista getEntrev() {
        return entrev;
    }

    public void setEntrev(DataEntrevista entrev) {
        this.entrev = entrev;
    }   

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }   

    public DataContrato() {
    }
    
    
    
    
}
