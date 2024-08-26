package Ejercicio_4

fun main(args: Array<String>) {
    while (true) {
        val seleccion = desplegarMenu()
        if (seleccion == 5) {
            println("Saliendo...")
            break
        }

        if (seleccion in 1..4) {
            val primerNumero = solicitarNumero("Ingrese el primer número:")
            val segundoNumero = solicitarNumero("Ingrese el segundo número:")
            val resultado = calcularOperacion(seleccion, primerNumero, segundoNumero)
            resultado?.let {
                println("Resultado: $it")
            }
        } else {
            println("Selección inválida, intente nuevamente.")
        }
    }
}

fun desplegarMenu(): Int {
    return try {
        println("==== Menú de Operaciones ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")
        readln().toInt()
    } catch (e: NumberFormatException) {
        println("Error: Entrada no válida. Por favor, ingrese un número válido.")
        -1
    }
}

fun solicitarNumero(mensaje: String): Double {
    while (true) {
        try {
            println(mensaje)
            return readln().toDouble()
        } catch (e: NumberFormatException) {
            println("Error: Entrada no válida. Por favor, ingrese un número válido.")
        }
    }
}

fun calcularOperacion(seleccion: Int, numero1: Double, numero2: Double): Double? {
    return when (seleccion) {
        1 -> numero1 + numero2
        2 -> numero1 - numero2
        3 -> numero1 * numero2
        4 -> if (numero2 != 0.0) numero1 / numero2 else {
            println("Error: División por cero no permitida.")
            null
        }
        else -> null
    }
}
