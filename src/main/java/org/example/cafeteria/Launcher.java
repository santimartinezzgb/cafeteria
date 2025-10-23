package org.example.cafeteria;

import clases.Camarero;
import clases.Cliente;
import clases.ClienteServido;

import java.util.ArrayList;
import java.util.Arrays;

public class Launcher {
    static void main(String[] args) throws InterruptedException {
        //Application.launch(HelloApplication.class, args);

        Cliente cli1 = new Cliente("Joao");
        Cliente cli2 = new Cliente("Marcos");
        Cliente cli3 = new Cliente("Arda");
        Cliente cli4 = new Cliente("Jude");
        Cliente cli5 = new Cliente("Daniel");

        ArrayList<Cliente> CLIENTES = new ArrayList<>(Arrays.asList(cli1, cli2, cli3, cli4, cli5));

        Camarero camarero1 = new Camarero("CAMARERO 1");
        Camarero camarero2 = new Camarero("CAMARERO 2");


        for(int i = 0; i<CLIENTES.size();i++){

            CLIENTES.getFirst().start();
            CLIENTES.getFirst().join();
            Thread servicio0 = new Thread(camarero1);
            servicio0.start();
            servicio0.join();
            ClienteServido clienteServido0 = new ClienteServido(CLIENTES.get(0), camarero1);
            clienteServido0.comprobar();

            CLIENTES.get(1).start();
            CLIENTES.get(1).join();
            Thread servicio1 = new Thread(camarero2);
            servicio1.start();
            servicio1.join();
            ClienteServido clienteServido1 = new ClienteServido(CLIENTES.get(1), camarero2);
            clienteServido1.comprobar();

            CLIENTES.get(2).start();
            CLIENTES.get(2).join();
            Thread servicio2 = new Thread(camarero1);
            servicio2.start();
            servicio2.join();
            ClienteServido clienteServido2 = new ClienteServido(CLIENTES.get(2), camarero1);
            clienteServido2.comprobar();

            CLIENTES.get(3).start();
            CLIENTES.get(3).join();
            Thread servicio3 = new Thread(camarero2);
            servicio3.start();
            servicio3.join();
            ClienteServido clienteServido3 = new ClienteServido(CLIENTES.get(3), camarero2);
            clienteServido3.comprobar();

            CLIENTES.get(4).start();
            CLIENTES.get(4).join();
            Thread servicio4 = new Thread(camarero1);
            servicio4.start();
            servicio4.join();
            ClienteServido clienteServido4 = new ClienteServido(CLIENTES.get(4), camarero1);
            clienteServido4.comprobar();


        }
    }
}


