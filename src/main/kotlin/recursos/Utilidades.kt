package recursos

import modelo.Juego
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.lang.Exception

/**
 * Clase mediante la cual reutilizamos codigo
 */
class Utilidades {
    companion object {

        /**
         * Metodo para pedir un String al usuario
         * @param texto mediante este parametro introducimos un texto que se muestra al usuario
         */
        fun pedirString(texto: String): String {
            println(texto)
            return readLine().toString()
        }

        fun pedirByte(texto: String): Byte {
            println(texto)
            var value: Byte? = null

            do {
                try {
                    value = readLine()?.toByte()
                } catch (ex: Exception) {
                    println("La opción introducida es incorrecta, vuelve a probar")
                }
            } while (value == null)

            return value
        }

        fun guardarJuego(juegos: MutableList<Juego>) {
            try {
                val flujoHaciaFichero = ObjectOutputStream(FileOutputStream("partidas.dat"))
                flujoHaciaFichero.writeObject(juegos)
                flujoHaciaFichero.close()
            } catch (ex: FileNotFoundException) {
                println("Archivo no encontrado")
            } catch (ex: IOException) {
                ex.stackTrace
            }
        }

        fun cargarPartida(): MutableList<Juego> {
            var juegos: MutableList<Juego> = arrayListOf()
            try {
                val recuperar = ObjectInputStream(FileInputStream("partidas.dat"))
                juegos = recuperar.readObject() as MutableList<Juego>
            } catch (ex: FileNotFoundException) {
                ex.stackTrace
            } catch (ex: IOException) {
                ex.stackTrace
            } catch (ex: ClassNotFoundException) {
                ex.stackTrace
            }
            return juegos
        }

        fun seleccionarPartida(juegos: MutableList<Juego>) {
            if (juegos.isEmpty()) {
                limpiarPantalla()
                println("\u001B[31m No hay datos guardados. \u001B[0m")
            } else {
                textoVerde("----DATOS----")
                for (juego in juegos) {
                    textoVerde("Partida ${juego.getIdPartida()}")
                }
            }
        }

        fun limpiarPantalla() {
            println("\n\n\n\n\n\n\n\n\n\n\n\n")
        }

        fun textoError(texto: String) {
            println("\u001B[31m${texto}\u001B[0m")
        }

        fun textoVerde(texto: String) {
            println("\u001B[32;1m${texto}\u001B[0m")
        }

        fun textoInformativo(texto: String) {
            println("\u001b[33;1m${texto}\u001b[0m")
        }
    }

}