
import kotlin.math.pow
import kotlin.math.roundToInt

/**
 * Extiende la clase [Float] para permitir el redondeo del número a un número específico de posiciones decimales.
 *
 * @param posiciones El número de posiciones decimales a las que se redondeará el valor.
 * @return Un [Float] redondeado al número de posiciones decimales especificadas.
 */
fun Float.redondear(posiciones: Int): Float {
    val factor = 10.0.pow(posiciones.toDouble()).toFloat()
    return (this * factor).roundToInt() / factor
}



/**
 * Selección del número de participantes y asignación del nombre de estos. Pide un valor numérico y luego un nombre para cada vehículo según el número de vehículos asignados.
 */
fun determinarParticipantes(){

    println("Por favor, introduzca el número de competidores: ")
    val numeroDeCompetidores = readln().toInt()                           // Pedimos al usuario un número de competidores.

    for (i in 1..numeroDeCompetidores){                             // Creamos un bucle que pase una vez por número de competidores que decidan poner.

        println("Por favor, introduzca el nombre del vehículo: ")
        val nombreVehiculo = readln()                                     // Pedimos al usuario un nombre. Este nombre no puede ser repetido.
        val listaParticipantesCheckRepetible = mutableSetOf<String>()     // Asignamos un conjunto donde almacenar los nombres.
        listaParticipantesCheckRepetible.plus(nombreVehiculo)             // Almacenamos el nombre en un conjunto -> un conjunto debe tener ítems únicos.

        for (j in listaParticipantesCheckRepetible){                      // Creamos otro bucle que se recorra la lista de nombres sin repetir y que genere una lista final con los vehículos creados.

            val vehiculoAsignado = generarRandomVehiculo()                // Asignamos la función a una variable
            val listaParticipantesFinal = listOf<Vehiculo>()              // Creamos una variable para almacenar la lista de vehículos

            listaParticipantesFinal.addLast(vehiculoAsignado)             // Una vez se pase el check del conjunto para eliminar repetidos se añadirá a una lista.

            return
        }
    }

}

/**
 * Este método contiene una serie de atributos randomizados con el fin de llamarlo en la instanciación de los distintos vehículos.
 */


// Idea -> No tengo muy claro cómo randomizar las instancias de un objeto así que voy a probar a usar un método que genere valores aleatorios y luego una lista con una palabra clave que lo enlace a ellas con un 'when'.
fun generarRandomVehiculo(): Vehiculo{

    val marca = listOf("Opel", "Volkswagen", "Citroen", "BMW", "Toyota", "Seat")
    val modelo = listOf("Corsa", "Passat", "C5", "M2", "Yaris", "Panda")
    val capacidad = (1..200).random().toFloat()
    val combustible = (1..200).random().toFloat()
    val kmActuales = (1..200).random().toFloat()
    val hibrido = listOf(true, false).random()
    val cilindradas = listOf(125, 250, 400, 500, 750, 900, 1000).random()
    val tipoQuad = listOf( "CUADRICICLO_LIGERO", "CUADRICICLO_NO_LIGERO", "VEHICULO_ESPECIAL")
    val peso = (1000..10000).random().toFloat()

    val tipoVehiculo = listOf("Automovil", "Motocicleta", "Camión", "Quad").random()

    return when(tipoVehiculo){

        "Automovil" -> Automovil("",
            marca.random(),
            modelo.random(),
            capacidad,
            combustible,
            kmActuales,
            hibrido)


        "Motocicleta" -> Motocicleta("",
            marca.random(),
            modelo.random(),
            capacidad,
            combustible,
            kmActuales,
            cilindradas)


        "Camión" -> Camion("",
            marca.random(),
            modelo.random(),
            capacidad,
            combustible,
            kmActuales,
            hibrido,
            peso)


        else -> Quad("",
            marca.random(),
            modelo.random(),
            capacidad,
            combustible,
            kmActuales,
            cilindradas,
            tipoQuad.random())
    }

}




/**
 * Punto de entrada del programa. Crea una lista de vehículos y una carrera, e inicia la carrera mostrando
 * los resultados al finalizar.
 */
fun main() {

    val vehiculos = listOf(
        Automovil("aurora", "Seat", "Panda", 50f, 50f * 0.1f, 0f, true),
        Automovil("Boreal m8", "BMW", "M8", 80f, 80f * 0.1f, 0f, false),
        Motocicleta("Céfiro", "Derbi", "Motoreta", 15f, 15f * 0.1f, 0f, 500),
        Automovil("Dinamo", "Cintroen", "Sor", 70f, 70f * 0.1f, 0f, true),
        Automovil("eclipse negro", "Renault", "Espacio", 60f, 60f * 0.1f, 0f, false),
        Motocicleta("Fénix", "Honda", "Vital", 20f, 20f * 0.1f, 0f, 250)
    )

    determinarParticipantes()

    val carrera = Carrera("Gran Carrera de Filigranas", 1000f, vehiculos)

    println("\n*** ${carrera.nombreCarrera} ***\n")
    carrera.iniciarCarrera()

    val resultados = carrera.obtenerResultados()

    println("* Clasificación:\n")
    resultados.forEach { println("${it.posicion} -> ${it.vehiculo.nombre} (${it.vehiculo.kilometrosActuales} kms)") }

    println("\n" + resultados.joinToString("\n") { it.toString() })

    println("\n* Historial Detallado:\n")
    resultados.forEach { println("${it.posicion} -> ${it.vehiculo.nombre}\n${it.historialAcciones.joinToString("\n")}\n") }
}

