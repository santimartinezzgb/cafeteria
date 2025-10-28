package org.example.cafeteria;

import clases.Camarero;
import clases.Cliente;
import clases.ClienteServido;

import java.util.ArrayList;
import java.util.Arrays;

public class Launcher {
    static void main(String[] args) throws InterruptedException {


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

            // Selecciono módulos de i para que en cada pasada intercale entre 0 y 1
            Camarero camarero = CAMAREROS.get(i % CAMAREROS.size());

            cliente.start();
            cliente.join();

            Thread servicio = new Thread(camarero);
            servicio.start();
            servicio.join();

            ClienteServido clienteServido = new ClienteServido(cliente, camarero);
            clienteServido.comprobar();
        }
    }
}


