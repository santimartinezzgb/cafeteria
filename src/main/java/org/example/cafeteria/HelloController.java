package org.example.cafeteria;

import clases.Barista;
import clases.Buffer;
import clases.Camarero;
import clases.Cliente;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.OutputStream;
import java.io.PrintStream;

public class HelloController {

    @FXML
    private TextArea textoDelPanel;
    @FXML
    private Button btnIniciar;

    @FXML
    public void salirDelPrograma(){
        Platform.exit();
    }

    @FXML
    public void iniciarTurno() {
        btnIniciar.setVisible(false);
        textoDelPanel.clear();
        textoDelPanel.setText("\uD83D\uDD5A Abriendo cafetería... \uD83D\uDD5A\n\n");

        // Redirigir la salida estándar a la interfaz gráfica
        PrintStream souts_de_hilos = new PrintStream(new OutputStream() {
            // Escribir en el TextArea desde cualquier hilo
            @Override
            public void write(int b) {
                Platform.runLater(() -> textoDelPanel.appendText(String.valueOf((char) b)));
            }
        });
        // setOut y setErr redirigen la salida estándar y de error
        System.setOut(souts_de_hilos);
        System.setErr(souts_de_hilos);


        new Thread(() -> {
            Buffer buffer = new Buffer();
            Camarero camarero = new Camarero(buffer);
            Barista barista = new Barista(buffer);

            barista.start();
            camarero.start();

            try {
                barista.join();
                camarero.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("Cafetería cerrada");
        }).start();
    }


}