import java.util.Scanner;

public class BinarioInteractivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char respuesta = 'S';

        // Repetir ciclo si se quiere
        while (respuesta == 'S' || respuesta == 's') {
            int numero = -1;

            // Condición: Debe ser entero y mayor o igual a 0
            while (true) {
                System.out.print("Coloca un número entero positivo (>= 0): ");
                if (sc.hasNextInt()) {
                    numero = sc.nextInt();
                    if (numero >= 0) {
                        break; // Dato aceptado
                    } else {
                        System.out.println("Error: El número no puede ser negativo.");
                    }
                } else {
                    System.out.println("Error: Debes colocar un número entero.");
                    sc.next(); // Limpiamos la entrada no válida
                }
            }

            // Conversión a binario
            String binario = "";
            if (numero == 0) {
                binario = "0";
            } else {
                int cociente = numero;
                while (cociente > 0) {
                    int residuo = cociente % 2;
                    cociente = cociente / 2;
                    // Se concatena el residuo al incio de la cadena para obtener el orden requerido
                    binario = residuo + binario;
                }
            }

            System.out.println("El número " + numero + " en binario es: " + binario);

            // Preguntamos si quiere hacer otra conversión
            System.out.print("\n¿Gustas convertir otro número? (S/N): ");
            respuesta = sc.next().charAt(0);
            System.out.println();
        }

        System.out.println("¡Fin del programa!");
        sc.close();
    }
}