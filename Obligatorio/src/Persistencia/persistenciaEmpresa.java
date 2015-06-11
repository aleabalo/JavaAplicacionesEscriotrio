/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

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

    public static void agregarEmpresa(Empresa e) throws Exception {

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

    public static void modificarEmpresa(Empresa e) throws Exception {

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

    public static Empresa buscarEmpresa(int rut) throws Exception {

        try {
            Connection con = iniciarConexion.getConection();
            CallableStatement ps;
            ps = con.prepareCall("{call buscarEmpresa (?)}");
            ps.setInt(1, rut);
            ResultSet rs;
            rs = ps.executeQuery();
            Empresa em = null;

            if (rs.first()) {
                String nomre = rs.getString(1);
                String direccion = rs.getString(2);
                String telefono = rs.getString(3);
                em = new Empresa(rut, nomre, direccion, telefono);
            }

            return em;
        } catch (Exception ex) {
            throw ex;

        }
    }

    public static void eliminarEmpresa(int rut) throws Exception {

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

    public static ArrayList<Empresa> ListEmpresa() throws Exception {

        try {
            Connection con = iniciarConexion.getConection();
            CallableStatement ps;
            ps = con.prepareCall("{call listarEmpresa}");
            ResultSet rs;
            rs = ps.executeQuery();
            ArrayList<Empresa> empersas = new ArrayList<>();

            if (rs.first()) {
                do {
                    Empresa em = null;
                    int rut = rs.getInt(1);
                    String nomre = rs.getString(2);
                    String direccion = rs.getString(3);
                    String telefono = rs.getString(4);
                    em = new Empresa(rut, nomre, direccion, telefono);
                    empersas.add(em);

                } while (rs.next());

            }
            return empersas;
        } catch (Exception ex) {
            throw ex;

        }
    }

}
