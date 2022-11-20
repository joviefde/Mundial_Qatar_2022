package org.joviefde.gestionjugadores.gui;

import javax.swing.*;

public class Ventana {
    private JPanel panel1;
    JTextField tfNombre;
    JTextField tfPais;
    JTextField tfEqipo;
    JTextField tfParticipaciones;
    JButton btGuardar;
    JButton btNuevo;
    JButton btModificar;
    JButton btEliminar;
    JButton btAnterior;
    JButton btSiguiente;
    JButton btPrimero;
    JButton btUltimo;
    JBarraEstado barraEstado;
    JTextField tfBusqueda;
    JButton btBuscar;

    public Ventana() {

        JFrame frame = new JFrame("Mundial QATAR 2022");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
