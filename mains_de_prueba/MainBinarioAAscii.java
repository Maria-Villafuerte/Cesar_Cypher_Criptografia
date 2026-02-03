public class MainBinarioAAscii {
    
    public static void main(String[] args) {
        ConvertidorBinario convertidor = new ConvertidorBinario();
        
        String binario = "01001000011011110110110001100001";
        String resultado = convertidor.binarioAAscii(binario);
        
        System.out.println("Entrada: " + binario);
        System.out.println("Salida:  " + resultado);
        System.out.println("Esperado: Hola");
    }
}
