public class ScriptXorBinario {
    
    public static void main(String[] args) {
        OperacionesBinarias opBinarias = new OperacionesBinarias();
        ConvertidorBinario convertidor = new ConvertidorBinario();
        
        String binario1 = "01001000";
        String binario2 = "00110011";
        
        System.out.println("=== OPERACION XOR BINARIO ===");
        System.out.println();
        
        System.out.println("Operandos:");
        System.out.println("Binario 1: " + binario1 + " (Decimal: " + opBinarias.binarioADecimal(binario1) + ")");
        System.out.println("Binario 2: " + binario2 + " (Decimal: " + opBinarias.binarioADecimal(binario2) + ")");
        System.out.println();
        
        System.out.println("Tabla de verdad XOR:");
        System.out.println("0 XOR 0 = 0");
        System.out.println("0 XOR 1 = 1");
        System.out.println("1 XOR 0 = 1");
        System.out.println("1 XOR 1 = 0");
        System.out.println();
        
        System.out.println("Proceso bit a bit:");
        System.out.println("------------------");
        
        for (int i = 0; i < binario1.length(); i++) {
            char bit1 = binario1.charAt(i);
            char bit2 = binario2.charAt(i);
            char resultado = (bit1 == bit2) ? '0' : '1';
            System.out.println(bit1 + " XOR " + bit2 + " = " + resultado);
        }
        
        String resultadoXor = opBinarias.aplicarXor(binario1, binario2);
        
        System.out.println();
        System.out.println("Resultado:");
        System.out.println("----------");
        System.out.println(binario1);
        System.out.println(binario2 + " XOR");
        System.out.println("--------");
        System.out.println(resultadoXor + " (Decimal: " + opBinarias.binarioADecimal(resultadoXor) + ")");
        
        // Ejemplo con texto
        System.out.println();
        System.out.println("=== EJEMPLO: CIFRADO XOR DE TEXTO ===");
        System.out.println();
        
        String textoOriginal = "Hola";
        String clave = "clave";
        
        System.out.println("Texto original: " + textoOriginal);
        System.out.println("Clave: " + clave);
        System.out.println();
        
        String binarioTexto = convertidor.asciiABinario(textoOriginal);
        String binarioClave = convertidor.asciiABinario(clave);
        
        // Ajustar longitudes
        while (binarioClave.length() < binarioTexto.length()) {
            binarioClave = binarioClave + convertidor.asciiABinario(clave);
        }
        binarioClave = binarioClave.substring(0, binarioTexto.length());
        
        System.out.println("Texto en binario:  " + binarioTexto);
        System.out.println("Clave en binario:  " + binarioClave);
        
        String cifrado = opBinarias.aplicarXor(binarioTexto, binarioClave);
        System.out.println("Resultado XOR:     " + cifrado);
        
        String textoCifrado = convertidor.binarioAAscii(cifrado);
        System.out.println();
        System.out.println("Texto cifrado: " + textoCifrado);
        
        // Descifrar (aplicar XOR otra vez)
        String descifrado = opBinarias.aplicarXor(cifrado, binarioClave);
        String textoDescifrado = convertidor.binarioAAscii(descifrado);
        System.out.println("Texto descifrado: " + textoDescifrado);
    }
}
