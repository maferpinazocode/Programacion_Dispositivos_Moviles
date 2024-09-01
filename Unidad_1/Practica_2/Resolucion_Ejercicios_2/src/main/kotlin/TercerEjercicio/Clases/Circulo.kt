package TercerEjercicio.Clases

class Circulo(private val radio: Double) : Shape() {
    override var area: Double = 0.0
         set
    override var perimetro: Double = 0.0
         set

    init {
        hallarArea()
        hallarPerimetro()
    }

    override fun hallarArea() {
        area = Math.PI * radio * radio
    }

    override fun hallarPerimetro() {
        perimetro = 2 * Math.PI * radio
    }


    constructor(radio: Double, mensaje: String) : this(radio) {
        println("\nInicializando Círculo con radio: $radio")
        println(mensaje) // Función especial: imprimir mensaje adicional
        hallarArea()
        hallarPerimetro()
    }

}