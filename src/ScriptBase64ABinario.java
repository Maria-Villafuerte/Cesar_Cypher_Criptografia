public class ScriptBase64ABinario {
    
    public static void main(String[] args) {
        ConvertidorBinario convertidor = new ConvertidorBinario();
        ManejadorBase64 manejadorB64 = new ManejadorBase64();
        OperacionesBinarias opBinarias = new OperacionesBinarias();
        
        String textoBase64 = "SG9sYQ==";
        
        System.out.println("=== CONVERSION BASE64 A BINARIO ===");
        System.out.println("Texto Base64: " + textoBase64);
        System.out.println();
        
        System.out.println("Alfabeto Base64:");
        System.out.println(manejadorB64.obtenerAlfabeto());
        System.out.println("(Posiciones 0-63)");
        System.out.println();
        
        String textoSinPadding = manejadorB64.eliminarPadding(textoBase64);
        System.out.println("Sin padding: " + textoSinPadding);
        System.out.println();
        
        System.out.println("Proceso paso a paso:");
        System.out.println("--------------------");
        
        for (int i = 0; i < textoSinPadding.length(); i++) {
            char caracter = textoSinPadding.charAt(i);
            int indice = manejadorB64.caracterAIndice(caracter);
            String binario = opBinarias.decimalABinario(indice, 6);
            
            System.out.println("'" + caracter + "' -> Indice: " + indice + " -> Binario (6 bits): " + binario);
        }
        
        System.out.println();
        System.out.println("Resultado final:");
        String resultado = convertidor.base64ABinario(textoBase64);
        System.out.println(resultado);
        
        System.out.println();
        System.out.println("Con espacios (grupos de 6 bits):");
        StringBuilder conEspacios = new StringBuilder();
        for (int i = 0; i < resultado.length(); i += 6) {
            int fin = Math.min(i + 6, resultado.length());
            conEspacios.append(resultado.substring(i, fin)).append(" ");
        }
        System.out.println(conEspacios.toString().trim());
    }
}
