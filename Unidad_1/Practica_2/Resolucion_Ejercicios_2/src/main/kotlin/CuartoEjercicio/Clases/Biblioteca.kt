package CuartoEjercicio.Clases

import CuartoEjercicio.Interfaces.IBiblioteca


class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuarios = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
    }

    override fun registrarUsuario(usuario: Usuario) {
        usuarios[usuario] = mutableListOf()
    }

    override fun prestarMaterial(usuario: Usuario, material: Material): Boolean {
        if (materialesDisponibles.contains(material) && usuarios.containsKey(usuario)) {
            materialesDisponibles.remove(material)
            usuarios[usuario]?.add(material)
            return true
        }
        return false
    }

    override fun devolverMaterial(usuario: Usuario, material: Material): Boolean {
        if (usuarios[usuario]?.contains(material) == true) {
            usuarios[usuario]?.remove(material)
            materialesDisponibles.add(material)
            return true
        }
        return false
    }

    override fun mostrarMaterialesDisponibles() {
        println("Materiales Disponibles:")
        for (material in materialesDisponibles) {
            material.mostrarDetalles()
            println()
        }
    }

    override fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario) {
        println("Materiales Reservados por ${usuario.nombre} ${usuario.apellido}:")
        usuarios[usuario]?.forEach { material ->
            material.mostrarDetalles()
            println()
        }
    }
}
