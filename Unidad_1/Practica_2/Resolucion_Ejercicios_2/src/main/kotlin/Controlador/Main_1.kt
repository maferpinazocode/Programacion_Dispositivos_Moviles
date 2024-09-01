package Controlador
import Clases.CuentaBancaria

fun main(args: Array<String>) {
    println("Hello World!")
    var cuenta = CuentaBancaria(230.0,300.5)
    println(cuenta.mostrarEstado())

    cuenta.retiro(200.0)
    println("Retiro realizado con éxito.")
    println(cuenta.mostrarEstado())

    cuenta.depositar(300.0)
    println("Depósito realizado con éxito.")
    println(cuenta.mostrarEstado())

    println("Historial de transacciones:")
    cuenta.mostrarHistorial().forEach { println(it) }

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}