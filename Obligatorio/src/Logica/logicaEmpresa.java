/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import DataTypes.DataEmpresa;
import Expecioneas.EmpresaExisteException;
import Expecioneas.EmpresaNoExisteException;
import Persistencia.persistenciaEmpresa;
import java.util.ArrayList;

/**
 *
 * @author ale
 */
public class logicaEmpresa {

    private static logicaEmpresa lg = null;

    public logicaEmpresa() {
    }

    public static logicaEmpresa getInstance() {
        if (lg == null) {
            lg = new logicaEmpresa();
        }

        return lg;
    }

    public DataEmpresa convertirEmpresaEnDatatype(Empresa e) {
        DataEmpresa em = new DataEmpresa();
        em.setDireccion(e.getDireccion());
        em.setNombre(e.getNombre());
        em.setRut(e.getRut());
        em.setTelefono(e.getTelefono());

        return em;
    }

    public Empresa convertirDatatypeEnEmpresa(DataEmpresa e) {
        Empresa em = new Empresa();
        em.setDireccion(e.getDireccion());
        em.setNombre(e.getNombre());
        em.setRut(e.getRut());
        em.setTelefono(e.getTelefono());

        return em;
    }

    private void validateCrear(DataEmpresa e) throws Exception {

        if (persistenciaEmpresa.getInstance().buscarEmpresa(e.getRut()) != null) {
            throw new EmpresaExisteException();
        }
        Empresa em;
        em = convertirDatatypeEnEmpresa(e);
        if (em == null) {
            throw new Exception("Error creando la empresa");
        }

    }

    private void validateModificarElminar(int rut) throws Exception {

        if (this.buscarEmpresa(rut) == null) {
            throw new EmpresaNoExisteException();
        }
    }

    public void agregarEmpresa(DataEmpresa e) throws Exception {
        try {
            this.validateCrear(e);
            persistenciaEmpresa.getInstance().agregarEmpresa(e);

        } catch (Exception ex) {
            throw ex;
        }
    }

    public DataEmpresa buscarEmpresa(int rut) throws Exception {
        try {
            DataEmpresa e = persistenciaEmpresa.getInstance().buscarEmpresa(rut);
            if (e == null)
                throw new EmpresaNoExisteException();
            return e;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void modificarEmpresa(DataEmpresa e) throws Exception {

        try {

            Empresa emp = this.convertirDatatypeEnEmpresa(e);
            if (emp != null) {
                validateModificarElminar(emp.getRut());
                persistenciaEmpresa.getInstance().modificarEmpresa(e);
            }

        } catch (Exception ex) {
            throw ex;
        }

    }

    public void eliminarEmpresa(int rut) throws Exception {
        try {
            persistenciaEmpresa.getInstance().eliminarEmpresa(rut);
        } catch (Exception ex) {
            throw ex;
        }

    }

    public ArrayList<DataEmpresa> ListEmpresa() throws Exception {
        try {
            return persistenciaEmpresa.getInstance().ListEmpresa();
        } catch (Exception ex) {
            throw ex;
        }

    }

}
