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
public class DataOferta {
    
    
    private int id;
    private String Cargo;
    private int Puestos;
    private String Titulo;
    private String Requerimientos;
    private DataEmpresa empresa;
    private DataArea area;
    private List<DataAspirante> aspirante;

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

    public DataEmpresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(DataEmpresa empresa) {
        this.empresa = empresa;
    }

    public DataArea getArea() {
        return area;
    }

    public void setArea(DataArea area) {
        this.area = area;
    }

    public List<DataAspirante> getAspirante() {
        return aspirante;
    }

    public void setAspirante(List<DataAspirante> aspirante) {
        this.aspirante = aspirante;
    }   

    public DataOferta() {
    }
    
    @Override
    public String toString() {
        String nombre = this.Titulo;
        return nombre;
    }
    
}
