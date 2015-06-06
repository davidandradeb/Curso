/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.swing;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 *
 * @author DYALOGOSAS.davidandrade
 */
public class MiPimerVentana extends JFrame implements WindowListener {

    private JLabel lblNombre_t;
    private JLabel lblNombreDigitado_t;
    private JTextField txtNombre_t;
    private JPasswordField txtContrasena_t;
    private JButton btnActualizarNombre_t;

    public MiPimerVentana() {
        init();
    }

    private void init() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;



        JPanel panelObjetos = new JPanel(new GridLayout(3, 2));
        lblNombreDigitado_t = new JLabel();

        lblNombre_t = new JLabel("Usuario: ");
        txtNombre_t = new JTextField();

        txtNombre_t.setSize(200, 20);

        txtContrasena_t = new JPasswordField();

        btnActualizarNombre_t = new JButton("Actualizar nombre");

        panelObjetos.add(lblNombre_t);
        panelObjetos.add(txtNombre_t);
        panelObjetos.add(new JLabel("Contraseña"));
        panelObjetos.add(txtContrasena_t);
        panelObjetos.add(lblNombreDigitado_t);
        panelObjetos.add(btnActualizarNombre_t);

        btnActualizarNombre_t.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, "Se va a asignar: " + txtNombre_t.getText());
                lblNombreDigitado_t.setText(txtNombre_t.getText());
            }
        });

        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(this);
        this.add(panelObjetos);
        setSize(width / 2, 100);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        MiPimerVentana ventana = new MiPimerVentana();

        //ventana.setSize(800, 600);
        ventana.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("windowOpened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (JOptionPane.showConfirmDialog(null, "Esta seguro de cerrar") == 0) {
            System.exit(0);
        } else {
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("windowClosed");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("windowIconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("windowDeiconified");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("windowActivated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("windowDeactivated");
    }

}
