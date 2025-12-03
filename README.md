
# Simulación de Cafetería con Patrón Productor-Consumidor

## Descripción
Este proyecto en **Java** simula el funcionamiento de una **cafetería** utilizando el **patrón Productor-Consumidor** con **hilos (threads)**.  
Los **baristas** actúan como productores preparando cafés, los **camareros** como consumidores sirviéndolos a los clientes, y un **buffer compartido** coordina la comunicación entre ambos roles.  

---

## Funcionamiento

1. **Baristas (Productores)**: Preparan cafés y los colocan en el buffer compartido cuando hay espacio disponible.
2. **Buffer**: Estructura de datos sincronizada (cola limitada) que almacena temporalmente los cafés preparados.
3. **Camareros (Consumidores)**: Retiran cafés del buffer y los entregan a los clientes que esperan.

---

## Arquitectura del Sistema

### Componentes principales:
- **Clase `Barista`**: Hilo productor que genera cafés continuamente
- **Clase `Camarero`**: Hilo consumidor que retira cafés del buffer y los sirve
- **Clase `Buffer`**: Estructura sincronizada (usando `BlockingQueue` o monitores con `wait()`/`notify()`)
- **Sincronización**: Evita condiciones de carrera y garantiza el orden correcto de operaciones

---

