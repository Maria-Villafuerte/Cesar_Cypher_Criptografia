public class ScriptBinarioAAscii {
    
    public static void main(String[] args) {
        ConvertidorBinario convertidor = new ConvertidorBinario();
        ManejadorASCII manejadorAscii = new ManejadorASCII();
        OperacionesBinarias opBinarias = new OperacionesBinarias();
        
        String binario = "01001000011011110110110001100001";
        
        System.out.println("=== CONVERSION BINARIO A ASCII ===");
        System.out.println("Binario original: " + binario);
        System.out.println("Longitud: " + binario.length() + " bits");
        System.out.println();
        
        System.out.println("Proceso paso a paso:");
        System.out.println("--------------------");
        
        for (int i = 0; i < binario.length(); i += 8) {
            String grupo = binario.substring(i, i + 8);
            int decimal = opBinarias.binarioADecimal(grupo);
            char caracter = manejadorAscii.decimalACaracter(decimal);
            
            System.out.println(grupo + " -> Decimal: " + decimal + " -> ASCII: '" + caracter + "'");
        }
        
        System.out.println();
        System.out.println("Resultado final:");
        String resultado = convertidor.binarioAAscii(binario);
        System.out.println("\"" + resultado + "\"");
    }
}
