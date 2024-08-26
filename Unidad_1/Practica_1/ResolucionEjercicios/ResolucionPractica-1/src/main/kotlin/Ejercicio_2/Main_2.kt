package Ejercicio_2

import kotlin.random.Random

fun encontrarGanador(opUsuario: Int, opComputador: Int): String {
    val ganador: String = when {
        opUsuario == opComputador -> "Hubo Empate :o"
        (opUsuario == 1 && opComputador == 3) || (opUsuario == 2 && opComputador == 1) || (opUsuario == 3 && opComputador == 2) -> "Usuario :)"
        else -> "Computador :("
    }
    return ganador
}

fun obtenerOpcionUsuario(): Int {
    println("Elegir la opción que desea (un número):")
    println("1 -> Piedra")
    println("2 -> Papel")
    println("3 -> Tijera")

    val opcion = readln().toInt()

    return opcion
}

fun main(args: Array<String>) {

    val opcionUsuario = obtenerOpcionUsuario()
    val opcionGenerada = Random.nextInt(1, 4)

    println("La opción del computador es $opcionGenerada")

    val ganador = encontrarGanador(opcionUsuario, opcionGenerada)
    println("El ganador es: \n$ganador")

}
