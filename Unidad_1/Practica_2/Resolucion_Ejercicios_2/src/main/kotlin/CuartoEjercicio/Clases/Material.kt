package CuartoEjercicio.Clases

// La clase abstracta Material representa el concepto general de un material en la biblioteca.
// Es la clase base de la cual heredarán otras clases como Libro o Revista.
abstract class Material(val titulo: String, val autor: String, val anioPublicacion: Int) {

    // El método abstracto mostrarDetalles debe ser implementado por las clases que hereden de Material.
    // Se utiliza para mostrar los detalles específicos de cada tipo de material.
    abstract fun mostrarDetalles()
}
