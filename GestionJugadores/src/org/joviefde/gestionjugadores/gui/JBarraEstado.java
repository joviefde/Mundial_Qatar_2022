package org.joviefde.gestionjugadores.gui;

import javax.swing.*;

public class JBarraEstado {
    private JPanel panel1;
    private JLabel lbMensaje;
    private JLabel lbEstado;

    public JBarraEstado() {

    }
    public void setMensaje(String mensaje) {
        lbMensaje.setText(mensaje);
    }
    public void setEstado(String mensaje) {
        lbEstado.setText(mensaje);
    }
}
