package CuartoEjercicio.Clases

// Importamos la interfaz IBiblioteca, la cual define las operaciones que debe implementar la clase Biblioteca.
import CuartoEjercicio.Interfaces.IBiblioteca

// Definición de la clase Biblioteca que implementa la interfaz IBiblioteca.
class Biblioteca : IBiblioteca {
    // Lista mutable que almacena los materiales disponibles en la biblioteca.
    private val materialesDisponibles = mutableListOf<Material>()

    // Mapa que asocia a cada usuario (clave) con una lista mutable de materiales que tiene en préstamo (valor).
    private val usuarios = mutableMapOf<Usuario, MutableList<Material>>()

    // Método para registrar un material en la lista de materiales disponibles.
    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material) // Añade el material a la lista de materiales disponibles.
    }

    // Método para registrar un usuario en el mapa de usuarios.
    override fun registrarUsuario(usuario: Usuario) {
        usuarios[usuario] = mutableListOf() // Crea una entrada en el mapa con una lista vacía de materiales prestados.
    }

    // Método para prestar un material a un usuario.
    override fun prestarMaterial(usuario: Usuario, material: Material): Boolean {
        // Verifica si el material está disponible y si el usuario está registrado.
        if (materialesDisponibles.contains(material) && usuarios.containsKey(usuario)) {
            materialesDisponibles.remove(material) // Elimina el material de la lista de materiales disponibles.
            usuarios[usuario]?.add(material) // Añade el material a la lista de préstamos del usuario.
            return true // El préstamo fue exitoso.
        }
        return false // El préstamo falló (material no disponible o usuario no registrado).
    }

    // Método para devolver un material prestado por un usuario.
    override fun devolverMaterial(usuario: Usuario, material: Material): Boolean {
        // Verifica si el usuario tiene el material en préstamo.
        if (usuarios[usuario]?.contains(material) == true) {
            usuarios[usuario]?.remove(material) // Elimina el material de la lista de préstamos del usuario.
            materialesDisponibles.add(material) // Añade el material de vuelta a la lista de materiales disponibles.
            return true // La devolución fue exitosa.
        }
        return false // La devolución falló (el usuario no tenía el material en préstamo).
    }

    // Método para mostrar todos los materiales disponibles en la biblioteca.
    override fun mostrarMaterialesDisponibles() {
        println("Materiales Disponibles:") // Imprime el título de la sección.
        for (material in materialesDisponibles) {
            material.mostrarDetalles() // Muestra los detalles de cada material disponible.
            println() // Añade una línea en blanco para separación.
        }
    }

    // Método para mostrar los materiales que tiene prestados un usuario en particular.
    override fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario) {
        println("Materiales Reservados por ${usuario.nombre} ${usuario.apellido}:") // Imprime el título de la sección con el nombre del usuario.
        usuarios[usuario]?.forEach { material ->
            material.mostrarDetalles() // Muestra los detalles de cada material prestado por el usuario.
            println() // Añade una línea en blanco para separación.
        }
    }
}
