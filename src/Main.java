package src; 
<<<<<<< HEAD
import src.menusCrud.menuMain; 
=======
import java.util.List;

import src.models.Categoria;
import src.models.comun.DbObject; 
>>>>>>> branch 'master' of https://github.com/Aadirn/miTienda.git

public class Main {
	
	/**
	 * <strong>EJERCICIOS</strong>
	 * <strong>Entrega: 6 de Noviembre (Github)</strong>
	 * 
	 * 1.- Actualizar vuestros repositorio con este
	 * 2.- Interface Comandos:
	 * 	-> Categoria: CRUD
	 *  -> Producto: CRUD // NOTA: Un producto tiene un id_Categoria obligatorio, y tiene existir la categoria
	 *  -> Cliente: CRUD
	 * 
	 * 2.- Listar:
	 *  -> Productos de una Categoria // Dado un ID de categoria; tener todos los productos
	 * 
	 * 3*.- Validaciones:
	 *  -> Los datos del C/U (Create/Update) tienen que cumplir condiciones coherentes. 
	 *  => PISTA: regex
	 * 
	 * *-> Para nota ;)
	 * 
	 */

	public static void main(String[] args) {
		 
		
<<<<<<< HEAD
		
		menuMain.getInstance().display();
		
		/*Producto prod = new Producto();
		 prod.setNombre("Prod 01");
		 prod.save();*/
		 
		
		 /*Categoria cat = new Categoria();
=======
		 Categoria cat = new Categoria();
>>>>>>> branch 'master' of https://github.com/Aadirn/miTienda.git
		 cat.setNombre("Cat 01");
		 cat.save();
		 
		 List<DbObject> cats = cat.list();
		 for (DbObject obj : cats) {
			 Categoria item = (Categoria) obj;
			 if (item.getId() == 1) {
				 item.delete();	 
			 }
		 }
		 
		 cats.get(7).delete();
		 
		 Categoria cat2 = new Categoria();
		 cat2.delete();
		 
<<<<<<< HEAD
		 cat2 = (Categoria) cat2.getByid(1);*/
=======
		 cat2 = (Categoria) cat2.getByid(1);
>>>>>>> branch 'master' of https://github.com/Aadirn/miTienda.git
		 
		 
	 
	}

}
