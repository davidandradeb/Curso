/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.bases_datos.bd.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 * SIngleton conexion base de datos
 *
 * @author DYALOGOSAS.davidandrade
 */
public class ConexionBaseDatos {

    static Logger log = Logger.getLogger(ConexionBaseDatos.class.getName());

    private static final String strURL_c = "jdbc:mysql://127.0.0.1:3306/curso";
    private static final String strUsuario_c = "curso";
    private static final String strContrasena_c = "curso*bd";

    private static Connection cntConexionMySQL_t = null;

    /**
     *
     * @return @throws EscepcionConexionBaseDatos
     */
    public static Connection getCntConexionMySQL_t() throws EscepcionConexionBaseDatos {
        try {
            if (cntConexionMySQL_t == null || cntConexionMySQL_t.isClosed()) {
                inicializarConexion();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new EscepcionConexionBaseDatos(ex);
        }
        return cntConexionMySQL_t;
    }

    /**
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private static void inicializarConexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        cntConexionMySQL_t = DriverManager.getConnection(strURL_c, strUsuario_c, strContrasena_c);
    }

    public static void cerrar() {
        if (cntConexionMySQL_t != null) {
            try {
                if (!cntConexionMySQL_t.isClosed()) {
                    cntConexionMySQL_t.close();
                }
            } catch (SQLException ex) {
                log.error("No se pudo cerrar la conexion", ex);
            }
        }
    }

}
