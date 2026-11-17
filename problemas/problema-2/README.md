¿Qué hace el programa?
En este programa trabajamos con dos situaciones. Primero calculamos la distancia entre dos puntos de un plano. Después usamos dos preguntas de sí o no para obtener una tasa dentro de un modelo académico.
Con este ejercicio practicamos el uso de variables, operaciones matemáticas y decisiones con if-else en Java.
" las tasas son solo para practicar lógica". 
Datos que pide
- x1 y y1: coordenadas del primer punto. Son números decimales (double).
- x2 y y2: coordenadas del segundo punto. También son números decimales (double).
- p: indica si la persona compra como estudiante. Es un número entero: 1 para sí y 0 para no.
- q: indica si el equipo es educativo. Es un número entero: 1 para sí y 0 para no.
Los decimales se escriben con punto, por ejemplo 2.5. En las preguntas p y q, si se ingresa un número entero distinto de 0 o 1, el programa muestra un error y termina. El código espera que los datos tengan el tipo indicado; no valida texto ingresado en lugar de números.
¿Cómo lo resolvimos?
Primero restamos las coordenadas para conocer el cambio horizontal y el vertical:
- Δx = x2 - x1
- Δy = y2 - y1
Después calculamos la distancia con la fórmula √(Δx² + Δy²). Para obtener la raíz usamos Math.sqrt.
Por último, revisamos las dos respuestas con if-else:
Compra como estudiante |Equipo educativo|Tasa del modelo|
Sí (1) , Sí (1) , 0% 
Sí (1) , No (0) , 8% 
No (0) , Sí (1) , 8% 
No (0) , No (0) , 16% 
El programa muestra los valores de Δx, Δy, la distancia con dos decimales y la tasa como porcentaje.
 Partes principales del código
- Usamos Scanner para leer los datos que escribe la persona.
- Guardamos las coordenadas en variables double y calculamos los incrementos y la distancia.
- Validamos que p y q sean 0 o 1 y aplicamos las condiciones de la tabla.
- Finalmente, mostramos los resultados y cerramos el lector.
¿Cómo se compila y ejecuta?
Necesitas tener instalado el "JDK de Java". Guarda el código que nos compartieron en un archivo llamado SimuVectorTIC.java, dentro de problemas/problema-2/src/. Abre una terminal en la carpeta problemas/problema-2/ y escribe:
bash
cd src
javac SimuVectorTIC.java
java SimuVectorTIC
Después, escribe cada dato cuando el programa lo pida y presiona Enter. Los archivos compilados .class no se suben al repositorio.
 Un ejemplo
Para los puntos (1, 2) y (4, 6), y respondiendo sí a las dos preguntas, la ejecución sería:
=== SimuVector-TIC ===
Módulo vectorial y modelo lógico académico
Ingresa x1: 1
Ingresa y1: 2
Ingresa x2: 4
Ingresa y2: 6
Ingresa 1 para Sí o 0 para No.
¿La persona compra como estudiante? (1/0): 1
¿El equipo es educativo? (1/0): 1
=== Resultados ===
Δx = 3.00
Δy = 4.00
Distancia entre los puntos = 5.00
Tasa del modelo académico = 0%
Nota: las tasas son solo para practicar lógica.
La diferencia entre las coordenadas es 4 - 1 = 3 en x y 6 - 2 = 4 en y. La distancia es √(3² + 4²) = 5. Como ambas respuestas son 1, corresponde una tasa de 0% en el modelo. 