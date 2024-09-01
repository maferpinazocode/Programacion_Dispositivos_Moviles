package Controlador
import Clases.CuentaBancaria

fun main() {
    val cuenta = CuentaBancaria(saldo = 1000.0, limiteRetiro = 500.0)

    println(cuenta.mostrarEstado())

    cuenta.retiro(200.0)
    println("Retiro realizado con éxito.")
    println(cuenta.mostrarEstado())

    cuenta.depositar(300.0)
    println("Depósito realizado con éxito.")
    println(cuenta.mostrarEstado())

    println("Historial de transacciones:")
    cuenta.mostrarHistorial().forEach { println(it) }

}