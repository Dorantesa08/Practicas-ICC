public class PrecisionPi {

    public static void main(String[] args) {
        // Variable de tolerancia pedida en el punto 2
        double tolerancia = 0.001;

        int dardos = 0;
        int dardosDentro = 0;
        double piEstimado = 0.0;
        double errorAbsoluto = 1.0; // Se inicia mayor a la tolerancia para entrar al ciclo

        // Ciclo while mientras el error sea >= tolerancia
        while (errorAbsoluto >= tolerancia) {
            dardos++;
            double x = Math.random();
            double y = Math.random();

            if (x * x + y * y <= 1.0) {
                dardosDentro++;
            }

            piEstimado = 4.0 * dardosDentro / dardos;
            errorAbsoluto = Math.abs(Math.PI - piEstimado);
        }

        // Imprimir
        System.out.println("Tolerancia: " + tolerancia);
        System.out.println("Dardos necesarios: " + dardos);
        System.out.println("Estimacion final de Pi: " + piEstimado);
        System.out.println("Error absoluto: " + errorAbsoluto);
    }
}