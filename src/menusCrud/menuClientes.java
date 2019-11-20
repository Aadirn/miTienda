package src.menusCrud;

import java.util.Scanner;

public class menuClientes {

	private boolean salir;
	private int opcion;
	private Scanner keyboard;

	private static menuClientes instance;

	private menuClientes() {
	}

	public static menuClientes getInstance() {
		if (instance == null) {
			instance = new menuClientes();
		}
		return instance;
	}

	public void display() {

		keyboard = new Scanner(System.in);
		do {
			System.out.println("~~~~~~~~~~MEN� CLIENTES~~~~~~~~~\n");
			System.out.println("1.-Crear\n2.-Leer\n3.-Actualizar\n4.-Borrar\n5.-Atr�s\n");
			System.out.println("Seleccione(1|2|3|4|5): ");

			opcion = Integer.parseInt(keyboard.nextLine());
			salir = false;
			switch (opcion) {

			case 1:
				System.out.println("Crear\n");
				break;
			case 2:
				System.out.println("Leer\n");
				break;
			case 3:
				System.out.println("Actualizar\n");
				break;
			case 4:
				System.out.println("Borrar\n");
				break;
			case 5:
				System.out.println("Atras\n");
				menuMain.getInstance().display();
				break;
			default:
				System.out.println("ACCION NO VALIDA!\n");
			}
		} while (!salir);
	}
}
