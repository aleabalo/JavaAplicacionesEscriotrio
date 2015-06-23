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
import java.util.ArrayList;

/**
 *
 * @author ale
 */
public class persistenciaAspirante {

    private persistenciaAspirante() {
    }

    private static persistenciaAspirante aspirante = null;

    public static persistenciaAspirante getInstance() {
        if (aspirante == null) {
            aspirante = new persistenciaAspirante();
        }

        return aspirante;
    }

    //Alta de Aspirante
    public void altaAspirante(DataAspirante a) throws Exception {

        try {
            Connection con = (Connection) iniciarConexion.getConection();
            CallableStatement ps;
            con.setAutoCommit(false);
//            Cedula,Nombre,Apellido,Edad,Cv
            ps = (CallableStatement) con.prepareCall("{call altaAspirante (?,?,?,?,?)}");
            ps.setString(1, a.getCedula());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getApellido());
            ps.setInt(4, a.getEdad());
            ps.setString(5, a.getArchivoPdf());
            ps.execute();
            for (DataArea area : a.getAreasDeInteres()) {
                persistenciaArea.getInstance().agregarAreaAspirante(a, area, con);
            }
            con.commit();

        } catch (Exception ex) {

            throw ex;
        }
    }

    public DataAspirante buscarAspirante(String cedula) throws Exception {
        try {
            Connection con = (Connection) iniciarConexion.getConection();
            CallableStatement ps;
            ps = (CallableStatement) con.prepareCall("{call buscarAspirante (?)}");
            ps.setString(1, cedula);
            ResultSet rs;
            rs = ps.executeQuery();
            DataAspirante a = null;

            if (rs.first()) {
                a = new DataAspirante();
//                Cedula char(10) not null, 
                //Nombre char(50) not null,
                //Apellido char(50) not null,
                //Edad smallint not null,
                //Cv char(150) not null,
                a.setNombre(rs.getString(2));
                a.setApellido(rs.getString(3));
                a.setEdad(rs.getInt(4));
                a.setArchivoPdf(rs.getString(5));
            }
            if (a != null) {
                a.setAreasDeInteres(persistenciaArea.getInstance().ListarAreasAspirante(a));
            }

            return a;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void eliminarAspirante(String cedula) throws Exception {

        try {
            Connection con = (Connection) iniciarConexion.getConection();
            CallableStatement ps;
            ps = (CallableStatement) con.prepareCall("{call eliminarAspirante (?)}");
            ps.setString(1, cedula);
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void modAspirante(DataAspirante a) throws Exception {

        try {
            Connection con = (Connection) iniciarConexion.getConection();
            CallableStatement ps;
            ps = (CallableStatement) con.prepareCall("{call modAspirante (?,?,?,?,?)}");
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

    public ArrayList<DataAspirante> ListarAspirantes() throws Exception {
        try {
            Connection con = (Connection) iniciarConexion.getConection();
            CallableStatement ps;
            ps = (CallableStatement) con.prepareCall("{call listarAspirante}");
            ResultSet rs;
            rs = ps.executeQuery();
            ArrayList<DataAspirante> aspirantes = new ArrayList<>();

            if (rs.first()) {
                do {
                    DataAspirante a = new DataAspirante();
                    a.setCedula(rs.getString(1));
                    a.setNombre(rs.getString(2));
                    a.setApellido(rs.getString(3));
                    a.setEdad(rs.getInt(4));
                    a.setArchivoPdf(rs.getString(5));
                    a.setAreasDeInteres(persistenciaArea.getInstance().ListarAreasAspirante(a));
                    aspirantes.add(a);
                } while (rs.next());
            }
            return aspirantes;
        } catch (Exception ex) {
            throw ex;
        }
    }

}
