package TercerEjercicio.Clases

abstract class Shape() {
    abstract var area: Double
    abstract var perimetro: Double

    abstract fun hallarArea()
    abstract fun hallarPerimetro()

    fun imprimirInformacion() {
        println("Área: $area")
        println("Perímetro: $perimetro")
    }

}