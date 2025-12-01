package clases;

public class Buffer {
    public int contador_de_cafes = 0;
    private final int CAPACIDAD_MAXIMA = 5;
    

    // PARA CAMARERO
    public synchronized void get() {

        while (contador_de_cafes == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        contador_de_cafes--;
        notifyAll();
        System.out.println("CAMARERO recoge café. CAFÉS EN MESA: ("+contador_de_cafes+"/"+ CAPACIDAD_MAXIMA +")");
    }

    // PARA EL BARISTA
    public synchronized void put (){

        while(contador_de_cafes == CAPACIDAD_MAXIMA) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        contador_de_cafes++;
        notifyAll();
        System.out.println("BARISTA tiene listo el café. CAFÉS EN MESA: (" + contador_de_cafes + "/"+ CAPACIDAD_MAXIMA +")");
    }
}


