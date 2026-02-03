import java.util.Scanner;

/**
 * MainPrincipal.java
 * Programa principal que integra todas las funcionalidades de conversión y cifrado
 * 
 * Funcionalidades disponibles:
 * - Conversiones ASCII <-> Binario
 * - Conversiones Base64 <-> Binario
 * - Conversiones Base64 <-> ASCII
 * - Operaciones XOR
 */
public class MainPrincipal {
    
    private static Scanner scanner;
    private static ConvertidorBinario convertidorBin;
    private static ConvertidorCompleto convertidorCompleto;
    private static OperacionesBinarias opBinarias;
    private static ManejadorASCII manejadorAscii;
    private static ManejadorBase64 manejadorB64;
    private static Validador validador;
    
    public static void main(String[] args) {
        inicializarComponentes();
        
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║     SISTEMA DE CONVERSIÓN Y CRIPTOGRAFÍA                   ║");
        System.out.println("║     Laboratorio: Cesar_Cypher_Criptografia                 ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        boolean continuar = true;
        
        while (continuar) {
            mostrarMenuPrincipal();
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1:
                    menuConversionesBasicas();
                    break;
                case 2:
                    menuConversionesCompuestas();
                    break;
                case 3:
                    menuOperacionesXOR();
                    break;
                case 4:
                    menuDemostraciones();
                    break;
                case 5:
                    menuValidaciones();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("\n¡Gracias por usar el sistema! Hasta pronto.\n");
                    break;
                default:
                    System.out.println("\nOpción no válida. Intente nuevamente.\n");
            }
        }
        
        scanner.close();
    }
    
    private static void inicializarComponentes() {
        scanner = new Scanner(System.in);
        convertidorBin = new ConvertidorBinario();
        convertidorCompleto = new ConvertidorCompleto();
        opBinarias = new OperacionesBinarias();
        manejadorAscii = new ManejadorASCII();
        manejadorB64 = new ManejadorBase64();
        validador = new Validador();
    }
    
    private static void mostrarMenuPrincipal() {
        System.out.println("┌────────────────────────────────────────────────────────────┐");
        System.out.println("│                     MENÚ PRINCIPAL                         │");
        System.out.println("├────────────────────────────────────────────────────────────┤");
        System.out.println("│  1. Conversiones Básicas (ASCII/Binario/Base64)            │");
        System.out.println("│  2. Conversiones Compuestas (Base64 <-> ASCII)             │");
        System.out.println("│  3. Operaciones XOR                                        │");
        System.out.println("│  4. Demostraciones Interactivas                            │");
        System.out.println("│  5. Validaciones                                           │");
        System.out.println("│  0. Salir                                                  │");
        System.out.println("└────────────────────────────────────────────────────────────┘");
        System.out.print("Seleccione una opción: ");
    }
    
    // ==================== MENÚ 1: CONVERSIONES BÁSICAS ====================
    private static void menuConversionesBasicas() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║              CONVERSIONES BÁSICAS                          ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println("1. ASCII a Binario");
        System.out.println("2. Binario a ASCII");
        System.out.println("3. Base64 a Binario");
        System.out.println("4. Binario a Base64");
        System.out.println("0. Volver al menú principal");
        System.out.print("\nSeleccione una opción: ");
        
        int opcion = leerOpcion();
        System.out.println();
        
        switch (opcion) {
            case 1:
                asciiABinario();
                break;
            case 2:
                binarioAAscii();
                break;
            case 3:
                base64ABinario();
                break;
            case 4:
                binarioABase64();
                break;
            case 0:
                return;
            default:
                System.out.println("Opción no válida.");
        }
        
        pausar();
    }
    
    private static void asciiABinario() {
        System.out.println("=== ASCII a Binario ===");
        System.out.print("Ingrese el texto: ");
        scanner.nextLine(); // Limpiar buffer
        String texto = scanner.nextLine();
        
        if (!validador.validarEntrada(texto, "ascii")) {
            System.out.println("Error: El texto contiene caracteres no ASCII válidos.");
            return;
        }
        
        String resultado = convertidorBin.asciiABinario(texto);
        
        System.out.println("\n✓ Conversión exitosa:");
        System.out.println("Entrada:  " + texto);
        System.out.println("Salida:   " + resultado);
        System.out.println("Longitud: " + resultado.length() + " bits");
        
        // Mostrar desglose
        System.out.println("\nDesglose por carácter:");
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            int ascii = manejadorAscii.caracterADecimal(c);
            String bin = opBinarias.decimalABinario(ascii, 8);
            System.out.printf("  '%c' → ASCII: %3d → Binario: %s%n", c, ascii, bin);
        }
    }
    
    private static void binarioAAscii() {
        System.out.println("=== Binario a ASCII ===");
        System.out.print("Ingrese la cadena binaria: ");
        scanner.nextLine(); // Limpiar buffer
        String binario = validador.sanitizarBinario(scanner.nextLine());
        
        if (!validador.validarEntrada(binario, "binario")) {
            System.out.println("Error: La cadena debe contener solo 0s y 1s.");
            return;
        }
        
        String resultado = convertidorBin.binarioAAscii(binario);
        
        System.out.println("\n✓ Conversión exitosa:");
        System.out.println("Entrada:  " + binario);
        System.out.println("Salida:   " + resultado);
        
        // Mostrar desglose
        System.out.println("\nDesglose por byte:");
        String binarioCompleto = binario;
        while (binarioCompleto.length() % 8 != 0) {
            binarioCompleto = "0" + binarioCompleto;
        }
        for (int i = 0; i < binarioCompleto.length(); i += 8) {
            String grupo = binarioCompleto.substring(i, i + 8);
            int decimal = opBinarias.binarioADecimal(grupo);
            char caracter = manejadorAscii.decimalACaracter(decimal);
            System.out.printf("  %s → Decimal: %3d → ASCII: '%c'%n", grupo, decimal, caracter);
        }
    }
    
    private static void base64ABinario() {
        System.out.println("=== Base64 a Binario ===");
        System.out.print("Ingrese la cadena Base64: ");
        scanner.nextLine(); // Limpiar buffer
        String base64 = validador.sanitizarBase64(scanner.nextLine());
        
        if (!validador.validarEntrada(base64, "base64")) {
            System.out.println("Error: La cadena contiene caracteres no válidos para Base64.");
            return;
        }
        
        String resultado = convertidorBin.base64ABinario(base64);
        
        System.out.println("\n✓ Conversión exitosa:");
        System.out.println("Entrada:  " + base64);
        System.out.println("Salida:   " + resultado);
        System.out.println("Longitud: " + resultado.length() + " bits");
        
        // Mostrar desglose
        System.out.println("\nDesglose por carácter Base64 (6 bits cada uno):");
        String textoSinPadding = manejadorB64.eliminarPadding(base64);
        for (int i = 0; i < textoSinPadding.length(); i++) {
            char c = textoSinPadding.charAt(i);
            int indice = manejadorB64.caracterAIndice(c);
            String bin = opBinarias.decimalABinario(indice, 6);
            System.out.printf("  '%c' → Índice: %2d → Binario: %s%n", c, indice, bin);
        }
    }
    
    private static void binarioABase64() {
        System.out.println("=== Binario a Base64 ===");
        System.out.print("Ingrese la cadena binaria: ");
        scanner.nextLine(); // Limpiar buffer
        String binario = validador.sanitizarBinario(scanner.nextLine());
        
        if (!validador.validarEntrada(binario, "binario")) {
            System.out.println("Error: La cadena debe contener solo 0s y 1s.");
            return;
        }
        
        String resultado = convertidorBin.binarioABase64(binario);
        
        System.out.println("\n✓ Conversión exitosa:");
        System.out.println("Entrada:  " + binario);
        System.out.println("Salida:   " + resultado);
        
        // Mostrar desglose
        System.out.println("\nDesglose por grupo de 6 bits:");
        String binarioCompleto = binario;
        while (binarioCompleto.length() % 6 != 0) {
            binarioCompleto = binarioCompleto + "0";
        }
        for (int i = 0; i < binarioCompleto.length(); i += 6) {
            String grupo = binarioCompleto.substring(i, i + 6);
            int decimal = opBinarias.binarioADecimal(grupo);
            char caracter = manejadorB64.indiceACaracter(decimal);
            System.out.printf("  %s → Decimal: %2d → Base64: '%c'%n", grupo, decimal, caracter);
        }
    }
    
    // ==================== MENÚ 2: CONVERSIONES COMPUESTAS ====================
    private static void menuConversionesCompuestas() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║           CONVERSIONES COMPUESTAS                          ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println("1. Base64 a ASCII");
        System.out.println("2. ASCII a Base64");
        System.out.println("0. Volver al menú principal");
        System.out.print("\nSeleccione una opción: ");
        
        int opcion = leerOpcion();
        System.out.println();
        
        switch (opcion) {
            case 1:
                base64AAscii();
                break;
            case 2:
                asciiABase64();
                break;
            case 0:
                return;
            default:
                System.out.println("Opción no válida.");
        }
        
        pausar();
    }
    
    private static void base64AAscii() {
        System.out.println("=== Base64 a ASCII ===");
        System.out.print("Ingrese la cadena Base64: ");
        scanner.nextLine(); // Limpiar buffer
        String base64 = validador.sanitizarBase64(scanner.nextLine());
        
        if (!validador.validarEntrada(base64, "base64")) {
            System.out.println("Error: La cadena contiene caracteres no válidos para Base64.");
            return;
        }
        
        System.out.println("\nProceso de conversión:");
        System.out.println("1. Base64 → Binario");
        String binario = convertidorBin.base64ABinario(base64);
        System.out.println("   Binario intermedio: " + binario);
        
        System.out.println("2. Ajuste de bits (múltiplo de 8)");
        String resultado = convertidorCompleto.base64AAscii(base64);
        
        System.out.println("3. Binario → ASCII");
        System.out.println("\n✓ Conversión exitosa:");
        System.out.println("Entrada:  " + base64);
        System.out.println("Salida:   " + resultado);
    }
    
    private static void asciiABase64() {
        System.out.println("=== ASCII a Base64 ===");
        System.out.print("Ingrese el texto: ");
        scanner.nextLine(); // Limpiar buffer
        String texto = scanner.nextLine();
        
        if (!validador.validarEntrada(texto, "ascii")) {
            System.out.println("Error: El texto contiene caracteres no ASCII válidos.");
            return;
        }
        
        System.out.println("\nProceso de conversión:");
        System.out.println("1. ASCII → Binario");
        String binario = convertidorBin.asciiABinario(texto);
        System.out.println("   Binario intermedio: " + binario);
        
        System.out.println("2. Binario → Base64");
        String resultado = convertidorCompleto.asciiABase64(texto);
        
        System.out.println("\n✓ Conversión exitosa:");
        System.out.println("Entrada:  " + texto);
        System.out.println("Salida:   " + resultado);
    }
    
    // ==================== MENÚ 3: OPERACIONES XOR ====================
    private static void menuOperacionesXOR() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║              OPERACIONES XOR                               ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println("1. XOR entre dos cadenas binarias");
        System.out.println("2. Cifrado XOR de texto");
        System.out.println("3. Descifrado XOR de texto");
        System.out.println("0. Volver al menú principal");
        System.out.print("\nSeleccione una opción: ");
        
        int opcion = leerOpcion();
        System.out.println();
        
        switch (opcion) {
            case 1:
                xorBinario();
                break;
            case 2:
                cifradoXOR();
                break;
            case 3:
                descifradoXOR();
                break;
            case 0:
                return;
            default:
                System.out.println("Opción no válida.");
        }
        
        pausar();
    }
    
    private static void xorBinario() {
        System.out.println("=== XOR entre cadenas binarias ===");
        scanner.nextLine(); // Limpiar buffer
        
        System.out.print("Ingrese la primera cadena binaria: ");
        String bin1 = validador.sanitizarBinario(scanner.nextLine());
        
        System.out.print("Ingrese la segunda cadena binaria: ");
        String bin2 = validador.sanitizarBinario(scanner.nextLine());
        
        if (!validador.validarEntrada(bin1, "binario") || !validador.validarEntrada(bin2, "binario")) {
            System.out.println("Error: Las cadenas deben contener solo 0s y 1s.");
            return;
        }
        
        String resultado = opBinarias.aplicarXor(bin1, bin2);
        
        System.out.println("\n✓ Operación XOR exitosa:");
        System.out.println("Binario 1: " + bin1);
        System.out.println("Binario 2: " + bin2);
        System.out.println("Resultado: " + resultado);
        
        System.out.println("\nDesglose bit a bit:");
        int maxLen = Math.max(bin1.length(), bin2.length());
        bin1 = opBinarias.completarBits(bin1, maxLen);
        bin2 = opBinarias.completarBits(bin2, maxLen);
        
        for (int i = 0; i < maxLen; i++) {
            char b1 = bin1.charAt(i);
            char b2 = bin2.charAt(i);
            char res = resultado.charAt(i);
            System.out.printf("  %c XOR %c = %c%n", b1, b2, res);
        }
    }
    
    private static void cifradoXOR() {
        System.out.println("=== Cifrado XOR de texto ===");
        scanner.nextLine(); // Limpiar buffer
        
        System.out.print("Ingrese el texto a cifrar: ");
        String texto = scanner.nextLine();
        
        System.out.print("Ingrese la clave: ");
        String clave = scanner.nextLine();
        
        if (!validador.validarEntrada(texto, "ascii") || !validador.validarEntrada(clave, "ascii")) {
            System.out.println("Error: El texto y la clave deben contener solo caracteres ASCII válidos.");
            return;
        }
        
        // Convertir a binario
        String binTexto = convertidorBin.asciiABinario(texto);
        String binClave = convertidorBin.asciiABinario(clave);
        
        // Repetir la clave para que tenga la misma longitud
        while (binClave.length() < binTexto.length()) {
            binClave += convertidorBin.asciiABinario(clave);
        }
        binClave = binClave.substring(0, binTexto.length());
        
        // Aplicar XOR
        String binCifrado = opBinarias.aplicarXor(binTexto, binClave);
        String textoCifrado = convertidorBin.binarioAAscii(binCifrado);
        
        System.out.println("\n✓ Cifrado exitoso:");
        System.out.println("Texto original: " + texto);
        System.out.println("Clave:          " + clave);
        System.out.println("Texto cifrado:  " + textoCifrado);
        System.out.println("\nBinario original: " + binTexto);
        System.out.println("Binario clave:    " + binClave);
        System.out.println("Binario cifrado:  " + binCifrado);
    }
    
    private static void descifradoXOR() {
        System.out.println("=== Descifrado XOR de texto ===");
        scanner.nextLine(); // Limpiar buffer
        
        System.out.print("Ingrese el texto cifrado: ");
        String textoCifrado = scanner.nextLine();
        
        System.out.print("Ingrese la clave: ");
        String clave = scanner.nextLine();
        
        // Convertir a binario
        String binCifrado = convertidorBin.asciiABinario(textoCifrado);
        String binClave = convertidorBin.asciiABinario(clave);
        
        // Repetir la clave
        while (binClave.length() < binCifrado.length()) {
            binClave += convertidorBin.asciiABinario(clave);
        }
        binClave = binClave.substring(0, binCifrado.length());
        
        // Aplicar XOR (descifrado)
        String binOriginal = opBinarias.aplicarXor(binCifrado, binClave);
        String textoOriginal = convertidorBin.binarioAAscii(binOriginal);
        
        System.out.println("\n✓ Descifrado exitoso:");
        System.out.println("Texto cifrado:   " + textoCifrado);
        System.out.println("Clave:           " + clave);
        System.out.println("Texto original:  " + textoOriginal);
    }
    
    // ==================== MENÚ 4: CIFRADO CÉSAR ====================
    private static void menuCifradoCesar() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║              CIFRADO CÉSAR                                 ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println("⚠️  Funcionalidad pendiente de implementación");
        System.out.println("    Por favor, complete la clase CifradorCesar.java");
        pausar();
    }
    
    // ==================== MENÚ 5: DEMOSTRACIONES ====================
    private static void menuDemostraciones() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║           DEMOSTRACIONES INTERACTIVAS                      ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println("1. Demostración completa: ASCII → Binario → Base64");
        System.out.println("2. Demostración completa: Base64 → Binario → ASCII");
        System.out.println("3. Tabla de caracteres Base64");
        System.out.println("4. Ejemplos de XOR");
        System.out.println("0. Volver al menú principal");
        System.out.print("\nSeleccione una opción: ");
        
        int opcion = leerOpcion();
        System.out.println();
        
        switch (opcion) {
            case 1:
                demoAsciiCompleto();
                break;
            case 2:
                demoBase64Completo();
                break;
            case 3:
                mostrarTablaBase64();
                break;
            case 4:
                demoXOR();
                break;
            case 0:
                return;
            default:
                System.out.println("Opción no válida.");
        }
        
        pausar();
    }
    
    private static void demoAsciiCompleto() {
        System.out.println("=== DEMOSTRACIÓN: ASCII → Binario → Base64 ===");
        String texto = "Hola";
        
        System.out.println("Texto original: " + texto);
        System.out.println("\nPASO 1: ASCII a Binario");
        System.out.println("------------------------");
        String binario = convertidorBin.asciiABinario(texto);
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            int ascii = manejadorAscii.caracterADecimal(c);
            String bin = opBinarias.decimalABinario(ascii, 8);
            System.out.printf("'%c' → ASCII: %3d → Binario: %s%n", c, ascii, bin);
        }
        System.out.println("Binario completo: " + binario);
        
        System.out.println("\nPASO 2: Binario a Base64");
        System.out.println("------------------------");
        String base64 = convertidorBin.binarioABase64(binario);
        System.out.println("Resultado Base64: " + base64);
        
        System.out.println("\nVERIFICACIÓN:");
        System.out.println("Base64 → ASCII: " + convertidorCompleto.base64AAscii(base64));
    }
    
    private static void demoBase64Completo() {
        System.out.println("=== DEMOSTRACIÓN: Base64 → Binario → ASCII ===");
        String base64 = "SG9sYQ==";
        
        System.out.println("Texto Base64: " + base64);
        System.out.println("\nPASO 1: Base64 a Binario");
        System.out.println("------------------------");
        String binario = convertidorBin.base64ABinario(base64);
        String textoSinPadding = manejadorB64.eliminarPadding(base64);
        for (int i = 0; i < textoSinPadding.length(); i++) {
            char c = textoSinPadding.charAt(i);
            int indice = manejadorB64.caracterAIndice(c);
            String bin = opBinarias.decimalABinario(indice, 6);
            System.out.printf("'%c' → Índice: %2d → Binario: %s%n", c, indice, bin);
        }
        System.out.println("Binario completo: " + binario);
        
        System.out.println("\nPASO 2: Binario a ASCII");
        System.out.println("------------------------");
        String ascii = convertidorCompleto.base64AAscii(base64);
        System.out.println("Resultado ASCII: " + ascii);
    }
    
    private static void mostrarTablaBase64() {
        System.out.println("=== TABLA DE CARACTERES BASE64 ===");
        System.out.println("\nAlfabeto Base64 completo (64 caracteres):");
        String alfabeto = manejadorB64.obtenerAlfabeto();
        System.out.println(alfabeto);
        
        System.out.println("\nÍndice | Carácter | Binario");
        System.out.println("-------+----------+---------");
        for (int i = 0; i < 64; i++) {
            char c = manejadorB64.indiceACaracter(i);
            String bin = opBinarias.decimalABinario(i, 6);
            System.out.printf("  %2d   |    %c     | %s%n", i, c, bin);
            
            if ((i + 1) % 10 == 0 && i < 63) {
                System.out.print("\nPresione Enter para continuar...");
                scanner.nextLine();
            }
        }
    }
    
    private static void demoXOR() {
        System.out.println("=== DEMOSTRACIÓN: OPERACIÓN XOR ===");
        System.out.println("\nTabla de verdad XOR:");
        System.out.println("  0 XOR 0 = 0");
        System.out.println("  0 XOR 1 = 1");
        System.out.println("  1 XOR 0 = 1");
        System.out.println("  1 XOR 1 = 0");
        
        System.out.println("\nEjemplo 1: XOR simple");
        String bin1 = "1010";
        String bin2 = "1100";
        String resultado = opBinarias.aplicarXor(bin1, bin2);
        System.out.println(bin1 + " XOR");
        System.out.println(bin2 + " =");
        System.out.println(resultado);
        
        System.out.println("\nEjemplo 2: Cifrado con XOR");
        String texto = "AB";
        String clave = "XY";
        System.out.println("Texto: " + texto);
        System.out.println("Clave: " + clave);
        
        String binTexto = convertidorBin.asciiABinario(texto);
        String binClave = convertidorBin.asciiABinario(clave);
        String binCifrado = opBinarias.aplicarXor(binTexto, binClave);
        String textoCifrado = convertidorBin.binarioAAscii(binCifrado);
        
        System.out.println("Texto cifrado: " + textoCifrado);
        
        // Descifrar
        String binDescifrado = opBinarias.aplicarXor(binCifrado, binClave);
        String textoDescifrado = convertidorBin.binarioAAscii(binDescifrado);
        System.out.println("Texto descifrado: " + textoDescifrado);
    }
    
    // ==================== MENÚ 6: VALIDACIONES ====================
    private static void menuValidaciones() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║              VALIDACIONES                                  ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println("1. Validar cadena binaria");
        System.out.println("2. Validar cadena Base64");
        System.out.println("3. Validar texto ASCII");
        System.out.println("0. Volver al menú principal");
        System.out.print("\nSeleccione una opción: ");
        
        int opcion = leerOpcion();
        System.out.println();
        
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese la cadena a validar: ");
        String cadena = scanner.nextLine();
        
        boolean valido = false;
        switch (opcion) {
            case 1:
                cadena = validador.sanitizarBinario(cadena);
                valido = validador.validarEntrada(cadena, "binario");
                System.out.println(valido ? "✓ Cadena binaria válida" : "Cadena binaria inválida");
                break;
            case 2:
                cadena = validador.sanitizarBase64(cadena);
                valido = validador.validarEntrada(cadena, "base64");
                System.out.println(valido ? "✓ Cadena Base64 válida" : "Cadena Base64 inválida");
                break;
            case 3:
                valido = validador.validarEntrada(cadena, "ascii");
                System.out.println(valido ? "✓ Texto ASCII válido" : "Texto ASCII inválido");
                break;
            case 0:
                return;
            default:
                System.out.println("Opción no válida.");
        }
        
        pausar();
    }
    
    // ==================== MÉTODOS AUXILIARES ====================
    private static int leerOpcion() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // Limpiar buffer
            return -1;
        }
    }
    
    private static void pausar() {
        System.out.print("\nPresione Enter para continuar...");
        try {
            scanner.nextLine();
            scanner.nextLine();
        } catch (Exception e) {
            // Ignorar
        }
    }
}
