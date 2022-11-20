package org.joviefde.gestionjugadores;

import org.joviefde.gestionjugadores.gui.Ventana;
import org.joviefde.gestionjugadores.gui.VentanaController;
import org.joviefde.gestionjugadores.gui.VentanaModel;

public class Lanzar {

    public static void main(String args[]) {

        Ventana view = new Ventana();
        VentanaModel model = new VentanaModel();
        VentanaController controller = new VentanaController(model, view);
    }
}
