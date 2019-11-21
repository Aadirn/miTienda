package src.menusCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.models.FacturaLinea;
import src.models.comun.DbObject;
import src.models.comun.Tools;

public class menuFacturaLinea {

	private String opcion;
	private Scanner keyboard;
	private int sel;

	private List<DbObject> facturasLin = new ArrayList<DbObject>();
	private FacturaLinea factLin = new FacturaLinea();

	private static menuFacturaLinea instance;

	private menuFacturaLinea() {
	}

	public static menuFacturaLinea getInstance() {
		if (instance == null) {
			instance = new menuFacturaLinea();
		}
		return instance;
	}

	public void display() {

		facturasLin = factLin.list();

		keyboard = new Scanner(System.in);
		do {
			System.out.println("~~~~~~~~~~MENÚ FACTURA LINEA~~~~~~~~~\n");
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
					createFactLin();
					break;
				case 2:
					System.out.println("Leer\n");
					listFactLin();
					break;
				case 3:
					System.out.println("Actualizar\n");
					actualizarFactLin();
					break;
				case 4:
					System.out.println("Borrar\n");
					deleteFactLin();
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

	private void listFactLin() {

		facturasLin = factLin.list();

		for (int i = 0; i < facturasLin.size(); i++) {
			System.out.println(facturasLin.get(i).getId() + ".-" + facturasLin.get(i) + "\n");
		}
	}

	private void createFactLin() {// TODO: COMPROBACIONES DE TODO
		System.out.println("Selecciona el ID de la factura a la que pertenece\n");
		factLin.setId_factura(menuController.getInstance().elegirObj(new FacturaLinea()).getId());
		System.out.println("Escriba el nombre de esta factura linea");
		factLin.setNombre(keyboard.nextLine());
		keyboard.reset();
		System.out.println("Escriba el precio de esta factura linea");
		factLin.setPrecio(Integer.valueOf(keyboard.nextLine()));
		keyboard.reset();

		factLin.save();

	}

	private void deleteFactLin() {
		listFactLin();
		System.out.println("Seleccione que cliente quiere borrar\n");
		opcion = keyboard.nextLine();
		/*
		 * if(!Tools.getInstance().isNumeric(opcion)||Integer.valueOf(opcion)<0||Integer
		 * .valueOf(opcion)>=productos.get(productos.size()-1).getId()) {
		 * System.out.println("No existe ningun Producto con esa ID\n"); deleteProd(); }
		 */
		sel = Integer.valueOf(opcion);
		// prod.getByid(sel).delete();
		facturasLin.get(sel).delete();
	}

	private void actualizarFactLin() {
		System.out.println("Seleccione el cliente que quiera actualizar\n");
		listFactLin();
		opcion = keyboard.nextLine();
		sel = Integer.valueOf(opcion);
		factLin = (FacturaLinea) factLin.getByid(sel);
		do {
			System.out.println("¿Que quieres cambiar?");
			System.out.println("1.-ID\n2.-Nombre\n3.-Precio\n4.-Guardar Cambios\n5.-Atrás\n");
			keyboard.reset();
			opcion = keyboard.nextLine();
			sel = Integer.valueOf(opcion);
			switch (sel) {
			case 1:
				System.out.println("Seleccione el nuevo ID al que pertenece: \n");
				factLin.setId_factura(menuController.getInstance().elegirObj(new FacturaLinea()).getId());
				break;
			case 2:
				System.out.println("Escriba el nuevo nombre: \n");
				opcion = keyboard.nextLine();
				factLin.setNombre(opcion);
				;
				keyboard.reset();

				break;
			case 3:
				System.out.println("Escriba el nuevo precio: \n");
				opcion = keyboard.nextLine();
				factLin.setPrecio(Integer.valueOf(opcion));
				keyboard.reset();

				break;
			case 4:
				System.out.println("Guardando...\n");
				factLin.save();
				break;
			case 5:
				System.out.println("Volviendo a Menú Factura Linea\n");
				menuFacturaLinea.getInstance().display();
				break;
			default:
				break;
			}
		} while (true);

	}
}
