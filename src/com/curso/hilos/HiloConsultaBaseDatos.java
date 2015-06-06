/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.hilos;

import com.curso.jpa.dao.ITablas;
import com.curso.jpa.modelo.DAOMascotas;
import com.curso.jpa.modelo.DAOUsuarios;
import com.curso.jpa.tablas.Mascotas;
import com.curso.jpa.tablas.Usuarios;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public class HiloConsultaBaseDatos implements Runnable {

    private ITablas tabla;

    public HiloConsultaBaseDatos(ITablas tabla) {
        this.tabla = tabla;
    }

    @Override
    public void run() {
        DAOMascotas daoMascotas = new DAOMascotas();
        DAOUsuarios daoUsuarios = new DAOUsuarios();

        System.out.println("Inicio Hilo "+tabla.getClass().getCanonicalName());
        if (tabla instanceof Mascotas) {
            for (Mascotas mascota : daoMascotas.lista()) {
                System.out.println("Masc: " + mascota.getNombre());
            }
        } else if (tabla instanceof Usuarios) {
            for (Usuarios usu : daoUsuarios.lista()) {
                System.out.println("USU: " + usu.getEmail());
            }
        }
        
        System.out.println("Fin Hilo "+tabla.getClass().getCanonicalName());
        

    }

}
