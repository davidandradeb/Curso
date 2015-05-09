/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.bases_datos;

import com.curso.bases_datos.bd.conexion.EscepcionConexionBaseDatos;
import java.sql.SQLException;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public class ProgramaPrincipal {

    public static void main(String[] args) throws EscepcionConexionBaseDatos, SQLException {
        AccesoDatosMascotas objAccesoDatomascota_t;
        AccesoDatosUsuarios daoUsuarios_t = new AccesoDatosUsuarios();

        objAccesoDatomascota_t = new AccesoDatosMascotas();
        int intIdMascotaNueva_t = 0;

        try {
            objAccesoDatomascota_t.crear("perro", "mateo", 12, 1);
        } catch (ExcepcionMascotaExiste e) {
            System.out.println(e.getLocalizedMessage());
        }

        try {
            intIdMascotaNueva_t = objAccesoDatomascota_t.crear("leon", "fernando", 15, 3);
            System.out.println("ID: " + intIdMascotaNueva_t);
        } catch (ExcepcionMascotaExiste e) {
            System.out.println(e.getLocalizedMessage());
        }

        
        int idUsuariRicardo = daoUsuarios_t.crearUsuario("ricardo.montes@dyalogo.com", "ricardo");
        System.out.println("IDRicardo: "+idUsuariRicardo);
        
        System.out.println("\nMascotas del usuario 3: ");
        for(String nombreMascota : objAccesoDatomascota_t.mascotasXUsuario(3)){
            System.out.println("Nombre: " + nombreMascota);
        }
        
    }

}
