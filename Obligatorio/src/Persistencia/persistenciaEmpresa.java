/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import DataTypes.DataEmpresa;
import Logica.Empresa;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ale
 */
public class persistenciaEmpresa {

    private  persistenciaEmpresa() {
    }
    
    private static persistenciaEmpresa emp = null;

    public static persistenciaEmpresa getInstance() {
        if (emp == null)
            emp = new persistenciaEmpresa();
                
        return emp;
    }
    
    public void agregarEmpresa(DataEmpresa e) throws Exception {

        try {
            Connection con = iniciarConexion.getConection();
            CallableStatement ps;
            ps = con.prepareCall("{call altaEmpresa (?,?,?,?)}");
            ps.setInt(1, e.getRut());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getDireccion());
            ps.setString(4, e.getTelefono());
            ps.execute();
        } catch (Exception ex) {
            throw ex;

        }

    }

    public  void modificarEmpresa(DataEmpresa e) throws Exception {

        try {
            Connection con = iniciarConexion.getConection();
            CallableStatement ps;
            ps = con.prepareCall("{call modificarEmpresa (?,?,?,?)}");
            ps.setInt(1, e.getRut());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getDireccion());
            ps.setString(4, e.getTelefono());
            ps.execute();
        } catch (Exception ex) {
            throw ex;

        }

    }

    public  DataEmpresa buscarEmpresa(int rut) throws Exception {

        try {
            Connection con = iniciarConexion.getConection();
            CallableStatement ps;
            ps = con.prepareCall("{call buscarEmpresa (?)}");
            ps.setInt(1, rut);
            ResultSet rs;
            rs = ps.executeQuery();
            DataEmpresa em  = null;

            if (rs.first()) {
                em = new DataEmpresa();
                String nomre = rs.getString(1);
                String direccion = rs.getString(2);
                String telefono = rs.getString(3);
                em.setDireccion(direccion);
                em.setNombre(nomre);
                em.setRut(rut);
                em.setTelefono(telefono);
            }

            return em;
        } catch (Exception ex) {
            throw ex;

        }
    }

    public void eliminarEmpresa(int rut) throws Exception {

        try {
            Connection con = iniciarConexion.getConection();
            CallableStatement ps;
            ps = con.prepareCall("{call borrarEmpresa (?)}");
            ps.setInt(1, rut);
            ps.execute();

        } catch (Exception ex) {
            throw ex;

        }
    }

    public ArrayList<DataEmpresa> ListEmpresa() throws Exception {

        try {
            Connection con = iniciarConexion.getConection();
            CallableStatement ps;
            ps = con.prepareCall("{call listarEmpresa}");
            ResultSet rs;
            rs = ps.executeQuery();
            ArrayList<DataEmpresa> empersas = new ArrayList<>();

            if (rs.first()) {
                do {
                    DataEmpresa em = new DataEmpresa();
                    int rut = rs.getInt(1);
                    String nomre = rs.getString(2);
                    String direccion = rs.getString(3);
                    String telefono = rs.getString(4);
                    em.setDireccion(direccion);
                    em.setNombre(nomre);
                    em.setRut(rut);
                    em.setTelefono(telefono);
                    empersas.add(em);

                } while (rs.next());

            }
            return empersas;
        } catch (Exception ex) {
            throw ex;

        }
    }

}
