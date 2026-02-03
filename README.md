<!--
PROJECT NAME
-->

# CIFRADOS 2025 - Sistema de Conversión y Criptografía
<a id="readme-top"></a>

<!--
PROJECT DESCRIPTION
-->
## Descripción

Sistema completo de conversión entre diferentes representaciones de datos (ASCII, Binario, Base64) con operaciones criptográficas básicas. Este proyecto implementa conversores bidireccionales y operaciones XOR para cifrado, desarrollado como parte del curso Cifrados 2025.

El sistema permite realizar conversiones entre:
- ASCII ↔ Binario
- Base64 ↔ Binario  
- Base64 ↔ ASCII (conversión compuesta)
- Operaciones XOR para cifrado y descifrado


## Características

### Conversiones Básicas
- ✅ **ASCII a Binario**: Convierte texto plano a representación binaria (8 bits por carácter)
- ✅ **Binario a ASCII**: Decodifica cadenas binarias a texto legible
- ✅ **Base64 a Binario**: Convierte codificación Base64 a binario (6 bits por carácter)
- ✅ **Binario a Base64**: Codifica datos binarios en formato Base64

### Conversiones Compuestas
- ✅ **Base64 a ASCII**: Conversión completa pasando por representación binaria intermedia
- ✅ **ASCII a Base64**: Codificación de texto en Base64

### Operaciones Criptográficas
- ✅ **XOR Binario**: Operación XOR bit a bit entre cadenas binarias
- ✅ **Cifrado XOR**: Cifrado de texto usando clave con operación XOR
- ✅ **Descifrado XOR**: Recuperación de texto original usando la misma clave

### Sistema Interactivo
-  Menú principal con múltiples opciones
-  Validación de entradas
-  Visualización detallada de procesos paso a paso
-  Demostraciones interactivas para aprendizaje
- Tabla de caracteres Base64

##  Instalación y Ejecuión

### Requisitos Previos
- Java Development Kit (JDK) 8 o superior
- IDE compatible con Java (VS Code, IntelliJ IDEA, Eclipse, NetBeans)

### Instalación

1. Clona este repositorio:

    ```bash
    git clone https://github.com/Maria-Villafuerte/Cesar_Cypher_Criptografia.git 
    cd Cesar_Cypher_Criptografia
    ```

2. Compila el proyecto:

    ```bash
    javac src/*.java
    ```

3. Ejecuta el programa principal:

    ```bash
    java -cp src MainPrincipal
    ```

### Ejecución de Scripts Individuales

El proyecto incluye scripts de demostración para cada conversión:

```bash
# ASCII a Binario
java -cp src ScriptAsciiABinario

# Base64 a Binario
java -cp src ScriptBase64ABinario

# Binario a ASCII
java -cp src ScriptBinarioAAscii

# Binario a Base64
java -cp src ScriptBinarioABase64

# Base64 a ASCII
java -cp src ScriptBase64AAscii

# Operaciones XOR
java -cp src ScriptXorBinario
```

##  Estructura del Proyecto

```
cifrados-25/
│
├── src/
│   ├── MainPrincipal.java              # Programa principal con menú interactivo
│   │
│   ├── ConvertidorBinario.java     # Conversiones básicas a/desde binario
│   ├──ConvertidorCompleto.java    # Conversiones compuestas (Base64 ↔ ASCII)
│   ├── ManejadorASCII.java         # Operaciones con caracteres ASCII
│   ├── ManejadorBase64.java        # Gestión de alfabeto y validación Base64
│   ├── OperacionesBinarias.java    # Operaciones binarias y XOR
│   ├── Validador.java              # Validación de entradas
│   ├── Utilidades.java             # Funciones auxiliares
│   ├── ScriptAsciiABinario.java
│   ├── ScriptBase64ABinario.java
│   ├── ScriptBinarioAAscii.java
│   ├── ScriptBinarioABase64.java
│   ├── ScriptBase64AAscii.java
│   ├── ScriptXorBinario.java
│   ├── MainAsciiABinario.java
│   ├── MainBase64ABinario.java
│   ├── MainBinarioAAscii.java
│   ├── MainBinarioABase64.java
│   ├── MainBase64AAscii.java
│   └── MainXorBinario.java
│
├── README.md
└── .gitignore
```

##  Funcionalidades Implementadas

### 1. ASCII a Binario
Convierte cada carácter ASCII a su representación binaria de 8 bits.

**Ejemplo:**
```
Entrada: "Hola"
Salida:  "01001000011011110110110001100001"

Desglose:
'H' → ASCII: 72  → Binario: 01001000
'o' → ASCII: 111 → Binario: 01101111
'l' → ASCII: 108 → Binario: 01101100
'a' → ASCII: 97  → Binario: 01100001
```

### 2. Base64 a Binario
Convierte cada carácter Base64 a su representación binaria de 6 bits.

**Ejemplo:**
```
Entrada: "SG9sYQ=="
Salida:  "010010000110111101101100011000010000"

Desglose:
'S' → Índice: 18 → Binario: 010010
'G' → Índice: 6  → Binario: 000110
'9' → Índice: 61 → Binario: 111101
's' → Índice: 44 → Binario: 101100
'Y' → Índice: 24 → Binario: 011000
'Q' → Índice: 16 → Binario: 010000
```

### 3. Binario a Base64
Agrupa bits en grupos de 6 y convierte a caracteres Base64.

**Ejemplo:**
```
Entrada: "01001000011011110110110001100001"
Salida:  "SG9sYQ=="
```

### 4. Binario a ASCII
Agrupa bits en grupos de 8 y convierte a caracteres ASCII.

**Ejemplo:**
```
Entrada: "01001000011011110110110001100001"
Salida:  "Hola"
```

### 5. Base64 a ASCII
Conversión compuesta que pasa por binario como representación intermedia.

**Proceso:**
```
Base64 → Binario → Ajuste de bits → ASCII

"SG9sYQ==" → "010010000110111101101100011000010000" → "Hola"
```

### 6. XOR Binario
Aplica la operación XOR bit a bit entre dos cadenas binarias.

**Tabla de verdad:**
```
0 XOR 0 = 0
0 XOR 1 = 1
1 XOR 0 = 1
1 XOR 1 = 0
```

**Ejemplo:**
```
Binario 1: 01001000
Binario 2: 00110011
Resultado: 01111011
```

##  Uso del Sistema Interactivo

### Menú Principal

```
╔════════════════════════════════════════════════════════════╗
║                     MENÚ PRINCIPAL                         ║
├────────────────────────────────────────────────────────────┤
│  1. Conversiones Básicas (ASCII/Binario/Base64)            │
│  2. Conversiones Compuestas (Base64 <-> ASCII)             │
│  3. Operaciones XOR                                        │
│  4. Demostraciones Interactivas                            │
│  5. Validaciones                                           │
│  0. Salir                                                  │
└────────────────────────────────────────────────────────────┘
```

### Ejemplo de Uso: Cifrado XOR

```java
Texto original: "Hola"
Clave:          "clave"

Proceso:
1. Convertir texto a binario
2. Convertir clave a binario
3. Aplicar XOR
4. Convertir resultado a ASCII

Resultado cifrado: [texto cifrado]
```

##  Componentes del Sistema

### ConvertidorBinario
Clase principal para conversiones básicas entre formatos.

**Métodos principales:**
- `asciiABinario(String texto)`: ASCII → Binario
- `binarioAAscii(String binario)`: Binario → ASCII
- `base64ABinario(String textoBase64)`: Base64 → Binario
- `binarioABase64(String binario)`: Binario → Base64

### ConvertidorCompleto
Maneja conversiones compuestas que requieren pasos intermedios.

**Métodos principales:**
- `base64AAscii(String textoBase64)`: Base64 → Binario → ASCII
- `asciiABase64(String textoAscii)`: ASCII → Binario → Base64

### OperacionesBinarias
Operaciones de bajo nivel con números binarios.

**Métodos principales:**
- `decimalABinario(int decimal, int longitud)`: Decimal → Binario con padding
- `binarioADecimal(String binario)`: Binario → Decimal
- `aplicarXor(String bin1, String bin2)`: Operación XOR bit a bit
- `validarBinario(String cadena)`: Validación de formato binario

### ManejadorBase64
Gestión del alfabeto Base64 y operaciones relacionadas.

**Alfabeto Base64:**
```
ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/
```

**Métodos principales:**
- `caracterAIndice(char caracter)`: Obtiene índice (0-63) de carácter
- `indiceACaracter(int indice)`: Obtiene carácter del índice
- `agregarPadding(String texto)`: Añade '=' para completar múltiplo de 4
- `eliminarPadding(String texto)`: Remueve caracteres de padding

## Demo

<p align="center">
  <img src="Diseño sin título.gif" alt="Demo del sistema" width="12000"/>
</p>

---
