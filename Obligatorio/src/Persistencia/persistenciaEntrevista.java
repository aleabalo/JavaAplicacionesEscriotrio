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
import java.util.Calendar;

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
            ps.setDate(3, (Date) e.getFechaEntrevista());
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        }
    }

    //Metodo para verificar que no se solape una entrevista con otra ya existente
    //En este caso nuestro modelo establece que debe existir al menos una ventana de 2 horas entre el inicio de una entrevista y la siguiente
    // de forma que el candidato tenga el tiempo suficiente para viajar de un lugar al otro.
    public boolean verificarSolapamiento(DataEntrevista e) throws Exception {
        try {
            boolean solapa = false;
            DataAspirante a = e.getAspirante();
            ArrayList<DataEntrevista> entrevistas = persistenciaEntrevista.getInstance().entrevistasCandidato(a);
            Calendar Inicio = Calendar.getInstance();
            Inicio.setTime(e.getFechaEntrevista());
            Inicio.add(Calendar.HOUR, -2);
            Calendar Fin = Calendar.getInstance();
            Fin.setTime(e.getFechaEntrevista());
            Fin.add(Calendar.HOUR, 2);
            for (DataEntrevista ent : entrevistas) {
                Calendar fecha = Calendar.getInstance();
                fecha.setTime(ent.getFechaEntrevista());
                if(fecha.after(Inicio) && fecha.before(Fin)){
                    solapa=true;
                }
            }
            return solapa;
        } catch (Exception ex) {
            throw ex;
        }
    }

    //Lista de Entrevistas solicitadas para una empresa dada
    public ArrayList<DataEntrevista> listarSolicitudesEmpresa(DataEmpresa e) throws Exception {
        try {
            Connection con = (Connection) iniciarConexion.getConection();
            CallableStatement ps;
            ps = (CallableStatement) con.prepareCall("{call listarSolicitudesEmpresa(?)}");
            ps.setInt(1, e.getRut());
            ResultSet rs;
            rs = ps.executeQuery();
            ArrayList<DataEntrevista> entrevistas = new ArrayList<DataEntrevista>();
            if (rs.first()) {
                do {
                    DataEntrevista en = new DataEntrevista();
                    DataOferta of = PersistenciaOferta.getInstance().buscarOferta(rs.getInt(2));
                    en.setOferta(of);
                    DataAspirante as = persistenciaAspirante.getInstance().buscarAspirante(rs.getString(3));
                    en.setAspirante(as);
                    en.setFechaEntrevista(rs.getDate(4));
                    entrevistas.add(en);
                } while (rs.next());
            }
            return entrevistas;
        } catch (Exception ex) {
            throw ex;
        }
    }

    //Lista de Entrevistas para un candidato dado
    public ArrayList<DataEntrevista> entrevistasCandidato(DataAspirante a) throws Exception {
        try {
            Connection con = (Connection) iniciarConexion.getConection();
            CallableStatement ps;
            ps = (CallableStatement) con.prepareCall("{call entrevistasCandidato(?)}");
            ps.setString(1, a.getCedula());
            ResultSet rs;
            rs = ps.executeQuery();
            ArrayList<DataEntrevista> entrevistas = new ArrayList<DataEntrevista>();
            if (rs.first()) {
                do {
                    DataEntrevista en = new DataEntrevista();
                    DataOferta of = PersistenciaOferta.getInstance().buscarOferta(rs.getInt(2));
                    en.setOferta(of);
                    DataAspirante as = persistenciaAspirante.getInstance().buscarAspirante(rs.getString(3));
                    en.setAspirante(as);
                    en.setFechaEntrevista(rs.getDate(4));
                    entrevistas.add(en);
                } while (rs.next());
            }
            return entrevistas;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
