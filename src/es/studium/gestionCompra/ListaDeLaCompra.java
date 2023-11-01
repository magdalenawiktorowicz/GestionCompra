package es.studium.gestionCompra;

import java.util.ArrayList;
import java.util.List;

public class ListaDeLaCompra {
	// atributos de la clase
	private String nombreLista;
	private List<ArticuloAComprar> listaArticulos;

	// constructor por defecto
	public ListaDeLaCompra() {
		this.listaArticulos = new ArrayList<>();
	}

	// constructor con el cual asignamos el nombre a la lista
	public ListaDeLaCompra(String nombreLista) {
		this.nombreLista = nombreLista;
		this.listaArticulos = new ArrayList<>();
	}

	// método get para obtener el nombre de la lista
	public String getNombreLista() {
		return nombreLista;
	}
	
	// método set para asignar el nombre a la lista
	public void setNombreLista(String nombreLista) {
		this.nombreLista = nombreLista;
	}

	// método para agregar un artículo a la lista de la compra
	public void agregarProductoAComprar(ArticuloAComprar articulo) {
		listaArticulos.add(articulo);
	}

	// método para eliminar un artículo de la lista de la compra
	public void eliminarArticulo(String descripcionArticulo) {
		/*
		 * al método removeIf pasamos una lambda que indica que se elimine el artículo
		 * si su descricpción es equivalente a la descripción pasada como parámetro al
		 * método eliminarArticulo si no hay ningún artículo correspondiente, no pasa nada
		 */
		listaArticulos.removeIf(articulo -> articulo.getDescripcion().equals(descripcionArticulo));
	}

	// método get para obtener la lista de la compra
	public List<ArticuloAComprar> getArticulos() {
		return listaArticulos;
	}

}