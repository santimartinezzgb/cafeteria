package clases;

// PRODUCTOR
public class Barista extends Thread {
    private Buffer buffer;
    private int vueltas = 15;

    public Barista(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run(){
        for (int i = 0; i < vueltas; i++){
            buffer.put();

            int numero_random = (int) Math.floor(Math.random()*500);
            try {
                Thread.sleep(numero_random);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Barista interrumpido");
                break;
            }
        }
        System.out.println("Barista terminó su turno");
    }

}