/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.bases_datos;

import com.curso.bases_datos.bd.conexion.ConexionBaseDatos;
import com.curso.bases_datos.bd.conexion.EscepcionConexionBaseDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public abstract class SuperAccesoDatos {

    String strNombreTabla_t;

    public SuperAccesoDatos(String strNombreTabla_t) {
        this.strNombreTabla_t = strNombreTabla_t;
    }

    int crear(String strCampos_p, String strParametros_p) throws EscepcionConexionBaseDatos, SQLException {

        PreparedStatement pstInserta_t = null;
        ResultSet rstIdInsertado_t = null;
        int intFilasAfectadas_t = 0;

        try {
            StringBuilder strSQLCreacion_t = new StringBuilder("INSERT INTO " + strNombreTabla_t + "(" + strCampos_p + ") VALUES(");
            strSQLCreacion_t.append(strParametros_p);
            strSQLCreacion_t.append(")");

            pstInserta_t = ConexionBaseDatos.getCntConexionMySQL_t().prepareStatement(strSQLCreacion_t.toString(), Statement.RETURN_GENERATED_KEYS);

            intFilasAfectadas_t = pstInserta_t.executeUpdate();

            if (intFilasAfectadas_t == 0) {
                return -1;
            }

            rstIdInsertado_t = pstInserta_t.getGeneratedKeys();

            if (rstIdInsertado_t.next()) {
                return rstIdInsertado_t.getInt(1);
            } else {
                return -1;
            }
        } finally {
            if (pstInserta_t != null && !pstInserta_t.isClosed()) {
                pstInserta_t.close();
            }
            if (rstIdInsertado_t != null && !rstIdInsertado_t.isClosed()) {
                rstIdInsertado_t.close();
            }
        }

    }

}
