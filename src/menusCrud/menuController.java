package src.menusCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.models.Categoria;
import src.models.Producto;
import src.models.comun.DbObject;

public class menuController {

	private static menuController instance;
	private List<DbObject> lista= new ArrayList<DbObject>();
	private Scanner keyboard = new Scanner(System.in);

	private menuController() {
	}

	public static menuController getInstance() {
		if (instance == null) {
			instance = new menuController();
		}
		return instance;
	}
	
	public DbObject elegirObj(DbObject obj) {
		
		lista=obj.list();
		
		for(int i=0;i<lista.size();i++) {
			System.out.println(lista.get(i).getId()+".-"+lista.get(i)+"\n");
		}
		
		System.out.println("Seleccione la ID del objeto que desee\n");
		
		int idPedido = Integer.parseInt(keyboard.nextLine());
		
		DbObject peticion = obj.getByid(idPedido);
		
		return peticion;
		
		
	}
	
	public Producto selectProducto() {
		return (Producto) menuController.getInstance().elegirObj(new Producto());
	}
	
	public Categoria selectCategoria() {
		return (Categoria) menuController.getInstance().elegirObj(new Categoria());
	}

}
