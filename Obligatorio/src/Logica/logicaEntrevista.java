/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import DataTypes.DataEntrevista;

/**
 *
 * @author Estefanía
 */
public class logicaEntrevista {
    
    //Singleton
    private static logicaEntrevista lg = null;
    public logicaEntrevista() {
    }
    public static logicaEntrevista getInstance() {
        if (lg == null) {
            lg = new logicaEntrevista();
        }
        return lg;
    }
    
    public DataEntrevista convertirEntrevistaEnDatatype(Entrevista e) {
        DataEntrevista en = new DataEntrevista();
        en.setAspirante(logicaAspirante.getInstance().convertirAspiranteEnDatatype(e.getAspirante()));
        en.setFechaEntrevista(e.getFechaEntrevista());
        en.setOferta(logicaOferta.getInstance().convertirOfertaEnDatatype(e.getOferta()));       

        return en;
    }
    
    public Entrevista convertirDatatypeEnEntrevista(DataEntrevista e) {
        Entrevista en = new Entrevista();
        en.setAspirante(logicaAspirante.getInstance().convertirDatatypeEnAspirante(e.getAspirante()));
        en.setFechaEntrevista(e.getFechaEntrevista());
        en.setOferta(logicaOferta.getInstance().convertirDatatypeEnOferta(e.getOferta()));       

        return en;
    }
    
}
