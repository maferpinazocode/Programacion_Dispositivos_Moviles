package CuartoEjercicio.Controlador

import CuartoEjercicio.Clases.Libro
import CuartoEjercicio.Clases.Revista
import CuartoEjercicio.Clases.Usuario

fun main(){
    val libro1 = Libro("Kotlin Programming", "John Doe", 2023, "Programación", 300)
    val revista1 = Revista("Tech Monthly", "Jane Smith", 2022, "1234-5678", 10, 3, "Tech Publishers")
    val usuario1 = Usuario("Carlos", "Pérez", 30)
    val usuario2 = Usuario("Ana", "García", 25)
}