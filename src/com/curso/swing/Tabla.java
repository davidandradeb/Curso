/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.swing;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public class Tabla extends JFrame{
    private JTable tabla;
    
     String[] columnNames = {"id",
            "nombre",
            "edad",
            "tipo"};

    public Tabla() {
        init();
    }
    
    
    public void init(){
        TablaMascotas tbl = new TablaMascotas();
        tabla = new JTable(tbl.data, columnNames);

        tabla.setColumnModel(new DefaultTableColumnModel());
        add(tabla);
        
        setSize(800, 600);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        Tabla t = new Tabla();
        
    }

}
