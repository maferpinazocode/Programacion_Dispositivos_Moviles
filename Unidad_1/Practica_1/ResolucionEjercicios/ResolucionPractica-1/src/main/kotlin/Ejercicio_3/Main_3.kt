package Ejercicio_3

import kotlin.random.Random

import kotlin.random.Random

fun main(args: Array<String>) {
    // Genera un número aleatorio entre 1 y 31
    val numeroGenerado = crearNumeroAleatorio(1, 31)
    // Número de intentos que el usuario tiene para adivinar
    val numIntentos = 5
    println("-- Bienvenido a adivinar el número --")
    println("Se te otorgarán pistas ")

    // Inicia el juego con el número generado y el número de intentos
    ejecutarJuego(numeroGenerado, numIntentos)
}

// Función para crear un número aleatorio en un rango especificado
fun crearNumeroAleatorio(min: Int, max: Int): Int {
    return Random.nextInt(min, max)
}

// Función principal del juego
fun ejecutarJuego(numeroGenerado: Int, intentosRestantes: Int) {
    var intentos = intentosRestantes

    // Mientras queden intentos
    while (intentos > 0) {
        println("Te quedan $intentos intento(s).")
        println("¡Ingresa el número!")

        // Obtiene el número ingresado por el usuario, manejando posibles errores
        val numeroIngresado = obtenerNumeroUsuario()

        // Si el número ingresado es válido
        if (numeroIngresado != null) {
            // Verifica si el número ingresado es el correcto
            if (verificarNumero(numeroIngresado, numeroGenerado)) {
                println("¡Muy bien, acertaste :)")
                break // Termina el juego si el número es correcto
            } else {
                // Ofrece una pista si el número no es correcto
                generarPista(numeroIngresado, numeroGenerado)
                intentos -= 1 // Reduce el número de intentos
                if (intentos > 0) {
                    println("Vuelve a intentarlo.")
                }
            }
        } else {
            // Mensaje de error si el número ingresado no es válido
            println("Por favor, ingresa un número válido.")
        }
    }

    // Mensaje final cuando se acabaron los intentos
    if (intentos == 0) {
        println("Lo siento, se te acabaron los intentos. El número era $numeroGenerado.")
    }
}

// Función para obtener el número ingresado por el usuario y manejar errores
fun obtenerNumeroUsuario(): Int? {
    return try {
        readln().toIntOrNull() // Intenta convertir la entrada a entero
    } catch (e: NumberFormatException) {
        null // Devuelve null si ocurre una excepción
    }
}

// Función para verificar si el número ingresado es el correcto
fun verificarNumero(numeroIngresado: Int, numeroGenerado: Int): Boolean {
    return if (numeroIngresado == numeroGenerado) {
        println("¡El número a adivinar es $numeroGenerado!")
        true
    } else {
        false
    }
}

// Función para generar una pista sobre el número a adivinar
fun generarPista(numeroIngresado: Int, numeroGenerado: Int) {
    if (numeroIngresado < numeroGenerado) {
        println("¡El número a adivinar es mayor!")
    } else {
        println("¡El número a adivinar es menor!")
    }
}
