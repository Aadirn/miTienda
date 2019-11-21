package src.menusCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.models.Clientes;
import src.models.comun.DbObject;
import src.models.comun.Tools;

public class menuClientes {

	private String opcion;
	private Scanner keyboard;
	private int sel;

	private List<DbObject> clientes = new ArrayList<DbObject>();
	private Clientes cli = new Clientes();

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

		clientes = cli.list();

		keyboard = new Scanner(System.in);
		do {
			System.out.println("~~~~~~~~~~MENÚ CLIENTES~~~~~~~~~\n");
			System.out.println("1.-Crear\n2.-Leer\n3.-Actualizar\n4.-Borrar\n5.-Atrás\n");
			System.out.println("Seleccione(1|2|3|4|5): ");

			opcion = keyboard.nextLine();
			if (!Tools.getInstance().isNumeric(opcion)) {
				System.out.println("Teclea un numero, capullo\n");
			} else {
				sel = Integer.valueOf(opcion);
				switch (sel) {

				case 1:
					System.out.println("Crear\n");
					createClient();
					break;
				case 2:
					System.out.println("Leer\n");
					listClients();
					break;
				case 3:
					System.out.println("Actualizar\n");
					actualizarClients();
					break;
				case 4:
					System.out.println("Borrar\n");
					deleteClients();
					break;
				case 5:
					System.out.println("Atras\n");
					menuMain.getInstance().display();
					break;
				default:
					System.out.println("ACCION NO VALIDA!\n");
				}
			}
		} while (true);
	}

	private void listClients() {

		clientes = cli.list();

		for (int i = 0; i < clientes.size(); i++) {
			System.out.println(clientes.get(i).getId() + ".-" + clientes.get(i) + "\n");
		}
	}

	private void createClient() {// TODO: COMPROBACIONES DE TODO
		System.out.println("Introduzca nombre del cliente\n");
		cli.setNombre(keyboard.nextLine());
		keyboard.reset();
		System.out.println("Introduzca el DNI\n");
		cli.setDni(keyboard.nextLine());
		keyboard.reset();
		System.out.println("Introduzca direccion\n");
		cli.setDireccion(keyboard.nextLine());
		keyboard.reset();
		System.out.println("Introduzca telefono\n");
		cli.setTelefono(keyboard.nextLine());
		keyboard.reset();
		System.out.println("Introduzca e-mail\n");
		cli.setEmail(keyboard.nextLine());
		keyboard.reset();

		cli.save();

	}

	private void deleteClients() {
		listClients();
		System.out.println("Seleccione que cliente quiere borrar\n");
		opcion = keyboard.nextLine();
		/*
		 * if(!Tools.getInstance().isNumeric(opcion)||Integer.valueOf(opcion)<0||Integer
		 * .valueOf(opcion)>=productos.get(productos.size()-1).getId()) {
		 * System.out.println("No existe ningun Producto con esa ID\n"); deleteProd(); }
		 */
		sel = Integer.valueOf(opcion);
		// prod.getByid(sel).delete();
		clientes.get(sel).delete();
	}

	private void actualizarClients() {
		System.out.println("Seleccione el cliente que quiera actualizar\n");
		listClients();
		opcion = keyboard.nextLine();
		sel = Integer.valueOf(opcion);
		cli = (Clientes) cli.getByid(sel);
		do {
			System.out.println("¿Que quieres cambiar?");
			System.out.println(
					"1.-Nombre\n2.-DNI\n3.-Direcciones\n4.-Telefono\n5.-E-mail\n6.-Guardar Cambios\n7.-Atrás\n");
			keyboard.reset();
			opcion = keyboard.nextLine();
			sel = Integer.valueOf(opcion);
			switch (sel) {
			case 1:
				System.out.println("Escriba el nuevo nombre: \n");
				opcion = keyboard.nextLine();
				cli.setNombre(opcion);
				keyboard.reset();
				break;
			case 2:
				System.out.println("Escriba el nuevo DNI: \n");
				opcion = keyboard.nextLine();
				cli.setDni(opcion);
				keyboard.reset();

				break;
			case 3:
				System.out.println("Escriba la nueva direccion: \n");
				opcion = keyboard.nextLine();
				cli.setDireccion(opcion);
				keyboard.reset();

				break;
			case 4:
				System.out.println("Escriba el nuevo telefono: \n");
				opcion = keyboard.nextLine();
				cli.setTelefono(opcion);
				keyboard.reset();
				break;
			case 5:
				System.out.println("Escriba el nuevo e-mail: \n");
				opcion = keyboard.nextLine();
				cli.setEmail(opcion);
				keyboard.reset();
				break;
			case 6:
				System.out.println("Guardando...\n");
				cli.save();
				break;
			case 7:
				System.out.println("Volviendo a Menú Clientes\n");
				menuClientes.getInstance().display();
				break;
			default:
				break;
			}
		} while (true);

	}
}
