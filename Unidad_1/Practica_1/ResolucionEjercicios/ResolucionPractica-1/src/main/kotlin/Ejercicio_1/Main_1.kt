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

fun main(args: Array<String>) {
    var puntuacionUsuario: Int
    while (true) {
        println("Ingresar puntuación de usuario en el rango de 0 a 10")
        puntuacionUsuario = readln().toInt()
        // Verificar que esté en el rango permitido
        if (puntuacionUsuario in 0..10) {
            break // Si es válida, rompe el bucle
        } else {
            println("Puntuación no establecida, vuelve a ingresar")
        }
    }

    println("Ingresar salario mensual de usuario")
    var salarioMensual = readln().toFloat()

    // Determina el nivel de rendimiento mediante en la puntuación del usuario
    var nivelUsuario = hallarNivel(puntuacionUsuario)

    // Calcula la cantidad de dinero que el usuario recibirá por en el salario y la puntuación
    var cantidadDinero = hallarDinero(salarioMensual, puntuacionUsuario)

    // Imprime el resultado
    println("Resultado: Nivel de Rendimiento $nivelUsuario, Cantidad de dinero recibido $cantidadDinero")

}