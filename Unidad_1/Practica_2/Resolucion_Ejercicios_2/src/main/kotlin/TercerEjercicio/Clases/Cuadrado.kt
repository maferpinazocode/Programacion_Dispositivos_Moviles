package TercerEjercicio.Clases

class Cuadrado(private val lado: Double) : Shape() {
    override var area: Double = 0.0
        set
    override var perimetro: Double = 0.0
        set

    init {
        hallarArea()
        hallarPerimetro()
    }

    override fun hallarArea() {
        area = lado * lado
    }

    override fun hallarPerimetro() {
        perimetro = 4 * lado
    }
}