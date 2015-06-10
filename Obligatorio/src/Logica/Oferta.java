/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author ale
 */
public class Oferta {
    
    private int id;
    private String Cargo;
    private int Puestos;
    private String Titulo;
    private String Requerimientos;
    private Empresa empresa;
    private Area area;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public int getPuestos() {
        return Puestos;
    }

    public void setPuestos(int Puestos) {
        this.Puestos = Puestos;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getRequerimientos() {
        return Requerimientos;
    }

    public void setRequerimientos(String Requerimientos) {
        this.Requerimientos = Requerimientos;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Oferta(int id, String Cargo, int Puestos, String Titulo, String Requerimientos, Empresa empresa, Area area) {
        this.id = id;
        this.Cargo = Cargo;
        this.Puestos = Puestos;
        this.Titulo = Titulo;
        this.Requerimientos = Requerimientos;
        this.empresa = empresa;
        this.area = area;
    }

    public Oferta() {
    }
    
    
    
}
