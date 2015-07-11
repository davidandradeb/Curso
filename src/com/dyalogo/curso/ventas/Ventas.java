/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dyalogo.curso.ventas;

import com.curso.jpa.tablas.Usuarios;
import com.dyalogo.curso.ventas.dao.DAOUsuarios;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public class Ventas {

    private final static BufferedReader objLectorEntradasUsuario_t = new BufferedReader(new InputStreamReader(System.in));
    private String strLineaDigitada_t;

    public static void main(String[] args) throws IOException {
        DAOUsuarios daoUsuarios_t = new DAOUsuarios();
        Usuarios objUsuario_t;
        String usuario, contrasena;

        System.out.println("Digite el usuario: ");
        usuario = objLectorEntradasUsuario_t.readLine();

        System.out.println("Digite la contraseña: ");
        contrasena = objLectorEntradasUsuario_t.readLine();

        try {
            objUsuario_t = daoUsuarios_t.login(usuario, contrasena);
            if(objUsuario_t!=null){
                System.out.println("Su perfil es: "+objUsuario_t.getPerfil());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.exit(0);

    }
}
