/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dyalogo.curso.ventas.dao;

import com.curso.jpa.dao.ImpDAO;
import com.curso.jpa.tablas.Usuarios;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public class DAOUsuarios extends ImpDAO<Usuarios> {

    public DAOUsuarios() {
        super(Usuarios.class);
    }

    public Usuarios login(String usuario, String contrasena) {
        return obtenerByCondicion("usuario='" + usuario + "' and contrasena='" + contrasena + "'");
    }

}
