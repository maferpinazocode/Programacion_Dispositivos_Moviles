package Ejercicio_3

import kotlin.random.Random

fun main(args: Array<String>) {
    val numeroGenerado = Random.nextInt(1, 31)  // O usar 32 si quieres incluir el 31.
    var numIntentos: Int = 5
    println("-- Bienvenido a adivinar el número --")
    println("Se te otorgarán pistas ")

    while (numIntentos > 0) {
        println("Te quedan $numIntentos intento(s).")
        println("¡Ingresa el número!")
        val numAdivinar = readln().toInt()

        if (numAdivinar < numeroGenerado) {
            println("¡El número a adivinar es mayor!")
            println("Vuelve a intentarlo.")
        } else if (numAdivinar > numeroGenerado) {
            println("¡El número a adivinar es menor!")
            println("Vuelve a intentarlo.")
        } else {
            println("¡El número a adivinar es $numeroGenerado!")
            println("Muy bien, acertaste :)")
            break
        }

        numIntentos -= 1
    }

    if (numIntentos == 0) {
        println("Lo siento, se te acabaron los intentos. El número era $numeroGenerado.")
    }
}
