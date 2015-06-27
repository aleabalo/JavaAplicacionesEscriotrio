/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataTypes;

/**
 *
 * @author Estefanía
 */
public class DataComision {
    
    private String NombreAspirante;
    private Double MontoComision;

    public String getNombreAspirante() {
        return NombreAspirante;
    }

    public void setNombreAspirante(String NombreAspirante) {
        this.NombreAspirante = NombreAspirante;
    }

    public Double getMontoComision() {
        return MontoComision;
    }

    public void setMontoComision(Double MontoComision) {
        this.MontoComision = MontoComision;
    }
    
    public DataComision() {
    }  
    
}
