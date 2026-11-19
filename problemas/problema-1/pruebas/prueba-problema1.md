# Pruebas manuales - 1
## MÓDULO FINANCIERO-LÓGICO
Desarrollar un programa que permita calcular el impuesto correspondiente a una compra, tomando en cuenta dos condiciones:  

P: El comprador es un estudiante acreditado.  
Q: El equipo pertenece al catálogo educativo.  
De acuerdo con el cumplimiento de estas condiciones, el programa determina el porcentaje de impuesto que debe aplicarse al precio base.
## Entradas, tipos de datos, valores válidos y salidas
### Entradas
El programa solicita el precio base de una compra y dos condiciones lógicas que determinan el porcentaje de impuesto que debe aplicarse.

| Variable | Tipo de dato | Descripción | Valores válidos |
|---|---|---|---|
| precio | double | Precio base de la compra | Números mayores o iguales a cero |
| P | boolean | Indica si el comprador es un estudiante acreditado | true / false |
| Q | boolean | Indica si el equipo pertenece al catálogo educativo | true / false |

El precio puede contener números enteros o decimales. Las condiciones P y Q solamente pueden tomar dos valores: verdadero (true) o falso (false).
### Salidas
El programa determina el porcentaje de impuesto correspondiente según las condiciones ingresadas:
- Si P y Q son verdaderas, se aplica un impuesto del 0%.
- Si solamente una condición es verdadera, se aplica un impuesto del 8%.
- Si ninguna condición es verdadera, se aplica un impuesto del 16%.
Finalmente, muestra el importe del impuesto y el total de la compra, obtenido al sumar el impuesto al precio base.

 ![Pruebas vectoriales](Imagenes/pruebas1.png)