/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marvel.dominio;

/**
 *º
 * @author DYALOGOSAS.davidandrade
 */
public class ExcepcionPersonajeMuerto extends Exception{
    Personaje objPersonajeMuerto_t;

    public ExcepcionPersonajeMuerto(Personaje objPersonajeMuerto_p) {
        this.objPersonajeMuerto_t = objPersonajeMuerto_p;
    }
    
    
    
    
}
