package clases;

public class Camarero implements Runnable{
    public String nombre;
    public int preparacion;

    public Camarero(String nombre) {
        this.nombre = nombre;
        this.preparacion = (int) Math.floor(Math.random()*8000);
    }


    public void run() {
        System.out.println(this.nombre + " está preparando el café...");
        try {
            Thread.sleep(preparacion);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
