/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.jpa.modelo;

import com.curso.jpa.dao.ImpDAO;
import com.curso.jpa.tablas.Mascotas;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public class DAOMascotas extends ImpDAO<Mascotas>{

    public DAOMascotas() {
        super(Mascotas.class);
    }
    
    

}
