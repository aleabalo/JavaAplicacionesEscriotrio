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
public class DataEntrevista {
    
    private int idEntrevista;
    private Date fechaEntrevista;     
    private DataOferta oferta;
    private DataAspirante aspirante;

    public Date getFechaEntrevista() {
        return fechaEntrevista;
    }

    public void setFechaEntrevista(Date fechaEntrevista) {
        this.fechaEntrevista = fechaEntrevista;
    }

    public DataOferta getOferta() {
        return oferta;
    }

    public void setOferta(DataOferta oferta) {
        this.oferta = oferta;
    }

    public DataAspirante getAspirante() {
        return aspirante;
    }

    public void setAspirante(DataAspirante aspirante) {
        this.aspirante = aspirante;
    }

    public int getIdEntrevista() {
        return idEntrevista;
    }

    public void setIdEntrevista(int idEntrevista) {
        this.idEntrevista = idEntrevista;
    }   

    public DataEntrevista() {
    } 
    
    @Override
    public String toString(){
        return (this.aspirante.toString() + " - Oferta: " + this.oferta.toString());
    }
    
}
