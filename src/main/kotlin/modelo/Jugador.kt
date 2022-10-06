package modelo

class Jugador(id: Int, nick: String, ganadas: Byte, nombre: String, apellidos: String) {
    private val id: Int
    private var nick: String
    private var ganadas: Byte
    private val nombre: String
    private val apellidos: String

    init {
        this.id = id
        this.nick = nick
        this.ganadas = ganadas
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