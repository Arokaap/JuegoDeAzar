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
    fun setIdPartida(value: Byte) {
        idPartida = value
    }

    fun getJugadores() {
        Utilidades.limpiarPantalla()
        if (jugadores.isNotEmpty()) {
            for (jugador in jugadores) {
                Utilidades.textoInformativo("Jugador numero ${jugador.getId()}")
                Utilidades.textoVerde("Nick: ${jugador.getNick()}")
                Utilidades.textoVerde("Victorias: ${jugador.getGanadas()}")
                println("")
            }
        } else {
            Utilidades.textoError("No hay jugadores")
        }

    }

    fun getNumJugadores(): Byte = numJugadores

    private fun generarNumeroCorrecto() {
        numeroCorrecto = ((Math.random() * (10 - 1 + 1)).toInt() + 1).toByte()
    }

    fun aniadirJugador() {
        var mayorId: Byte = 0

        if (jugadores.isNotEmpty()) {
            for (jugador in jugadores) {
                if (jugador.getId() >= mayorId) {
                    mayorId = (jugador.getId() + 1).toByte()
                }
            }
        } else {
            mayorId = 1
        }

        Utilidades.limpiarPantalla()
        val nick = Utilidades.pedirString("\u001B[33;1mIntroduzca el nick del jugador $mayorId")
        Utilidades.limpiarPantalla()
        val nombre = Utilidades.pedirString("Introduzca el nombre del jugador")
        Utilidades.limpiarPantalla()
        val apellidos = Utilidades.pedirString("Introduzca los apellidos del jugador\u001B[0m")
        Utilidades.limpiarPantalla()

        jugadores.add(Jugador(mayorId, nick, nombre, apellidos))

        Utilidades.textoVerde("Jugador añadido correctamente!")
        this.numJugadores++
    }

    fun eliminarJugador() {
        var eliminado = false
        getJugadores()
        if (jugadores.isNotEmpty()) {
            val id = Utilidades.pedirByte("Indique el numero del jugador que desea eliminar:")

            Utilidades.limpiarPantalla()
            for (jugador in jugadores) {
                if (jugador.getId() == id) {
                    jugadores.remove(jugador)
                    Utilidades.textoVerde("Jugador eliminado correctamente")
                    eliminado = true
                    this.numJugadores--
                    break
                }
            }

            for (jugador in jugadores) {
                if (jugador.getId() > id && eliminado) {
                    jugador.setId((jugador.getId() - 1).toByte())
                }
            }

            if (!eliminado) {
                Utilidades.textoError("No existe el jugador indicado")
            }
        }


    }

    fun jugar() {
        var hayGanador = false
        Utilidades.textoInformativo("Numero del 1 al 10\n")
        for (jugador in jugadores) {
            Utilidades.textoInformativo("Turno del jugador ${jugador.getId()} (${jugador.getNick()})")
            val opc = Utilidades.pedirByte("Indique el numero:")
            Utilidades.limpiarPantalla()

            if (opc == this.numeroCorrecto) {
                jugador.setAcertado(true)
                hayGanador = true
            }
        }

        Utilidades.textoVerde("---GANADORES---")

        if (hayGanador) {
            for (jugador in jugadores) {
                if (jugador.getAcertado()) {
                    Utilidades.textoVerde(jugador.getNick())
                    jugador.setAcertado(false)
                    jugador.sumarGanadas()
                }
            }
        } else {
            Utilidades.textoError("Nadie ha acertado esta ronda, suerte en la proxima partida")
        }

        generarNumeroCorrecto()

    }

    companion object {
        private const val serialVersionUID: Long = 123
        fun menuInicial(): Byte {
            val sb = StringBuilder("\n\n\u001b[33;1m--------MENU---------")
                .append("\n1. Nueva partida")
                .append("\n2. Cargar partida")
                .append("\n3. Borrar partida")
                .append("\n4. Creditos")
                .append("\n5. Salir\u001b[0m")

            println(sb)

            return Utilidades.pedirByte("Introduzca una opción:")
        }

        fun menuPartida(): Byte {
            val sb = StringBuilder("\n\n\u001b[33;1m------PARTIDA-------")
                .append("\n1. Iniciar juego")
                .append("\n2. Añadir jugador")
                .append("\n3. Mostrar jugadores")
                .append("\n4. Eliminar jugador")
                .append("\n5. Guardar partida")
                .append("\n6. Salir de la partida\u001b[0m")

            println(sb)

            return Utilidades.pedirByte("Introduzca una opción:")
        }
    }
}