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
public class DataArea {
    
    private int Id_Area;
    private String Desc_Area;

    public int getId_Area() {
        return Id_Area;
    }

    public void setId_Area(int Id_Area) {
        this.Id_Area = Id_Area;
    }

    public String getDesc_Area() {
        return Desc_Area;
    }

    public void setDesc_Area(String Desc_Area) {
        this.Desc_Area = Desc_Area;
    }

    public DataArea(int Id_Area, String Desc_Area) {
        this.Id_Area = Id_Area;
        this.Desc_Area = Desc_Area;
    }

    public DataArea() {
    }
    
}
