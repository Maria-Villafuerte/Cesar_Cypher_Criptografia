public class ConvertidorBinario {
    
    private OperacionesBinarias opBinarias;
    private ManejadorASCII manejadorAscii;
    private ManejadorBase64 manejadorB64;
    
    public ConvertidorBinario() {
        opBinarias = new OperacionesBinarias();
        manejadorAscii = new ManejadorASCII();
        manejadorB64 = new ManejadorBase64();
    }
    
    // Convierte texto ASCII a binario (8 bits por carácter)
    public String asciiABinario(String texto) {
        StringBuilder resultado = new StringBuilder();
        
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            int valorDecimal = manejadorAscii.caracterADecimal(caracter);
            String binario = opBinarias.decimalABinario(valorDecimal, 8);
            resultado.append(binario);
        }
        
        return resultado.toString();
    }
    
    // Convierte binario a texto ASCII (grupos de 8 bits)
    public String binarioAAscii(String binario) {
        // Asegurar que la longitud sea múltiplo de 8
        String binarioCompleto = binario;
        while (binarioCompleto.length() % 8 != 0) {
            binarioCompleto = "0" + binarioCompleto;
        }
        
        StringBuilder resultado = new StringBuilder();
        
        for (int i = 0; i < binarioCompleto.length(); i += 8) {
            String grupo = binarioCompleto.substring(i, i + 8);
            int valorDecimal = opBinarias.binarioADecimal(grupo);
            char caracter = manejadorAscii.decimalACaracter(valorDecimal);
            resultado.append(caracter);
        }
        
        return resultado.toString();
    }
    
    // Convierte texto Base64 a binario (6 bits por carácter)
    public String base64ABinario(String textoBase64) {
        String textoLimpio = manejadorB64.eliminarPadding(textoBase64);
        StringBuilder resultado = new StringBuilder();
        
        for (int i = 0; i < textoLimpio.length(); i++) {
            char caracter = textoLimpio.charAt(i);
            int indice = manejadorB64.caracterAIndice(caracter);
            String binario = opBinarias.decimalABinario(indice, 6);
            resultado.append(binario);
        }
        
        return resultado.toString();
    }
    
    // Convierte binario a texto Base64 (grupos de 6 bits)
    public String binarioABase64(String binario) {
        // Completar para que sea múltiplo de 6
        String binarioCompleto = binario;
        while (binarioCompleto.length() % 6 != 0) {
            binarioCompleto = binarioCompleto + "0";
        }
        
        StringBuilder resultado = new StringBuilder();
        
        for (int i = 0; i < binarioCompleto.length(); i += 6) {
            String grupo = binarioCompleto.substring(i, i + 6);
            int valorDecimal = opBinarias.binarioADecimal(grupo);
            char caracter = manejadorB64.indiceACaracter(valorDecimal);
            resultado.append(caracter);
        }
        
        // Agregar padding si es necesario
        return manejadorB64.agregarPadding(resultado.toString());
    }
}
