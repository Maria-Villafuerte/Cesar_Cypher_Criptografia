public class ScriptBinarioABase64 {
    
    public static void main(String[] args) {
        ConvertidorBinario convertidor = new ConvertidorBinario();
        ManejadorBase64 manejadorB64 = new ManejadorBase64();
        OperacionesBinarias opBinarias = new OperacionesBinarias();
        
        String binario = "01001000011011110110110001100001";
        
        System.out.println("=== CONVERSION BINARIO A BASE64 ===");
        System.out.println("Binario original: " + binario);
        System.out.println("Longitud: " + binario.length() + " bits");
        System.out.println();
        
        // Completar para que sea múltiplo de 6
        String binarioCompleto = binario;
        while (binarioCompleto.length() % 6 != 0) {
            binarioCompleto = binarioCompleto + "0";
        }
        
        System.out.println("Binario completado (multiplo de 6): " + binarioCompleto);
        System.out.println("Longitud: " + binarioCompleto.length() + " bits");
        System.out.println();
        
        System.out.println("Proceso paso a paso:");
        System.out.println("--------------------");
        
        for (int i = 0; i < binarioCompleto.length(); i += 6) {
            String grupo = binarioCompleto.substring(i, i + 6);
            int decimal = opBinarias.binarioADecimal(grupo);
            char caracter = manejadorB64.indiceACaracter(decimal);
            
            System.out.println(grupo + " -> Decimal: " + decimal + " -> Base64: '" + caracter + "'");
        }
        
        System.out.println();
        System.out.println("Resultado final:");
        String resultado = convertidor.binarioABase64(binario);
        System.out.println(resultado);
    }
}
