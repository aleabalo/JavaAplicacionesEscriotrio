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
public class DataEmpresa {
    
    private int RutEmp;
    private String NomEmp;
    private String DirEmp;
    private String TelEmp;

    public int getRutEmp() {
        return RutEmp;
    }

    public void setRutEmp(int RutEmp) {
        this.RutEmp = RutEmp;
    }

    public String getNomEmp() {
        return NomEmp;
    }

    public void setNomEmp(String NomEmp) {
        this.NomEmp = NomEmp;
    }

    public String getDirEmp() {
        return DirEmp;
    }

    public void setDirEmp(String DirEmp) {
        this.DirEmp = DirEmp;
    }

    public String getTelEmp() {
        return TelEmp;
    }

    public void setTelEmp(String TelEmp) {
        this.TelEmp = TelEmp;
    }

    public DataEmpresa(int RutEmp, String NomEmp, String DirEmp, String TelEmp) {
        this.RutEmp = RutEmp;
        this.NomEmp = NomEmp;
        this.DirEmp = DirEmp;
        this.TelEmp = TelEmp;
    }

    public DataEmpresa() {
    }
    
}
