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

    public Entrevista(Date fechaEntrevista, Oferta oferta, Aspirante aspirante) {
        this.fechaEntrevista = fechaEntrevista;        
        this.oferta = oferta;
        this.aspirante = aspirante;
    }

    public Entrevista() {
    }
       
    
}
