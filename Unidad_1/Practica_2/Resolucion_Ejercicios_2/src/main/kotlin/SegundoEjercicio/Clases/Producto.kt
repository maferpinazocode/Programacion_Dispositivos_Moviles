package SegundoEjercicio.Clases

class Producto(precio: Double, descuento: Double) {
    var preciosAccesos: Int = 0
    var descuentoAccesos: Int = 0


    var precio: Double = precio
        set(value) {
            if (value >= 0){
                field = value
            }
            else{
                throw IllegalArgumentException("El precio no puede ser negativo.")
            }
        }
        get() {
            preciosAccesos ++
            println("Accediendo al precio. Veces accedido: $preciosAccesos")
            return field
        }

    var descuento: Double = descuento
        set(value) {
            if (value in 0.0 .. 100.0){
                field = value
            }
            else{
                throw IllegalArgumentException("El descuento no puede ser negativo. De estar entre 0 y 100.")
            }
        }
        get() {
            descuentoAccesos++
            println("Accediendo al descuento. Veces accedido: $descuentoAccesos")
            return field
        }
}