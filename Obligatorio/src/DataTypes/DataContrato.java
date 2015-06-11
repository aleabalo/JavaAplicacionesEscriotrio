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
    
    private int NumCont;
    private double SdoCont;
    private Date IniCont;
    private Date FinCont;

    public int getNumCont() {
        return NumCont;
    }

    public void setNumCont(int NumCont) {
        this.NumCont = NumCont;
    }

    public double getSdoCont() {
        return SdoCont;
    }

    public void setSdoCont(double SdoCont) {
        this.SdoCont = SdoCont;
    }

    public Date getIniCont() {
        return IniCont;
    }

    public void setIniCont(Date IniCont) {
        this.IniCont = IniCont;
    }

    public Date getFinCont() {
        return FinCont;
    }

    public void setFinCont(Date FinCont) {
        this.FinCont = FinCont;
    }

    public DataContrato(int NumCont, double SdoCont, Date IniCont, Date FinCont) {
        this.NumCont = NumCont;
        this.SdoCont = SdoCont;
        this.IniCont = IniCont;
        this.FinCont = FinCont;
    }

    public DataContrato() {
    }
    
    
    
    
}
