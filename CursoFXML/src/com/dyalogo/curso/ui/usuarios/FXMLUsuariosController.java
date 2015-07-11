/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dyalogo.curso.ui.usuarios;

import com.curso.jpa.tablas.Usuarios;
import com.dyalogo.curso.ventas.dao.DAOUsuarios;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author davidandrade
 */
public class FXMLUsuariosController implements Initializable {

    @FXML
    TableView tblUsuarios;
    
    
    
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarDatos();
        
    }    
    
    public void cargarDatos(){
        DAOUsuarios daoUsuarios = new DAOUsuarios();
        ObservableList<Usuarios> lstObsUsuarios = FXCollections.observableArrayList(daoUsuarios.lista());
        tblUsuarios.setItems(lstObsUsuarios);
        
        tblUsuarios.getVisibleLeafColumn(0).setCellValueFactory(new PropertyValueFactory<Usuarios, Integer>("id"));
        tblUsuarios.getVisibleLeafColumn(1).setCellValueFactory(new PropertyValueFactory<Usuarios, String>("usuario"));
        tblUsuarios.getVisibleLeafColumn(2).setCellValueFactory(new PropertyValueFactory<Usuarios, String>("contrasena"));
        tblUsuarios.getVisibleLeafColumn(3).setCellValueFactory(new PropertyValueFactory<Usuarios, String>("perfil"));
        
        
    }
    
    
}
