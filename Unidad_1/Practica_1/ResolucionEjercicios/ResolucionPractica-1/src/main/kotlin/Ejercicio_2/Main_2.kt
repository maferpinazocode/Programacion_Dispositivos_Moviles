package Ejercicio_2

import kotlin.random.Random

fun encontrarGanador(opUsuario: Int, opComputador: Int): String {
    var nGanador: Int = 0
    var opEmpate: Int = 4

    if (opUsuario == opComputador){
        nGanador = opEmpate
    }
    else if ((opUsuario == 1 && opComputador == 3) || (opUsuario == 2 && opComputador == 1) || (opUsuario == 3 && opComputador == 2)){
        nGanador = opUsuario
    }
    else {
        nGanador = opComputador
    }

    var ganador = when (nGanador){
        opComputador -> "Computador :("
        opUsuario -> "Usuario :)"
        opEmpate -> "Hubo Empate :o"
        else -> "Error"
    }

    return ganador
}
fun main(args: Array<String>) {
    println("Elegir la opción que desea (un número):")
    println("1 -> Piedra")
    println("2 -> Papel")
    println("3 -> Tijera")

    var opcionUsuario = readln().toInt()
    var opcionGenerada = Random.nextInt(1,4)

    println("La opción del computador es $opcionGenerada")

    var ganador = encontrarGanador(opcionUsuario, opcionGenerada)
    println("El ganador es: \n$ganador")
}