package TercerEjercicio.Controlador

import TercerEjercicio.Clases.Circulo
import TercerEjercicio.Clases.Cuadrado
import TercerEjercicio.Clases.Rectangulo

fun main() {
    val cuadrado = Cuadrado(6.0)
    val circulo = Circulo(4.0)
    val rectangulo = Rectangulo(9.0, 5.0)

    println("Cuadrado:")
    cuadrado.imprimirInformacion()

    println("\nCírculo:")
    circulo.imprimirInformacion()

    println("\nRectángulo:")
    rectangulo.imprimirInformacion()
}