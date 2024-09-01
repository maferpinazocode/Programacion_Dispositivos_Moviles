package CuartoEjercicio.Clases

// La clase Revista extiende la clase abstracta Material y representa una revista en la biblioteca.
// Tiene propiedades adicionales como ISSN, volumen, número y editorial.
class Revista(titulo: String, autor: String, anioPublicacion: Int, val issn: String, val volumen: Int, val numero: Int, val editorial: String
) : Material(titulo, autor, anioPublicacion) {

    // El método mostrarDetalles sobrescribe el método abstracto de la clase Material.
    // Muestra los detalles específicos de la revista.
    override fun mostrarDetalles() {
        println("Revista: $titulo") // Muestra el título de la revista.
        println("Autor: $autor") // Muestra el autor de la revista.
        println("Año de Publicación: $anioPublicacion") // Muestra el año de publicación de la revista.
        println("ISSN: $issn") // Muestra el ISSN de la revista.
        println("Volumen: $volumen") // Muestra el volumen de la revista.
        println("Número: $numero") // Muestra el número de la revista.
        println("Editorial: $editorial") // Muestra la editorial de la revista.
    }
}
