import jdk.incubator.vector.VectorOperators.ABS

class Camion(nombre: String = "",
             marca: String = "",
             modelo: String,
             capacidadCombustible: Float,
             combustibleActual: Float,
             kilometrosActuales: Float,
             esHibrido: Boolean,
             peso: Float): Automovil(nombre,
    marca,
    modelo,
    capacidadCombustible,
    combustibleActual,
    kilometrosActuales,
    esHibrido) {

    val peso = peso

    init {
        require(peso in 1000.0f..10000.0f) { "El peso del camión debe de encontrarse entre 1000 y 10000kg." }
    }

    companion object{
        const val KM_POR_LITRO = 6.25f
        const val KM_POR_LITRO_HIBRIDO = 11.25f
        const val TRAMO_DE_CONSUMO = 1000.0f
    }

    override fun calcularAutonomia(): Float {
        val autonomiaBase = if (esHibrido) {
            (combustibleActual * (KM_POR_LITRO_HIBRIDO + AHORRO_ELECTRICO)).redondear(2)
        } else {
            (combustibleActual * (KM_POR_LITRO + AHORRO_ELECTRICO)).redondear(2)
        }

        val reduccionPeso = ((peso / TRAMO_DE_CONSUMO) * 0.2).toFloat()

        return kotlin.math.abs(autonomiaBase - reduccionPeso)    // <- ABS(..) no funcionaba así que he importado el pack completo // Para que no pueda dar un valor negativo usamos el ABS.
    }

    override fun toString(): String {
        return "Camion(nombre=$nombre, marca=$marca, modelo=$modelo, capacidadCombustible=$capacidadCombustible, combustibleActual=$combustibleActual, kilometrosActuales=$kilometrosActuales, esElectrico=$esHibrido)"
    }
}