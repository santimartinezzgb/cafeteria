package clases;

public class Camarero extends Thread {
    private Buffer buffer;
    private int vueltas = 35;
    private int tiempo_preparacion = 500;

    public Camarero(Buffer buffer){
        this.buffer = buffer;
    }

    public void run(){
        for (int i = 0; i < vueltas; i++) {
            buffer.get();

            int numero_random = (int) Math.floor(Math.random() * tiempo_preparacion);
            try {
                Thread.sleep(numero_random);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("CAMARERO - Turno terminado");
    }
}
