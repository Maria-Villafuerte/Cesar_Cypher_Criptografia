import java.util.ArrayList;

public class Utilidades {
    
    // Divide una cadena en partes de longitud fija
    public ArrayList<String> dividirCadena(String cadena, int longitud) {
        ArrayList<String> partes = new ArrayList<>();
        
        for (int i = 0; i < cadena.length(); i += longitud) {
            int fin = Math.min(i + longitud, cadena.length());
            partes.add(cadena.substring(i, fin));
        }
        
        return partes;
    }
    
    // Une una lista de strings en una sola cadena
    public String unirLista(ArrayList<String> lista) {
        StringBuilder resultado = new StringBuilder();
        for (String elemento : lista) {
            resultado.append(elemento);
        }
        return resultado.toString();
    }
    
    // Imprime con formato título y contenido
    public void imprimirFormato(String titulo, String contenido) {
        System.out.println("=== " + titulo + " ===");
        System.out.println(contenido);
        System.out.println();
    }
}
