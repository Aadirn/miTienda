package src; 
import src.menusCrud.menuMain; 

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
		
	
		menuMain.getInstance().display();
		
		/*Categoria prod = new Categoria();
		 prod.setNombre("Cat 02");
		 prod.save();*/
		 
		
		 /*Categoria cat = new Categoria();
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
		 
		 cat2 = (Categoria) cat2.getByid(1);*/
		 
		 
	 
	}
}


