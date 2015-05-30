/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.jpa.conexion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public class Conexion {
    
    private static EntityManagerFactory conexionBD;

    public static EntityManagerFactory getConexionBD() {
        
        if(conexionBD==null){
            conexionBD = Persistence.createEntityManagerFactory("CursoPU");
        }
        
        return conexionBD;
    }
    
    
    public static void cerrarConexion(){
        if(conexionBD==null){
            conexionBD.close();
            conexionBD = null;
        }
    }
    
    
    

}
