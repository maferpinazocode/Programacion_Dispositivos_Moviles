package Ejercicio_2

import kotlin.random.Random

fun main(args: Array<String>) {
    println("Elegir la opción que desea (un número):")
    println("1 -> Piedra")
    println("2 -> Papel")
    println("3 -> Tijera")

    var opcionUsuario = readln().toInt()
    var opcionGenerada = Random.nextInt(1,4)

    println("La opción del computador es $opcionGenerada")

}