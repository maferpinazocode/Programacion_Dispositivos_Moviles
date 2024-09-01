package TercerEjercicio.Clases

// Clase Cuadrado que hereda de la clase abstracta Shape
class Cuadrado(private val lado: Double) : Shape() {
    // Propiedades para almacenar el área y el perímetro del cuadrado
    override var area: Double = 0.0
    override var perimetro: Double = 0.0

    // Bloque init que se ejecuta al crear una instancia del Cuadrado
    init {
        hallarArea()       // Calcula el área del cuadrado
        hallarPerimetro()  // Calcula el perímetro del cuadrado
    }

    // Implementación del método para calcular el área del cuadrado
    override fun hallarArea() {
        area = lado * lado
    }

    // Implementación del método para calcular el perímetro del cuadrado
    override fun hallarPerimetro() {
        perimetro = 4 * lado
    }
}
