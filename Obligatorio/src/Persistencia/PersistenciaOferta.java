/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import DataTypes.DataAspirante;
import DataTypes.DataOferta;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author sistemas
 */
public class PersistenciaOferta {

    private PersistenciaOferta() {
    }
    private static PersistenciaOferta oferta = null;

    public static PersistenciaOferta getInstance() {
        if (oferta == null) {
            oferta = new PersistenciaOferta();
        }

        return oferta;
    }

    //Alta de Oferta
    public void altaOferta(DataOferta o) throws Exception {
        Connection con = null;
        CallableStatement ps = null;
        try {
            con = (Connection) iniciarConexion.getConection();            

            ps = (CallableStatement) con.prepareCall("{call altaOferta (?,?,?,?,?,?)}");
            ps.setString(1, o.getCargo());
            ps.setInt(2, o.getPuestos());
            ps.setString(3, o.getTitulo());
            ps.setString(4, o.getRequerimientos());
            ps.setInt(5, o.getEmpresa().getRut());
            ps.setInt(6, o.getArea().getId());
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        } finally {
            ps.close();
            con.close();
        }
    }

    //Modificacion de Oferta
    public void modOferta(DataOferta o) throws Exception {
        Connection con = null;
        CallableStatement ps = null;
        try {
            con = (Connection) iniciarConexion.getConection();
            ps = (CallableStatement) con.prepareCall("{call modOferta (?,?,?,?,?,?,?)}");
            ps.setInt(1, o.getId());
            ps.setString(2, o.getCargo());
            ps.setInt(3, o.getPuestos());
            ps.setString(4, o.getTitulo());
            ps.setString(5, o.getRequerimientos());
            ps.setInt(6, o.getEmpresa().getRut());
            ps.setInt(7, o.getArea().getId());
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        }finally {
            ps.close();
            con.close();
        }
    }

    //Buscar Oferta
    public DataOferta buscarOferta(int id) throws Exception {
        Connection con = null;
        CallableStatement ps = null;
        try {
            con = (Connection) iniciarConexion.getConection();
            ps = (CallableStatement) con.prepareCall("{call buscarOferta (?)}");
            ps.setInt(1, id);
            ResultSet rs;
            rs = ps.executeQuery();
            DataOferta oferta = null;
            
            if (rs.first()) {
                oferta = new DataOferta();
                oferta.setId(rs.getInt(1));
                oferta.setCargo(rs.getString(2));
                oferta.setPuestos(rs.getInt(3));
                oferta.setTitulo(rs.getString(4));
                oferta.setRequerimientos(rs.getString(5));
                oferta.setEmpresa(persistenciaEmpresa.getInstance().buscarEmpresa(rs.getInt(7)));
                oferta.setArea(persistenciaArea.getInstance().buscarArea(rs.getInt(8)));
                oferta.setAspirante(listarSolicitudesOferta(rs.getInt(1)));
            }
            rs.close();
            return oferta;
        } catch (Exception ex) {
            throw ex;
        }finally {
            ps.close();
            con.close();
        }
    }

    //Desactivar Oferta
    public void desactivarOferta(DataOferta o) throws Exception {
        Connection con = null;
        CallableStatement ps = null;
        try {
            con = (Connection) iniciarConexion.getConection();
            ps = (CallableStatement) con.prepareCall("{call desactivarOferta (?)}");
            ps.setInt(1, o.getId());
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        }finally {
            ps.close();
            con.close();
        }
    }

    //Listar de Ofertas Activas
    public ArrayList<DataOferta> listaOferta() throws Exception {
        Connection con = null;
        CallableStatement ps = null;
        try {
            con = (Connection) iniciarConexion.getConection();
            ps = (CallableStatement) con.prepareCall("{call listaOferta}");
            ResultSet rs;
            rs = ps.executeQuery();
            ArrayList<DataOferta> ofertas = new ArrayList<>();

            if (rs.first()) {
                do {
                    DataOferta of = new DataOferta();
                    of.setId(rs.getInt(1));
                    of.setCargo(rs.getString(2));
                    of.setPuestos(rs.getInt(3));
                    of.setTitulo(rs.getString(4));
                    of.setRequerimientos(rs.getString(5));
                    of.setEmpresa(persistenciaEmpresa.getInstance().buscarEmpresa(rs.getInt(7)));
                    of.setArea(persistenciaArea.getInstance().buscarArea(rs.getInt(8)));
                    of.setAspirante(listarSolicitudesOferta(rs.getInt(1)));
                    ofertas.add(of);
                } while (rs.next());
            }
            rs.close();
            return ofertas;
        } catch (Exception ex) {
            throw ex;
        }finally {
            ps.close();
            con.close();
        }
    }

    //Lista de Aspirantes registrados a la Oferta
    public ArrayList<DataAspirante> listarSolicitudesOferta(int Id) throws Exception {
        Connection con = null;
        CallableStatement ps = null;
        try {
            con = (Connection) iniciarConexion.getConection();
            ps = (CallableStatement) con.prepareCall("{call listarSolicitudesOferta(?)}");
            ps.setInt(1, Id);
            ResultSet rs;
            rs = ps.executeQuery();
            ArrayList<DataAspirante> aspirantes = new ArrayList<>();
            if (rs.first()) {
                do {
                    DataAspirante as = new DataAspirante();
                    as = persistenciaAspirante.getInstance().buscarAspirante(rs.getString(2));
                    aspirantes.add(as);
                } while (rs.next());
            }
            rs.close();
            return aspirantes;
        } catch (Exception ex) {
            throw ex;
        }finally {
            ps.close();
            con.close();
        }
    }

    //Solicitar entrevista para una oferta    
    public void solicitarEntrevista(DataOferta o, DataAspirante a) throws Exception {
        Connection con = null;
        CallableStatement ps = null;
        try {
            con = (Connection) iniciarConexion.getConection();
            ps = (CallableStatement) con.prepareCall("{call solicitarEntrevista (?,?)}");
            ps.setInt(1, o.getId());
            ps.setString(2, a.getCedula());
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        }finally {
            ps.close();
            con.close();
        }
    }    
    
    //Denegar solicitud de entrevista a un Aspirante
    public void rechazarEntrevista(DataOferta o, DataAspirante a) throws Exception {
        Connection con = null;
        CallableStatement ps = null;
        try {
            con = (Connection) iniciarConexion.getConection();
            ps = (CallableStatement) con.prepareCall("{call bajaSolicitudEntrevista (?,?)}");
            ps.setInt(1, o.getId());
            ps.setString(2, a.getCedula());
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        }finally {
            ps.close();
            con.close();
        }
    }
}
