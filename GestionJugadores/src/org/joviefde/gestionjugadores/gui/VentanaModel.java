package org.joviefde.gestionjugadores.gui;

import org.joviefde.gestionjugadores.base.Jugador;

import java.util.ArrayList;
public class VentanaModel {

    private ArrayList<Jugador> listaJugadores;
    private int posicion;

    public VentanaModel() {
        listaJugadores = new ArrayList<>();
        posicion = 0;
    }
    public void guardar(Jugador jugador) {

        listaJugadores.add(jugador);
        posicion++;
    }
    public void modificar(Jugador jugadorModificado) {

        Jugador jugador = listaJugadores.get(posicion);
        jugador.setNombre(jugadorModificado.getNombre());
        jugador.setEquipo(jugadorModificado.getEquipo());
        jugador.setPais(jugadorModificado.getPais());
        jugador.setParticipaciones(jugadorModificado.getParticipaciones());
    }
    public void eliminar() {
        listaJugadores.remove(posicion);
    }

    public Jugador getActual() {

        return listaJugadores.get(posicion);
    }
    public Jugador buscar(String nombre) {
        for (Jugador jugador : listaJugadores) {
            if (jugador.getNombre().equals(nombre)) {
                return jugador;
            }
        }

        return null;
    }
    public Jugador getPrimero() {

        posicion = 0;
        return listaJugadores.get(posicion);
    }
    public Jugador getAnterior() {

        if (posicion == 0)
            return null;

        posicion--;
        return listaJugadores.get(posicion);
    }
    public Jugador getSiguiente() {

        if (posicion == listaJugadores.size() - 1)
            return null;

        posicion++;
        return listaJugadores.get(posicion);
    }
    public Jugador getUltimo() {

        posicion = listaJugadores.size() - 1;
        return listaJugadores.get(posicion);
    }
}
