import java.util.Scanner;

public class Problema2 {

    // Scanner único para leer las coordenadas desde la consola.
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        // Ejecuta directamente el problema geométrico, sin menú.
        calcularDist();
    }

    // Calcula la distancia entre dos puntos del plano cartesiano.
    public static void calcularDist() {
        System.out.println("\nDISTANCIA ENTRE DOS PUNTOS");

        double x1 = leerCo("Ingresa x1:");
        double y1 = leerCo("Ingresa y1:");
        double x2 = leerCo("Ingresa x2:");
        double y2 = leerCo("Ingresa y2:");

        // No continúa si los dos puntos tienen las mismas coordenadas.
        if (x1 == x2 && y1 == y2) {
            System.out.println("Puntos iguales: modifique al menos una coordenada.");
            return;
        }

        // Calcula los incrementos en los ejes X y Y.
        double incrementoX = x2 - x1;
        double incrementoY = y2 - y1;

        // Aplica el teorema de Pitágoras para calcular la distancia.
        double distancia = Math.sqrt(
                incrementoX * incrementoX + incrementoY * incrementoY
        );

        // Comprueba que el resultado sea un número finito.
        if (Double.isInfinite(distancia) || Double.isNaN(distancia)) {
            System.out.println("Las coordenadas son demasiado grandes para calcular la distancia.");
            return;
        }

        // Muestra los incrementos y la distancia con dos decimales.
        System.out.println("Incremento en X: " + String.format("%.2f", incrementoX));
        System.out.println("Incremento en Y: " + String.format("%.2f", incrementoY));
        System.out.println("Distancia: " + String.format("%.2f", distancia) + " unidades");
    }

    // Lee coordenadas positivas, negativas o decimales.
    // No permite letras ni notación científica.
    public static double leerCo(String mensaje) {
        while (true) {
            System.out.println(mensaje);
            String texto = entrada.nextLine().trim();

            // Ejemplos aceptados: 5, -3, 4.25 y -6.8.
            if (texto.matches("-?\\d+(\\.\\d+)?")) {
                double coordenada = Double.parseDouble(texto);

                // Evita aceptar valores infinitos.
                if (!Double.isInfinite(coordenada) && !Double.isNaN(coordenada)) {
                    return coordenada;
                }
            }

            System.out.println("Coordenada inválida. Ejemplo permitido: -4.5");
        }
    }
}
