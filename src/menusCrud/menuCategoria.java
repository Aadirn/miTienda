package src.menusCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.models.Categoria;
import src.models.comun.DbObject;
import src.models.comun.Tools;

public class menuCategoria {

	private String opcion;
	private Scanner keyboard;
	private int sel;

	private List<DbObject> categorias = new ArrayList<DbObject>();
	private Categoria cat = new Categoria();

	private static menuCategoria instance;

	private menuCategoria() {
	}

	public static menuCategoria getInstance() {
		if (instance == null) {
			instance = new menuCategoria();
		}
		return instance;
	}

	public void display() {

		categorias = cat.list();

		keyboard = new Scanner(System.in);
		do {
			System.out.println("~~~~~~~~~~MENÚ CATEGORIA~~~~~~~~~\n");
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
					createCat();
					break;
				case 2:
					System.out.println("Leer\n");
					listCat();
					break;
				case 3:
					System.out.println("Actualizar\n");
					actualizarCat();
					break;
				case 4:
					System.out.println("Borrar\n");
					deleteCat();
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

	private void listCat() {

		categorias = cat.list();

		for (int i = 0; i < categorias.size(); i++) {
			System.out.println(categorias.get(i).getId() + ".-" + categorias.get(i) + "\n");
		}
	}

	private void createCat() {// TODO: COMPROBACIONES DE TODO
		System.out.println("Introduzca nombre de la categoria\n");
		cat.setNombre(keyboard.nextLine());
		keyboard.reset();

		cat.save();

	}

	private void deleteCat() {
		listCat();
		System.out.println("Seleccione que categoria quiere borrar\n");
		opcion = keyboard.nextLine();
		/*
		 * if(!Tools.getInstance().isNumeric(opcion)||Integer.valueOf(opcion)<0||Integer
		 * .valueOf(opcion)>=productos.get(productos.size()-1).getId()) {
		 * System.out.println("No existe ningun Producto con esa ID\n"); deleteProd(); }
		 */
		sel = Integer.valueOf(opcion);
		// prod.getByid(sel).delete();
		categorias.get(sel).delete();
	}

	private void actualizarCat() {
		System.out.println("Seleccione la categoria que quiera actualizar\n");
		listCat();
		opcion = keyboard.nextLine();
		sel = Integer.valueOf(opcion);
		cat = (Categoria) cat.getByid(sel);

		System.out.println("Escriba el nuevo nombre: \n");
		opcion = keyboard.nextLine();
		cat.setNombre(opcion);
		keyboard.reset();
		cat.save();

	}
}
