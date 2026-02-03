
public class MainBase64ABinario {
    
    public static void main(String[] args) {
        ConvertidorBinario convertidor = new ConvertidorBinario();
        
        String textoBase64 = "SG9sYQ==";
        String resultado = convertidor.base64ABinario(textoBase64);
        
        System.out.println("Entrada: " + textoBase64);
        System.out.println("Salida:  " + resultado);
        System.out.println("Esperado: 010010000110111101101100011000010000");
    }
}
