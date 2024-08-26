package Ejercicio_2

import kotlin.random.Random

// Función que determina quién es el ganador entre el usuario y el computador
fun encontrarGanador(opUsuario: Int, opComputador: Int): String {
    // Variable que almacena el resultado del juego
    val ganador: String = when {
        // Si las opciones del usuario y el computador son iguales, es un empate
        opUsuario == opComputador -> "Hubo Empate :o"
        // Si el usuario gana (Piedra vs Tijera, Papel vs Piedra, Tijera vs Papel)
        (opUsuario == 1 && opComputador == 3) || (opUsuario == 2 && opComputador == 1) || (opUsuario == 3 && opComputador == 2) -> "Usuario :)"
        // En cualquier otro caso, gana el computador
        else -> "Computador :("
    }
    // Devolver el resultado
    return ganador
}

// Función que obtiene la opción del usuario
fun obtenerOpcionUsuario(): Int {
    // Mostrar opciones disponibles
    println("Elegir la opción que desea (un número):")
    println("1 -> Piedra")
    println("2 -> Papel")
    println("3 -> Tijera")

    try {
        // Leer la opción del usuario y convertirla a entero
        val opcion = readln().toInt()
        // Verificar que la opción esté en el rango válido (1, 2 o 3)
        if (opcion !in 1..3) {
            // Si no es válida, lanzar una excepción
            throw IllegalArgumentException("Opción no válida. Debe ser 1, 2 o 3.")
        }
        // Devolver la opción válida
        return opcion
    } catch (e: NumberFormatException) {
        // Si el usuario no ingresó un número, lanzar una excepción
        throw IllegalArgumentException("Debe ingresar un número válido.")
    }
}

// Función principal del programa
fun main(args: Array<String>) {

    // Obtener la opción seleccionada por el usuario
    val opcionUsuario = obtenerOpcionUsuario()
    // Generar aleatoriamente la opción del computador (1 a 3)
    val opcionGenerada = Random.nextInt(1, 4)

    // Mostrar la opción del computador
    println("La opción del computador es $opcionGenerada")

    // Determinar quién es el ganador
    val ganador = encontrarGanador(opcionUsuario, opcionGenerada)
    // Mostrar el resultado
    println("El ganador es: \n$ganador")
}
