/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Date;

/**
 *
 * @author ale
 */
public class Entrevista {
     private int idEntrevista;
     private Date fechaEntrevista;     
     private Oferta oferta;
     private Aspirante aspirante;

    public Date getFechaEntrevista() {
        return fechaEntrevista;
    }

    public void setFechaEntrevista(Date fechaEntrevista) {
        this.fechaEntrevista = fechaEntrevista;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public Aspirante getAspirante() {
        return aspirante;
    }

    public void setAspirante(Aspirante aspirante) {
        this.aspirante = aspirante;
    }

    public int getIdEntrevista() {
        return idEntrevista;
    }

    public void setIdEntrevista(int idEntrevista) {
        this.idEntrevista = idEntrevista;
    }   

    public Entrevista(int idEnt, Date fechaEntrevista, Oferta oferta, Aspirante aspirante) {
        this.idEntrevista = idEnt;
        this.fechaEntrevista = fechaEntrevista;        
        this.oferta = oferta;
        this.aspirante = aspirante;
    }

    public Entrevista() {
    }
       
    
}
