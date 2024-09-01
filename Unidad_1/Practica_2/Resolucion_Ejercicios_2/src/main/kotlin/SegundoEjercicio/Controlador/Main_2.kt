package SegundoEjercicio.Controlador

import SegundoEjercicio.Clases.Producto
import java.util.Scanner

fun main() {

    val scanner = Scanner(System.`in`)
    val papitasFritas = Producto(100.0,15.0)
    val papitasPicantes = Producto(900.0,10.0)
    val papitasDulces = Producto(800.0,5.0)


    println("Opciones de productos disponibles:")
    println("1. Papitas Fritas - Precio: \$${papitasFritas.precio} - Descuento: ${papitasFritas.descuento}%")
    println("2. Papitas Picantes - Precio: \$${papitasPicantes.precio} - Descuento: ${papitasPicantes.descuento}%")
    println("3. Papitas Dulces - Precio: \$${papitasDulces.precio} - Descuento: ${papitasDulces.descuento}%")

    print("Elige el número del producto que deseas comprar (1, 2 o 3): ")
    val eleccion = scanner.nextInt()

    val productoSeleccionado = when (eleccion) {
        1 -> papitasFritas
        2 -> papitasPicantes
        3 -> papitasDulces
        else -> {
            println("Opción no válida.")
            return
        }
    }

    println("Has elegido: Producto ${eleccion}")
    println("El precio final después del descuento es: \$${productoSeleccionado.calcularPrecioFinal()}")

    println("Precio original: \$${productoSeleccionado.precio}")
    println("Descuento aplicado: ${productoSeleccionado.descuento}%")

    // Mostrar los totales de accesos
    println("Finalmente, veamos cuantos accesos al get se realizaron: ")
    productoSeleccionado.mostrarTotales()


}