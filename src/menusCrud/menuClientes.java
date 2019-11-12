package src.menusCrud;

import java.util.Scanner;

public class menuClientes {

	private boolean salir;
	private int opcion;
	private Scanner keyboard;

	public menuClientes() {

	}

	public void display() {

		keyboard = new Scanner(System.in);
		do {
			System.out.println("~~~~~~~~~~MENÚ CLIENTES~~~~~~~~~\n");
			System.out.println("1.-Crear\n2.-Leer\n3.-Actualizar\n4.-Borrar\n5.-Atrás\n");
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
				System.out.println("Actualizar\n");// categorias();
				break;
			case 4:
				System.out.println("Borrar\n");// facturas();
				break;
			case 5:
				System.out.println("Atras\n");// salirApp();
				menuMain mM = new menuMain();
				mM.display();
				break;
			default:
				System.out.println("ACCION NO VALIDA!\n");
			}
		} while (!salir);
	}
}
