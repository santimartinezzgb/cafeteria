package org.example.cafeteria;

import clases.Camarero;
import clases.Cliente;
import javafx.application.Application;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.nanoTime;

public class Launcher {
    static void main(String[] args) throws InterruptedException {
        //Application.launch(HelloApplication.class, args);
        Cliente cli1 = new Cliente("Joao");
        Cliente cli2 = new Cliente("Marcos");
        Cliente cli3 = new Cliente("Arda");
        Cliente cli4 = new Cliente("Jude");
        Cliente cli5 = new Cliente("Daniel");

        ArrayList<Cliente> CLIENTES = new ArrayList<>(Arrays.asList(cli1, cli2, cli3, cli4, cli5));

        Camarero cam1 = new Camarero("CAMARERO 1", CLIENTES);
        Camarero cam2 = new Camarero("CAMARERO 2", CLIENTES);


        cli1.start();
        cli2.start();
        cli3.start();
        cli4.start();
        cli5.start();


        cam1.start();
        cam2.start();

        cam1.join();
        cam2.join();
    }

}


