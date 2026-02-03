

public class MainBase64AAscii {
    
    public static void main(String[] args) {
        ConvertidorCompleto convertidor = new ConvertidorCompleto();
        
        String textoBase64 = "SG9sYQ==";
        String resultado = convertidor.base64AAscii(textoBase64);
        
        System.out.println("Entrada: " + textoBase64);
        System.out.println("Salida:  " + resultado);
        System.out.println("Esperado: Hola");
    }
}
