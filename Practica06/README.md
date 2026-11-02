Práctica 06

En esta práctica estuve trabajando con la lectura de datos desde la consola usando Scanner en Java. La idea principal fue meterle validaciones al programa para que no se trabe o se rompa si llego a poner letras en lugar de números o valores negativos, y con eso mismo armar el sistema de préstamos para la Cabaña del Misterio.

Estructura de las carpetas

- src/: Aquí guardé todo el código fuente en Java (PiInteractivo.java, BinarioInteractivo.java y CabanaDelMisterio.java).
- bin/: Es la carpeta donde se guardan los archivos compilados .class.
- docs/images/: Es la carpeta donde metí las fotos de los 3 escenarios de prueba que se pidieron y la práctica en pdf


Lo que hice en cada actividad

Actividad 1.1: Dardos a la medida (PiInteractivo.java)
Estuve investigando sobre nextInt() y hasNextInt() para ver cómo validar lo que ingresa el usuario. El método nextInt() lee números enteros, pero si metes un texto o decimal el programa truena feo tirando la excepción InputMismatchException y la entrada se queda atorada en la memoria. El método hasNextInt() me sirvió como un filtro previo que regresa un true o false para revisar si el dato sí es un entero válido antes de leerlo, evitando que falle todo. Modifiqué la estimación de Pi usando un ciclo while(true) junto con hasNextInt() para obligar a que el número de dardos sea un entero mayor a cero.

Actividad 1.2: Decimal a binario (BinarioInteractivo.java)
Hice el programa que convierte números enteros a binario dividiendo entre 2 y guardando los residuos. Validé que solo te acepte números mayores o iguales a 0 y le agregué un ciclo con sc.next().charAt(0) para que te pregunte al final si quieres seguir haciendo más conversiones (S/N), así no hay que estar ejecutando el programa desde la terminal a cada rato.

Actividad 2.1: Programa final para La Cabaña del Misterio (CabanaDelMisterio.java)
Armé el sistema para manejar los préstamos pidiendo los datos uno por uno desde la consola: nombre, tipo de cliente (donde depende si es P, E o R para hacer sus descuentos o recargos), capital, tasa base y plazo en meses. Encerré el menú en un ciclo con 4 opciones para ver el resumen, cambiar el capital, comparar el interés simple contra el compuesto y salir. Además le configuré los contadores para que el programa se cierre solo si llegas a 5 operaciones o si te equivocas 3 veces seguidas en las opciones del menú.


Capturas de prueba

- 2.1-escenario1.png: Es la prueba con el cliente Robbie Valentino, capital de $12,899.00 a 21 meses, cambiando el capital a $14,800.00.
- 2.1-escenario2.png: Mi prueba personal simulando comprar la laptop ROG Strix SCAR 18 (2026) con un costo de $129,999.00 a 25 meses, ajustando el capital a $135,000.00 hasta completar las 5 operaciones permitidas.
- 2.1-escenario3.png: La prueba de errores donde puse la letra 'G' en tipo de cliente, -100 en capital y metí 3 opciones mal en el menú ('8', '15', '2008') para comprobar que el programa sí se cierra solo al llegar al límite de fallos.

COnclusión

Sinceramente la práctica se me hizo bastante difícil y me perdía rápido, me tardé rato buscando cómo solucionar los errores. Tener todo metido dentro del método main hace que sea pesado rastrear las cosas cuando algo falla. Lo que más noté que se repite en todo el código son los bloques while con hasNextDouble() y hasNextInt() para estar checando los datos, y volver a escribir las fórmulas del interés simple y compuesto tanto en la opción de resumen como en la de comparativa.