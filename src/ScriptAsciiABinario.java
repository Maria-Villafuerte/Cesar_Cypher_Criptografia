public class ScriptAsciiABinario {
    
    public static void main(String[] args) {
        ConvertidorBinario convertidor = new ConvertidorBinario();
        ManejadorASCII manejadorAscii = new ManejadorASCII();
        OperacionesBinarias opBinarias = new OperacionesBinarias();
        
        String texto = "Hola";
        
        System.out.println("=== CONVERSION ASCII A BINARIO ===");
        System.out.println("Texto original: " + texto);
        System.out.println();
        
        System.out.println("Proceso paso a paso:");
        System.out.println("--------------------");
        
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            int decimal = manejadorAscii.caracterADecimal(caracter);
            String binario = opBinarias.decimalABinario(decimal, 8);
            
            System.out.println("'" + caracter + "' -> ASCII: " + decimal + " -> Binario: " + binario);
        }
        
        System.out.println();
        System.out.println("Resultado final:");
        String resultado = convertidor.asciiABinario(texto);
        System.out.println(resultado);
        
        System.out.println();
        System.out.println("Con espacios (para mejor lectura):");
        StringBuilder conEspacios = new StringBuilder();
        for (int i = 0; i < resultado.length(); i += 8) {
            conEspacios.append(resultado.substring(i, i + 8)).append(" ");
        }
        System.out.println(conEspacios.toString().trim());
    }
}
