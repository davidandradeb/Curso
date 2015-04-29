package com.marvel.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public class Prueba {

    public static void main(String[] args) {

        String saludo = "hola";
        String saludo2 = "Hola";
        List<String> nombresSuperHeroes = new ArrayList<>();

        if (saludo.equalsIgnoreCase(saludo2)) {
            System.out.println("Elemento igual");
        } else {
            System.out.println("Elemento diferente");
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("I = " + i);
        }

        nombresSuperHeroes.add("IronMan");
        nombresSuperHeroes.add("Hulk");

        for (String item : nombresSuperHeroes) {
            System.out.println("Nombre; " + item);
        }

        for (int i = 0; i < nombresSuperHeroes.size(); i++) {
            System.out.println("Nombre: " + nombresSuperHeroes.get(i));
        }

        int i = 0;
        while (i < nombresSuperHeroes.size()) {
            System.out.println("Nombre: " + nombresSuperHeroes.get(i));

            i++;
        }

        i = 0;
        do {
            System.out.println("Nombre: " + nombresSuperHeroes.get(i));
            i++;
        } while (i < nombresSuperHeroes.size());

        switch (saludo) {

            case "hola":
                System.out.println(saludo);
                break;

            default:

                break;

        }

        System.out.println("" + elementoEnLista(nombresSuperHeroes, "Hulk"));

        SuperHeroe objIronMan_t = new SuperHeroe("IronMan");
        Villano objLoki_t = new Villano();

        try {

            objIronMan_t.luchar(objLoki_t);

        } catch (ExcepcionPersonajeMuerto | NullPointerException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RuntimeException e) {
            System.out.println("Excepcion de Runtime");
        } finally {
            objIronMan_t = null;
            objLoki_t = null;
        }

        
       
                //Lineas de codigo 
    }

    public static boolean elementoEnLista(List<String> lista, String elemento) {
        String itemEncontrado="";
        String otroProceso;
        try {
            
            for (String item : lista) {
                if (item.equals(elemento)) {
                    itemEncontrado = item;
                    return true;
                }
            }
            otroProceso = "Prueba "+ itemEncontrado;
        } finally {
            otroProceso = null;
        }

        //Lineas adicionales
        return false;
    }
}
