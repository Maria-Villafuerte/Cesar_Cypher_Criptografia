public class ManejadorASCII {
    
    // Convierte un carácter a su valor decimal ASCII
    public int caracterADecimal(char caracter) {
        return (int) caracter;
    }
    
    // Convierte un valor decimal a su carácter ASCII
    public char decimalACaracter(int decimal) {
        return (char) decimal;
    }
    
    // Valida que todos los caracteres sean ASCII válidos (0-127)
    public boolean validarAscii(String texto) {
        if (texto == null || texto.isEmpty()) {
            return false;
        }
        
        for (int i = 0; i < texto.length(); i++) {
            int valor = (int) texto.charAt(i);
            if (valor < 0 || valor > 127) {
                return false;
            }
        }
        return true;
    }
}
