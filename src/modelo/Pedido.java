
package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author rafa
 */
public class Pedido {
   private int idPedido;
   private int idMesa;
   private String nombreMesero;
   private LocalDate fechaHora;
   private double importe;
   private boolean cobro;

    public Pedido() {
    }

    public Pedido(int idPedido, int idMesa, String nombreMesero, LocalDate fechaHora, double importe, boolean cobro) {
        this.idPedido = idPedido;
        this.idMesa = idMesa;
        this.nombreMesero = nombreMesero;
        this.fechaHora = fechaHora;
        this.importe = importe;
        this.cobro = cobro;
    }

    public Pedido(int idMesa, String nombreMesero, LocalDate fechaHora, double importe, boolean cobro) {
        this.idMesa = idMesa;
        this.nombreMesero = nombreMesero;
        this.fechaHora = fechaHora;
        this.importe = importe;
        this.cobro = cobro;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public String getNombreMesero() {
        return nombreMesero;
    }

    public void setNombreMesero(String nombreMesero) {
        this.nombreMesero = nombreMesero;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public boolean isCobro() {
        return cobro;
    }

    public void setCobro(boolean cobro) {
        this.cobro = cobro;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", idMesa=" + idMesa + ", nombreMesero=" + nombreMesero + ", fechaHora=" + fechaHora + ", importe=" + importe + ", cobro=" + cobro + '}';
    }
   
   
}
