/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.jpa.modelo;

import com.curso.jpa.conexion.Conexion;
import com.curso.jpa.tablas.Mascotas;
import com.curso.jpa.tablas.Usuarios;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public class Programa {

    public static void main(String[] args) throws IOException {
        DAOUsuarios daoUsuarios_t = new DAOUsuarios();
        DAOMascotas daoMascotas_t = new DAOMascotas();

        for (Usuarios usuario : daoUsuarios_t.lista()) {
            System.out.println("ID:" + usuario.getId() + " Email: " + usuario.getEmail());

            for (Mascotas mascotaUsuario : usuario.getMascotasList()) {
                System.out.println("Nombre: " + mascotaUsuario.getNombre());
            }
        }
        
        

       
        Usuarios usuarioNuevo = new Usuarios();
        usuarioNuevo.setEmail("pepito.perez@dyalogo.com");
        usuarioNuevo.setContrasena("nose");

        try {

            daoUsuarios_t.insertar(usuarioNuevo);
            System.out.println("Usuario insertado: " + usuarioNuevo.getId());

        } catch (Exception e) {
            System.out.println("No se logro insertar el usuario, esta repetido");
        }

        
        System.out.println("Cual id de usuario quiere borrar");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String id = br.readLine();

        daoUsuarios_t.eliminar(daoUsuarios_t.obtenerByID(Integer.parseInt(id)));
        System.out.println("Usuario eliminado, reimprimir el listado");

        for (Usuarios usuario : daoUsuarios_t.lista()) {
            System.out.println("ID:" + usuario.getId() + " Email: " + usuario.getEmail());
        }

        Mascotas mascota = new Mascotas();

        mascota.setIdUsuario(usuarioNuevo);
        mascota.setColo("Rojo");
        mascota.setEdad(11);
        mascota.setNombre("ROlando");
        mascota.setTipo("Perro");

        try {
            daoMascotas_t.insertar(mascota);
        } catch (Exception ex) {
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Mascotas itemMascota : daoMascotas_t.lista()) {
            System.out.println("" + itemMascota.getNombre() + " " + itemMascota.getIdUsuario().getEmail());
        }

        Conexion.cerrarConexion();
        System.exit(0);

    }

}
