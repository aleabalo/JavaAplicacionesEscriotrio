/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import DataTypes.DataArea;
import DataTypes.DataAspirante;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;

/**
 *
 * @author ale
 */
public class persistenciaAspirante {
    
    
     private  persistenciaAspirante() {
    }
    
    private static persistenciaAspirante aspirante = null;
    
    public static persistenciaAspirante getInstance() {
        if (aspirante == null)
            aspirante = new persistenciaAspirante();
                
        return aspirante;
    }
    
     //Alta de Aspirante
    public void altaAspirante(DataAspirante a) throws Exception {

        try {
            Connection con = (Connection)iniciarConexion.getConection();
            CallableStatement ps;
//            Cedula,Nombre,Apellido,Edad,Cv
            ps = (CallableStatement)con.prepareCall("{call altaAspirante (?,?,?,?,?)}");
            ps.setString(1, a.getCedula());  
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getApellido());
            ps.setInt(4, a.getEdad());
            ps.setString(5, a.getArchivoPdf());
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    private DataAspirante altaAreasAspirante(){
    
    }
    
    public DataAspirante buscarAspirante(int cedula) throws Exception {
        try {
            Connection con = (Connection) iniciarConexion.getConection();
            CallableStatement ps;
            ps = (CallableStatement) con.prepareCall("{call buscarArea (?)}");
            ps.setInt(1, cedula);
            ResultSet rs;
            rs = ps.executeQuery();
            DataAspirante a = null;
            
            if(rs.first()){
                a = new DataAspirante();
//                Cedula char(10) not null, 
                //Nombre char(50) not null,
                //Apellido char(50) not null,
                //Edad smallint not null,
                //Cv char(150) not null,
                a.setNombre(rs.getString(2));
                a.setNombre(rs.getString(1));
                a.setNombre(rs.getString(1));
            }
            return area;
        } catch (Exception ex) {
            throw ex;
        }
    } 
    
}
