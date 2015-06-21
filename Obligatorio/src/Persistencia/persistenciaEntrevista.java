/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import DataTypes.DataEntrevista;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;

/**
 *
 * @author Estefanía
 */
public class persistenciaEntrevista {
    
    //Singleton
    private persistenciaEntrevista() {
    }
    private static persistenciaEntrevista entrevista = null;

    public static persistenciaEntrevista getInstance() {
        if (entrevista == null) {
            entrevista = new persistenciaEntrevista();
        }

        return entrevista;
    }
    
    //Alta de Entrevista    
    public void agendarEntrevista(DataEntrevista e) throws Exception {
        try {
            Connection con = (Connection) iniciarConexion.getConection();
            CallableStatement ps;
            ps = (CallableStatement) con.prepareCall("{call agendarEntrevista (?,?,?)}");
            ps.setInt(1, e.getOferta().getId());
            ps.setString(2, e.getAspirante().getCedula());
            ps.setDate(3, (Date)e.getFechaEntrevista());         
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    //Metodo para verificar que no se solape una entrevista con otra ya existente
    
}
