/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.bases_datos;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public class ExcepcionMascotaExiste extends Exception{
    
    public ExcepcionMascotaExiste(String mensaje){
        super(mensaje);
    }

}
