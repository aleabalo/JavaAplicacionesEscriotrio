/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import DataTypes.DataAspirante;
import DataTypes.DataOferta;
import Expecioneas.ExisteOfertaException;
import Expecioneas.NoExisteOfertaException;
import Persistencia.PersistenciaOferta;
import java.util.ArrayList;

/**
 *
 * @author Estefanía
 */
public class logicaOferta {
    
    //Singleton
    private static logicaOferta lg = null;
    public logicaOferta() {
    }
    public static logicaOferta getInstance() {
        if (lg == null) {
            lg = new logicaOferta();
        }
        return lg;
    }
    
    
    public DataOferta convertirOfertaEnDatatype(Oferta o) {
        DataOferta of = new DataOferta();
        of.setArea(logicaArea.getInstance().convertirAreaEnDatatype(o.getArea()));
        ArrayList<DataAspirante> lista = new ArrayList<DataAspirante>();
        for(Aspirante as: o.getAspirante()){            
            DataAspirante da = logicaAspirante.getInstance().convertirAspiranteEnDatatype(as);
            lista.add(da);
        }
        of.setAspirante(lista);
        of.setCargo(o.getCargo());
        of.setEmpresa(logicaEmpresa.getInstance().convertirEmpresaEnDatatype(o.getEmpresa()));
        of.setId(o.getId());
        of.setPuestos(o.getPuestos());
        of.setRequerimientos(o.getRequerimientos());
        of.setTitulo(o.getTitulo());

        return of;
    }
    
    public Oferta convertirDatatypeEnOferta(DataOferta o) {
        Oferta of = new Oferta();
        of.setArea(logicaArea.getInstance().convertirDatatypeEnArea(o.getArea()));
        ArrayList<Aspirante> lista = new ArrayList<Aspirante>();
        for(DataAspirante as: o.getAspirante()){            
            Aspirante da = logicaAspirante.getInstance().convertirDatatypeEnAspirante(as);
            lista.add(da);
        }
        of.setAspirante(lista);
        of.setCargo(o.getCargo());
        of.setEmpresa(logicaEmpresa.getInstance().convertirDatatypeEnEmpresa(o.getEmpresa()));
        of.setId(o.getId());
        of.setPuestos(o.getPuestos());
        of.setRequerimientos(o.getRequerimientos());
        of.setTitulo(o.getTitulo());

        return of;
    }   
    
    public DataOferta buscarOferta(int id) throws Exception {
        try {            
            return PersistenciaOferta.getInstance().buscarOferta(id);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    private void validaExistencia(DataOferta o) throws Exception {

        if (this.buscarOferta(o.getId()) != null) {
            throw new ExisteOfertaException();
        }
    }
    
    private void validaModificarElminar(int id) throws Exception {

        if (this.buscarOferta(id) == null) {
            throw new NoExisteOfertaException();
        }
    }
    
    //Listar de Ofertas Activas
    public ArrayList<DataOferta> listaOferta() throws Exception{
        try {
            return PersistenciaOferta.getInstance().listaOferta();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    //Alta de Oferta
    public void altaOferta(DataOferta o) throws Exception {
        try {
            this.validaExistencia(o);
            PersistenciaOferta.getInstance().altaOferta(o);            

        } catch (Exception ex) {
            throw ex;
        }
    }
    
    //Modificacion de Oferta
    public void modOferta(DataOferta o) throws Exception{
        try{
            Oferta of = this.convertirDatatypeEnOferta(o);
            if(of != null){
                validaModificarElminar(of.getId());
                PersistenciaOferta.getInstance().modOferta(o);
            }
        } catch (Exception ex) {
            throw ex;
        }        
    }
    
    //Desactivar Oferta
    public void desactivarOferta(DataOferta o) throws Exception{
        try{
            Oferta of = this.convertirDatatypeEnOferta(o);
            if(of != null){
                validaModificarElminar(of.getId());
                PersistenciaOferta.getInstance().desactivarOferta(o);
            }
        } catch (Exception ex) {
            throw ex;
        }        
    }
    
    //Lista de Aspirantes registrados a la Oferta
    public ArrayList<DataAspirante> listarSolicitudesOferta(int Id) throws Exception {
        try{
            ArrayList<DataAspirante> listado = PersistenciaOferta.getInstance().listarSolicitudesOferta(Id);
            return listado;            
        } catch (Exception ex) {
            throw ex;
        }     
    }
    
    //Solicitar una entrevista para una Oferta dada
    public void solicitarEntrevista(DataAspirante as, DataOferta of) throws Exception{
        try{
            Oferta o = this.convertirDatatypeEnOferta(of);
            if(o != null){
                validaModificarElminar(o.getId());
                PersistenciaOferta.getInstance().solicitarEntrevista(of, as);
            }            
        } catch (Exception ex) {
            throw ex;
        }        
    }    
    
    //Denegar una solicitud de Entrevista a un candidato
    public void rechazarEntrevista(DataAspirante as, DataOferta of) throws Exception{
        try{
            Oferta o = this.convertirDatatypeEnOferta(of);
            if(o != null){
                validaModificarElminar(o.getId());
                PersistenciaOferta.getInstance().rechazarEntrevista(of, as);                
            }            
        } catch (Exception ex) {
            throw ex;
        }        
    }
    
}
