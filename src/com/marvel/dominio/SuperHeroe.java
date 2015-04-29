package com.marvel.dominio;


/**
 * Esta clase define los atributos y metodos que puede tener un super heroe
 * @author DYALOGOSAS.davidandrade
 */
public class SuperHeroe extends Personaje {
    private boolean esVengador = false;

    public SuperHeroe(String nombre) {
        super(nombre);
    }
    
    
    
    public boolean isEsVengador() {
        return esVengador;
    }

    public void setEsVengador(boolean esVengador) {
        //Validacion de seguridad
        this.esVengador = esVengador;
    }

    @Override
    public boolean luchar(Personaje personaje) throws ExcepcionPersonajeMuerto,NullPointerException{
        super.estaVivo = false;
        
        
        if(personaje.estaVivo==false){
            throw new ExcepcionPersonajeMuerto(personaje);
        }
        
        return false;
    }

    
            
    
}