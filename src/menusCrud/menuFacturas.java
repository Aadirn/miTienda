package src.menusCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.models.Clientes;
import src.models.Factura;
import src.models.comun.DbObject;
import src.models.comun.Tools;

public class menuFacturas {

	private String opcion;
	private Scanner keyboard;
	private int sel;

	private List<DbObject> facturas = new ArrayList<DbObject>();
	private Factura fact = new Factura();
	
	private static menuFacturas instance;

	private menuFacturas() {
	}

	public static menuFacturas getInstance() {
		if (instance == null) {
			instance = new menuFacturas();
		}
		return instance;
	}

	public void display() {

		facturas = fact.list();

		keyboard = new Scanner(System.in);
		do {
			System.out.println("~~~~~~~~~~MENÚ FACTURAS~~~~~~~~~\n");
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
					createFact();
					break;
				case 2:
					System.out.println("Leer\n");
					listFact();
					break;
				case 3:
					System.out.println("Actualizar\n");
					actualizarFact();
					break;
				case 4:
					System.out.println("Borrar\n");
					deleteFact();
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

	private void listFact() {

		facturas = fact.list();

		for (int i = 0; i < facturas.size(); i++) {
			System.out.println(facturas.get(i).getId() + ".-" + facturas.get(i) + "\n");
		}
	}

	private void createFact() {// TODO: COMPROBACIONES DE TODO
		System.out.println("Seleccione ID del cliente al que pertenece esta factura\n");
		fact.setId_cliente(menuController.getInstance().elegirObj(new Clientes()).getId());
		keyboard.reset();
		System.out.println("Introduzca la serie de esta factura\n");
		fact.setSerie(Integer.parseInt(keyboard.nextLine()));
		keyboard.reset();
		//Problema con la fecha en sql, asi que...
		fact.setFecha(null);

		fact.save();

	}

	private void deleteFact() {
		listFact();
		System.out.println("Seleccione que factura quiere borrar\n");
		opcion = keyboard.nextLine();
		/*
		 * if(!Tools.getInstance().isNumeric(opcion)||Integer.valueOf(opcion)<0||Integer
		 * .valueOf(opcion)>=productos.get(productos.size()-1).getId()) {
		 * System.out.println("No existe ningun Producto con esa ID\n"); deleteProd(); }
		 */
		sel = Integer.valueOf(opcion);
		// prod.getByid(sel).delete();

		fact = (Factura) fact.getByid(sel);
		fact.delete();
	}

	private void actualizarFact() {
		System.out.println("Seleccione la factura que quiera actualizar\n");
		listFact();
		opcion = keyboard.nextLine();
		sel = Integer.valueOf(opcion);
		fact = (Factura) fact.getByid(sel);
		do {
			System.out.println("¿Que quieres cambiar?");
			System.out.println(
					"1.-ID Cliente\n2.-Fecha (No implementado)\n3.-Serie\n4.-Guardar Cambios\n5.-Atrás\n");
			keyboard.reset();
			opcion = keyboard.nextLine();
			sel = Integer.valueOf(opcion);
			switch (sel) {
			case 1:
				System.out.println("Seleccione el nuevo cliente: \n");
				fact.setId_cliente(menuController.getInstance().elegirObj(new Clientes()).getId());
				keyboard.reset();
				break;
			case 2:
				System.out.println("Escriba la nueva fecha: (No Implementado) \n");
				break;
			case 3:
				System.out.println("Escriba la nueva serie: \n");
				opcion = keyboard.nextLine();
				fact.setSerie(Integer.valueOf(opcion));
				keyboard.reset();

				break;
			case 4:
				System.out.println("Guardando...\n");
				fact.save();
				break;
			case 5:
				System.out.println("Volviendo a Menú Facturas\n");
				menuFacturas.getInstance().display();
				break;
			default:
				break;
			}
		} while (true);

	}
}
