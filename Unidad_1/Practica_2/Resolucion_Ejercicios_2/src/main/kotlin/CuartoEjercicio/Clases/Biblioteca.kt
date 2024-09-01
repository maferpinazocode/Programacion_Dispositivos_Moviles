package CuartoEjercicio.Clases

import CuartoEjercicio.Interfaces.IBiblioteca


class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuarios = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
    }

    override fun registrarUsuario(usuario: Usuario) {
    }

    override fun prestarMaterial(usuario: Usuario, material: Material): Boolean {

        return false
    }

    override fun devolverMaterial(usuario: Usuario, material: Material): Boolean {
        return false 
    }

    override fun mostrarMaterialesDisponibles() {

    }

    override fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario) {

    }
}
