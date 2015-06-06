/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.swing;

import com.curso.jpa.modelo.DAOMascotas;
import com.curso.jpa.tablas.Mascotas;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author davidandrade
 */
public class CursoFX extends Application {

    private TableView tblVistaDat__t = new TableView();
    
    @Override
    public void start(Stage primaryStage) {
        
        DAOMascotas daoMascotas = new DAOMascotas();
        Button btn = new Button();
        btn.setText("Cargar tabla");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //Cargar una tabla
                crearColumnas();

                tblVistaDat__t.setItems(FXCollections.observableArrayList(daoMascotas.lista()));
                
            }
        });
        
        imprimirString("david");
        imprimirString("david","leonardo");
        imprimirString("erick","elias","vicky");
        
        StackPane root = new StackPane();
        VBox general = new VBox();
        general.getChildren().add(btn);
        general.getChildren().add(tblVistaDat__t);
        
        root.getChildren().add(general);
        
        Scene scene = new Scene(root, 800, 600);
        
        primaryStage.setTitle("Cargar tabla");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void crearColumnas() {
        TableColumn colElemento__t = new TableColumn("Id");
        colElemento__t.setMinWidth(100);
        colElemento__t.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        TableColumn colItem______t = new TableColumn("Nombre");
        colItem______t.setMinWidth(100);
        colItem______t.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        
        tblVistaDat__t.getColumns().addAll(colElemento__t, colItem______t);
        tblVistaDat__t.getSortOrder().clear();
        
    }

    private void imprimirString(String... nombres){
        for(String nombre : nombres){
            System.out.println(""+nombre);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
