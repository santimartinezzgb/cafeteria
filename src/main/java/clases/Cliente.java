package clases;

public class Cliente extends Thread{
    public String nombre;
    public int tiempo_de_espera;
    public boolean atendido;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.tiempo_de_espera =(int) Math.floor(Math.random()*8000);
        this.atendido = false;
    }

    public void run (){
        try{
            Thread.sleep(tiempo_de_espera);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("LLega un cliente");
        this.atendido= true;

    }
}
