package controlador

import modelo.Juego
import recursos.Utilidades

fun main() {
    val juegos: MutableList<Juego> = Utilidades.cargarPartida()
    var repetir = true

    do {
        when (Juego.menuInicial()) {
            1.toByte() -> {
                Utilidades.limpiarPantalla()
                var juegoActual: Juego

                if (juegos.isEmpty()) {
                    juegoActual = Juego(1, ((Math.random() * (10 - 1 + 1)).toInt() + 1).toByte())
                } else {
                    juegoActual =
                        Juego(
                            ((juegos.last().getIdPartida()) + 1).toByte(),
                            ((Math.random() * (10 - 1 + 1)).toInt() + 1).toByte()
                        )
                }

                do {
                    when (Juego.menuPartida()) {
                        1.toByte() -> {
                            if (juegoActual.getNumJugadores() != 0.toByte()) {
                                Utilidades.limpiarPantalla()
                                juegoActual.jugar()
                            } else {
                                Utilidades.limpiarPantalla()
                                Utilidades.textoError("No existen jugadores para comenzar la partida")
                            }
                        }

                        2.toByte() -> {
                            juegoActual.aniadirJugador()
                        }

                        3.toByte() -> {
                            juegoActual.getJugadores()

                        }

                        4.toByte() -> juegoActual.eliminarJugador()
                        5.toByte() -> {
                            if (juegos.contains(juegoActual)) {
                                juegos.remove(juegos[(juegoActual.getIdPartida()).toInt() - 1])
                            }
                            juegos.add(juegoActual)

                            Utilidades.guardarJuego(juegos)
                            Utilidades.limpiarPantalla()
                            Utilidades.textoVerde("Guardado exitoso!")
                        }

                        6.toByte() -> {
                            Utilidades.limpiarPantalla()
                            repetir = false
                        }

                        else -> {
                            Utilidades.limpiarPantalla()
                            Utilidades.textoError("Opción incorrecta")
                        }
                    }
                } while (repetir)

                repetir = true
            }

            2.toByte() -> {
                Utilidades.limpiarPantalla()
                var existe = false
                Utilidades.seleccionarPartida(juegos)
                if (juegos.isNotEmpty()) {
                    val opc = Utilidades.pedirByte("\nSelecciona el numero de una partida:  ")
                    Utilidades.limpiarPantalla()

                    for (juego in juegos) {
                        if (juego.getIdPartida() == opc) {
                            existe = true
                            do {
                                when (Juego.menuPartida()) {
                                    1.toByte() -> {
                                        if (juego.getNumJugadores() != 0.toByte()) {
                                            Utilidades.limpiarPantalla()
                                            juego.jugar()
                                        } else {
                                            Utilidades.limpiarPantalla()
                                            Utilidades.textoError("No existen jugadores para comenzar la partida")
                                        }
                                    }

                                    2.toByte() -> {
                                        juego.aniadirJugador()
                                    }

                                    3.toByte() -> {
                                        juego.getJugadores()
                                    }

                                    4.toByte() -> juego.eliminarJugador()
                                    5.toByte() -> {
                                        if (juegos.contains(juego)) {
                                            juegos.remove(juegos[(juego.getIdPartida()).toInt() - 1])
                                        }
                                        juegos.add(juego)

                                        Utilidades.guardarJuego(juegos)
                                        Utilidades.limpiarPantalla()
                                        Utilidades.textoVerde("Guardado exitoso!")
                                    }

                                    6.toByte() -> {
                                        Utilidades.limpiarPantalla()
                                        repetir = false
                                    }

                                    else -> {
                                        Utilidades.limpiarPantalla()
                                        Utilidades.textoError("Opción incorrecta")
                                    }
                                }
                            } while (repetir)

                            repetir = true
                        }
                    }
                    if (!existe) {
                        Utilidades.textoError("La partida seleccionada no existe")
                    }
                }
            }

            3.toByte() -> {
                Utilidades.limpiarPantalla()
                Utilidades.seleccionarPartida(juegos)
                try {
                    if (juegos.isNotEmpty()) {
                        val opcion = Utilidades.pedirByte("\nIntroduce el numero de la partida que deseas eliminar:")
                        Utilidades.limpiarPantalla()
                        var borrado = false
                        for (juego in juegos) {
                            if (juego.getIdPartida() == opcion) {
                                juegos.remove(juego)
                                Utilidades.textoVerde("La partida ha sido eliminada correctamente")
                                borrado = true
                                break
                            }
                        }

                        for (juego in juegos) {
                            if (juego.getIdPartida() > opcion && borrado) {
                                juego.setIdPartida((juego.getIdPartida() - 1).toByte())
                            }
                        }

                        if (!borrado) {
                            Utilidades.textoError("La partida seleccionada no existe")
                        } else {
                            Utilidades.guardarJuego(juegos)
                        }


                    }
                } catch (ex: Exception) {
                    Utilidades.textoError("Error inesperado al borrar la partida")
                }
            }

            4.toByte() -> {
                Utilidades.limpiarPantalla()
                println("Todos los creditos reservados a:")
                Utilidades.textoVerde("Aarón Aragón Aroca")
            }

            5.toByte() -> {
                Utilidades.limpiarPantalla()
                Utilidades.textoVerde("Gracias por jugar!")
                repetir = false
            }

            else -> {
                Utilidades.limpiarPantalla()
                Utilidades.textoError("Opción incorrecta")
            }

        }
    } while (repetir)
}

