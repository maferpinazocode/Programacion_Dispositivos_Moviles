package PrimerEjercicio.Clases
import java.time.LocalDate

// Clase para representar una transacción, incluyendo el tipo (retiro o depósito), monto y fecha.
data class Transaccion(val tipo: String, val monto: Double, val fecha: String)

// Clase principal CuentaBancaria que gestiona el saldo, límite de retiro y las transacciones.
class CuentaBancaria(saldo: Double, var limiteRetiro: Double) {

    // Lista mutable que almacena el historial de transacciones de la cuenta.
    private val historialTransacciones = mutableListOf<Transaccion>()

    // Propiedad 'saldo' con getter y setter personalizados. Se valida que el saldo no pueda ser negativo.
    var saldo: Double = saldo
        get() {
            return field // Devuelve el valor actual del saldo.
        }
        set(value) {
            if (value >= 0) {
                field = value // Asigna el nuevo valor si es no negativo.
            } else {
                // Lanza una excepción si el valor es negativo.
                throw IllegalArgumentException("El saldo no puede ser negativo. Valor proporcionado: $value")
            }
        }

    // Método para realizar un retiro. Maneja excepciones para verificar la validez del monto.
    fun retiro(monto: Double) {
        try {
            // Verificaciones: monto positivo, dentro del límite de retiro y saldo suficiente.
            if (monto <= 0) throw IllegalArgumentException("El monto de retiro debe ser positivo.")
            if (monto > limiteRetiro) throw IllegalArgumentException("El monto de retiro excede el límite permitido.")
            if (monto > saldo) throw IllegalArgumentException("Fondos insuficientes.")

            // Realiza el retiro y añade la transacción al historial.
            saldo -= monto
            historialTransacciones.add(Transaccion("Retiro", monto, LocalDate.now().toString()))
        } catch (e: IllegalArgumentException) {
            // Captura y muestra el error en caso de una excepción.
            println("Error al realizar el retiro: ${e.message}")
        }
    }

    // Método para realizar un depósito. También maneja excepciones y añade la transacción al historial.
    fun depositar(monto: Double) {
        try {
            // Verificación: el monto de depósito debe ser positivo.
            if (monto <= 0) throw IllegalArgumentException("El monto de depósito debe ser positivo.")

            // Realiza el depósito y añade la transacción al historial.
            saldo += monto
            historialTransacciones.add(Transaccion("Depósito", monto, LocalDate.now().toString()))
        } catch (e: IllegalArgumentException) {
            // Captura y muestra el error en caso de una excepción.
            println("Error al realizar el depósito: ${e.message}")
        }
    }

    // Método para mostrar el estado actual de la cuenta (saldo y límite de retiro).
    fun mostrarEstado(): String {
        return "Saldo actual: $saldo, Limite de Retiro: $limiteRetiro"
    }

    // Método para devolver el historial completo de transacciones.
    fun mostrarHistorial(): List<Transaccion> {
        return historialTransacciones
    }
}
