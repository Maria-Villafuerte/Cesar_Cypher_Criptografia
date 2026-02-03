

public class MainAsciiABinario {
        public static void main(String[] args) {
        ConvertidorBinario convertidor = new ConvertidorBinario(); 
        String texto = "Hola";
        String resultado = convertidor.asciiABinario(texto);
        
        System.out.println("Entrada: " + texto);
        System.out.println("Salida:  " + resultado);
        System.out.println("Esperado: 01001000011011110110110001100001");
    }
}
