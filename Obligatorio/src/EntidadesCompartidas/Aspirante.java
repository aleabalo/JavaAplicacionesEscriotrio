/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesCompartidas;

import java.util.List;

/**
 *
 * @author ale
 */
public class Aspirante {

    private String Cedula;
    private String Nombre;
    private String Apellido;
    private int Edad;
    private String ArchivoPdf;
    private List<Area> areasDeInteres;

    public List<Area> getAreasDeInteres() {
        return areasDeInteres;
    }

    public void setAreasDeInteres(List<Area> areasDeInteres) {
        this.areasDeInteres = areasDeInteres;
    }

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

    public boolean addAreaInteres(Area e) {
        return areasDeInteres.add(e);
    }

    public boolean removeAreaInteres(Area o) {
        return areasDeInteres.remove(o);
    }

    public Aspirante(String Cedula, String Nombre, String Apellido, int Edad, String ArchivoPdf, List<Area> areasDeInteres) {
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
        this.ArchivoPdf = ArchivoPdf;
        this.areasDeInteres = areasDeInteres;
    }

    public Aspirante(String Cedula, String Nombre, String Apellido, int Edad, String ArchivoPdf) {
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
        this.ArchivoPdf = ArchivoPdf;
    }
    
    

    public Aspirante() {
    }

}
