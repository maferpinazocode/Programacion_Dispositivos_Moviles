package PrimerEjercicio.Controlador
import PrimerEjercicio.Clases.CuentaBancaria

fun main() {
    // Se crea una nueva instancia de CuentaBancaria con un saldo inicial de 1000.0 y un límite de retiro de 500.0
    val cuenta = CuentaBancaria(saldo = 1000.0, limiteRetiro = 500.0)

    // Se muestra el estado actual de la cuenta (saldo y límite de retiro)
    println(cuenta.mostrarEstado())

    // Se realiza un retiro de 200.0
    cuenta.retiro(200.0)
    println("Retiro realizado con éxito.")
    // Se muestra el estado actualizado de la cuenta después del retiro
    println(cuenta.mostrarEstado())

    // Se realiza un depósito de 300.0
    cuenta.depositar(300.0)
    println("Depósito realizado con éxito.")
    // Se muestra el estado actualizado de la cuenta después del depósito
    println(cuenta.mostrarEstado())

    // Se muestra el historial de todas las transacciones realizadas (retiros y depósitos)
    println("Historial de transacciones:")
    cuenta.mostrarHistorial().forEach { println(it) }  // Se imprime cada transacción del historial
}
