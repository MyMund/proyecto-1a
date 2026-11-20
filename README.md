# Problema 2: Distancia entre dos puntos

## 1. Enunciado y propósito del problema

El problema consiste en desarrollar un programa que permita calcular la distancia entre dos puntos en un plano cartesiano, a partir de sus coordenadas:

- **P1 (x1, y1):** Representa el punto inicial.
- **P2 (x2, y2):** Representa el punto final.

A partir de estas coordenadas, el programa obtiene los incrementos en los ejes X y Y, y calcula la magnitud del desplazamiento entre ambos puntos mediante el teorema de Pitágoras.

El propósito es automatizar el cálculo de la distancia y los incrementos entre dos puntos mediante operaciones matemáticas y una interfaz gráfica desarrollada en Java.

## 2. Entradas, tipos de datos y salidas

### Entradas

| Entrada | Tipo de dato | Valores válidos | Descripción |
|---|---|---|---|
| Coordenada x1 | `double` | Números reales | Coordenada X del punto inicial P1. |
| Coordenada y1 | `double` | Números reales | Coordenada Y del punto inicial P1. |
| Coordenada x2 | `double` | Números reales | Coordenada X del punto final P2. |
| Coordenada y2 | `double` | Números reales | Coordenada Y del punto final P2. |

Los campos permiten números negativos, decimales y notación científica. No se aceptan campos vacíos ni valores que no puedan convertirse a números.

### Salidas

| Salida | Descripción |
|---|---|
| Incremento en X (Δx) | Diferencia entre las coordenadas X de ambos puntos. |
| Incremento en Y (Δy) | Diferencia entre las coordenadas Y de ambos puntos. |
| Magnitud o distancia (d) | Distancia entre el punto inicial y el punto final, expresada en unidades. |

## 3. Procedimiento de solución

### Fórmulas utilizadas

Para calcular los incrementos entre las coordenadas:

**Incremento en X:**

```text
Δx = x2 - x1
```

**Incremento en Y:**

```text
Δy = y2 - y1
```

Para calcular la distancia entre los dos puntos se utiliza el teorema de Pitágoras:

```text
d = √((Δx)² + (Δy)²)
```

Sustituyendo los incrementos:

```text
d = √((x2 - x1)² + (y2 - y1)²)
```

### Pasos del procedimiento

1. Solicitar las coordenadas X y Y del punto inicial P1.
2. Solicitar las coordenadas X y Y del punto final P2.
3. Verificar que los cuatro campos contengan valores numéricos válidos.
4. Calcular el incremento en X restando x1 a x2.
5. Calcular el incremento en Y restando y1 a y2.
6. Elevar al cuadrado ambos incrementos.
7. Sumar los resultados obtenidos.
8. Calcular la raíz cuadrada de la suma para obtener la distancia.
9. Mostrar los incrementos y la magnitud en la interfaz gráfica.

### Pseudocódigo

```text
INICIO

    LEER x1, y1
    LEER x2, y2

    SI los valores no son numéricos ENTONCES
        MOSTRAR "Ingresa coordenadas válidas"
    SINO
        incrementoX = x2 - x1
        incrementoY = y2 - y1

        incrementoXCu = incrementoX ^ 2
        incrementoYCu = incrementoY ^ 2

        sumaCuadrados = incrementoXCu + incrementoYCu

        distancia = RAIZ(sumaCuadrados)

        MOSTRAR incrementoX
        MOSTRAR incrementoY
        MOSTRAR distancia
    FIN SI

FIN
```

## 4. Explicación de las partes principales del programa

El programa está desarrollado en Java utilizando la biblioteca Swing para construir una interfaz gráfica.

### Constructor

El constructor `ModGeometrico()` inicializa los componentes de la interfaz, establece el tamaño y la posición de la ventana, configura los botones y prepara los campos de entrada para validar las coordenadas.

También establece el botón de cálculo como acción predeterminada al presionar Enter y configura la tecla Escape para limpiar los campos.

### Método `btnCalcularActionPerformed`

Es el encargado de ejecutar el procedimiento principal:

- Obtiene las cuatro coordenadas ingresadas.
- Convierte los valores de texto a tipo `double`.
- Calcula los incrementos en X y Y.
- Eleva al cuadrado ambos incrementos.
- Suma los cuadrados.
- Calcula la raíz cuadrada para obtener la distancia.
- Muestra los resultados en la interfaz.

### Cálculos matemáticos

Para obtener los incrementos se utilizan las siguientes operaciones:

```java
double incrementoX = x2 - x1;
double incrementoY = y2 - y1;
```

Posteriormente, se elevan al cuadrado y se suman:

```java
double incrementoXCu = Math.pow(incrementoX, 2);
double incrementoYCu = Math.pow(incrementoY, 2);

double sumaCuadrados = incrementoXCu + incrementoYCu;
```

Finalmente, se calcula la distancia:

```java
double distancia = Math.sqrt(sumaCuadrados);
```

### Validación de datos

El programa utiliza `Double.parseDouble()` para convertir las coordenadas ingresadas a valores numéricos.

Mediante `try-catch` y la excepción `NumberFormatException`, se detectan campos vacíos o datos que no pueden convertirse a números. En esos casos, se muestra una advertencia al usuario.

Además, el método `validarCoordenada()` controla los caracteres permitidos mientras se escriben las coordenadas. Admite números, signo negativo, punto decimal y notación científica.

### Método `btnLimpiarActionPerformed`

Restablece los cuatro campos de coordenadas y los resultados a sus valores iniciales. También devuelve el cursor al primer campo para facilitar un nuevo cálculo.

### Métodos auxiliares

Se incluyen métodos para mejorar la presentación y el funcionamiento de la interfaz:

- `validarCoordenada()`: controla los caracteres permitidos en los campos de coordenadas.
- `bloquearPegado()`: impide pegar texto en los campos de entrada.
- `estilizarBoton()`: configura la apariencia de los botones y sus efectos al pasar el cursor.
- `configurarAtajoEscape()`: permite limpiar los campos mediante la tecla Escape.
- `formatearNumero()`: muestra los resultados con dos decimales y utiliza notación científica para valores de gran magnitud.

## 5. Instrucciones de compilación y ejecución

### Requisitos

- Tener instalado el JDK de Java.
- Contar con el archivo `ModGeometrico.java`.
- Disponer de una terminal o consola para ejecutar los comandos.

### Estructura de archivos

La siguiente estructura corresponde a una organización sencilla del programa:

```problema-2/
├── README.md
├── src/
│   └── ModGeometrico.java
├── pruebas/
│   └── prueba-problema2.md
└── out/
```

### Compilar el programa

Desde la carpeta `problema-2`, ejecutar:

```bash
mkdir -p out
javac -d out src/ModGeometrico.java
```

Este comando crea la carpeta `out` si no existe y compila el archivo Java, colocando los archivos `.class` generados dentro de ella.

### Ejecutar el programa

```bash
java -cp out ModGeometrico
```

El comando inicia la aplicación gráfica.

### Ingreso de datos

1. Introducir las coordenadas X y Y del punto inicial P1.
2. Introducir las coordenadas X y Y del punto final P2.
3. Presionar el botón **Calcular Distancia** para obtener los resultados.
4. Consultar los incrementos en X y Y, así como la magnitud de la distancia.
5. Utilizar el botón **Limpiar** para reiniciar los campos y realizar otro cálculo.

## 6. Ejemplo de ejecución

**Datos de entrada:**

- Punto inicial: P₁ = (0, 0)
- Punto final: P₂ = (1, 1)

**Procedimiento:**

1. Calcular el incremento en X:

   Δx = 1 - 0 = 1

2. Calcular el incremento en Y:

   Δy = 1 - 0 = 1

3. Calcular la distancia:

   d = √((1)² + (1)²)

   d = √(1 + 1)

   d = √2 ≈ 1.4142

**Resultados esperados:**

| Resultado | Valor |
|---|---:|
| Incremento en X (Δx) | 1.00 |
| Incremento en Y (Δy) | 1.00 |
| Distancia | 1.41 unidades |

El programa muestra los incrementos y la distancia calculada en la interfaz gráfica.

## Pruebas del programa

Consulta los casos de prueba realizados para verificar el funcionamiento del programa:

[Ver pruebas del problema 2](pruebas/prueba-problema2.md)