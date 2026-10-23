public class CotizadorPines {
    public static void main(String[] args) {

        // Datos del cliente
        String cliente1 = "Robbie Valentino";
        int precioCliente1 = 12899;
        int meses = 21;
        char clasificacionCliente1 = 'E'; // Se cambia para las pruebas ('P', 'E', 'R')
        double tasaBase = 15.0;

        // Validacion de los datos de entrada
        if (precioCliente1 <= 0 || meses <= 0) {
            System.out.println("Error: El monto del prestamo y los meses deben ser mayores a cero.");
            return;
        }

        if (clasificacionCliente1 != 'P' && clasificacionCliente1 != 'E' && clasificacionCliente1 != 'R') {
            System.out.println("Error: Clasificacion de cliente no valida.");
            return;
        }

        // Ajuste de tasa segun el tipo de cliente
        double tasaAplicada = tasaBase;
        if (clasificacionCliente1 == 'P') {
            tasaAplicada = tasaBase - 2.0;
        } else if (clasificacionCliente1 == 'R') {
            tasaAplicada = tasaBase + 3.0;
        }

        // Calculo del interes simple
        double plazoEnAnios = meses / 12.0;
        double interesSimple = precioCliente1 * (tasaAplicada / 100.0) * plazoEnAnios;
        double totalSimple = precioCliente1 + interesSimple;

        // ACTIVIDAD 2.2: Interes compuesto usando ciclo for
        double tasaMensual = (tasaAplicada / 100.0) / 12.0;
        double saldoAcumulado = precioCliente1;

        System.out.println("Desglose mes por mes:");
        for (int i = 1; i <= meses; i++) {
            saldoAcumulado = saldoAcumulado * (1.0 + tasaMensual);
            System.out.printf("En el mes %d se tiene un saldo de %.2f\n", i, saldoAcumulado);
        }

        double totalCompuestoCiclo = saldoAcumulado;
        double interesCompuesto = totalCompuestoCiclo - precioCliente1;

        // ACTIVIDAD 2.2: Interes compuesto con formula directa Math.pow
        double totalCompuestoFormula = precioCliente1 * Math.pow(1.0 + tasaMensual, meses);

        // Impresion
        System.out.println("Cliente: " + cliente1 + " (" + clasificacionCliente1 + ")");
        System.out.println("Tasa aplicada: " + tasaAplicada + "%");
        System.out.println("Prestamo: $" + precioCliente1);
        System.out.println("Meses de pago: " + meses);
        System.out.printf("Interes simple: $%.2f\n", interesSimple);
        System.out.printf("Total con interes simple: $%.2f\n", totalSimple);
        System.out.printf("Interes compuesto: $%.2f\n", interesCompuesto);
        System.out.printf("Total con interes compuesto: $%.2f\n", totalCompuestoCiclo);
    }
}