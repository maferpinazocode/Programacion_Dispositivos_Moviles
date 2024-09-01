package CuartoEjercicio.Interfaces

import CuartoEjercicio.Clases.Material
import CuartoEjercicio.Clases.Usuario

interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestarMaterial(usuario: Usuario, material: Material): Boolean
    fun devolverMaterial(usuario: Usuario, material: Material): Boolean
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario)
}