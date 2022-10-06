package recursos

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
    }

}