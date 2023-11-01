package es.studium.gestionCompra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) {
		
		// creamos una lista de compra sin asignarle el nombre
		ListaDeLaCompra listaCompra = new ListaDeLaCompra();
		// asignamos el nombre a la lista utilizando el método setter
		listaCompra.setNombreLista("Lidl");
		// comprobamos que la lista tiene su nombre asignado
//		System.out.println("Nombre de la lista: " + listaCompra.getNombreLista());
		
		// creamos otra lista de compra con nombre
//		ListaDeLaCompra listaCompra2 = new ListaDeLaCompra("Mercadona");
		// comprobamos que la lista tiene su nombre asignado
//		System.out.println("Nombre de la lista: " + listaCompra2.getNombreLista());
		
		
		// creamos artículos a comprar
		ArticuloAComprar arroz = new ArticuloAComprar("arroz", 3, "Kg");
		ArticuloAComprar leche = new ArticuloAComprar("leche", 1.5 , "L");
		ArticuloAComprar pan = new ArticuloAComprar("pan", 2, "barras");
		ArticuloAComprar queso = new ArticuloAComprar("queso", 1, "paquete");
		ArticuloAComprar harina = new ArticuloAComprar("harina", 3, "Kg");
		
		// mostramos los productos
//		System.out.println("Todos los artículos creados:");
//		System.out.println(arroz);
//		System.out.println(leche);
//		System.out.println(pan);
//		System.out.println(queso);
//		System.out.println(harina);
		
		// agregamos los articulos a la lista de compra en Lidl
		listaCompra.agregarProductoAComprar(arroz);
		listaCompra.agregarProductoAComprar(leche);
		listaCompra.agregarProductoAComprar(pan);
		listaCompra.agregarProductoAComprar(queso);
		listaCompra.agregarProductoAComprar(harina);
		
		// mostramos la lista
//		System.out.println("Todos los artículos en la lista de la compra " + listaCompra.getNombreLista() + ":");
//		for (ArticuloAComprar articulo : listaCompra.getArticulos()) { 
//			System.out.println(articulo); 
//		}
		
		// llamamos al método crearFichero para crear el fichero con la lista de la compra
//		crearFichero(listaCompra.getNombreLista());
		
		// escribir la lista en el fichero externo, pasándole como parámetros
		// el nombre del fichero y la lista con artículos a comprar
//		escribirEnFichero(listaCompra);

		
		// llamar al método leerContenidoFichero, pasándole el nombre del fichero del cual queremos leer la lista
		// y guardar el contenido en el objeto listaCargada de tipo ListaDeLaCompra
		ListaDeLaCompra listaCargada = leerContenidoFichero("Lidl");
		// mostrar todos los artículos de la lista de compra  
		for (ArticuloAComprar articulo : listaCargada.getArticulos()) {
			System.out.println(articulo); 
		}
		
		// eliminar un artículo de la lista
//		listaCargada.eliminarArticulo("harina");
//		escribirEnFichero(listaCargada);
		// leemos el contenido de la lista de nuevo
//		listaCargada = leerContenidoFichero("Lidl");
//		for (ArticuloAComprar articulo : listaCargada.getArticulos()) {
//			System.out.println(articulo); 
//		}

	}
	
	// método para crear un fichero con la lista de la compra
	public static void crearFichero(String nombreDeLaLista) {
		// instanciamos el objeto File
		File compras = new File("compras");
		// creamos un directorio "compras" si este no existe todavía
		compras.mkdirs();
		// instanciamos otro objeto File para crear el fichero
		File tienda = new File("compras\\" + nombreDeLaLista + ".txt");
		try {
			//Creamos el fichero en el directorio creado anteriormente
			tienda.createNewFile();
			// Comprobamos que el directorio y el fichero se han creado correctamente
			System.out.println("Nombre del fichero creado: " + tienda.getName());
			System.out.println("Ruta relativa: " + tienda.getPath());
			System.out.println("Ruta absoluta: " + tienda.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// método para obtener una lista de la compra del fichero cuyo nombre pasamos como parámetro
	public static ListaDeLaCompra leerContenidoFichero(String nombreDeLaLista) {
		// creamos e instanciamos el objeto de tipo ListaDeLaCompra y le asignamos el nombre
		ListaDeLaCompra listaCompra = new ListaDeLaCompra("Lidl");
		// creamos e iniciamos un objeto tipo File
		File fichero = new File("compras\\" + nombreDeLaLista + ".txt");
		// creamos un String para guardar cada línea del fichero
		String line;
		/*
		 * utilizamos try-with-resources para que los objetos FileReader y BufferedReader se cierren automáticamente
		 * al final del bloque try;
		 * en los paréntesis declaramos e iniciamos los objetos FileReader y BufferedReader
		 */
		try (BufferedReader bf = new BufferedReader(new FileReader(fichero))) {
			// mientras la siguiente linea en el fichero existe, seguimos leyendo el contenido
			while((line = bf.readLine()) != null) {
				// una línea en el fichero corresponde a un artículo
				// por lo cual creamos un array tipo String para separar cada elemento
				String[] strArticulo = line.split(" ");
				// creamos un objeto tipo ArticuloAComprar y le asignamos la descripción, la cantidad y la unidad
				ArticuloAComprar articulo = new ArticuloAComprar(strArticulo[3], Double.valueOf(strArticulo[0]), strArticulo[1]);
				// añadimos el artículo a la lista anteriormente creada
				listaCompra.agregarProductoAComprar(articulo);
			}
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe..");
		} catch (IOException e) {
			System.out.println("Se ha producido un error.");
		}
		// devolvemos una lista con todos los artículos a comprar
		return listaCompra;
	}
	
	// método para escribir al fichero
	public static void escribirEnFichero(ListaDeLaCompra lista) {
		String nombreFichero = lista.getNombreLista();
		/*
		 * utilizamos try-with-resources para que los objetos FileWriter y BufferedWriter se cierren automáticamente
		 * al final del bloque try;
		 * en los paréntesis declaramos e iniciamos los objetos FileWriter y BufferedWriter
		 */
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("compras\\" + nombreFichero + ".txt"))) {
			// cada artículo en la lista pasada al método
			for (ArticuloAComprar articulo : lista.getArticulos()) {
				// le escribimos en el fichero
				writer.write(articulo.toString() + "\n");
			}
		} catch (IOException e) {
			System.out.println("Se ha producido un error.");
		}
		System.out.println("La lista se ha guardado correctamente en el fichero: " + nombreFichero + ".txt");
	}

}