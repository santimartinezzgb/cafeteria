# ☕ Simulación de Cafetería Multihilo

## 📋 Descripción

Este proyecto en **Java** simula el funcionamiento de una **cafetería** donde varios clientes son atendidos por camareros utilizando **hilos (threads)**.  
Cada cliente tiene un tiempo máximo de espera, y los camareros tardan un tiempo variable en preparar los cafés.  
Si la preparación excede el límite de espera del cliente, este se va enfadado; de lo contrario, se lleva su café satisfecho.

---

## ⚙️ Funcionamiento

1. Se crean varios **clientes** (`Cliente`) y **camareros** (`Camarero`).
2. Cada cliente llega, espera su turno y es atendido por un camarero (según el índice del bucle).
3. Los tiempos de espera y preparación se comparan para determinar el resultado.
4. Todo el proceso se muestra mediante la función `appendText()` en la interfaz.

---

## Tecnologías Utilizadas

1. Java 8+
2. JavaFX (para interfaz y appendText)
3. Programación concurrente (Threads)

---