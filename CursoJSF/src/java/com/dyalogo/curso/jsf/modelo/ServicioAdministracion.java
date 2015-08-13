/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dyalogo.curso.jsf.modelo;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public class ServicioAdministracion {
    private ServicioMascotas svrMascotas_t;

    public ServicioAdministracion() {
        svrMascotas_t = new ServicioMascotas();
    }

    
    
    
    public ServicioMascotas getSvrMascotas_t() {
        return svrMascotas_t;
    }

    public void setSvrMascotas_t(ServicioMascotas svrMascotas_t) {
        this.svrMascotas_t = svrMascotas_t;
    }
    
    
    
    

}
