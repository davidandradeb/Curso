package com.marvel.dominio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public class Villano extends Personaje {

    @Override
    public boolean luchar(Personaje personaje) throws ExcepcionPersonajeMuerto {
        throw new ExcepcionPersonajeMuerto(personaje);
    }
    
    
    
}
