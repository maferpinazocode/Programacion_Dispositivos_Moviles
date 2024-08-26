package Ejercicio_4

fun main (args: Array<String>){
    var opcion: Int
    while (true) {
        println("==== Menú ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")

        opcion = readln().toInt()
        if (opcion == 5){
            return
        }

        var numero1: Double = readln().toDouble()
        var numero2: Double = readln().toDouble()
        // POR QUE ME CORTAS?
        // SE CORTO SOLO INTERNET FALLO

        var respuesta = when (opcion) {
            1 -> numero1 + numero2
            2 -> numero1 - numero2
            3 -> numero1 * numero2
            4 -> numero1 / numero2
            else -> "Error"
        }

        println("Resultado: $respuesta")
    }
}