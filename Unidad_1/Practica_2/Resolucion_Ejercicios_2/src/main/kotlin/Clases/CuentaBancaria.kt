package Clases
import java.time.LocalDate

data class Transaccion(val tipo: String, val monto: Double, val fecha: String)

class CuentaBancaria(saldo: Double, var limiteRetiro: Double) {

    private val historialTransacciones = mutableListOf<Transaccion>()
    var saldo: Double = saldo
        get() {
            return field
        }
        set(value) {
            if (value >= 0) {
                field = value
            } else {
                throw IllegalArgumentException("El saldo no puede ser negativo. Valor proporcionado: $value")
            }
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