package SegundoEjercicio.Clases

class Producto {
    var preciosAccesos: Int = 0

    var precio: Double = 0.0
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
}