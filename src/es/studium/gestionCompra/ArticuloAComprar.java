package es.studium.gestionCompra;

public class ArticuloAComprar {
	// atributos de la clase (encapsulados)
	private String descripcion;
    private double cantidad;
    private String unidad;
    
    // constructor con parámetros
    public ArticuloAComprar(String descripcion, double cantidad, String unidad) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.unidad = unidad;
    }
    
    // métodos get y set
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    
	/*
	 * el método toString() devuelve una cadena con la descripción completa del artículo 
	 * de esta manera, al imprimir el objeto (e.g. con
	 * System.out.println(nombreDelVariableDelArticulo)) veremos su descripción completa
	 */
    @Override
    public String toString() {
        return cantidad + " " + unidad + " de " + descripcion;
    }
}
