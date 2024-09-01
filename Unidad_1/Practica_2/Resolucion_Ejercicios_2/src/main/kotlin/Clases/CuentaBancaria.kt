package Clases
data class Transaccion(val tipo: String, val monto: Double, val fecha: String)


class CuentaBancaria(var saldo: Double, var limiteRetiro: Double) {

    private val historialTransacciones = mutableListOf<Transaccion>()
    init {
        require(saldo >= 0){"Lo siento. El saldo no debe ser negativo."}
        require(limiteRetiro > 0){"El límite de retiro debe ser mayor a cero."}
    }

    fun depositar(monto: Double){
        if(monto > 0){
            saldo += monto
            println("Deposito realizado con éxito. Nuevo saldo: $saldo")
        }
        else{
            println("Error. El monto a depositar debe ser mayor a cero.")
        }
    }

    fun mostrarEstado(): String {
        return "Saldo actual: $saldo, Limite de Retiro: $limiteRetiro"
    }
}