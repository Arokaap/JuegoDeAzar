package modelo

import recursos.Utilidades
import java.lang.StringBuilder
import java.util.*

class Juego(numeroCorrecto: Byte, jugadores: Array<Jugador>) {

    private var numeroCorrecto: Byte
    private var jugadores: Array<Jugador>

    init {
        this.numeroCorrecto = numeroCorrecto
        this.jugadores = jugadores
    }

    fun getNumeroCorrecto(): Byte = numeroCorrecto
    fun getJugadores(): Array<Jugador> = jugadores
    fun getNumJugadores(): Byte = numJugadores

    companion object {
        private var numJugadores: Byte = 0

        fun menuInicial(): Byte {
            val sb = StringBuilder("\n\n--------MENU---------")
                .append("\n1. Comenzar partida")
                .append("\n2. Opciones")
                .append("\n3. Creditos")
                .append("\n4. Salir")

            println(sb)

            return Utilidades.pedirByte("Introduzca una opción:\n")
        }

        fun menuPartida(): Byte {
            val sb = StringBuilder("\n\n------PARTIDA-------")
                .append("\n1. Iniciar juego")
                .append("\n2. Añadir jugador")
                .append("\n3. Mostrar jugadores")
                .append("\n4. Eliminar Jugador")
                .append("\n5. Salir del juego")

            println(sb)

            return Utilidades.pedirByte("Introduzca una opción:\n")
        }

        fun existirJugadores(): Boolean {
            var existeJugador:Boolean = true
            if (this.numJugadores <= 0) {
                existeJugador = false
            }

            return existeJugador
        }
    }

    fun generarNumeroCorrecto() {
        numeroCorrecto = ((Math.random()) * 10).toInt().toByte()
    }
}