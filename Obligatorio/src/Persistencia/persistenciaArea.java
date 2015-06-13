/*
 * To change this template, choose Tools | Templates
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
 * @author sistemas
 */
public class persistenciaArea {

    private persistenciaArea() {
    }

    private static persistenciaArea area = null;

    public static persistenciaArea getInstance() {
        if (area == null) {
            area = new persistenciaArea();
        }

        return area;
    }

    //Alta de Area
    public void altaArea(DataArea a) throws Exception {

        try {
            Connection con = (Connection) iniciarConexion.getConection();
            CallableStatement ps;
            ps = (CallableStatement) con.prepareCall("{call altaArea (?)}");
            ps.setString(1, a.getDescripcion());
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        }
    }

    //Modificacion de Area
    public void modArea(DataArea a) throws Exception {

        try {
            Connection con = (Connection) iniciarConexion.getConection();
            CallableStatement ps;
            ps = (CallableStatement) con.prepareCall("{call modArea (?,?)}");
            ps.setInt(1, a.getId());
            ps.setString(2, a.getDescripcion());
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        }
    }

    //Eliminar Area
    public void eliminarArea(int a) throws Exception {

        try {
            Connection con = (Connection) iniciarConexion.getConection();
            CallableStatement ps;
            ps = (CallableStatement) con.prepareCall("{call eliminarArea (?)}");
            ps.setInt(1, a);
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
        public void eliminarAreaAspirante(DataArea area, DataAspirante aspirante) throws Exception {

        try {
            Connection con = (Connection) iniciarConexion.getConection();
            CallableStatement ps;
            ps = (CallableStatement) con.prepareCall("{call bajaAreaAspirante (?,?)}");
//            ps.setInt(1, aspirante.getCedula());
            
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        }
    }

    //Buscar Area, pendiente de hacer el metodo en la base
    public DataArea buscarArea(int id) throws Exception {
        try {
            Connection con = (Connection) iniciarConexion.getConection();
            CallableStatement ps;
            ps = (CallableStatement) con.prepareCall("{call buscarArea (?)}");
            ps.setInt(1, id);
            ResultSet rs;
            rs = ps.executeQuery();
            DataArea area = null;

            if (rs.first()) {
                area = new DataArea();
                area.setId(rs.getInt(1));
                area.setDescripcion(rs.getString(2));
            }
            return area;
        } catch (Exception ex) {
            throw ex;
        }
    }

    //Listar Areas
    public ArrayList<DataArea> ListarAreas() throws Exception {
        try {
            Connection con = (Connection) iniciarConexion.getConection();
            CallableStatement ps;
            ps = (CallableStatement) con.prepareCall("{call listarArea}");
            ResultSet rs;
            rs = ps.executeQuery();
            ArrayList<DataArea> areas = new ArrayList<>();

            if (rs.first()) {
                do {
                    DataArea ar = new DataArea();
                    ar.setId(rs.getInt(1));
                    ar.setDescripcion(rs.getString(2));
                    areas.add(ar);
                } while (rs.next());
            }
            return areas;
        } catch (Exception ex) {
            throw ex;
        }
    }

    //Listar Areas por Aspirante
    public ArrayList<DataArea> ListarAreasAspirante(DataAspirante aspirante) throws Exception {
        try {
            Connection con = (Connection) iniciarConexion.getConection();
            CallableStatement ps;
            ps = (CallableStatement) con.prepareCall("{call buscarAreaAspirante (?)}");
            ps.setString(1, aspirante.getCedula());
            ResultSet rs;
            rs = ps.executeQuery();
            ArrayList<DataArea> areas = new ArrayList<>();

            if (rs.first()) {
                do {
                    DataArea ar = new DataArea();
                    ar.setId(rs.getInt(1));
                    ar.setDescripcion(rs.getString(2));
                    areas.add(ar);
                } while (rs.next());
            }
            return areas;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void agregarAreaAspirante(DataAspirante aspirante, DataArea area, Connection con) throws Exception {

        try {
            CallableStatement ps;
            ps = (CallableStatement) con.prepareCall("{call AltaAreaAspirante (?,?)}");
            ps.setString(1, aspirante.getCedula());
            ps.setInt(2, area.getId());
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        }

    }

}
