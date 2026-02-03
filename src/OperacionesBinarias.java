import java.util.ArrayList;

public class OperacionesBinarias {
    
    // Convierte un número decimal a binario con longitud fija
    public String decimalABinario(int decimal, int longitud) {
        if (decimal == 0) {
            return repetirCaracter('0', longitud);
        }
        
        StringBuilder binario = new StringBuilder();
        int numero = decimal;
        
        while (numero > 0) {
            int residuo = numero % 2;
            binario.insert(0, residuo);
            numero = numero / 2;
        }
        
        // Completar con ceros a la izquierda si es necesario
        while (binario.length() < longitud) {
            binario.insert(0, '0');
        }
        
        return binario.toString();
    }
    
    // Convierte una cadena binaria a número decimal
    public int binarioADecimal(String binario) {
        int decimal = 0;
        int potencia = 0;
        
        for (int i = binario.length() - 1; i >= 0; i--) {
            if (binario.charAt(i) == '1') {
                decimal += (int) Math.pow(2, potencia);
            }
            potencia++;
        }
        
        return decimal;
    }
    
    // Verifica si una cadena contiene solo 0s y 1s
    public boolean validarBinario(String cadena) {
        if (cadena == null || cadena.isEmpty()) {
            return false;
        }
        
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (c != '0' && c != '1') {
                return false;
            }
        }
        return true;
    }
    
    // Agrupa bits en grupos del tamaño especificado
    public ArrayList<String> agruparBits(String binario, int tamanoGrupo) {
        ArrayList<String> grupos = new ArrayList<>();
        
        // Completar con ceros si no es múltiplo del tamaño
        String binarioCompleto = binario;
        while (binarioCompleto.length() % tamanoGrupo != 0) {
            binarioCompleto = "0" + binarioCompleto;
        }
        
        for (int i = 0; i < binarioCompleto.length(); i += tamanoGrupo) {
            grupos.add(binarioCompleto.substring(i, i + tamanoGrupo));
        }
        
        return grupos;
    }
    
    // Aplica operación XOR entre dos cadenas binarias
    public String aplicarXor(String binario1, String binario2) {
        // Igualar longitudes agregando ceros a la izquierda
        int maxLongitud = Math.max(binario1.length(), binario2.length());
        binario1 = completarBits(binario1, maxLongitud);
        binario2 = completarBits(binario2, maxLongitud);
        
        StringBuilder resultado = new StringBuilder();
        
        for (int i = 0; i < maxLongitud; i++) {
            char bit1 = binario1.charAt(i);
            char bit2 = binario2.charAt(i);
            
            // XOR: 0^0=0, 0^1=1, 1^0=1, 1^1=0
            if (bit1 == bit2) {
                resultado.append('0');
            } else {
                resultado.append('1');
            }
        }
        
        return resultado.toString();
    }
    
    // Completa una cadena binaria con ceros a la izquierda
    public String completarBits(String binario, int longitud) {
        StringBuilder resultado = new StringBuilder(binario);
        while (resultado.length() < longitud) {
            resultado.insert(0, '0');
        }
        return resultado.toString();
    }
    
    // Método auxiliar para repetir un carácter
    private String repetirCaracter(char c, int veces) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < veces; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}
