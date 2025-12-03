package clases;

public class Buffer {
    public int CONTADOR_CAFES = 0;
    private final int CAPACIDAD_MAXIMA = 3;

    // PARA CAMARERO
    public synchronized void get() {

        while (CONTADOR_CAFES == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        CONTADOR_CAFES--;
        notifyAll();
        System.out.println("\nCAMARERO recoge la taza.\nTAZAS EN MESA: (" +
                CONTADOR_CAFES + "/" + CAPACIDAD_MAXIMA +
                ")\n==============================");
    }

    // PARA EL BARISTA
    public synchronized void put() {

        while (CONTADOR_CAFES == CAPACIDAD_MAXIMA) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        CONTADOR_CAFES++;
        notifyAll();
        System.out.println("\nBARISTA deja la taza.\nTAZAS EN MESA: (" +
                CONTADOR_CAFES + "/" + CAPACIDAD_MAXIMA +
                ")\n==============================");
    }
}
