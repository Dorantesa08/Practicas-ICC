import java.util.Scanner;

public class PiInteractivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalDardos = 0;

        // Recibir entrada que logre ser válida
        while (true) {
            System.out.print("Cantidad de dardos a lanzar (entero mayor a 0): ");
            
            // Verifica si la entrada es un número entero
            if (sc.hasNextInt()) {
                totalDardos = sc.nextInt();
                
                // Verifica que sea estrictamente positivo y mayor a cero
                if (totalDardos > 0) {
                    break; //Salir del ciclo de validación
                } else {
                    System.out.println("Error: La cantidad de dardos debe ser mayor a 0.");
                }
            } else {
                System.out.println("Error: Se debe ingresar un entero.");
                sc.next(); // Limpia la palabra o texto no admitido
            }
        }

        // Algoritmo de Monte Carlo Práctica 5
        int dentroCirculo = 0;
        int i = 0;

        while (i < totalDardos) {
            double x = Math.random();
            double y = Math.random();

            if (x * x + y * y <= 1.0) {
                dentroCirculo++;
            }
            i++;
        }

        double estimacionPi = 4.0 * dentroCirculo / totalDardos;

        // Impresión en términal
        System.out.println("Total de dardos lanzados: " + totalDardos);
        System.out.println("Dardos dentro del círculo: " + dentroCirculo);
        System.out.printf("Estimación final de PI: %.6f\n", estimacionPi);

        sc.close();
    }
}