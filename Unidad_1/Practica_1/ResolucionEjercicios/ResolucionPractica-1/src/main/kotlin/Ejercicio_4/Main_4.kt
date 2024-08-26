package Ejercicio_4

fun main(args: Array<String>) {
    // Bucle infinito para mostrar el menú repetidamente hasta que el usuario decida salir
    while (true) {
        // Llamamos a la función para mostrar el menú y obtenemos la opción seleccionada
        val seleccion = desplegarMenu()

        // Si la opción seleccionada es 5, salimos del programa
        if (seleccion == 5) {
            println("Saliendo...")
            break
        }

        // Verificamos si la opción es válida (entre 1 y 4)
        if (seleccion in 1..4) {
            // Pedimos los dos números al usuario
            val primerNumero = solicitarNumero("Ingrese el primer número:")
            val segundoNumero = solicitarNumero("Ingrese el segundo número:")

            // Calculamos el resultado de la operación seleccionada
            val resultado = calcularOperacion(seleccion, primerNumero, segundoNumero)

            // Si el resultado no es nulo, mostramos el resultado
            resultado?.let {
                println("Resultado: $it")
            }
        } else {
            // Si la opción no es válida, mostramos un mensaje de error
            println("Selección inválida, intente nuevamente.")
        }
    }
}

// Función para mostrar el menú y obtener la opción seleccionada por el usuario
fun desplegarMenu(): Int {
    return try {
        println("==== Menú de Operaciones ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")
        // Leemos la opción del usuario y la convertimos a entero
        readln().toInt()
    } catch (e: NumberFormatException) {
        // Si el usuario no ingresa un número válido, mostramos un mensaje de error
        println("Error: Entrada no válida. Por favor, ingrese un número válido.")
        -1 // Retornamos un valor inválido para indicar un error
    }
}

// Función para solicitar un número al usuario con un mensaje específico
fun solicitarNumero(mensaje: String): Double {
    while (true) {
        try {
            println(mensaje)
            // Leemos el número del usuario y lo convertimos a Double
            return readln().toDouble()
        } catch (e: NumberFormatException) {
            // Si el usuario no ingresa un número válido, mostramos un mensaje de error
            println("Error: Entrada no válida. Por favor, ingrese un número válido.")
        }
    }
}

// Función para calcular la operación matemática basada en la opción seleccionada
fun calcularOperacion(seleccion: Int, numero1: Double, numero2: Double): Double? {
    return when (seleccion) {
        1 -> numero1 + numero2 // Opción 1: Suma
        2 -> numero1 - numero2 // Opción 2: Resta
        3 -> numero1 * numero2 // Opción 3: Multiplicación
        4 -> if (numero2 != 0.0) numero1 / numero2 else {
            // Opción 4: División, con chequeo para evitar división por cero
            println("Error: División por cero no permitida.")
            null // Retornamos null en caso de error
        }
        else -> null // Para cualquier otro valor de opción, retornamos null
    }
}
