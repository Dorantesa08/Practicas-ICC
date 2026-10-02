public class Cotizador {
    public static void main(String[] args) {

        int precioCliente1 = 12899;
        String cliente1 = "Robbie Valentino";
        char clasificacionCliente1 = 'E';

        double tasaAnual = 0.15;
        double plazoCliente1 = 21.0 / 12; // Plazo en años

        // se saca el interes, el total a pagar y las mensualidades
        double interes = precioCliente1 * tasaAnual * plazoCliente1;
        double total = precioCliente1 + interes;
        double mensualidad = total / 21.0;

        // Impresión en pantalla usando printf
        System.out.printf("Cliente: %s (%c)\n", cliente1, clasificacionCliente1);
        System.out.printf("Interes: $%.2f\n", interes);
        System.out.printf("Total: $%.2f\n", total);
        System.out.printf("Pago mensual: $%.2f\n", mensualidad);
    }
}