package org.joviefde.gestionjugadores.base;

public class Jugador {

    private String nombre;
    private String pais;
    private String equipo;
    private float participaciones;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public float getParticipaciones() {
        return participaciones;
    }

    public void setParticipaciones(float participaciones) {
        this.participaciones = participaciones;
    }
}
