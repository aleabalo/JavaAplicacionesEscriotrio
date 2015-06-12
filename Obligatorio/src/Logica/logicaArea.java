/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import DataTypes.DataArea;
import DataTypes.DataAspirante;
import Expecioneas.ExisteAreaException;
import Expecioneas.NoExisteAreaException;
import Persistencia.persistenciaArea;
import java.util.ArrayList;
/**
 *
 * @author sistemas
 */
public class logicaArea {
    
    //Singleton
    private static logicaArea lg = null;
    public logicaArea() {
    }
    public logicaArea getInstance() {
        if (lg == null) {
            lg = new logicaArea();
        }
        return lg;
    }
    
    private DataArea convertirAreaEnDatatype(Area a) {
        DataArea ar = new DataArea();
        ar.setId(a.getId());
        ar.setDescripcion(a.getDescripcion());

        return ar;
    }
    
    private Area convertirDatatypeEnArea(DataArea a) {
        Area ar = new Area();
        ar.setId(a.getId());
        ar.setDescripcion(a.getDescripcion());

        return ar;
    }
    
    public DataArea buscarArea(int id) throws Exception {
        try {            
            return persistenciaArea.getInstance().buscarArea(id);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    private void validaExistencia(DataArea a) throws Exception {

        if (this.buscarArea(a.getId()) != null) {
            throw new ExisteAreaException();
        }
        Area ar;
        ar = convertirDatatypeEnArea(a);
        if (ar == null) {
            throw new Exception("Error creando el area");
        }
    }
    
    private void validaModificarElminar(int id) throws Exception {

        if (this.buscarArea(id) == null) {
            throw new NoExisteAreaException();
        }
    }
    
    //Alta de Area
    public void altaArea(DataArea a) throws Exception {
        try {
            this.validaExistencia(a);
            persistenciaArea.getInstance().altaArea(a);            

        } catch (Exception ex) {
            throw ex;
        }
    }
    
    //Modificar Area
    public void modArea(DataArea a) throws Exception{
        try{
            Area ar = this.convertirDatatypeEnArea(a);
            if(ar != null){
                validaModificarElminar(ar.getId());
                persistenciaArea.getInstance().modArea(a);
            }
        } catch (Exception ex) {
            throw ex;
        }        
    }
    
    //Eliminar Area
    public void eliminarArea(DataArea a) throws Exception{
        try{
            validaModificarElminar(a.getId());
            persistenciaArea.getInstance().eliminarArea(a);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    //Listado de Areas
    public ArrayList<DataArea> ListarArea() throws Exception {
        try {
            return persistenciaArea.getInstance().ListarAreas();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    //Listado de areas por Aspirante
    public ArrayList<DataArea> ListarAreasAspirante(DataAspirante as) throws Exception {
        try {
            return persistenciaArea.getInstance().ListarAreasAspirante(as);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
}
