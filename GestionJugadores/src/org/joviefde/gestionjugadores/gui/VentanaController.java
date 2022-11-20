package org.joviefde.gestionjugadores.gui;

import org.joviefde.gestionjugadores.base.Jugador;
import org.joviefde.gestionjugadores.util.Util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VentanaController implements ActionListener, KeyListener {

    private VentanaModel model;
    private Ventana view;

    private int posicion;

    public VentanaController(VentanaModel model, Ventana view) {
        this.model = model;
        this.view = view;
        anadirActionListener(this);
        anadirKeyListener(this);

        posicion = 0;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        String actionCommand = event.getActionCommand();
        Jugador jugador = null;

        switch (actionCommand) {
            case "Nuevo":
                view.tfNombre.setText("");
                view.tfNombre.setEditable(true);
                view.tfEqipo.setText("");
                view.tfEqipo.setEditable(true);
                view.tfParticipaciones.setText("");
                view.tfParticipaciones.setEditable(true);
                view.tfPais.setText("");
                view.tfPais.setEditable(true);

                view.btGuardar.setEnabled(true);
                break;
            case "Guardar":

                if (view.tfNombre.getText().equals("")) {
                    Util.mensajeError("El nombre es un campo obligatorio", "Nuevo jugador");
                    return;
                }

                jugador = new Jugador();
                jugador.setNombre(view.tfNombre.getText());
                jugador.setPais(view.tfPais.getText());
                jugador.setEquipo(view.tfEqipo.getText());
                jugador.setParticipaciones(Float.parseFloat(view.tfParticipaciones.getText()));

                model.guardar(jugador);

                view.btGuardar.setEnabled(false);
                break;
            case "Modificar":
                jugador = new Jugador();
                jugador.setNombre(view.tfNombre.getText());
                jugador.setPais(view.tfPais.getText());
                jugador.setEquipo(view.tfEqipo.getText());
                jugador.setParticipaciones(Float.parseFloat(view.tfParticipaciones.getText()));

                model.modificar(jugador);
                break;
            case "Cancelar":
                view.tfNombre.setEditable(false);
                view.tfEqipo.setEditable(false);
                view.tfParticipaciones.setEditable(false);
                view.tfPais.setEditable(false);

                jugador = model.getActual();
                cargar(jugador);

                view.btGuardar.setEnabled(false);
                break;
            case "Eliminar":
                if (JOptionPane.showConfirmDialog(null, "Vas a desconvocar al jugador, ¿seguro?", "Eliminar", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
                    return;

                model.eliminar();
                jugador = model.getActual();
                cargar(jugador);
                break;
            case "Buscar":
                jugador = model.buscar(view.tfBusqueda.getText());
                if (jugador == null) {
                    Util.mensajeInformacion("No se ha encontrado ningún jugador con ese nombre", "Buscar");
                    return;
                }
                cargar(jugador);
                break;
            case "Primero":
                jugador = model.getPrimero();
                cargar(jugador);
                break;
            case "Anterior":
                jugador = model.getAnterior();
                cargar(jugador);
                break;
            case "Siguiente":
                jugador = model.getSiguiente();
                cargar(jugador);
                break;
            case "Último":
                jugador = model.getUltimo();
                cargar(jugador);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getSource() == view.tfBusqueda) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                view.btBuscar.doClick();
            }
        }
    }

    private void cargar(Jugador jugador) {
        if (jugador == null)
            return;

        view.tfNombre.setText(jugador.getNombre());
        view.tfEqipo.setText(jugador.getEquipo());
        view.tfPais.setText(jugador.getPais());
        view.tfParticipaciones.setText(String.valueOf(jugador.getParticipaciones()));
    }

    private void anadirKeyListener(KeyListener listener) {
        view.tfBusqueda.addKeyListener(listener);
    }

    private void anadirActionListener(ActionListener listener) {

        view.btNuevo.addActionListener(listener);
        view.btGuardar.addActionListener(listener);
        view.btModificar.addActionListener(listener);
        view.btEliminar.addActionListener(listener);
        view.btPrimero.addActionListener(listener);
        view.btAnterior.addActionListener(listener);
        view.btSiguiente.addActionListener(listener);
        view.btUltimo.addActionListener(listener);
        view.btBuscar.addActionListener(listener);
    }
}
