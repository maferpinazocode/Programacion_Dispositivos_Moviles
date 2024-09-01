package CuartoEjercicio.Controlador

import CuartoEjercicio.Clases.Libro
import CuartoEjercicio.Clases.Revista
import CuartoEjercicio.Clases.Usuario
import CuartoEjercicio.Clases.Biblioteca



fun main() {
    // Crear instancia de Biblioteca
    val biblioteca = Biblioteca()

    // Crear instancias de materiales
    val libro1 = Libro("Gato Negro", "Edgar Allan Poe", 1984, "Terror", 300)
    val revista1 = Revista("Victoria Secrets", "Roy Larson Raymond", 1985, "1234-5678", 10, 3, "Tech Publishers")

    // Crear instancias de usuarios
    val usuario1 = Usuario("Harry", "Potter", 30)
    val usuario2 = Usuario("Ana", "Lopez", 25)

    // Registrar materiales y usuarios en la biblioteca
    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(revista1)
    biblioteca.registrarUsuario(usuario1)
    biblioteca.registrarUsuario(usuario2)

    // Mostrar materiales disponibles
    biblioteca.mostrarMaterialesDisponibles()

    // Prestar material
    biblioteca.prestarMaterial(usuario1, libro1)

    // Mostrar materiales reservados por usuario
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario1)

    // Devolver material
    biblioteca.devolverMaterial(usuario1, libro1)

    // Mostrar materiales disponibles después de la devolución
    biblioteca.mostrarMaterialesDisponibles()
}
