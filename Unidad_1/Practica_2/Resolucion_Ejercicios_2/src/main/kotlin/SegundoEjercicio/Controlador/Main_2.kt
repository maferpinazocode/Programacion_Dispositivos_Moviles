package SegundoEjercicio.Controlador

import SegundoEjercicio.Clases.Producto

fun main() {
    val producto = Producto(100.0,15.0)


    println("Precio original: ${producto.precio}")
    println("Descuento aplicado: ${producto.descuento}%")
    println("Precio final: ${producto.calcularPrecioFinal()}")

    println("Precio original: ${producto.precio}")
    println("Descuento aplicado: ${producto.descuento}%")

    producto.reiniciarProducto()
    println("Producto reiniciado. Precio: ${producto.precio}, Descuento: ${producto.descuento}")
}