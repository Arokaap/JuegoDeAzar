package controlador

import modelo.Juego

fun main() {

    var repetir = true

    do {
        when (Juego.menuInicial()) {
            1.toByte() -> {
                do {
                    when (Juego.menuPartida()) {
                        1.toByte() -> {
                            if (Juego.existirJugadores()) {
                            } else {
                                println("Debes añadir al menos un jugador para iniciar la partida")
                            }
                        }

                        2.toByte() -> {
                            println("Añadimos")
                        }
                    }
                } while (repetir)
            }


            2.toByte() -> println("No existen opciones que configurar")
            3.toByte() -> println("Todos los creditos reservados a:\nAarón Aragón Aroca")
            4.toByte() -> {
                println("Gracias por jugar!")
                repetir = false
            }

            else -> println("Opción no contemplada")

        }
    } while (repetir)
}