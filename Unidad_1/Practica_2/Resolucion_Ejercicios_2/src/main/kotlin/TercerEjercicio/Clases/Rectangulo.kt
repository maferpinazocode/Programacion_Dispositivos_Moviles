package TercerEjercicio.Clases

// Clase Rectangulo que hereda de la clase abstracta Shape
class Rectangulo(private val largo: Double, private val ancho: Double) : Shape() {
    // Propiedades para almacenar el área y el perímetro del rectángulo
    override var area: Double = 0.0
    override var perimetro: Double = 0.0

    // Bloque init que se ejecuta al crear una instancia del Rectangulo
    init {
        hallarArea()       // Calcula el área del rectángulo
        hallarPerimetro()  // Calcula el perímetro del rectángulo
    }

    // Implementación del método para calcular el área del rectángulo
    override fun hallarArea() {
        area = largo * ancho
    }

    // Implementación del método para calcular el perímetro del rectángulo
    override fun hallarPerimetro() {
        perimetro = 2 * (largo + ancho)
    }
}
