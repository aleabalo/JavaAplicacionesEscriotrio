/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import DataTypes.DataAspirante;
import DataTypes.DataEmpresa;
import DataTypes.DataEntrevista;
import DataTypes.DataOferta;
import Expecioneas.ExisteEntrevistaException;
import Expecioneas.SolapamientoEntrevistaException;
import Persistencia.persistenciaEntrevista;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Estefanía
 */
public class logicaEntrevista {

    //Singleton
    private static logicaEntrevista lg = null;

    public logicaEntrevista() {
    }

    public static logicaEntrevista getInstance() {
        if (lg == null) {
            lg = new logicaEntrevista();
        }
        return lg;
    }

    public DataEntrevista convertirEntrevistaEnDatatype(Entrevista e) {
        DataEntrevista en = new DataEntrevista();
        en.setIdEntrevista(e.getIdEntrevista());
        en.setAspirante(logicaAspirante.getInstance().convertirAspiranteEnDatatype(e.getAspirante()));
        en.setFechaEntrevista(e.getFechaEntrevista());
        en.setOferta(logicaOferta.getInstance().convertirOfertaEnDatatype(e.getOferta()));

        return en;
    }

    public Entrevista convertirDatatypeEnEntrevista(DataEntrevista e) {
        Entrevista en = new Entrevista();
        en.setIdEntrevista(e.getIdEntrevista());
        en.setAspirante(logicaAspirante.getInstance().convertirDatatypeEnAspirante(e.getAspirante()));
        en.setFechaEntrevista(e.getFechaEntrevista());
        en.setOferta(logicaOferta.getInstance().convertirDatatypeEnOferta(e.getOferta()));
        return en;
    }

    public List<DataEntrevista> buscarEntrevista(DataOferta o, DataAspirante a) throws Exception {
        try {
            return persistenciaEntrevista.getInstance().buscarEntrevista(o, a);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public DataEntrevista buscarEntrevistaId(int Id) throws Exception {
        try {
            return persistenciaEntrevista.getInstance().buscarEntrevistaId(Id);
        } catch (Exception ex) {
            throw ex;
        }
    }

    private void validaExistencia(DataEntrevista e) throws Exception {

        if (this.buscarEntrevista(e.getOferta(), e.getAspirante()) != null) {
            throw new ExisteEntrevistaException();
        }
        Entrevista en;
        en = this.convertirDatatypeEnEntrevista(e);
        if (en == null) {
            throw new Exception("Error creando la entrevista");
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
                if (fecha.after(Inicio) && fecha.before(Fin)) {
                    solapa = true;
                }
            }
            return solapa;
        } catch (Exception ex) {
            throw ex;
        }
    }

    //Agendar Entrevista
    public void agendarEntrevista(DataEntrevista e) throws Exception {
        try {
            if (this.buscarEntrevista(e.getOferta(), e.getAspirante()) == null) {
                throw new ExisteEntrevistaException();
            }
            else
            {
                boolean valida = this.verificarSolapamiento(e);
                if(!valida){
                persistenciaEntrevista.getInstance().agendarEntrevista(e);
                }
                else {
                    throw new SolapamientoEntrevistaException();
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    //Lista de Entrevistas solicitadas para una empresa dada
    public ArrayList<DataEntrevista> listarSolicitudesEmpresa(DataEmpresa em) throws Exception {
        try{
            ArrayList<DataEntrevista> listado = persistenciaEntrevista.getInstance().listarSolicitudesEmpresa(em);
            return listado;            
        } catch (Exception ex) {
            throw ex;
        }     
    }

}
