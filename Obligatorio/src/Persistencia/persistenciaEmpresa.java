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

/**
 *
 * @author ale
 */
public class persistenciaEmpresa {

    // este main es solo para probar que todo funcione bien, se borra despues
    public static void main(String[] args) {

        Empresa em = new Empresa(12, "Juan", "pablo", "maria");
        try {
//            persistenciaEmpresa.agregarEmpresa(em);
            Empresa em2 = null;
            em2 = persistenciaEmpresa.buscarEmpresa(12);
            System.out.println("nombre de la empresa es " + em2.getNombre());
            System.out.println("la direccion es  " + em2.getDireccion());
            System.out.println("telefono de la empresa es " + em2.getTelefono());
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }

    }

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

}
