public class ScriptBase64AAscii {
    
    public static void main(String[] args) {
        ConvertidorBinario convertidor = new ConvertidorBinario();
        ConvertidorCompleto convertidorCompleto = new ConvertidorCompleto();
        ManejadorBase64 manejadorB64 = new ManejadorBase64();
        OperacionesBinarias opBinarias = new OperacionesBinarias();
        
        String textoBase64 = "SG9sYQ==";
        
        System.out.println("=== CONVERSION BASE64 A ASCII (pasando por binario) ===");
        System.out.println("Texto Base64: " + textoBase64);
        System.out.println();
        
        // FASE 1: Base64 a Binario
        System.out.println("FASE 1: Base64 a Binario");
        System.out.println("------------------------");
        
        String textoSinPadding = manejadorB64.eliminarPadding(textoBase64);
        System.out.println("Sin padding: " + textoSinPadding);
        
        for (int i = 0; i < textoSinPadding.length(); i++) {
            char caracter = textoSinPadding.charAt(i);
            int indice = manejadorB64.caracterAIndice(caracter);
            String binario = opBinarias.decimalABinario(indice, 6);
            System.out.println("'" + caracter + "' -> " + indice + " -> " + binario);
        }
        
        String binarioCompleto = convertidor.base64ABinario(textoBase64);
        System.out.println();
        System.out.println("Binario resultante: " + binarioCompleto);
        
        // FASE 2: Ajuste de bits
        System.out.println();
        System.out.println("FASE 2: Ajuste de bits");
        System.out.println("----------------------");
        
        int padding = 0;
        for (int i = textoBase64.length() - 1; i >= 0; i--) {
            if (textoBase64.charAt(i) == '=') padding++;
            else break;
        }
        
        System.out.println("Caracteres de padding '=': " + padding);
        
        int bitsValidos = (textoSinPadding.length() * 6) - (padding * 2);
        bitsValidos = (bitsValidos / 8) * 8;
        System.out.println("Bits validos (multiplo de 8): " + bitsValidos);
        
        String binarioAjustado = binarioCompleto.substring(0, bitsValidos);
        System.out.println("Binario ajustado: " + binarioAjustado);
        
        // FASE 3: Binario a ASCII
        System.out.println();
        System.out.println("FASE 3: Binario a ASCII");
        System.out.println("-----------------------");
        
        for (int i = 0; i < binarioAjustado.length(); i += 8) {
            String grupo = binarioAjustado.substring(i, i + 8);
            int decimal = opBinarias.binarioADecimal(grupo);
            char caracter = (char) decimal;
            System.out.println(grupo + " -> " + decimal + " -> '" + caracter + "'");
        }
        
        System.out.println();
        System.out.println("Resultado final:");
        String resultado = convertidorCompleto.base64AAscii(textoBase64);
        System.out.println("\"" + resultado + "\"");
    }
}
