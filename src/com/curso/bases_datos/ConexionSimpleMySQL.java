/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.bases_datos;

import com.marvel.dominio.SecuenciasEscape;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public class ConexionSimpleMySQL {

    static Logger log = Logger.getLogger(SecuenciasEscape.class.getName());

    private static final String strURL_c = "jdbc:mysql://127.0.0.1:3306/curso";
    private static final String strUsuario_c = "curso";
    private static final String strContrasena_c = "curso*bd";

    public static void main(String[] args) {

        Connection cntMySQL_t = null;
        PreparedStatement pstConsultaSQL_t;
        ResultSet rstUsuarios_t;
        ResultSetMetaData rsmMetaDatos_t;

        try {
            //Cargar el driver de mysql.
            Class.forName("com.mysql.jdbc.Driver");
            log.info("Driver MySQL cargado con exito...");

            //Realizar la conexion a la base de datos.
            cntMySQL_t = DriverManager.getConnection(strURL_c, strUsuario_c, strContrasena_c);
            log.info("Conexion a: " + strURL_c + " creada con exito..");

            //Decirle a la base de dtos una instruccion SQL
            pstConsultaSQL_t = cntMySQL_t.prepareStatement("select * from usuarios");

            //pstConsultaSQL_t.setString(1, "david.andrade@dyalogo.com");
            //pstConsultaSQL_t.setString(2, "david");
            
            //Ejecuta la consulta SQL
            rstUsuarios_t = pstConsultaSQL_t.executeQuery();

            //Obtener meta-datos
            rsmMetaDatos_t = pstConsultaSQL_t.getMetaData();

            System.out.println("\nMETA-DATOS");

            System.out.println("Cantidad de columnas: " + rsmMetaDatos_t.getColumnCount());

            for (int i = 1; i <= rsmMetaDatos_t.getColumnCount(); i++) {
                //System.out.println("Columna " + i + " nombre: " + rsmMetaDatos_t.getColumnName(i) + ", tipo: " + rsmMetaDatos_t.getColumnTypeName(i));
                System.out.print("\t" + rsmMetaDatos_t.getColumnName(i));
            }

            //System.out.println("\nDatos de la consulta");
            System.out.println("");
            while (rstUsuarios_t.next()) {
                for (int i = 1; i <= rsmMetaDatos_t.getColumnCount(); i++) {
                    System.out.print("\t" + rstUsuarios_t.getString(rsmMetaDatos_t.getColumnName(i)));
                }
                System.out.println("");
            }

            rstUsuarios_t.close();
            pstConsultaSQL_t.close();

            log.info("Programa terminado");
        } catch (ClassNotFoundException ex) {
            log.error("No se encotró el driver", ex);
        } catch (SQLException ex) {
            log.error("No se pudo establecer la conexion con la base de datos", ex);
        } finally {

            if (cntMySQL_t != null) {
                try {
                    if (!cntMySQL_t.isClosed()) {
                        cntMySQL_t.close();
                    }
                } catch (SQLException ex) {
                    log.error("No se pudo cerrar la conexion", ex);
                }
            }

        }

    }

}
