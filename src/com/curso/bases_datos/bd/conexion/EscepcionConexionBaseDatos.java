/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.bases_datos.bd.conexion;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public class EscepcionConexionBaseDatos extends Exception{
    
    public EscepcionConexionBaseDatos(Throwable ex){
        super(ex);
    }

}
