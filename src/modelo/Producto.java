
package modelo;

/**
 *
 * @author rafa
 */
public class Producto {
    private int idProducto;
    private String nombreProducto;
    private double precio;
    private int stock;
    private boolean estado;

    public Producto() {
    }

    public Producto(String nombreProducto, double precio, int stock) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.stock = stock;
    }
    
    

    public Producto(int idProducto, String nombreProducto, double precio, int stock, boolean estado) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    public Producto(String nombreProducto, double precio, int stock, boolean estado) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {//"["+idProducto + "]  " +
        return  nombreProducto + ", " + precio + ", " + stock + ", " + estado ;
    }
    
    
}
