package controlador

import modelo.Juego
import recursos.Utilidades
import java.io.File
import java.io.FileOutputStream
import java.io.ObjectOutputStream

fun main() {
    var juegos: MutableList<Juego> = arrayListOf()
    var repetir = true

    juegos = Utilidades.cargarPartida()

    do {
        when (Juego.menuInicial()) {
            1.toByte() -> {
                var juegoActual: Juego

                if (juegos.isEmpty()) {
                    juegoActual = Juego(1, ((Math.random()) * 10).toInt().toByte())
                } else {
                    juegoActual =
                        Juego(((juegos.last().getIdPartida()) + 1).toByte(), ((Math.random()) * 10).toInt().toByte())
                }

                do {
                    when (Juego.menuPartida()) {
                        1.toByte() -> {
                            if (juegoActual.getNumJugadores() != 0.toByte()) {
                                println("existe jugadores")
                            } else {
                                println("Debes añadir al menos un jugador para iniciar la partida")
                            }
                        }

                        2.toByte() -> {
                            juegoActual.aniadirJugador()
                        }

                        3.toByte() -> {

                        }

                        4.toByte() -> println("Eliminamos")
                        5.toByte() -> {
                            if (juegos.contains(juegoActual)) {
                                println("Contiene")
                                juegos.remove(juegos[(juegoActual.getIdPartida()).toInt() - 1])
                            }
                            juegos.add(juegoActual)

                            Utilidades.guardarJuego(juegos)
                            println("Guardado exitoso!")
                        }

                        6.toByte() -> repetir = false
                    }
                } while (repetir)

                repetir = true
            }

            2.toByte() -> {
                Utilidades.seleccionarPartida(juegos)
            }

            3.toByte() -> {
                Utilidades.seleccionarPartida(juegos)
                try {
                    if (!juegos.isEmpty()) {
                        var opcion = Utilidades.pedirByte("\nIntroduce la partida que deseas eliminar:")
                        var borrado = false
                        for (juego in juegos) {
                            if (juego.getIdPartida() == opcion) {
                                juegos.remove(juego)
                                Utilidades.guardarJuego(juegos)
                                println("La partida ha sido eliminada correctamente")
                                borrado = true
                                break
                            }
                        }
                        if (!borrado) {
                            println("No existe la partida seleccionada")
                        }


                    }
                } catch (ex: Exception) {
                    println("Error inesperado al borrar la partida")
                }
            }

            4.toByte() -> println("Todos los creditos reservados a:\nAarón Aragón Aroca")
            5.toByte() -> {
                println("Gracias por jugar!")
                repetir = false
            }

            8.toByte() -> {
                for (juego in juegos) {
                    println(juego)
                }
            }

            else -> println("Opción no contemplada")

        }
    } while (repetir)
}

