/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.bases_datos;

import com.curso.bases_datos.bd.conexion.ConexionBaseDatos;
import com.curso.bases_datos.bd.conexion.EscepcionConexionBaseDatos;
import com.marvel.dominio.SecuenciasEscape;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public class Modelo {

    static Logger log = Logger.getLogger(Modelo.class.getName());

    public static void main(String[] args) {
        PreparedStatement pstConsultaSQL_t;
        ResultSet rstUsuarios_t;
        ResultSetMetaData rsmMetaDatos_t;

        try {

            pstConsultaSQL_t = ConexionBaseDatos.getCntConexionMySQL_t().prepareStatement("select * from usuarios");

            rstUsuarios_t = pstConsultaSQL_t.executeQuery();
            rsmMetaDatos_t = pstConsultaSQL_t.getMetaData();

            while (rstUsuarios_t.next()) {
                for (int i = 1; i <= rsmMetaDatos_t.getColumnCount(); i++) {
                    System.out.print("\t" + rstUsuarios_t.getString(rsmMetaDatos_t.getColumnName(i)));
                }
                System.out.println("");
            }

            
        } catch (EscepcionConexionBaseDatos ex) {
            log.error("No se conecto a l base de datos", ex);
            System.out.println("Ocurrio un error al intentar conectar la base de datos");
        } catch (SQLException e) {
            log.error("Ocurrio un error al intentar traer la tabla de usuarios");
            System.out.println("Ocurrio error al traer los usuarios");
        }finally{
            ConexionBaseDatos.cerrar();
        }

    }

}
