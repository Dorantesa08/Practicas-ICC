import java.util.Scanner;

public class CabanaDelMisterio {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Programa de la Cabaña del misterio");

        // 1. Registro y nombre validos
        System.out.print("Nombre completo del cliente: ");
        String nombre = scanner.nextLine();

        // 2. Registro del tipo de cliente y su validación
        char tipoCliente = ' ';
        boolean tipoValido = false;
        while (!tipoValido) {
            System.out.print("Tipo de cliente (P = Preferente, E = Estándar, R = Riesgoso): ");
            String entrada = scanner.nextLine().trim().toUpperCase();
            if (entrada.length() == 1 && (entrada.charAt(0) == 'P' || entrada.charAt(0) == 'E' || entrada.charAt(0) == 'R')) {
                tipoCliente = entrada.charAt(0);
                tipoValido = true;
            } else {
                System.out.println("Opción no válida. Debes ingresar P, E o R.");
            }
        }

        // 3. Registro del capital y su validación
        double capital = 0;
        boolean capitalValido = false;
        while (!capitalValido) {
            System.out.print("Capital del préstamo ($): ");
            if (scanner.hasNextDouble()) {
                capital = scanner.nextDouble();
                if (capital > 0) {
                    capitalValido = true;
                } else {
                    System.out.println("El capital debe ser un valor mayor a cero.");
                }
            } else {
                System.out.println("Entrada inválida. Ingresa un número válido para el capital.");
                scanner.next(); // Limpiar entrada
            }
        }

        // 4. Registro de la tasa anual base y su validación
        double tasaBase = 0;
        boolean tasaValida = false;
        while (!tasaValida) {
            System.out.print("Tasa anual base (%): ");
            if (scanner.hasNextDouble()) {
                tasaBase = scanner.nextDouble();
                if (tasaBase > 0) {
                    tasaValida = true;
                } else {
                    System.out.println("La tasa debe ser mayor a cero.");
                }
            } else {
                System.out.println("Entrada inválida. Ingresa un número válido.");
                scanner.next();
            }
        }

        // 5. Registro de plazo en meses y validación
        int plazoMeses = 0;
        boolean plazoValido = false;
        while (!plazoValido) {
            System.out.print("Plazo en meses: ");
            if (scanner.hasNextInt()) {
                plazoMeses = scanner.nextInt();
                if (plazoMeses > 0) {
                    plazoValido = true;
                } else {
                    System.out.println("El plazo debe ser mayor a cero.");
                }
            } else {
                System.out.println("Entrada inválida. Ingresa un número entero.");
                scanner.next();
            }
        }

        // Ajuste de tasa según el tipo de cliente
        double tasaFinal = tasaBase;
        if (tipoCliente == 'P') {
            tasaFinal = tasaBase * 0.90; // 10% de descuento
        } else if (tipoCliente == 'R') {
            tasaFinal = tasaBase * 1.15; // 15% de recargo
        }

        // 6. Límite de 5 operaciones o 3 errores en el Menú
        int operaciones = 0;
        int errores = 0;
        final int MAX_OPERACIONES = 5;
        final int MAX_ERRORES = 3;

        while (operaciones < MAX_OPERACIONES && errores < MAX_ERRORES) {
            System.out.println("\nMENÚ DE OPCIONES (Operación " + (operaciones + 1) + " de " + MAX_OPERACIONES + ")");
            System.out.println("1. Ver resumen actual del préstamo");
            System.out.println("2. Modificar capital del préstamo");
            System.out.println("3. Comparar Interés Simple vs. Compuesto");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción (1-4): ");

            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("\n--- RESUMEN DEL PRÉSTAMO ---");
                        System.out.println("Cliente: " + nombre + " (" + tipoCliente + ")");
                        System.out.println("Capital: $" + capital);
                        System.out.println("Tasa Final Aplicada: " + tasaFinal + "%");
                        System.out.println("Plazo: " + plazoMeses + " meses");
                        
                        double tiempoAños = plazoMeses / 12.0;
                        double interesSimple = capital * (tasaFinal / 100.0) * tiempoAños;
                        double montoSimple = capital + interesSimple;
                        double montoCompuesto = capital * Math.pow(1 + (tasaFinal / 100.0 / 12.0), plazoMeses);
                        
                        System.out.println("Monto Final (Simple): $" + montoSimple);
                        System.out.println("Monto Final (Compuesto): $" + montoCompuesto);
                        
                        operaciones++;
                        break;

                    case 2:
                        boolean nuevoCapitalValido = false;
                        while (!nuevoCapitalValido) {
                            System.out.print("\nIngresa el nuevo capital ($): ");
                            if (scanner.hasNextDouble()) {
                                double tempCapital = scanner.nextDouble();
                                if (tempCapital > 0) {
                                    capital = tempCapital;
                                    nuevoCapitalValido = true;
                                    System.out.println("¡Capital actualizado!");
                                } else {
                                    System.out.println("El capital debe ser mayor a cero.");
                                }
                            } else {
                                System.out.println("Entrada inválida.");
                                scanner.next();
                            }
                        }
                        operaciones++;
                        break;

                    case 3:
                        double tAños = plazoMeses / 12.0;
                        double intSimple = capital * (tasaFinal / 100.0) * tAños;
                        double mCompuesto = capital * Math.pow(1 + (tasaFinal / 100.0 / 12.0), plazoMeses);
                        double intCompuesto = mCompuesto - capital;
                        double diferencia = intCompuesto - intSimple;

                        System.out.println("\nInterés Simple: $" + intSimple);
                        System.out.println("Interés Compuesto: $" + intCompuesto);
                        System.out.println("Diferencia a favor del compuesto: $" + diferencia);

                        operaciones++;
                        break;

                    case 4:
                        System.out.println("\n¡Gracias por usar el sistema!");
                        scanner.close();
                        return;

                    default:
                        errores++;
                        System.out.println("Opción no válida. Llevas " + errores + " de " + MAX_ERRORES + " errores permitidos.");
                        break;
                }
            } else {
                errores++;
                System.out.println("Opción no válida. Llevas " + errores + " de " + MAX_ERRORES + " errores permitidos.");
                scanner.next(); // Limpiar entrada no entera
            }

            // Verificación del límite de errores
            if (errores >= MAX_ERRORES) {
                System.out.println("\nSe ha alcanzado el límite máximo de errores (" + MAX_ERRORES + "). El programa se cerrará.");
            } else if (operaciones >= MAX_OPERACIONES) {
                System.out.println("\nSe ha alcanzado el límite máximo de operaciones permitidas (" + MAX_OPERACIONES + "). El programa se cerrará.");
            }
        }

        scanner.close();
    }
}