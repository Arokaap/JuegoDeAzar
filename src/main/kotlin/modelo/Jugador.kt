package modelo

import java.io.Serializable

class Jugador(id: Byte, nick: String, nombre: String, apellidos: String) : Serializable {
    private val id: Byte
    private var nick: String
    private var ganadas: Byte
    private val nombre: String
    private val apellidos: String

    init {
        this.id = id
        this.nick = nick
        this.ganadas = 0
        this.nombre = nombre
        this.apellidos = apellidos
    }

    fun getNick(): String = nick
    fun setNick(value: String) {
        nick = value
    }

    fun getGanadas(): Byte = ganadas
    fun setGanadas(value: Byte) {
        ganadas = value
    }
}