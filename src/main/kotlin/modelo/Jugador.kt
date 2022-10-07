package modelo

import java.io.Serializable

class Jugador(id: Byte, nick: String, nombre: String, apellidos: String) : Serializable {
    private var id: Byte
    private var nick: String
    private var ganadas: Byte
    private val nombre: String
    private val apellidos: String
    private var acertado: Boolean = false

    init {
        this.id = id
        this.nick = nick
        this.ganadas = 0
        this.nombre = nombre
        this.apellidos = apellidos
    }

    fun getNick(): String = nick

    fun getId(): Byte = id
    fun setId(value: Byte) {
        id = value
    }

    fun getGanadas(): Byte = ganadas
    fun sumarGanadas() {
        ++ganadas
    }

    fun getAcertado(): Boolean = acertado
    fun setAcertado(value: Boolean) {
        acertado = value
    }

}