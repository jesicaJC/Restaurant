/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author rafa
 */
public class PedidoProducto {
    private int idPedidoProducto;
     private int idPedido;
      private int idProducto;
       private int cantidad;

    public PedidoProducto() {
    }

    public PedidoProducto(int idPedido, int idProducto, int cantidad) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public PedidoProducto(int idPedidoProducto, int idPedido, int idProducto, int cantidad) {
        this.idPedidoProducto = idPedidoProducto;
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public int getIdPedidoProducto() {
        return idPedidoProducto;
    }

    public void setIdPedidoProducto(int idPedidoProducto) {
        this.idPedidoProducto = idPedidoProducto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "PedidoProducto{" + "idPedidoProducto=" + idPedidoProducto + ", idPedido=" + idPedido + ", idProducto=" + idProducto + ", cantidad=" + cantidad + '}';
    }
     
    
       
}
