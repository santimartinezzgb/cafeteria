package clases;

public class ClienteServido {
    Cliente cliente;
    Camarero camarero;
    public ClienteServido(Cliente cliente, Camarero camarero){
        this.cliente = cliente;
        this.camarero = camarero;
    }

    public void comprobar(){
        int tiempo_de_espera = cliente.tiempo_de_espera;
        int preparacion = camarero.preparacion;

        if(tiempo_de_espera > preparacion){
            System.out.println(cliente.nombre +" se fue enfadado"+
                    "\n----------------------------------");
        } else {
            System.out.println(cliente.nombre + " se lleva su café"+
                    "\n----------------------------------");
        }
    }





}
