package Ejercicio_4

fun main(args: Array<String>) {
    var opcion: Int

    while (true) {
        try {
            println("==== Menú ====")
            println("1. Suma")
            println("2. Resta")
            println("3. Multiplicación")
            println("4. División")
            println("5. Salir")

            opcion = readln().toInt()

            if (opcion == 5) {
                println("Saliendo...")
                break
            }

            if (opcion !in 1..4) {
                println("Opción inválida, intente nuevamente.")
                continue
            }

            println("Ingrese el primer número:")
            val numero1: Double = readln().toDouble()

            println("Ingrese el segundo número:")
            val numero2: Double = readln().toDouble()

            val respuesta = when (opcion) {
                1 -> numero1 + numero2
                2 -> numero1 - numero2
                3 -> numero1 * numero2
                4 -> if (numero2 != 0.0) numero1 / numero2 else {
                    println("Error: División por cero no permitida.")
                    continue
                }
                else -> "Error inesperado"
            }

            println("Resultado: $respuesta")

        } catch (e: NumberFormatException) {
            println("Error: Entrada no válida. Por favor, ingrese un número.")
        } catch (e: Exception) {
            println("Ocurrió un error inesperado: ${e.message}")
        }
    }
}
