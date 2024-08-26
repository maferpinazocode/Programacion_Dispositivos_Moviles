package Ejercicio_1

// Función para hallar el nivel
fun hallarNivel(puntuacion: Int): String {
    // Determina el nivel basado en la puntuación dada
    val nivel = when (puntuacion) {
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "Nivel no establecido"  // Este else es redundante pero se mantiene para robustez
    }
    return nivel
}

// Función para hallar el dinero
fun hallarDinero(salario: Float, puntuacion: Int): Float {
    // Calcula la cantidad de dinero con en el salario y la puntuación, usando división flotante
    val dinero: Float = salario * (puntuacion / 10.0f)
    return dinero
}

// Función principal
fun main(args: Array<String>) {
    var puntuacionUsuario: Int

    // Bucle para asegurar que el usuario ingrese una puntuación válida
    while (true) {
        try {
            println("Ingresar puntuación de usuario en el rango de 0 a 10")
            puntuacionUsuario = readln().toInt()  // Lee la entrada y la convierte a Int

            // Verificar que esté en el rango permitido
            if (puntuacionUsuario in 0..10) {
                break  // Si es válida, rompe el bucle
            } else {
                println("Puntuación fuera de rango, vuelve a ingresar")
            }
        } catch (e: NumberFormatException) {
            // Capturar excepciones por si el usuario ingresa un valor que no numérico
            println("Entrada inválida. Por favor, ingresa un número entero.")
        }
    }

    var salarioMensual: Float

    // Manejo de excepciones para la entrada del salario
    while (true) {
        try {
            println("Ingresar salario mensual de usuario")
            salarioMensual = readln().toFloat()  // Lee la entrada y la convierte a Float
            break  // Si la conversión es correcta, se rompe el bucle
        } catch (e: NumberFormatException) {
            // Si el usuario ingresa un valor que no es un numérico, captura excepciones
            println("Entrada inválida. Por favor, ingresa un número válido para el salario.")
        }
    }

    // Determina el nivel de rendimiento mediante en la puntuación del usuario
    val nivelUsuario = hallarNivel(puntuacionUsuario)

    // Calcula la cantidad de dinero que el usuario recibirá por en el salario y la puntuación
    val cantidadDinero = hallarDinero(salarioMensual, puntuacionUsuario)

    // Imprime el resultado
    println("Resultado: Nivel de Rendimiento $nivelUsuario, Cantidad de dinero recibido $cantidadDinero")
}
