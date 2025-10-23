package clases;

import java.util.ArrayList;

public class Camarero extends Thread {
    public String nombre;
    public ArrayList<Cliente> CLIENTES;

    public Camarero(String nombre, ArrayList<Cliente> CLIENTES) {
        this.nombre = nombre;
        this.CLIENTES = CLIENTES;
    }

    @Override
    public void run() {

        int preparacion = (int) Math.floor(Math.random()*5000);
        try {
            Thread.sleep(preparacion);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (Cliente c : CLIENTES) {
            synchronized (c) {
                if (!c.atendido) {
                    c.atendido = true;

                    int tiempo_preparacion_cafe = (int) Math.floor(Math.random() * 5000);
                    if (c.tiempo_de_espera >= tiempo_preparacion_cafe) {
                        System.out.println(this.nombre + " ha cumplido el servicio" +
                                "\n" + c.nombre + " se está tomando su café" +
                                "\n-----------------------------------");
                    } else {
                        System.out.println(this.nombre + " es demasiado lento" +
                                "\n" + c.nombre + " se ha ido" +
                                "\n-----------------------------------");
                    }
                }
            }
        }
    }
}
