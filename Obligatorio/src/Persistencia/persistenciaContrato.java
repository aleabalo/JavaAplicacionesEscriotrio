/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import DataTypes.DataContrato;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Estefanía
 */
public class persistenciaContrato {
    
    private persistenciaContrato() {
    }
    private static persistenciaContrato contrato = null;

    public static persistenciaContrato getInstance() {
        if (contrato == null) {
            contrato = new persistenciaContrato();
        }

        return contrato;
    }
    
    //Alta de Contrato
    public void altaContrato(DataContrato c) throws Exception {
        Connection con = null;
        CallableStatement ps = null;
        try {
            con = (Connection) iniciarConexion.getConection();            

            ps = (CallableStatement) con.prepareCall("{call altaContrato (?,?,?,?,?)}");
            ps.setInt(1, c.getEntrev().getIdEntrevista());
            ps.setDouble(2, c.getSueldo());            
            ps.setDate(3, (Date) c.getFechaInicio());
            ps.setString(4, c.getTipoContrato());
            ps.setDate(5, (Date) c.getFechaCaducidad());
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        } finally {
            ps.close();
            con.close();
        }
    }
    
    //Listado de contratos
    public ArrayList<DataContrato> listaContrato() throws Exception {
        Connection con = null;
        CallableStatement ps = null;
        try {
            con = (Connection) iniciarConexion.getConection();            

            ps = (CallableStatement) con.prepareCall("{call listaContrato }");            
            ResultSet rs;
            rs = ps.executeQuery();
            ArrayList<DataContrato> contratos = null;

            if (rs.first()) {
                do {
                    DataContrato cont = new DataContrato();
                    cont.setEntrev(persistenciaEntrevista.getInstance().buscarEntrevistaId(rs.getInt(2)));
                    cont.setFechaCaducidad(rs.getDate(6));
                    cont.setFechaInicio(rs.getDate(4));
                    cont.setNumero(rs.getInt(1));
                    cont.setSueldo(rs.getDouble(3));
                    cont.setTipoContrato(rs.getString(5));
                    contratos.add(cont);
                } while (rs.next());
            }
            rs.close();
            return contratos;
        } catch (Exception ex) {
            throw ex;
        } finally {
            ps.close();
            con.close();
        }
    }
    
}
