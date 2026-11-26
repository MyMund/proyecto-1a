import java.util.Scanner;

public class Problema1 {

    // Scanner único para leer los datos desde la consola.
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        // Ejecuta directamente el problema financiero, sin menú.
        evaluar();
    }

    // Evalúa las proposiciones p y q y determina el impuesto correspondiente.
    public static void evaluar() {
        System.out.println("\nEVALUADOR FISCAL");

        double precio = leerPrecio();

        boolean p = leerResp("p) ¿El comprador es estudiante acreditado? (s/n):");
        boolean q = leerResp("q) ¿El equipo pertenece al catálogo educativo? (s/n):");

        int porcentaje;
        String condicion;
        String formula;

        if (p && q) {
            porcentaje = 0;
            condicion = "Exención total";
            formula = "p && q (AND)";
        } else if (p || q) {
            porcentaje = 8;
            condicion = "Impuesto reducido";
            formula = "p || q (OR)";
        } else {
            porcentaje = 16;
            condicion = "Impuesto general";
            formula = "!p && !q (NOT)";
        }

        // Calcula el impuesto y el total a pagar.
        double impuesto = precio * porcentaje / 100.0;
        double total = precio + impuesto;

        // Muestra los valores lógicos y los resultados con dos decimales.
        System.out.println("\nValores: p = " + (p ? 1 : 0) + ", q = " + (q ? 1 : 0));
        System.out.println("Condición: " + condicion);
        System.out.println("Fórmula aplicada: " + formula);
        System.out.println("Porcentaje aplicado: " + porcentaje + "%");
        System.out.println("Impuesto calculado: $" + String.format("%.2f", impuesto));
        System.out.println("Total a pagar: $" + String.format("%.2f", total));
    }

    // Lee un precio no negativo, con máximo dos decimales y límite establecido.
    public static double leerPrecio() {
        while (true) {
            System.out.println("Precio base (de $0 a $999999.99):");
            String texto = entrada.nextLine().trim();

            // Acepta solo dígitos y hasta dos cifras decimales.
            // Así se rechazan negativos, letras y notación científica.
            if (texto.matches("\\d+(\\.\\d{1,2})?")) {
                double precio = Double.parseDouble(texto);

                if (precio <= 999999.99) {
                    return precio;
                }
            }

            System.out.println("Precio inválido. Ejemplo permitido: 1500.50");
        }
    }

    // Lee una respuesta de sí o no y la convierte en un valor booleano.
    public static boolean leerResp(String mensaje) {
        while (true) {
            System.out.println(mensaje);
            String respuesta = entrada.nextLine().trim();

            if (respuesta.equalsIgnoreCase("s")) {
                return true;
            } else if (respuesta.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Respuesta no válida. Escribe s o n.");
            }
        }
    }
}
