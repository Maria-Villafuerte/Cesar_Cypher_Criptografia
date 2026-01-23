/**
 * CifradorCesar.java
 * Clase principal para cifrar y descifrar texto usando el algoritmo César.
 *
 * El cifrado César es un tipo de cifrado por sustitución en el que cada letra
 * del texto es desplazada un número fijo de posiciones en el alfabeto.
 */
public class CifradorCesar {

    /**
     * Cifra un texto usando el cifrado César con un desplazamiento dado
     * @param texto - Texto a cifrar
     * @param desplazamiento - Número de posiciones a desplazar (1-25)
     * @return Texto cifrado
     */
    public static String cifrar(String texto, int desplazamiento) {
        // TODO: Implementar cifrado César
        return null;
    }

    /**
     * Descifra un texto cifrado con César usando el desplazamiento
     * @param textoCifrado - Texto cifrado
     * @param desplazamiento - Desplazamiento usado en el cifrado
     * @return Texto original
     */
    public static String descifrar(String textoCifrado, int desplazamiento) {
        // TODO: Implementar descifrado César
        return null;
    }

    /**
     * Cifra un solo carácter
     * @param caracter - Carácter a cifrar
     * @param desplazamiento - Posiciones a desplazar
     * @return Carácter cifrado
     */
    private static char cifrarCaracter(char caracter, int desplazamiento) {
        // TODO: Implementar cifrado de un solo carácter
        return ' ';
    }

    /**
     * Normaliza el desplazamiento para que esté en rango 0-25
     * @param desplazamiento - Desplazamiento original
     * @return Desplazamiento normalizado
     */
    private static int normalizarDesplazamiento(int desplazamiento) {
        // TODO: Normalizar desplazamiento (manejar negativos y > 25)
        return 0;
    }

    /**
     * Determina si un carácter es una letra mayúscula
     * @param caracter - Carácter a verificar
     * @return true si es mayúscula, false en caso contrario
     */
    private static boolean esMayuscula(char caracter) {
        // TODO: Verificar si es mayúscula (A-Z)
        return false;
    }

    /**
     * Determina si un carácter es una letra minúscula
     * @param caracter - Carácter a verificar
     * @return true si es minúscula, false en caso contrario
     */
    private static boolean esMinuscula(char caracter) {
        // TODO: Verificar si es minúscula (a-z)
        return false;
    }

    /**
     * Cifra preservando mayúsculas, minúsculas y caracteres especiales
     * @param texto - Texto a cifrar
     * @param desplazamiento - Desplazamiento
     * @return Texto cifrado
     */
    public static String cifrarCompleto(String texto, int desplazamiento) {
        // TODO: Cifrar preservando formato original
        return null;
    }

    /**
     * Método main para pruebas
     */
    public static void main(String[] args) {
        // Ejemplos de uso
        System.out.println("=== PRUEBAS DE CIFRADO CÉSAR ===");

        // TODO: Descomentar cuando implementes los métodos
        // String original = "HOLA MUNDO";
        // int clave = 3;
        // String cifrado = cifrar(original, clave);
        // String descifrado = descifrar(cifrado, clave);

        // System.out.println("Original: " + original);
        // System.out.println("Cifrado: " + cifrado);
        // System.out.println("Descifrado: " + descifrado);
    }
}
