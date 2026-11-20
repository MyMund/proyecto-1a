# Problema 1: Evaluador Fiscal

## 1. Enunciado y propósito del problema

El problema consiste en desarrollar un programa que permita calcular el impuesto correspondiente a una compra, tomando en cuenta dos condiciones:

- **P:** El comprador es un estudiante acreditado.
- **Q:** El equipo pertenece al catálogo educativo.

De acuerdo con el cumplimiento de estas condiciones, el programa determina el porcentaje de impuesto que debe aplicarse al precio base.

El propósito es automatizar el cálculo del impuesto y del total de la compra mediante el uso de lógica proposicional, operaciones aritméticas y una interfaz gráfica desarrollada en Java.

## 2. Entradas, tipos de datos y salidas

### Entradas

| Entrada | Tipo de dato | Valores válidos | Descripción |
|---|---|---|---|
| Precio base | `double` | Números mayores o iguales a 0 | Precio del producto antes de aplicar el impuesto. |
| Premisa P | `boolean` | `true` / `false` | Indica si el comprador es un estudiante acreditado. |
| Premisa Q | `boolean` | `true` / `false` | Indica si el equipo pertenece al catálogo educativo. |

### Salidas

| Salida | Descripción |
|---|---|
| Valor de P y Q | Muestra el estado de las condiciones seleccionadas. |
| Porcentaje de impuesto | Indica la tasa correspondiente: 0 %, 8 % o 16 %. |
| Impuesto calculado | Cantidad monetaria que se agrega al precio base. |
| Total de compra | Resultado de sumar el precio base y el impuesto. |
| Mensaje de evaluación | Describe el tipo de impuesto aplicado. |

## 3. Procedimiento de solución

### Reglas de decisión

El programa utiliza las premisas P y Q para determinar el porcentaje de impuesto.

| P | Q | Condición lógica | Impuesto |
|---|---|---|---|
| Verdadero | Verdadero | P AND Q | 0 % |
| Verdadero | Falso | P OR Q | 8 % |
| Falso | Verdadero | P OR Q | 8 % |
| Falso | Falso | NOT P AND NOT Q | 16 % |

### Fórmulas utilizadas

Para calcular el impuesto:

```text
Impuesto = Precio base * Tasa
```

Para obtener el total de la compra:

```text
Total = Precio base + Impuesto
```

### Pasos del procedimiento

1. Solicitar el precio base del producto.
2. Verificar que el precio sea válido y no sea negativo.
3. Obtener los valores de las premisas P y Q mediante las casillas de selección.
4. Evaluar las condiciones lógicas:
   - Si P y Q son verdaderas, aplicar un impuesto del 0 %.
   - Si al menos una es verdadera, aplicar un impuesto del 8 %.
   - Si ambas son falsas, aplicar un impuesto del 16 %.
5. Calcular el impuesto correspondiente.
6. Sumar el impuesto al precio base.
7. Mostrar los resultados en la interfaz gráfica.

### Pseudocódigo

```text
INICIO

    LEER precio

    SI precio < 0 ENTONCES
        MOSTRAR "El precio no puede ser negativo"
    SINO
        LEER P
        LEER Q

        SI P Y Q ENTONCES
            tasa = 0.00
        SINO SI P O Q ENTONCES
            tasa = 0.08
        SINO
            tasa = 0.16
        FIN SI

        impuesto = precio * tasa
        total = precio + impuesto

        MOSTRAR tasa
        MOSTRAR impuesto
        MOSTRAR total
    FIN SI

FIN
```

## 4. Explicación de las partes principales del programa

El programa está desarrollado en Java utilizando la biblioteca Swing para construir una interfaz gráfica.

### Constructor

El constructor `ModFinanciero()` inicializa los componentes de la interfaz, configura el tamaño de la ventana, establece su posición y aplica estilos a los botones y campos de entrada.

También configura los atajos de teclado para facilitar el uso del programa.

### Método `evaluarActionPerformed`

Es el encargado de ejecutar el procedimiento principal:

- Obtiene el precio ingresado.
- Comprueba que el valor sea válido.
- Recupera el estado de las premisas P y Q.
- Evalúa las condiciones lógicas.
- Determina el porcentaje de impuesto.
- Calcula el impuesto y el total de la compra.
- Actualiza los resultados en la interfaz.

### Cálculo del impuesto

Una vez determinada la tasa correspondiente, se realizan las operaciones:

```java
double impuesto = precio * tasa;
double total = precio + impuesto;
```

### Validación de datos

El programa utiliza `Double.parseDouble()` para convertir el precio ingresado a un valor numérico.

También contempla excepciones mediante `NumberFormatException` para evitar que el programa continúe cuando el campo está vacío o contiene un valor no numérico.

### Método `limpiarActionPerformed`

Restablece los campos de entrada, las casillas de selección y los resultados para permitir una nueva evaluación.

### Métodos auxiliares

Se incluyen métodos para mejorar la presentación y el funcionamiento de la interfaz, como:

- `bloquearPegado()`: impide pegar contenido en el campo de precio.
- `estilizarBoton()`: configura la apariencia de los botones.
- `configurarAtajoEscape()`: permite limpiar los campos mediante la tecla Escape.
- `formatearNumero()`: da formato a los valores numéricos mostrados.

## 5. Instrucciones de compilación y ejecución

### Requisitos

- Tener instalado el JDK de Java.
- Contar con el archivo `ModFinanciero.java`.
- Disponer de una terminal o consola para ejecutar los comandos.

### Estructura de archivos

La siguiente estructura corresponde a una organización sencilla del programa:

```text
problema-1/
├── README.md
├── src/
│   └── ModFinanciero.java
├── pruebas/
│   └── prueba-problema1.md
└── out/
```

### Compilar el programa

Desde la carpeta `problema-1`, ejecutar:

```bash
mkdir -p out
javac -d out src/ModFinanciero.java
```

Este comando crea la carpeta `out` si no existe y compila el archivo Java, colocando los archivos `.class` generados dentro de ella.

### Ejecutar el programa

```bash
java -cp out ModFinanciero
```

El comando inicia la aplicación gráfica.

### Ingreso de datos

1. Introducir el precio base del producto.
2. Seleccionar la casilla correspondiente a la premisa P si el comprador es un estudiante acreditado.
3. Seleccionar la casilla correspondiente a la premisa Q si el equipo pertenece al catálogo educativo.
4. Presionar el botón **Evaluar** para obtener los resultados.
5. Utilizar el botón **Limpiar** para reiniciar los campos y realizar otro cálculo.

## 6. Ejemplos de ejecución

Para comprobar el funcionamiento del programa, se presentan los cuatro escenarios posibles según los valores de las premisas P y Q, utilizando un precio base de **$1,000.00**.

### Caso 1: P = Verdadero, Q = Verdadero

- Precio base: $1,000.00
- P: Verdadero (comprador estudiante acreditado).
- Q: Verdadero (equipo perteneciente al catálogo educativo).
- Condición lógica: P AND Q.
- Tasa de impuesto: 0%.

**Resultados esperados:**

| Concepto | Resultado |
|---|---:|
| Impuesto | $0.00 |
| Total | $1,000.00 |

### Caso 2: P = Verdadero, Q = Falso

- Precio base: $1,000.00
- P: Verdadero.
- Q: Falso.
- Condición lógica: P OR Q.
- Tasa de impuesto: 8%.

**Resultados esperados:**

| Concepto | Resultado |
|---|---:|
| Impuesto | $80.00 |
| Total | $1,080.00 |

### Caso 3: P = Falso, Q = Verdadero

- Precio base: $1,000.00
- P: Falso.
- Q: Verdadero.
- Condición lógica: P OR Q.
- Tasa de impuesto: 8%.

**Resultados esperados:**

| Concepto | Resultado |
|---|---:|
| Impuesto | $80.00 |
| Total | $1,080.00 |

### Caso 4: P = Falso, Q = Falso

- Precio base: $1,000.00
- P: Falso.
- Q: Falso.
- Condición lógica: NOT P AND NOT Q.
- Tasa de impuesto: 16%.

**Resultados esperados:**

| Concepto | Resultado |
|---|---:|
| Impuesto | $160.00 |
| Total | $1,160.00 |

Estos ejemplos permiten comprobar que el programa aplica correctamente las tasas de impuesto de acuerdo con las cuatro combinaciones posibles de las premisas lógicas.

El programa muestra estos resultados en la interfaz gráfica, indicando que se aplicó el impuesto reducido.

## Pruebas del programa

Consulta los casos de prueba realizados para verificar el funcionamiento del módulo financiero-lógico:

[Ver pruebas del problema 1](pruebas/prueba-problema1.md)