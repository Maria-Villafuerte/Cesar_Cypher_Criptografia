public class Validador {
    
    private OperacionesBinarias opBinarias;
    private ManejadorBase64 manejadorB64;
    private ManejadorASCII manejadorAscii;
    
    public Validador() {
        opBinarias = new OperacionesBinarias();
        manejadorB64 = new ManejadorBase64();
        manejadorAscii = new ManejadorASCII();
    }
    
    // Valida entrada según el tipo especificado
    public boolean validarEntrada(String texto, String tipo) {
        if (texto == null || texto.isEmpty()) {
            return false;
        }
        
        switch (tipo.toLowerCase()) {
            case "binario":
                return opBinarias.validarBinario(texto);
            case "base64":
                return manejadorB64.validarBase64(texto);
            case "ascii":
                return manejadorAscii.validarAscii(texto);
            default:
                return false;
        }
    }
    
    // Limpia una cadena binaria (elimina espacios)
    public String sanitizarBinario(String binario) {
        return binario.replaceAll("\\s+", "");
    }
    
    // Limpia una cadena Base64 (elimina espacios y saltos de línea)
    public String sanitizarBase64(String texto) {
        return texto.replaceAll("\\s+", "");
    }
}
