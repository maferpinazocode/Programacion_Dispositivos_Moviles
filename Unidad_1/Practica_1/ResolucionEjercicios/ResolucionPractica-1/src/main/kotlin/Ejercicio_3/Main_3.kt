package Ejercicio_3

import kotlin.random.Random

fun main(args: Array<String>){
    var numeroGenerado = Random.nextInt(1,31)
    var numIntentos: Int = 5
    println("-- Bienvenido a adivinar el número --")
    println("Se te otorgaran pistas ")

    while (numIntentos <= 5) {
        println("Solo tienes $numIntentos intentos ")
        println("¡Ingresa el número!")
        var numAdivinar = readln().toInt()
        if (numAdivinar < numeroGenerado){
            println("¡El número a adivinar es mayor!")
            println("Vuelve a intentarlo")
        }
        else if(numAdivinar > numeroGenerado){
            println("¡El número a adivinar es menor!")
            println("Vuelve a intentarlo")
        }
        else{
            println("¡El número a adivinar es $numeroGenerado!")
            println("Muy bien, acertaste :)")
            break
        }
        numIntentos = numIntentos - 1
    }
}