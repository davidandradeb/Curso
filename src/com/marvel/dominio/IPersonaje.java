package com.marvel.dominio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author davidandrade
 */
public interface IPersonaje {
    
    
    
    public boolean luchar(Personaje p) throws ExcepcionPersonajeMuerto;
    
}
