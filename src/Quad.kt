//enum class TIPO_QUAD{

//CUADRICICLO_LIGERO, CUADRICICLO_NO_LIGERO, VEHICULO_ESPECIAL

//}



class Quad(nombre: String = "",
           marca: String = "",
           modelo: String,
           capacidadCombustible: Float,
           combustibleActual: Float,
           kilometrosActuales: Float,
           cilindrada: Int, tipoDeQuad: String): Motocicleta(nombre,
    marca,
    modelo,
    capacidadCombustible,
    combustibleActual,
    kilometrosActuales,
    cilindrada) {


    companion object{



    }


    override fun calcularAutonomia(): Float{
        val autonomiaMoto = (combustibleActual * (KM_POR_LITRO - (1 - (cilindrada/1000))))

        val autonomiaQuad = (autonomiaMoto / 2).redondear(2)

        return autonomiaQuad
    }

    override fun toString(): String {
        return "Quad(nombre=$nombre, marca=$marca, modelo=$modelo, capacidadCombustible=$capacidadCombustible, combustibleActual=$combustibleActual, kilometrosActuales=$kilometrosActuales, cilindrada=$cilindrada)"
    }
}