public class ConvertidorCompleto {
    
    private ConvertidorBinario convertidor;
    
    public ConvertidorCompleto() {
        convertidor = new ConvertidorBinario();
    }
    
    // Convierte Base64 a ASCII pasando por binario
    public String base64AAscii(String textoBase64) {
        // Paso 1: Base64 a Binario
        String binario = convertidor.base64ABinario(textoBase64);
        
        // Paso 2: Ajustar longitud para que sea múltiplo de 8
        // Eliminar bits de padding sobrantes
        int bitsValidos = calcularBitsValidos(textoBase64);
        if (bitsValidos > 0 && bitsValidos <= binario.length()) {
            binario = binario.substring(0, bitsValidos);
        }
        
        // Paso 3: Binario a ASCII
        String ascii = convertidor.binarioAAscii(binario);
        
        return ascii;
    }
    
    // Convierte ASCII a Base64 pasando por binario
    public String asciiABase64(String textoAscii) {
        // Paso 1: ASCII a Binario
        String binario = convertidor.asciiABinario(textoAscii);
        
        // Paso 2: Binario a Base64
        String base64 = convertidor.binarioABase64(binario);
        
        return base64;
    }
    
    // Calcula cuántos bits válidos hay en una cadena Base64
    private int calcularBitsValidos(String textoBase64) {
        int padding = 0;
        for (int i = textoBase64.length() - 1; i >= 0; i--) {
            if (textoBase64.charAt(i) == '=') {
                padding++;
            } else {
                break;
            }
        }
        
        int caracteresValidos = textoBase64.length() - padding;
        int bitsTotal = caracteresValidos * 6;
        
        // Cada '=' representa 2 bits de padding
        int bitsValidos = bitsTotal - (padding * 2);
        
        // Ajustar para que sea múltiplo de 8
        bitsValidos = (bitsValidos / 8) * 8;
        
        return bitsValidos;
    }
}
