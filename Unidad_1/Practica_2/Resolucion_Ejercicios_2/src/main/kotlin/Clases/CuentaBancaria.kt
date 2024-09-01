package Clases
import java.time.LocalDate

data class Transaccion(val tipo: String, val monto: Double, val fecha: String)

class CuentaBancaria(var saldo: Double, var limiteRetiro: Double) {

    private val historialTransacciones = mutableListOf<Transaccion>()
    init {
        require(saldo >= 0){"Lo siento. El saldo no debe ser negativo."}
        require(limiteRetiro > 0){"El límite de retiro debe ser mayor a cero."}
    }

    fun retiro(monto: Double){
        saldo -= monto
        historialTransacciones.add(Transaccion("Retiro", monto, LocalDate.now().toString()))
    }

    fun depositar(monto: Double){
        if(monto > 0){
            saldo += monto
            historialTransacciones.add(Transaccion("Depósito", monto, LocalDate.now().toString()))
            println("Deposito realizado con éxito. Nuevo saldo: $saldo")
        }
        else{
            println("Error. El monto a depositar debe ser mayor a cero.")
        }
    }

    fun mostrarEstado(): String {
        return "Saldo actual: $saldo, Limite de Retiro: $limiteRetiro"
    }

    fun mostrarHistorial(): List<Transaccion>{
        return historialTransacciones
    }
}