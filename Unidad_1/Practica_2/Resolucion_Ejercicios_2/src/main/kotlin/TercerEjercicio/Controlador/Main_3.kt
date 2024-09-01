package TercerEjercicio.Controlador

import TercerEjercicio.Clases.Circulo
import TercerEjercicio.Clases.Cuadrado
import TercerEjercicio.Clases.Rectangulo

fun main() {
    // Creación de instancias de cada forma
    val cuadrado = Cuadrado(6.0)
    val circulo = Circulo(4.0)
    val rectangulo = Rectangulo(9.0, 5.0)

    // Impresión de la información del cuadrado
    println("Cuadrado:")
    cuadrado.imprimirInformacion()

    // Impresión de la información del círculo
    println("\nCírculo:")
    circulo.imprimirInformacion()

    // Impresión de la información del rectángulo
    println("\nRectángulo:")
    rectangulo.imprimirInformacion()

    // Creación de un Círculo con el constructor secundario
    val circuloSec = Circulo(2.0, 3.0)
    println("\nCírculo con constructor secundario:")
    circuloSec.imprimirInformacion()
}
