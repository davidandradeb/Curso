/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dyalogo.curso.ui;

import com.curso.jpa.tablas.Usuarios;
import com.dyalogo.curso.ventas.dao.DAOUsuarios;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author davidandrade
 */
public class FXMLLoginController implements Initializable {

    private Usuarios usuario;

    @FXML
    private Label lblMensajes;

    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtContrasena;
    
    @FXML
    private Hyperlink linkAbrirUsuarios;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        DAOUsuarios daoUsuarios = new DAOUsuarios();

        try {
            usuario = daoUsuarios.login(txtUsuario.getText(), txtContrasena.getText());
            lblMensajes.setText("Su perfil es: " + usuario.getPerfil());
            linkAbrirUsuarios.setDisable(false);
        } catch (Exception e) {
            lblMensajes.setText("Ocurrio un error: " + e.getLocalizedMessage());
        }

    }

    @FXML
    private void abrirUsuarios(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("usuarios/FXMLUsuarios.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        linkAbrirUsuarios.setDisable(true);
        // TODO
    }

}
