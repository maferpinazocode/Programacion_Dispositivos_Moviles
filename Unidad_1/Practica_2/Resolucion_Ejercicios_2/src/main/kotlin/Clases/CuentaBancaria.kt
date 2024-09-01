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
        try {
            if (monto <= 0) throw IllegalArgumentException("El monto de retiro debe ser positivo.")
            if (monto > limiteRetiro) throw IllegalArgumentException("El monto de retiro excede el límite permitido.")
            if (monto > saldo) throw IllegalArgumentException("Fondos insuficientes.")

            saldo -= monto
            historialTransacciones.add(Transaccion("Retiro", monto, LocalDate.now().toString()))
        } catch (e: IllegalArgumentException) {
            println("Error al realizar el retiro: ${e.message}")
        }
    }

    fun depositar(monto: Double){
        try {
            if (monto <= 0) throw IllegalArgumentException("El monto de depósito debe ser positivo.")

            saldo += monto
            historialTransacciones.add(Transaccion("Depósito", monto, LocalDate.now().toString()))
        } catch (e: IllegalArgumentException) {
            println("Error al realizar el depósito: ${e.message}")
        }
    }

    fun mostrarEstado(): String {
        return "Saldo actual: $saldo, Limite de Retiro: $limiteRetiro"
    }

    fun mostrarHistorial(): List<Transaccion>{
        return historialTransacciones
    }
}