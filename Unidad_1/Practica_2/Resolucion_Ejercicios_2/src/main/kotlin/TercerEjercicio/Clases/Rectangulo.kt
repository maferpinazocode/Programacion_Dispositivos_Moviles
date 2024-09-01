package TercerEjercicio.Clases

class Rectangulo(private val largo: Double, private val ancho: Double) : Shape() {
    override var area: Double = 0.0
         set
    override var perimetro: Double = 0.0
         set

    init {
        hallarArea()
        hallarPerimetro()
    }

    override fun hallarArea() {
        area = largo * ancho
    }

    override fun hallarPerimetro() {
        perimetro = 2 * (largo + ancho)
    }


}