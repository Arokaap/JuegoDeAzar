package modelo

import recursos.Utilidades
import java.io.Serializable
import java.lang.StringBuilder

class Juego(idPartida: Byte, numeroCorrecto: Byte) : Serializable {

    private var idPartida: Byte
    private var numeroCorrecto: Byte
    private var numJugadores: Byte = 0
    private var jugadores: MutableList<Jugador> = arrayListOf()

    init {
        this.idPartida = idPartida
        this.numeroCorrecto = numeroCorrecto
    }

    fun getIdPartida(): Byte = idPartida
    fun getNumeroCorrecto(): Byte = numeroCorrecto
    fun getJugadores(): List<Jugador> = jugadores
    fun getNumJugadores(): Byte = numJugadores

    companion object {
        private const val serialVersionUID: Long = 123
        fun menuInicial(): Byte {
            val sb = StringBuilder("\n\n--------MENU---------")
                .append("\n1. Nueva partida")
                .append("\n2. Cargar partida")
                .append("\n3. Borrar partida")
                .append("\n4. Creditos")
                .append("\n5. Salir")

            println(sb)

            return Utilidades.pedirByte("Introduzca una opción:\n")
        }

        fun menuPartida(): Byte {
            val sb = StringBuilder("\n\n------PARTIDA-------")
                .append("\n1. Iniciar juego")
                .append("\n2. Añadir jugador")
                .append("\n3. Mostrar jugadores")
                .append("\n4. Eliminar jugador")
                .append("\n5. Guardar partida")
                .append("\n6. Salir de la partida")

            println(sb)

            return Utilidades.pedirByte("Introduzca una opción:")
        }
    }

    fun existirJugadores(): Boolean {
        return this.numJugadores > 0
    }

    fun generarNumeroCorrecto(): Unit {
        numeroCorrecto = ((Math.random()) * 10).toInt().toByte()
    }

    fun aniadirJugador() {
        var idUltimoJugador = (jugadores.size + 1).toByte()

        val nick = Utilidades.pedirString("Introduzca el nick del jugador ${idUltimoJugador}")
        val nombre = Utilidades.pedirString("Introduzca el nombre del jugador")
        val apellidos = Utilidades.pedirString("Introduzca los apellidos del jugador")

        jugadores.add(Jugador(idUltimoJugador, nick, nombre, apellidos))

        this.numJugadores++
    }

    fun mostrarJugadores(): Unit {
        for (jugador in jugadores!!) {
            println(jugador)
        }
    }

    fun guardarPartida() {

    }

    fun cargarPartida() {

    }
}