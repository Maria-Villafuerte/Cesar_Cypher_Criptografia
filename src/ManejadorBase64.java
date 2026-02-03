import java.util.HashMap;

public class ManejadorBase64 {
    
    // Alfabeto Base64 estándar
    private static final String ALFABETO_BASE64 = 
        "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    
    // Retorna un HashMap con cada carácter Base64 y su índice (0-63)
    public HashMap<Character, Integer> obtenerTablaBase64() {
        HashMap<Character, Integer> tabla = new HashMap<>();
        
        for (int i = 0; i < ALFABETO_BASE64.length(); i++) {
            tabla.put(ALFABETO_BASE64.charAt(i), i);
        }
        
        return tabla;
    }
    
    // Convierte un carácter Base64 a su índice (0-63)
    public int caracterAIndice(char caracter) {
        int indice = ALFABETO_BASE64.indexOf(caracter);
        return indice;
    }
    
    // Convierte un índice (0-63) a su carácter Base64
    public char indiceACaracter(int indice) {
        if (indice < 0 || indice > 63) {
            return '?';
        }
        return ALFABETO_BASE64.charAt(indice);
    }
    
    // Valida que una cadena contenga solo caracteres Base64 válidos
    public boolean validarBase64(String texto) {
        if (texto == null || texto.isEmpty()) {
            return false;
        }
        
        String textoSinPadding = eliminarPadding(texto);
        
        for (int i = 0; i < textoSinPadding.length(); i++) {
            char c = textoSinPadding.charAt(i);
            if (ALFABETO_BASE64.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }
    
    // Elimina los caracteres de padding '=' al final
    public String eliminarPadding(String texto) {
        int fin = texto.length();
        while (fin > 0 && texto.charAt(fin - 1) == '=') {
            fin--;
        }
        return texto.substring(0, fin);
    }
    
    // Agrega padding '=' para que la longitud sea múltiplo de 4
    public String agregarPadding(String textoBase64) {
        StringBuilder resultado = new StringBuilder(textoBase64);
        while (resultado.length() % 4 != 0) {
            resultado.append('=');
        }
        return resultado.toString();
    }
    
    // Obtiene el alfabeto Base64
    public String obtenerAlfabeto() {
        return ALFABETO_BASE64;
    }
}
