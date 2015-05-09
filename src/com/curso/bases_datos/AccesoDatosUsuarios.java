/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.bases_datos;

import com.curso.bases_datos.bd.conexion.EscepcionConexionBaseDatos;
import java.sql.SQLException;

/**
 * CRUD Create Read Update Delete
 *
 * @author DYALOGOSAS.davidandrade
 */
public class AccesoDatosUsuarios extends SuperAccesoDatos {

    public AccesoDatosUsuarios() {
        super("usuarios");
    }

    public int crearUsuario(String strEmail_p, String strContrasena_p) throws EscepcionConexionBaseDatos, SQLException {
        return crear("email,contrasena", "'" + strEmail_p + "','" + strContrasena_p + "'");
    }

}
