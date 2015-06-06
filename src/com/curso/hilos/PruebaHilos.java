/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.hilos;

import com.curso.jpa.conexion.Conexion;
import com.curso.jpa.tablas.Mascotas;
import com.curso.jpa.tablas.Usuarios;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public class PruebaHilos {

    public static void main(String[] args) throws InterruptedException {
        Thread hiloMascotas_t = new Thread(new HiloConsultaBaseDatos(new Mascotas()));
        Thread hiloUsuarios_t = new Thread(new HiloConsultaBaseDatos(new Usuarios()));

        Conexion.getConexionBD();

        System.out.println("Va a iniciar hilos");
        hiloUsuarios_t.start();
        hiloMascotas_t.start();
        

        System.out.println("HiloMascota: " + hiloMascotas_t.getState().toString());
        System.out.println("HiloUsuario: " + hiloUsuarios_t.getState().toString());

        System.out.println("Terminó el inicio de los hilos");

        while (hiloMascotas_t.getState() != Thread.State.TERMINATED || hiloUsuarios_t.getState() != Thread.State.TERMINATED) {
            System.out.println("HiloMascota: " + hiloMascotas_t.getState().toString());
            System.out.println("HiloUsuario: " + hiloUsuarios_t.getState().toString());
            Thread.currentThread().sleep(100);
        }
        
        Conexion.cerrarConexion();
        System.exit(0);
    }

}
