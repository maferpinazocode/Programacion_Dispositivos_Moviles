package TercerEjercicio.Clases

// Clase abstracta Shape que define la interfaz para las formas
abstract class Shape() {
    // Propiedades abstractas para área y perímetro
    abstract var area: Double
    abstract var perimetro: Double

    // Métodos abstractos para calcular área y perímetro
    abstract fun hallarArea()
    abstract fun hallarPerimetro()

    // Método para imprimir el área y el perímetro
    fun imprimirInformacion() {
        println("Área: $area")
        println("Perímetro: $perimetro")
    }
}
