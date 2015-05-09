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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public class AccesoDatosMascotas extends SuperAccesoDatos {

    public AccesoDatosMascotas() {
        super("mascotas");
    }

    /**
     * Este metodo crea una mascota en la base de datos
     *
     * @param strTipo_p
     * @param strNombreMascota_p
     * @param intEdad_p
     * @param intIdusuario_p
     * @return
     * @throws EscepcionConexionBaseDatos
     * @throws SQLException
     * @throws ExcepcionMascotaExiste
     */
    public int crear(String strTipo_p, String strNombreMascota_p, int intEdad_p, int intIdusuario_p)
            throws EscepcionConexionBaseDatos, SQLException, ExcepcionMascotaExiste {

        if (mascotaExiste(strNombreMascota_p, intIdusuario_p)) {
            //La mascota existe
            throw new ExcepcionMascotaExiste("La mascota " + strNombreMascota_p + " ya existe");
        } else {
            return crear("tipo,nombre,edad,id_usuario", "'" + strTipo_p + "','" + strNombreMascota_p + "'," + intEdad_p + "," + intIdusuario_p);
        }

    }

    /**
     * Retorna si una mascota existe o no
     *
     * @param strNombreMascota_p
     * @param intIdusuario_p
     * @return
     */
    private boolean mascotaExiste(String strNombreMascota_p, int intIdusuario_p) throws EscepcionConexionBaseDatos, SQLException {
        PreparedStatement pstConsultaMascota_t = null;
        ResultSet rstDatoMascota_t = null;

        try {
            pstConsultaMascota_t = ConexionBaseDatos.getCntConexionMySQL_t().prepareStatement("select id from mascotas where id_usuario=" + intIdusuario_p + " and nombre = '" + strNombreMascota_p + "'");
            rstDatoMascota_t = pstConsultaMascota_t.executeQuery();

            return rstDatoMascota_t.next();

        } finally {

            if (!pstConsultaMascota_t.isClosed()) {
                pstConsultaMascota_t.close();
            }

            if (!rstDatoMascota_t.isClosed()) {
                rstDatoMascota_t.close();
            }

            pstConsultaMascota_t = null;
            rstDatoMascota_t = null;

        }
    }

    /**
     * Retorna el id de la mascota
     *
     * @param intIdusuario_p
     * @return
     * @throws EscepcionConexionBaseDatos
     * @throws SQLException
     */
    public List<String> mascotasXUsuario(int intIdusuario_p) throws EscepcionConexionBaseDatos, SQLException {
        PreparedStatement pstConsultaMascota_t = null;
        ResultSet rstDatoMascota_t = null;

        List<String> lstMascotasXUsuario = new ArrayList<>();

        try {
            pstConsultaMascota_t = ConexionBaseDatos.getCntConexionMySQL_t().prepareStatement("select nombre from mascotas where id_usuario=" + intIdusuario_p);
            rstDatoMascota_t = pstConsultaMascota_t.executeQuery();

            while (rstDatoMascota_t.next()) {
                lstMascotasXUsuario.add(rstDatoMascota_t.getString("nombre"));
            }

            return lstMascotasXUsuario;

        } finally {

            if (!pstConsultaMascota_t.isClosed()) {
                pstConsultaMascota_t.close();
            }

            if (!rstDatoMascota_t.isClosed()) {
                rstDatoMascota_t.close();
            }

            pstConsultaMascota_t = null;
            rstDatoMascota_t = null;

        }

    }

}
