/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesCompartidas;

/**
 *
 * @author ale
 */
public class Area {

    private int Id;
    private String Descripcion;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Area(int Id, String Descripcion) {
        this.Id = Id;
        this.Descripcion = Descripcion;
    }

    public Area() {
    }
    
    

}
