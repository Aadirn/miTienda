package src.menusCrud;

import java.util.Scanner;

public class menuMain {

	private int opcion;
	private Scanner keyboard;
	
	private static menuMain instance;

	private menuMain() {
	}

	public static menuMain getInstance() {
		if (instance == null) {
			instance = new menuMain();
		}
		return instance;
	}

	public void display() {

		keyboard = new Scanner(System.in);
		do {
			System.out.println("~~~~~~~~~~MENÚ~~~~~~~~~\n");
			System.out.println("1.-Productos\n2.-Clientes\n3.-Categorias\n4.-Facturas\n5.-Facturas Linea\n6.-Salir\\n");
			System.out.println("Seleccione(1|2|3|4|5): ");

			opcion = Integer.parseInt(keyboard.nextLine());
			switch (opcion) {

			case 1:
				menuProducto.getInstance().display();
				break;
			case 2:
				menuClientes.getInstance().display();
				break;
			case 3:
				menuCategoria.getInstance().display();
				break;
			case 4:
				menuFacturas.getInstance().display();
				break;
			case 5:
				
				break;
			case 6:
				System.out.println("Has seleccionado salir. Chaito\n");
				
				System.exit(0);
				break;
			default:
				System.out.println("ACCION NO VALIDA!\n");
			}
		} while (true);
	}
}
