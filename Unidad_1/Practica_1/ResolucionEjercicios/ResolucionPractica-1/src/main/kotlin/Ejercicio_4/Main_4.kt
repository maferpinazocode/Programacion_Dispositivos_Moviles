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
        if (opcion == 5) {
            return
        }

    }
}