package CuartoEjercicio.Clases

// La clase Libro extiende la clase abstracta Material y representa un libro en la biblioteca.
class Libro(titulo: String, autor: String, anioPublicacion: Int, val genero: String, val numeroPaginas: Int)
    : Material(titulo, autor, anioPublicacion) {

    // El método mostrarDetalles sobrescribe el método abstracto de la clase Material.
    // Muestra los detalles específicos del libro.
    override fun mostrarDetalles() {
        println("Libro: $titulo") // Muestra el título del libro.
        println("Autor: $autor") // Muestra el autor del libro.
        println("Año de Publicación: $anioPublicacion") // Muestra el año de publicación del libro.
        println("Género: $genero") // Muestra el género del libro.
        println("Número de Páginas: $numeroPaginas") // Muestra el número de páginas del libro.
    }
}
