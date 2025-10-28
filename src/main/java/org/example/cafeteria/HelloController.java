package org.example.cafeteria;

import clases.Camarero;
import clases.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.Arrays;

public class HelloController {

    @FXML
    private TextArea txtSalida;

    @FXML
    public void iniciarTurno() {
        txtSalida.clear();
        txtSalida.appendText("Abriendo cafetería...\n\n");

        new Thread(() -> {
            try {
                Cliente cli1 = new Cliente("Joao");
                Cliente cli2 = new Cliente("Marcos");
                Cliente cli3 = new Cliente("Arda");
                Cliente cli4 = new Cliente("Jude");
                Cliente cli5 = new Cliente("Daniel");

                ArrayList<Cliente> CLIENTES = new ArrayList<>(Arrays.asList(cli1, cli2, cli3, cli4, cli5));

                Camarero camarero1 = new Camarero("CAMARERO 1");
                Camarero camarero2 = new Camarero("CAMARERO 2");

                ArrayList<Camarero> CAMAREROS = new ArrayList<>(Arrays.asList(camarero1, camarero2));

                for (int i = 0; i < CLIENTES.size(); i++) {
                    Cliente cliente = CLIENTES.get(i);
                    Camarero camarero = CAMAREROS.get(i % CAMAREROS.size());

                    cliente.start();
                    cliente.join();

                    appendText("Llega " + cliente.nombre + ". Espera a que le preparen su café...\n");

                    Thread servicio = new Thread(camarero);
                    servicio.start();
                    servicio.join();

                    appendText(camarero.nombre + " está preparando el café de "+ cliente.nombre + ". Tiempo de preparación: " + camarero.preparacion/1000 + " s\n");

                    int tiempo_de_espera = cliente.tiempo_de_espera/1000;

                    if (cliente.tiempo_de_espera > camarero.preparacion) {
                        appendText(cliente.nombre +" se fue enfadado. "+
                                "Su máximo de espera es " + tiempo_de_espera + " s y "
                                + camarero.nombre + " tardó " + tiempo_de_espera + " s\n"+
                                "____________________________________________________\n");
                    } else {
                        appendText(cliente.nombre + " se lleva su café. "+
                                "Su máximo de espera es " + tiempo_de_espera + " s y "
                                + camarero.nombre + " tardó " + tiempo_de_espera + " s\n"+
                                "____________________________________________________\n");
                    }
                }

                appendText("Servicio finalizado");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


    private void appendText(String texto) {
        javafx.application.Platform.runLater(() -> txtSalida.appendText(texto));
    }
}
