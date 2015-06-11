/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataTypes;

import java.util.List;

/**
 *
 * @author Estefanía
 */
public class DataAspirante {
    
    private String CI;
    private String NomAsp;
    private String ApAsp;
    private int EdadAsp;
    private String CvAsp;
    private List<DataArea> AreasInteres;

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public String getNomAsp() {
        return NomAsp;
    }

    public void setNomAsp(String NomAsp) {
        this.NomAsp = NomAsp;
    }

    public String getApAsp() {
        return ApAsp;
    }

    public void setApAsp(String ApAsp) {
        this.ApAsp = ApAsp;
    }

    public int getEdadAsp() {
        return EdadAsp;
    }

    public void setEdadAsp(int EdadAsp) {
        this.EdadAsp = EdadAsp;
    }

    public String getCvAsp() {
        return CvAsp;
    }

    public void setCvAsp(String CvAsp) {
        this.CvAsp = CvAsp;
    }

    public List<DataArea> getAreasInteres() {
        return AreasInteres;
    }

    public void setAreasInteres(List<DataArea> AreasInteres) {
        this.AreasInteres = AreasInteres;
    }

    public DataAspirante(String CI, String NomAsp, String ApAsp, int EdadAsp, String CvAsp, List<DataArea> AreasInteres) {
        this.CI = CI;
        this.NomAsp = NomAsp;
        this.ApAsp = ApAsp;
        this.EdadAsp = EdadAsp;
        this.CvAsp = CvAsp;
        this.AreasInteres = AreasInteres;
    }

    public DataAspirante() {
    }
    
    
}
