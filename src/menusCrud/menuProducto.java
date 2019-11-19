package src.menusCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.models.Categoria;
import src.models.Producto;
import src.models.comun.DbObject;

public class menuProducto {

	private int opcion;
	private Scanner keyboard;

	private static menuProducto instance;
	private List<DbObject> productos = new ArrayList<DbObject>();
	private Producto prod;

	private menuProducto() {
	}

	public static menuProducto getInstance() {
		if (instance == null) {
			instance = new menuProducto();
		}
		return instance;
	}

	public void display() {

		keyboard = new Scanner(System.in);
		do {
			System.out.println("~~~~~~~~~~MENÚ PRODUCTO~~~~~~~~~\n");
			System.out.println("1.-Crear\n2.-Leer\n3.-Actualizar\n4.-Borrar\n5.-Atrás\n");
			System.out.println("Seleccione(1|2|3|4|5): ");

			opcion = Integer.parseInt(keyboard.nextLine());
			switch (opcion) {

			case 1:
				System.out.println("Crear\n");
				createProd();
				break;
			case 2:
				System.out.println("Leer\n");
				listProd();
				break;
			case 3:
				System.out.println("Actualizar\n");
				break;
			case 4:
				System.out.println("Borrar\n");
				deleteProd();
				break;
			case 5:
				System.out.println("Atras\n");
				menuMain.getInstance().display();
				break;
			default:
				System.out.println("ACCION NO VALIDA!\n");
			}
		} while (true);
	}

	private void listProd() {
		prod = new Producto();

		productos = prod.list();

		for (int i = 0; i < productos.size(); i++) {
			System.out.println(i+".-"+productos.get(i) + "\n");
		}
	}

	private void createProd() {// TODO: COMPROBACIONES DE TODO
		prod = new Producto();
		Categoria cat = new Categoria();
		System.out.println("Introduzca nombre de Producto\n");
		prod.setNombre(keyboard.nextLine());
		keyboard.reset();
		System.out.println("Introduzca precio de Producto (Centimos)\n");
		prod.setPrecio(Integer.parseInt(keyboard.nextLine()));
		keyboard.reset();
		System.out.println("Introduzca stock de Producto\n");
		prod.setStock(Integer.parseInt(keyboard.nextLine()));
		keyboard.reset();
		//System.out.println("Introduzca ID de Producto\n");
		prod.setId_categoria(cat.getId());
		
		prod.save();

	}
	
	private void deleteProd() {
		
		listProd();
		
		System.out.println("Seleccione que producto quiere borrar\n");
		opcion=Integer.parseInt(keyboard.nextLine());
		productos.get(opcion).delete();
		
		
	}

}
