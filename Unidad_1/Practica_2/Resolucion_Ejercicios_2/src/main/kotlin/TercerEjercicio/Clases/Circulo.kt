package TercerEjercicio.Clases

// Clase Circulo que hereda de la clase abstracta Shape
class Circulo(private val radio: Double) : Shape() {
    // Propiedades para almacenar el área y el perímetro del círculo
    override var area: Double = 0.0
    override var perimetro: Double = 0.0

    // Bloque init que se ejecuta al crear una instancia del Circulo
    init {
        hallarArea()       // Calcula el área del círculo
        hallarPerimetro()  // Calcula el perímetro del círculo
    }

    // Implementación del método para calcular el área del círculo
    override fun hallarArea() {
        area = Math.PI * radio * radio
    }

    // Implementación del método para calcular el perímetro del círculo
    override fun hallarPerimetro() {
        perimetro = 2 * Math.PI * radio
    }

    // Constructor secundario que permite ajustar el radio si es menor que un umbral
    constructor(radio: Double, umbral: Double) : this(if (radio < umbral) umbral else radio) {
        println("\nInicializando Círculo con radio: $radio (ajustado si era menor que $umbral)")
        hallarArea()       // Recalcula el área con el radio ajustado
        hallarPerimetro()  // Recalcula el perímetro con el radio ajustado
    }
}
