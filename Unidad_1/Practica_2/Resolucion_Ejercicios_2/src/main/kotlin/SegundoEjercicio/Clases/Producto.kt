package SegundoEjercicio.Clases

class Producto(precio: Double, descuento: Double) {
    private var _preciosAccesos: Int = 0
    private var _descuentoAccesos: Int = 0

    var precio: Double = precio
        set(value) {
            if (value >= 0) {
                field = value
            } else {
                throw IllegalArgumentException("El precio no puede ser negativo.")
            }
        }
        get() {
            _preciosAccesos++
            return field
        }

    var descuento: Double = descuento
        set(value) {
            if (value in 0.0..100.0) {
                field = value
            } else {
                throw IllegalArgumentException("El descuento debe estar entre 0 y 100.")
            }
        }
        get() {
            _descuentoAccesos++
            return field
        }

    fun calcularPrecioFinal(): Double {
        val precioActual = precio // Accedes solo una vez a la propiedad
        return precioActual - (precioActual * (descuento / 100))
    }

    fun mostrarTotales() {
        println("Total accesos al precio: $_preciosAccesos")
        println("Total accesos al descuento: $_descuentoAccesos")
    }

}
