/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import DataTypes.DataAspirante;
import DataTypes.DataEmpresa;
import DataTypes.DataEntrevista;
import DataTypes.DataOferta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
        Connection con = null;
        CallableStatement ps = null;
        try {
            con = (Connection) iniciarConexion.getConection();
            ps = (CallableStatement) con.prepareCall("{call agendarEntrevista (?,?,?)}");
            ps.setInt(1, e.getOferta().getId());
            ps.setString(2, e.getAspirante().getCedula());
            ps.setDate(3, (Date) e.getFechaEntrevista());
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        } finally {
            ps.close();
            con.close();
        }
    }

    //Lista de Entrevistas solicitadas para una empresa dada, no tienen fecha ya que aun no son entrevistas si no solicitudes sin confirmar
    public ArrayList<DataEntrevista> listarSolicitudesEmpresa(DataEmpresa e) throws Exception {
        Connection con = null;
        CallableStatement ps = null;
        try {
            con = (Connection) iniciarConexion.getConection();
            ps = (CallableStatement) con.prepareCall("{call listarSolicitudesEmpresa(?)}");
            ps.setInt(1, e.getRut());
            ResultSet rs;
            rs = ps.executeQuery();
            ArrayList<DataEntrevista> entrevistas = new ArrayList<DataEntrevista>();
            if (rs.first()) {
                do {
                    DataEntrevista en = new DataEntrevista();
                    DataOferta of = PersistenciaOferta.getInstance().buscarOferta(rs.getInt(1));
                    en.setOferta(of);
                    DataAspirante as = persistenciaAspirante.getInstance().buscarAspirante(rs.getString(2));
                    en.setAspirante(as);
                    entrevistas.add(en);
                } while (rs.next());
            }
            rs.close();
            return entrevistas;
        } catch (Exception ex) {
            throw ex;
        } finally {
            ps.close();
            con.close();
        }
    }

    //Lista de Entrevistas para un candidato dado
    public ArrayList<DataEntrevista> entrevistasCandidato(DataAspirante a) throws Exception {
        Connection con = null;
        CallableStatement ps = null;
        try {
            con = (Connection) iniciarConexion.getConection();
            ps = (CallableStatement) con.prepareCall("{call entrevistasCandidato(?)}");
            ps.setString(1, a.getCedula());
            ResultSet rs;
            rs = ps.executeQuery();
            ArrayList<DataEntrevista> entrevistas = new ArrayList<DataEntrevista>();
            if (rs.first()) {
                do {
                    DataEntrevista en = new DataEntrevista();
                    en.setIdEntrevista(rs.getInt(1));
                    DataOferta of = PersistenciaOferta.getInstance().buscarOferta(rs.getInt(2));
                    en.setOferta(of);
                    DataAspirante as = persistenciaAspirante.getInstance().buscarAspirante(rs.getString(3));
                    en.setAspirante(as);
                    en.setFechaEntrevista(rs.getDate(4));
                    entrevistas.add(en);
                } while (rs.next());
            }
            rs.close();
            return entrevistas;
        } catch (Exception ex) {
            throw ex;
        } finally {
            ps.close();
            con.close();
        }
    }

    //Buscar entrevista para un candidato y una oferta dados
    public List<DataEntrevista> buscarEntrevista(DataOferta o, DataAspirante a) throws Exception {
        Connection con = null;
        CallableStatement ps = null;
        try {
            con = (Connection) iniciarConexion.getConection();
            ps = (CallableStatement) con.prepareCall("{call buscarEntrevista(?,?)}");
            ps.setInt(1, o.getId());
            ps.setString(2, a.getCedula());
            ResultSet rs;
            rs = ps.executeQuery();
            List<DataEntrevista> listaEntrev = null;

            if (rs.first()) {
                do {
                    DataEntrevista entrev = null;
                    entrev.setIdEntrevista(rs.getInt(1));
                    DataOferta of = PersistenciaOferta.getInstance().buscarOferta(rs.getInt(2));
                    entrev.setOferta(of);
                    DataAspirante as = persistenciaAspirante.getInstance().buscarAspirante(rs.getString(3));
                    entrev.setAspirante(as);
                    entrev.setFechaEntrevista(rs.getDate(4));
                    listaEntrev.add(entrev);
                } while (rs.next());
            }
            rs.close();
            return listaEntrev;

        } catch (Exception ex) {
            throw ex;
        } finally {
            ps.close();
            con.close();
        }
    }

    //Buscar entrevista por Id
    public DataEntrevista buscarEntrevistaId(int Id) throws Exception {
        Connection con = null;
        CallableStatement ps = null;
        try {
            con = (Connection) iniciarConexion.getConection();
            ps = (CallableStatement) con.prepareCall("{call buscarEntrevistaId(?)}");
            ps.setInt(1, Id);
            ResultSet rs;
            rs = ps.executeQuery();
            DataEntrevista entrev = null;

            if (rs.first()) {                
                entrev.setIdEntrevista(rs.getInt(1));
                DataOferta of = PersistenciaOferta.getInstance().buscarOferta(rs.getInt(2));
                entrev.setOferta(of);
                DataAspirante as = persistenciaAspirante.getInstance().buscarAspirante(rs.getString(3));
                entrev.setAspirante(as);
                entrev.setFechaEntrevista(rs.getDate(4));                
            }
            rs.close();
            return entrev;

        } catch (Exception ex) {
            throw ex;
        } finally {
            ps.close();
            con.close();
        }
    }
}
