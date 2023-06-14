import java.util.Scanner;

public class Wordle {

	public static void main(String[] args) {
		// Wordle:
		// + La palabra tiene que ser de 5 letras.
		// + Solo se pueden tener 6 intentos para jugar.
		// + Que cada letra que se encuentra en la palabra y en la posicion correcta se
		// muestre.
		// + Que cada letra que se encuentra en la palabra y pero no en la posicion
		// correcta se muestra.
		// + Que cada letra que no se encuentra en la palabra lo muestre.

		// Creamos este array con todas las palabras disponibles para jugar.
		String[] caja = { "aereo", "avion", "abeto", "boxer", "burro", "bufet", "bueno", "bucal", "bingo", "comic",
				"conos", "debil", "dulce", "drama", "fosil", "femur", "fresa", "freno", "guiso", "guapo", "gusto",
				"grumo", "hurto", "huevo", "hotel", "justo", "jugar", "jarra", "karma", "lunar", "movil", "multa",
				"morir", "novel", "paula", "regla", "solar", "tunel", "tarta", "video", "valle", "zanja", "arnes",
				"ebrio", "extra", "euros", "esqui", "ester", "error", "actor", "equis", "encia", "envio", "elite",
				"edgar", "islam", "islas", "index", "ozono", "oxido", "ovalo", "otoño", "ostra", "ostia", "admin",
				"ojera", "jorge", "ramon", "messi", "nadal", "mando", "arbol", "gomas", "curry", "alpha", "iluso",
				"cable", "beber", "bizum", "belen", "brazo", "kappa", "guiño", "marta" };
		int p = (int) (Math.random() * (caja.length - 1)); // Creamos la variable p que sera la encargada de seleccionar
															// una palabra random de la caja.
		String palabra = caja[p]; // En la variable palabra la inicializamos con la palabra que p haya
									// seleccionado de la caja.
		Scanner lector = new Scanner(System.in);
		int intentos = 6; // Limite de intentos
		String respuesta = "";

		System.out.println("BIENVENIDO A WORDLE");
		System.out.println("Antes de empezar te explico el mecanismo:");
		System.out.println(
				"Tendras que adivinar la palabra secreta, si aciertas una letra en la posicion correcta se mostrara con una V, si aciertas la letra pero no esta en la posicion correcta se mostrara con una C, si una letra no esta en la palabra se mostrara con X.");

		while (!respuesta.equals(palabra) && intentos > 0) { // Bucle while para que se ejecute mientras la respuesta
																// sea diferente de la palabra y los intentos sean
																// mayores a 0.
			System.out.println("Tienes " + intentos + " intentos restantes.");
			respuesta = lector.nextLine();
			if (respuesta.length() > 5 || respuesta.length() < 5) {
				System.out.println("AVISO: La palabra tiene que ser de 5 letras");
			} else {

				for (int i = 0; i < palabra.length(); i++) {
					if (respuesta.charAt(i) == palabra.charAt(i)) { // Verifica letra por letra si esta en la palabra y
																	// en la posicion correcta.
						System.out.print("V |");

					} else if (palabra.contains(Character.toString(respuesta.charAt(i)))) { // Agregamos el metodo
																							// .contains el cual se
																							// encarga de revisar si una
																							// subcadena esta en la
																							// cadena, no en la posicion
																							// exacta (en este caso la
																							// subcadena es cada letra,
																							// la cual convertimos de
																							// String a Char con
																							// Character)
						System.out.print("C |");
					} else {
						System.out.print("X |"); // En el caso de que ninguno sea, la letra no esta, por consecuente se
													// marca X.
					}
				}

				System.out.println("");
				intentos--; // Se restara un intento en cada pasada y se repitira el while.
			}
		}

		System.out.println("");

		if (respuesta.equals(palabra)) {
			System.out.println("Ya era hora que adivinaras, felicidades!");
		} else {
			System.out.println("JAJA como no adivinaste, la palabra era: " + palabra);
		}

	}

}