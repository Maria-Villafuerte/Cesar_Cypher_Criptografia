
public class MainXorBinario {
    
    public static void main(String[] args) {
        OperacionesBinarias opBinarias = new OperacionesBinarias();
        
        String binario1 = "01001000";
        String binario2 = "00110011";
        String resultado = opBinarias.aplicarXor(binario1, binario2);
        
        System.out.println("Entrada 1: " + binario1);
        System.out.println("Entrada 2: " + binario2);
        System.out.println("Salida:    " + resultado);
        System.out.println("Esperado:  01111011");
    }
}
