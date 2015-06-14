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
    
    private String Cedula;
    private String Nombre;
    private String Apellido;
    private int Edad;
    private String ArchivoPdf;
    private List<DataArea> areasDeInteres;

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getArchivoPdf() {
        return ArchivoPdf;
    }

    public void setArchivoPdf(String ArchivoPdf) {
        this.ArchivoPdf = ArchivoPdf;
    }

    public List<DataArea> getAreasDeInteres() {
        return areasDeInteres;
    }

    public void setAreasDeInteres(List<DataArea> areasDeInteres) {
        this.areasDeInteres = areasDeInteres;
    }   

    public DataAspirante() {
    }
    
    
}
