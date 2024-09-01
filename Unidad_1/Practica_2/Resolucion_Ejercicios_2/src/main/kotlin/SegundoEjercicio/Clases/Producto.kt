package SegundoEjercicio.Clases

class Producto(precio: Double, descuento: Double) {
    // Contadores privados para el número de accesos
    private var _preciosAccesos: Int = 0
    private var _descuentoAccesos: Int = 0

    // Propiedad precio con validación en el setter y contador en el getter
    var precio: Double = precio
        set(value) {
            if (value >= 0) {
                field = value
            } else {
                throw IllegalArgumentException("El precio no puede ser negativo.")
            }
        }
        get() {
            _preciosAccesos++  // Incrementa el contador cada vez que se accede
            return field
        }

    // Propiedad descuento con validación en el setter y contador en el getter
    var descuento: Double = descuento
        set(value) {
            if (value in 0.0..100.0) {
                field = value
            } else {
                throw IllegalArgumentException("El descuento debe estar entre 0 y 100.")
            }
        }
        get() {
            _descuentoAccesos++  // Incrementa el contador cada vez que se accede
            return field
        }

    // Método para calcular el precio final después de aplicar el descuento
    fun calcularPrecioFinal(): Double {
        val precioActual = precio // Accede al precio usando el getter
        return precioActual - (precioActual * (descuento / 100))
    }

    // Método para mostrar los totales de accesos a las propiedades
    fun mostrarTotales() {
        println("Total accesos al precio: $_preciosAccesos")
        println("Total accesos al descuento: $_descuentoAccesos")
    }
}
