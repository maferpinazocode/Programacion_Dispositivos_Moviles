package Ejercicio_3

import kotlin.random.Random

fun main(args: Array<String>) {
    val numeroGenerado = crearNumeroAleatorio(1, 31)
    val numIntentos = 5
    println("-- Bienvenido a adivinar el número --")
    println("Se te otorgarán pistas ")

    ejecutarJuego(numeroGenerado, numIntentos)
}

fun crearNumeroAleatorio(min: Int, max: Int): Int {
    return Random.nextInt(min, max)
}

fun ejecutarJuego(numeroGenerado: Int, intentosRestantes: Int) {
    var intentos = intentosRestantes

    while (intentos > 0) {
        println("Te quedan $intentos intento(s).")
        println("¡Ingresa el número!")
        val numeroIngresado = readln().toIntOrNull()

        if (numeroIngresado != null) {
            if (verificarNumero(numeroIngresado, numeroGenerado)) {
                println("¡Muy bien, acertaste :)")
                break
            } else {
                generarPista(numeroIngresado, numeroGenerado)
                intentos -= 1
                if (intentos > 0) {
                    println("Vuelve a intentarlo.")
                }
            }
        } else {
            println("Por favor, ingresa un número válido.")
        }
    }

    if (intentos == 0) {
        println("Lo siento, se te acabaron los intentos. El número era $numeroGenerado.")
    }
}

fun verificarNumero(numeroIngresado: Int, numeroGenerado: Int): Boolean {
    return if (numeroIngresado == numeroGenerado) {
        println("¡El número a adivinar es $numeroGenerado!")
        true
    } else {
        false
    }
}

fun generarPista(numeroIngresado: Int, numeroGenerado: Int) {
    if (numeroIngresado < numeroGenerado) {
        println("¡El número a adivinar es mayor!")
    } else {
        println("¡El número a adivinar es menor!")
    }
}
