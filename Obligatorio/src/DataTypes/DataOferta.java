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
public class DataOferta {
    
    
    private int IdOferta;
    private String CargoOf;
    private int PuestosOf;
    private String TituloOf;
    private String ReqOf;
    private DataEmpresa EmpOf;
    private DataArea AreaOf;

    public int getIdOferta() {
        return IdOferta;
    }

    public void setIdOferta(int IdOferta) {
        this.IdOferta = IdOferta;
    }

    public String getCargoOf() {
        return CargoOf;
    }

    public void setCargoOf(String CargoOf) {
        this.CargoOf = CargoOf;
    }

    public int getPuestosOf() {
        return PuestosOf;
    }

    public void setPuestosOf(int PuestosOf) {
        this.PuestosOf = PuestosOf;
    }

    public String getTituloOf() {
        return TituloOf;
    }

    public void setTituloOf(String TituloOf) {
        this.TituloOf = TituloOf;
    }

    public String getReqOf() {
        return ReqOf;
    }

    public void setReqOf(String ReqOf) {
        this.ReqOf = ReqOf;
    }

    public DataEmpresa getEmpOf() {
        return EmpOf;
    }

    public void setEmpOf(DataEmpresa EmpOf) {
        this.EmpOf = EmpOf;
    }

    public DataArea getAreaOf() {
        return AreaOf;
    }

    public void setAreaOf(DataArea AreaOf) {
        this.AreaOf = AreaOf;
    }

    public DataOferta(int IdOferta, String CargoOf, int PuestosOf, String TituloOf, String ReqOf, DataEmpresa EmpOf, DataArea AreaOf) {
        this.IdOferta = IdOferta;
        this.CargoOf = CargoOf;
        this.PuestosOf = PuestosOf;
        this.TituloOf = TituloOf;
        this.ReqOf = ReqOf;
        this.EmpOf = EmpOf;
        this.AreaOf = AreaOf;
    }

    public DataOferta() {
    }
    
}
