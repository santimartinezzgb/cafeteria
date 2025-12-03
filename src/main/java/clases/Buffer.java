package clases;

public class Buffer {
    public int contador_de_cafes = 0;
    private final int CAPACIDAD_MAXIMA = 3;
    

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
        System.out.println("\nCAMARERO recoge la taza.\nTAZAS EN MESA: ("+
                contador_de_cafes+"/"+ CAPACIDAD_MAXIMA +
                ")\n==============================");
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
        System.out.println("\nBARISTA deja la taza.\nTAZAS EN MESA: (" +
                contador_de_cafes + "/"+ CAPACIDAD_MAXIMA +
                ")\n==============================");
    }
}


