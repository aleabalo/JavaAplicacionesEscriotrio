/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesCompartidas;

import java.util.Date;

/**
 *
 * @author ale
 */
public class Entrevista {
     private Date fechaEntrevista;
     private Contrato contrato;
     private Oferta oferta;
     private Aspirante aspirante;

    public Date getFechaEntrevista() {
        return fechaEntrevista;
    }

    public void setFechaEntrevista(Date fechaEntrevista) {
        this.fechaEntrevista = fechaEntrevista;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
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

    public Entrevista(Date fechaEntrevista, Contrato contrato, Oferta oferta, Aspirante aspirante) {
        this.fechaEntrevista = fechaEntrevista;
        this.contrato = contrato;
        this.oferta = oferta;
        this.aspirante = aspirante;
    }

    public Entrevista() {
    }
       
    
}
