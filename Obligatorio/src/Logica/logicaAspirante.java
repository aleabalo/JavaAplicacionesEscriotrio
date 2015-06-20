/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import DataTypes.DataArea;
import DataTypes.DataAspirante;
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

}
