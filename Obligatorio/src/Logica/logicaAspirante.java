/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import DataTypes.DataArea;
import DataTypes.DataAspirante;
import Expecioneas.AspiranteExisteExcepcion;
import Expecioneas.AspiranteNoExisteExcepcion;
import Persistencia.persistenciaAspirante;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import com.sun.xml.internal.ws.util.StringUtils;
import java.util.ArrayList;

/**
 *
 * @author Estefanía
 */
public class logicaAspirante {

    //Singleton
    private static logicaAspirante lg = null;
    
    public logicaAspirante() {
    }
    
    public static logicaAspirante getInstance() {
        if (lg == null) {
            lg = new logicaAspirante();
        }
        return lg;
    }
    
    public DataAspirante convertirAspiranteEnDatatype(Aspirante a) {
        DataAspirante as = new DataAspirante();
        as.setApellido(a.getApellido());
        as.setArchivoPdf(a.getArchivoPdf());
        ArrayList<DataArea> lista = new ArrayList<DataArea>();
        for (Area ar : a.getAreasDeInteres()) {
            DataArea da = logicaArea.getInstance().convertirAreaEnDatatype(ar);
            lista.add(da);
        }
        as.setAreasDeInteres(lista);
        as.setCedula(a.getCedula());
        as.setEdad(a.getEdad());
        as.setNombre(a.getNombre());
        
        return as;
    }
    
    public Aspirante convertirDatatypeEnAspirante(DataAspirante a) {
        Aspirante as = new Aspirante();
        as.setApellido(a.getApellido());
        as.setArchivoPdf(a.getArchivoPdf());
        ArrayList<Area> lista = new ArrayList<Area>();
        for (DataArea ar : a.getAreasDeInteres()) {
            Area da = logicaArea.getInstance().convertirDatatypeEnArea(ar);
            lista.add(da);
        }
        as.setAreasDeInteres(lista);
        as.setCedula(a.getCedula());
        as.setEdad(a.getEdad());
        as.setNombre(a.getNombre());
        
        return as;
    }
    
    private void validaCrearAspirante(String cedula) throws Exception {
        try {
            Aspirante as = null;
            as = convertirDatatypeEnAspirante(persistenciaAspirante.getInstance().buscarAspirante(cedula));
            if (as != null) {
                throw new AspiranteExisteExcepcion();
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    private void validaModificarAspirante(String cedula) throws Exception {
        try {
            Aspirante as = null;
            as = convertirDatatypeEnAspirante(persistenciaAspirante.getInstance().buscarAspirante(cedula));
            if (as == null) {
                throw new AspiranteNoExisteExcepcion();
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void altaAspirante(DataAspirante a) throws Exception {
        try {
            validaCrearAspirante(a.getCedula());
            persistenciaAspirante.getInstance().altaAspirante(a);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public DataAspirante buscarAspirante(String cedula) throws Exception {
        DataAspirante a = null;
        try {
            if (!cedula.isEmpty()) {
                a = persistenciaAspirante.getInstance().buscarAspirante(cedula);
            }
        } catch (Exception e) {
            throw e;
        }
        return a;
    }
    
    public void eliminarAspirante(String cedula) throws Exception {
        try {
            validaModificarAspirante(cedula);
            persistenciaAspirante.getInstance().eliminarAspirante(cedula);            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void modAspirante(DataAspirante a) throws Exception {
        
        try {
            validaModificarAspirante(a.getCedula());
            persistenciaAspirante.getInstance().modAspirante(a);           
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public ArrayList<DataAspirante> ListarAspirantes() throws Exception {
        try {
            return persistenciaAspirante.getInstance().ListarAspirantes();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
