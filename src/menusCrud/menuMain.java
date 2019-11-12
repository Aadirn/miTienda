package src.menusCrud;

import java.util.Scanner;

public class menuMain {

	private boolean salir;
	private int opcion;
	private Scanner keyboard;

	public menuMain() {

	}

	public void display() {

		keyboard = new Scanner(System.in);
		do {
			System.out.println("~~~~~~~~~~MEN�~~~~~~~~~\n");
			System.out.println("1.-Productos\n2.-Clientes\n3.-Categorias\n4.-Facturas\n5.-Salir\n");
			System.out.println("Seleccione(1|2|3|4|5): ");

			opcion = Integer.parseInt(keyboard.nextLine());
			salir = false;
			switch (opcion) {

			case 1:
				menuProducto mP = new menuProducto();
				mP.display();
				break;
			case 2:
				menuClientes mC = new menuClientes();
				mC.display();
				break;
			case 3:
				menuCategoria mCat = new menuCategoria();
				mCat.display();
				break;
			case 4:
				menuFacturas mF = new menuFacturas();
				mF.display();
				break;
			case 5:
				System.out.println("SALIR\n");

				salir = true;
				break;
			default:
				System.out.println("ACCION NO VALIDA!\n");
			}
		} while (!salir);
	}
}
