/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dyalogo.curso.controlador;

import com.curso.jpa.modelo.DAOUsuarios;
import com.curso.jpa.tablas.Usuarios;
import com.dyalogo.curso.jsf.modelo.ServicioAdministracion;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author davidandrade
 */
@ManagedBean(name = "ctrlSesion")
@SessionScoped
public class ControladorSesion {

    private String strVersion_t = "1.0.0", strUsuario_t, strContrasena_t;
    private ServicioAdministracion svrAdm_t;
    private Usuarios objUsuario_t;

    public ControladorSesion() {
        svrAdm_t = new ServicioAdministracion();
    }

    public Usuarios getObjUsuario_t() {
        return objUsuario_t;
    }

    public void setObjUsuario_t(Usuarios objUsuario_t) {
        this.objUsuario_t = objUsuario_t;
    }

    public String getStrVersion_t() {
        return strVersion_t;
    }

    public void setStrVersion_t(String strVersion_t) {
        this.strVersion_t = strVersion_t;
    }

    public ServicioAdministracion getSvrAdm_t() {
        return svrAdm_t;
    }

    public void setSvrAdm_t(ServicioAdministracion svrAdm_t) {
        this.svrAdm_t = svrAdm_t;
    }

    public void iniciarSesion() {
        DAOUsuarios daoUsuarios_t = new DAOUsuarios();
        try {
            objUsuario_t = daoUsuarios_t.obtenerByCondicion("usuario='" + strUsuario_t + "' and contrasena = '" + strContrasena_t + "'");
            if (objUsuario_t != null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exito", "Bienvenido"));
                RequestContext.getCurrentInstance().execute("window.location='mascotas.jsf'");
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exito", "Usuario y/o contraseña invalido"));
            }
        } catch (javax.persistence.NoResultException nre) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exito", "Usuario y/o contraseña invalido"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", e.getLocalizedMessage()));
        }

    }

    public String getStrUsuario_t() {
        return strUsuario_t;
    }

    public void setStrUsuario_t(String strUsuario_t) {
        this.strUsuario_t = strUsuario_t;
    }

    public String getStrContrasena_t() {
        return strContrasena_t;
    }

    public void setStrContrasena_t(String strContrasena_t) {
        this.strContrasena_t = strContrasena_t;
    }

}
