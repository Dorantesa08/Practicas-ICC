public class EstimacionPi {
	public static void main(String[] args){
		
		//Cantidad total de dardos que se van a lanzar
		int totalDardos = 1000000; 
		int dardosDentroDelCirculo = 0;
		int numeroDeTiros = 0;

		//Se ocupa while para el tiro de dardos
		while (numeroDeTiros < totalDardos){
			//Se generan coordenadas aleatorias entre 0.0 y 1.0
			double x = Math.random();
			double y = Math.random();

			//Observar si cayó dentro dentro de este cuarto de círculo
			//x^2 + y^2 <= 1
			if ((x * x + y * y) <= 1.0){
				dardosDentroDelCirculo++; 
			}
			numeroDeTiros++;

		}
			//Estimación de Pi
			double estimacionPi = 4.0 * ((double) dardosDentroDelCirculo / totalDardos);

		//impresión
		System.out.println("Total de dardos lanzados:" + numeroDeTiros);
		System.out.println("Dardos dentro del círculo:" + dardosDentroDelCirculo);
		System.out.printf("Estimación de Pi: %.6f%n", estimacionPi);

	}
}