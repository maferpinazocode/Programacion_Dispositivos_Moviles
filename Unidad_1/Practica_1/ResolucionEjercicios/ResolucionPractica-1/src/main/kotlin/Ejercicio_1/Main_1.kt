package Ejercicio_1


fun main(args: Array<String>) {
    var puntuacionUsuario: Int
    while (true) {
        println("Ingresar puntuación de usuario en el rango de 0 a 10")
        puntuacionUsuario = readln().toInt()
        if (puntuacionUsuario in 0..10) {
            break
        } else {
            println("Puntuación no establecida, vuelve a ingresar")
        }
    }

    println("Ingresar salario mensual de usuario")
    var salarioMensual = readln().toFloat()


}