package CuartoEjercicio.Clases

class Libro(titulo: String, autor: String, anioPublicacion: Int, val genero: String, val numeroPaginas: Int)
    : Material(titulo, autor, anioPublicacion) {

    override fun mostrarDetalles() {
        println("Libro: $titulo")
        println("Autor: $autor")
        println("Año de Publicación: $anioPublicacion")
        println("Género: $genero")
        println("Número de Páginas: $numeroPaginas")
    }
}