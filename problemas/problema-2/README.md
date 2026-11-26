# Problema 2: Distancia entre dos puntos

## 1. Enunciado y propósito del problema

El problema consiste en desarrollar un programa que permita calcular la distancia entre dos puntos ubicados en un plano cartesiano bidimensional.

Para realizar el cálculo se utilizan las coordenadas de un punto inicial y un punto final:

- **Punto inicial:** \(P_1(x_1,y_1)\).
- **Punto final:** \(P_2(x_2,y_2)\).

El propósito es obtener los incrementos de posición en los ejes X y Y, así como la distancia entre ambos puntos, mediante operaciones matemáticas y programación estructurada en Java. La interacción con el usuario se realiza desde la consola.

## 2. Entradas, tipos de datos y salidas

### Entradas

| Entrada | Tipo de dato | Valores válidos | Descripción |
|---|---|---|---|
| Coordenada \(x_1\) | `double` | Números positivos, negativos o decimales | Coordenada horizontal del punto inicial. |
| Coordenada \(y_1\) | `double` | Números positivos, negativos o decimales | Coordenada vertical del punto inicial. |
| Coordenada \(x_2\) | `double` | Números positivos, negativos o decimales | Coordenada horizontal del punto final. |
| Coordenada \(y_2\) | `double` | Números positivos, negativos o decimales | Coordenada vertical del punto final. |

Las coordenadas se ingresan mediante la consola. Se aceptan números enteros y decimales, positivos o negativos. No se permite ingresar letras ni utilizar notación científica.

### Salidas

| Salida | Descripción |
|---|---|
| Incremento en X (\(\Delta x\)) | Diferencia entre las coordenadas horizontales de los puntos. |
| Incremento en Y (\(\Delta y\)) | Diferencia entre las coordenadas verticales de los puntos. |
| Distancia | Longitud del segmento que une los dos puntos, expresada en unidades. |
| Mensaje de validación | Informa si las coordenadas son inválidas, si los puntos coinciden o si no es posible representar el resultado. |

## 3. Procedimiento de solución

### Fórmulas utilizadas

Para calcular el incremento en X:

```text
Δx = x2 - x1
```

Para calcular el incremento en Y:

```text
Δy = y2 - y1
```

Para obtener la distancia entre los puntos se aplica el teorema de Pitágoras:

$$
d = \sqrt{(\Delta x)^2 + (\Delta y)^2}
$$

También puede expresarse de la siguiente manera:

$$
d = \sqrt{(x_2-x_1)^2 + (y_2-y_1)^2}
$$

### Condición especial

Antes de realizar los cálculos, el programa verifica que los puntos no tengan las mismas coordenadas.

Si se cumple que:

```text
x1 = x2 Y y1 = y2
```

se muestra un mensaje indicando que los puntos son iguales y se solicita modificar al menos una coordenada en una nueva ejecución.

### Pasos del procedimiento

1. Solicitar las coordenadas \(x_1\) y \(y_1\) del punto inicial.
2. Solicitar las coordenadas \(x_2\) y \(y_2\) del punto final.
3. Validar que cada coordenada tenga un formato numérico permitido.
4. Comprobar que los dos puntos no sean coincidentes.
5. Calcular el incremento en X mediante la resta \(x_2-x_1\).
6. Calcular el incremento en Y mediante la resta \(y_2-y_1\).
7. Aplicar el teorema de Pitágoras para obtener la distancia.
8. Verificar que el resultado sea un número válido y finito.
9. Mostrar los incrementos y la distancia con dos cifras decimales.

### Pseudocódigo

```text
INICIO

    LEER x1
    LEER y1
    LEER x2
    LEER y2

    SI x1 = x2 Y y1 = y2 ENTONCES
        MOSTRAR "Los puntos son iguales"
        TERMINAR
    FIN SI

    incrementoX = x2 - x1
    incrementoY = y2 - y1

    distancia = RAIZ(
        incrementoX * incrementoX +
        incrementoY * incrementoY
    )

    SI distancia NO ES FINITA ENTONCES
        MOSTRAR "No se puede calcular la distancia"
        TERMINAR
    FIN SI

    MOSTRAR incrementoX
    MOSTRAR incrementoY
    MOSTRAR distancia

FIN
```

## 4. Explicación de las partes principales del programa

El programa está desarrollado en Java mediante programación estructurada, utilizando métodos, estructuras condicionales y ciclos para organizar el procedimiento. La interacción se realiza mediante la consola, sin utilizar interfaces gráficas ni bibliotecas externas.

### Método `main()`

Es el punto de entrada del programa. Su función es ejecutar directamente el método `calcularDist()`, que contiene el procedimiento principal del problema.

### Scanner

Se utiliza un objeto `Scanner` para recibir las coordenadas que el usuario introduce mediante el teclado.

```java
static Scanner entrada = new Scanner(System.in);
```

El objeto permite leer las entradas mediante `entrada.nextLine()` y compartir el mismo mecanismo de lectura entre los métodos del programa.

### Método `calcularDist()`

Es el encargado de ejecutar el procedimiento principal:

- Solicita las cuatro coordenadas mediante el método `leerCo()`.
- Comprueba que los puntos no sean coincidentes.
- Calcula los incrementos en X y Y.
- Obtiene la distancia mediante el teorema de Pitágoras.
- Verifica que el resultado sea válido y finito.
- Muestra los resultados mediante `System.out.println()`.

### Validación de puntos coincidentes

El programa utiliza una estructura condicional `if` para comprobar si las coordenadas de ambos puntos son iguales.

```java
if (x1 == x2 && y1 == y2) {
    System.out.println("Puntos iguales: modifique al menos una coordenada.");
    return;
}
```

El operador `&&` comprueba que ambas condiciones sean verdaderas. Si los dos puntos coinciden, `return` termina la ejecución del método `calcularDist()`.

### Cálculo de los incrementos

Se obtiene la diferencia entre las coordenadas de ambos puntos:

```java
double incrementoX = x2 - x1;
double incrementoY = y2 - y1;
```

Estos valores representan el desplazamiento horizontal y vertical, respectivamente.

### Cálculo de la distancia

Se utiliza `Math.sqrt()` para obtener la raíz cuadrada de la suma de los cuadrados de los incrementos.

```java
double distancia = Math.sqrt(
    incrementoX * incrementoX + incrementoY * incrementoY
);
```

La operación corresponde al teorema de Pitágoras aplicado al plano cartesiano.

### Validación del resultado

Se utilizan los métodos `Double.isInfinite()` y `Double.isNaN()` para comprobar que la distancia no sea infinita ni un valor no numérico.

```java
if (Double.isInfinite(distancia) || Double.isNaN(distancia)) {
    System.out.println("Las coordenadas son demasiado grandes para calcular la distancia.");
    return;
}
```

Si el resultado no es válido, se muestra un mensaje y se termina el método.

### Método `leerCo()`

Se encarga de solicitar y validar cada coordenada.

Recibe un mensaje como parámetro para indicar qué dato debe ingresar el usuario.

Utiliza:

- `while`: repite la solicitud mientras el dato sea inválido.
- `nextLine()`: lee el texto ingresado desde la consola.
- `trim()`: elimina espacios al inicio y al final del texto.
- `matches()`: valida el formato del número mediante una expresión regular.
- `Double.parseDouble()`: convierte el texto en un número decimal.
- `Double.isInfinite()` y `Double.isNaN()`: comprueban que el valor convertido sea válido.
- `return`: devuelve la coordenada cuando cumple las condiciones.

La expresión regular utilizada es:

```java
"-?\\d+(\\.\\d+)?"
```

Esta permite ingresar números enteros o decimales, positivos o negativos, y evita letras y notación científica.

### Formato de los resultados

Se utiliza `String.format("%.2f", valor)` para presentar los incrementos y la distancia con dos cifras decimales.

Las salidas se realizan mediante `System.out.println()`.

## 5. Instrucciones de compilación y ejecución

### Requisitos

- Tener instalado el JDK de Java.
- Contar con el archivo `Problema2.java`.
- Disponer de una terminal o consola para ejecutar los comandos.

No se requieren bibliotecas externas ni el uso de un entorno de desarrollo específico.

### Estructura de archivos

```text
problema-2/
├── README.md
├── src/
│   └── Problema2.java
├── pruebas/
│   └── pruebas-problema2.md
└── out/                  # Se genera al compilar el programa
```

### Compilar el programa

Desde la carpeta raíz `problema-2`, crear la carpeta de salida:

```bash
mkdir out
```

Después, compilar el archivo que se encuentra dentro de `src`:

```bash
javac -d out src/Problema2.java
```

Este comando compila el código fuente y coloca el archivo `Problema2.class` dentro de la carpeta `out`.

### Ejecutar el programa

Desde la misma carpeta raíz, ejecutar:

```bash
java -cp out Problema2
```

El comando inicia el cálculo de distancia directamente en la consola.

> Si la carpeta `out` ya existe, no es necesario volver a crearla. La carpeta `pruebas` contiene el archivo `pruebas-problema2.md` con los casos de prueba del proyecto.

### Ingreso de datos

1. Introducir la coordenada \(x_1\) del punto inicial.
2. Introducir la coordenada \(y_1\) del punto inicial.
3. Introducir la coordenada \(x_2\) del punto final.
4. Introducir la coordenada \(y_2\) del punto final.
5. Consultar los incrementos y la distancia mostrados en la consola.

## 6. Ejemplos de ejecución

Para comprobar el funcionamiento del programa, se presentan distintos escenarios utilizando coordenadas de ejemplo.

### Caso 1: Puntos con incrementos positivos

- Punto inicial: \(P_1(1,2)\).
- Punto final: \(P_2(4,6)\).

**Cálculos:**

$$
\begin{aligned}
\Delta x &= 4 - 1 = 3\\
\Delta y &= 6 - 2 = 4\\
d &= \sqrt{3^2 + 4^2} = 5
\end{aligned}
$$

**Resultados esperados:**

| Concepto | Resultado |
|---|---:|
| Incremento en X | 3.00 |
| Incremento en Y | 4.00 |
| Distancia | 5.00 unidades |

### Caso 2: Coordenadas negativas

- Punto inicial: \(P_1(-2,-3)\).
- Punto final: \(P_2(2,0)\).

**Cálculos:**

$$
\begin{aligned}
\Delta x &= 2 - (-2) = 4\\
\Delta y &= 0 - (-3) = 3\\
d &= \sqrt{4^2 + 3^2} = 5
\end{aligned}
$$

**Resultados esperados:**

| Concepto | Resultado |
|---|---:|
| Incremento en X | 4.00 |
| Incremento en Y | 3.00 |
| Distancia | 5.00 unidades |

### Caso 3: Coordenadas decimales

- Punto inicial: \(P_1(1.5,2.5)\).
- Punto final: \(P_2(4.5,6.5)\).

**Cálculos:**

$$
\begin{aligned}
\Delta x &= 4.5 - 1.5 = 3\\
\Delta y &= 6.5 - 2.5 = 4\\
d &= \sqrt{3^2 + 4^2} = 5
\end{aligned}
$$

**Resultados esperados:**

| Concepto | Resultado |
|---|---:|
| Incremento en X | 3.00 |
| Incremento en Y | 4.00 |
| Distancia | 5.00 unidades |

### Caso 4: Puntos coincidentes

- Punto inicial: \(P_1(3,5)\).
- Punto final: \(P_2(3,5)\).

**Resultado esperado:**

```text
Puntos iguales: modifique al menos una coordenada.
```

El programa no continúa con el cálculo cuando ambos puntos tienen las mismas coordenadas.

Estos ejemplos permiten comprobar el cálculo de los incrementos y la distancia, así como la validación de puntos coincidentes.

## Pruebas del programa

Consulta los casos de prueba realizados para verificar el funcionamiento del módulo geométrico:

[Ver pruebas del problema 2](pruebas/pruebas-problema2.md)
