/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marvel.dominio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.log4j.Logger;






/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public class SecuenciasEscape {

    static Logger log = Logger.getLogger(SecuenciasEscape.class.getName());
    
    public static void main(String[] args) {

        StringBuilder a = new StringBuilder("as");
        StringBuffer sb = new StringBuffer("ss");
        
        
        log.info("Iniciando programa");

        int cantidadIteraciones = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            cantidadIteraciones = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            log.error("Eror de IO", ex);
        } catch (NumberFormatException ne) {
            log.error("Eror de Conversion", ne);
            System.out.println("Usted no digitó un numero ");
            System.exit(0);
        }catch(NullPointerException ex){
            System.out.println("Usted no digitó ni mierda ");
            System.exit(0);
        }

        System.out.println("Cadenas");
        for (int i = 0; i < cantidadIteraciones; i++) {

            a.append("Iterador " + i);

            for (int j = 0; j <= i; j++) {
                System.out.print("\t");
            }
            System.out.println("Cadena " + i);
        }

        System.out.println("A: " + a.toString());

    }

}
