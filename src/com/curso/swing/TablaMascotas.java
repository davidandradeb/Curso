/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.swing;

import com.curso.jpa.modelo.DAOMascotas;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public class TablaMascotas extends AbstractTableModel {

    private DAOMascotas daoMascotas_t;
    public Object[][] data;

    public TablaMascotas() {
        daoMascotas_t = new DAOMascotas();
        data = new Object[daoMascotas_t.lista().size()][4];

        for (int i = 0; i < daoMascotas_t.lista().size(); i++) {
            data[i][0] = daoMascotas_t.lista().get(i).getId();
            data[i][1] = daoMascotas_t.lista().get(i).getNombre();
            data[i][2] = daoMascotas_t.lista().get(i).getEdad();
            data[i][3] = daoMascotas_t.lista().get(i).getTipo();
        }
    }

    @Override
    public int getRowCount() {
        return daoMascotas_t.lista().size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
    
    

}
