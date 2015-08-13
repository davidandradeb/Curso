/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dyalogo.curso.jsf.modelo;

import com.curso.jpa.modelo.DAOMascotas;
import com.curso.jpa.modelo.DAOUsuarios;
import com.curso.jpa.tablas.Mascotas;
import com.curso.jpa.tablas.Usuarios;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public class ServicioMascotas {
    
    private Mascotas objMascota_t = new Mascotas();
    private final DAOMascotas dAOMascotas_t;
    private DAOUsuarios daoUsuarios_t = new DAOUsuarios();
    
    public ServicioMascotas() {
        dAOMascotas_t = new DAOMascotas();
        agregar();
    }
    
    public void editar() {
        objMascota_t = dAOMascotas_t.obtenerByID(Integer.parseInt(getParametroForma("id_mascota").toString()));
        if (objMascota_t.getIdUsuario() == null) {
            objMascota_t.setIdUsuario(new Usuarios());
        }
    }
    
    public void eliminar() {
        objMascota_t = dAOMascotas_t.obtenerByID(Integer.parseInt(getParametroForma("id_mascota").toString()));
        dAOMascotas_t.eliminar(objMascota_t);
    }
    
    public void agregar() {
        objMascota_t = new Mascotas();
        objMascota_t.setIdUsuario(new Usuarios());
    }
    
    public void guardar() {
        try {
            if (objMascota_t.getId() == null) {
                dAOMascotas_t.insertar(objMascota_t);
            } else {
                dAOMascotas_t.actualizar(objMascota_t);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exito", "Registro insertado con exito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", e.getLocalizedMessage()));
        }
        
    }
    
    public List<Usuarios> getLstusuarios() {
        return daoUsuarios_t.lista();
    }
    
    public List<Mascotas> getLstMascotas() {
        return dAOMascotas_t.lista();
    }
    
    public Mascotas getObjMascota_t() {
        return objMascota_t;
    }
    
    public void setObjMascota_t(Mascotas objMascota_t) {
        this.objMascota_t = objMascota_t;
    }

    /**
     * Retorna el resultado de f:param
     *
     * @param strNomFParam_p
     * @return
     */
    public Object getParametroForma(String strNomFParam_p) {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params
                = fc.getExternalContext().getRequestParameterMap();
        return params.get(strNomFParam_p);
    }
    
}
