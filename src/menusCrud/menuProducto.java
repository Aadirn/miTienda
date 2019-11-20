package src.menusCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.tools.Tool;

import src.models.Categoria;
import src.models.Producto;
import src.models.comun.DbObject;
import src.models.comun.Tools;

public class menuProducto {

	private String opcion;
	private Scanner keyboard;
	private int sel;

	private static menuProducto instance;
	private List<DbObject> productos = new ArrayList<DbObject>();
	private Producto prod = new Producto();

	private menuProducto() {
	}

	public static menuProducto getInstance() {
		if (instance == null) {
			instance = new menuProducto();
		}
		return instance;
	}

	public void display() {
		
		productos=prod.list();
		
		keyboard = new Scanner(System.in);
		do {
			System.out.println("~~~~~~~~~~MENÚ PRODUCTO~~~~~~~~~\n");
			System.out.println("1.-Crear\n2.-Leer\n3.-Actualizar\n4.-Borrar\n5.-Atrás\n");
			System.out.println("Seleccione(1|2|3|4|5): ");

			opcion = keyboard.nextLine();
			if (!Tools.getInstance().isNumeric(opcion)) {
				System.out.println("Teclea un numero, capullo\n");
			} else {
				sel=Integer.valueOf(opcion);
				switch (sel) {

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
					actualizarProd();
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
			}
		} while (true);
	}

	private void listProd() {

		productos = prod.list();

		for (int i = 0; i < productos.size(); i++) {
			System.out.println(productos.get(i).getId() + ".-" + productos.get(i) + "\n");
		}
	}

	private void createProd() {// TODO: COMPROBACIONES DE TODO
		System.out.println("Introduzca nombre de Producto\n");
		prod.setNombre(keyboard.nextLine());
		keyboard.reset();
		System.out.println("Introduzca precio de Producto (Centimos)\n");
		prod.setPrecio(Integer.parseInt(keyboard.nextLine()));
		keyboard.reset();
		System.out.println("Introduzca stock de Producto\n");
		prod.setStock(Integer.parseInt(keyboard.nextLine()));
		keyboard.reset();
		System.out.println("Seleccione a que categoria pertenece el producto");
		prod.setId_categoria(menuController.getInstance().elegirObj(new Categoria()).getId());

		prod.save();

	}

	private void deleteProd() {
		listProd();
		System.out.println("Seleccione que producto quiere borrar\n");
		opcion = keyboard.nextLine();
		if(!Tools.getInstance().isNumeric(opcion)||Integer.valueOf(opcion)<0||Integer.valueOf(opcion)>=productos.get(productos.size()-1).getId()) {
			System.out.println("No existe ningun Producto con esa ID\n");
			deleteProd();
		}
		sel=Integer.valueOf(opcion);
		prod.getByid(sel).delete();
	}

	private void actualizarProd() {
		System.out.println("Seleccione el producto que quiera actualizar\n");
		listProd();
		opcion = Integer.parseInt(keyboard.nextLine());
		prod = (Producto) prod.getByid(opcion);
		String teclado;
		do {
			System.out.println("¿Que quieres cambiar?");
			System.out.println("1.-Nombre\n2.-Precio\n3.-Stock\n4.-ID Categoria\n5.-Guardar Cambios\n6.-Atrás\n");
			keyboard.reset();
			opcion = Integer.parseInt(keyboard.nextLine());
			switch (opcion) {
			case 1:
				System.out.println("Escriba el nuevo nombre: \n");
				teclado = keyboard.nextLine();
				prod.setNombre(teclado);
				keyboard.reset();
				break;
			case 2:
				System.out.println("Escriba el nuevo precio: \n");
				teclado = keyboard.nextLine();
				prod.setPrecio(Integer.parseInt(teclado));
				keyboard.reset();

				break;
			case 3:
				System.out.println("Escriba el nuevo stock: \n");
				teclado = keyboard.nextLine();
				prod.setStock(Integer.parseInt(teclado));
				keyboard.reset();

				break;
			case 4:
				System.out.println("Seleccione la nueva categoria de este producto: \n");
				prod.setId_categoria(menuController.getInstance().elegirObj(new Categoria()).getId());

				break;
			case 5:
				System.out.println("Guardando...\n");
				prod.save();
				break;
			case 6:
				System.out.println("Volviendo a Menú Productos\n");
				menuProducto.getInstance().display();
				break;
			default:
				break;
			}
		} while (true);

	}

}
