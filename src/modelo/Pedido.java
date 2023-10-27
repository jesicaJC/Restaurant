
package modelo;

import java.sql.Timestamp;
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
   private Timestamp fechaHora;
   private double importe;
   private boolean cobro;

    public Pedido() {
    }

    public Pedido(int idMesa, String nombreMesero, double importe, boolean cobro) {
        this.idMesa = idMesa;
        this.nombreMesero = nombreMesero;
        this.importe = importe;
        this.cobro = cobro;
    }

    
    public Pedido(int idPedido, int idMesa, String nombreMesero, double importe, boolean cobro) {
        this.idPedido = idPedido;
        this.idMesa = idMesa;
        this.nombreMesero = nombreMesero;
        this.importe = importe;
        this.cobro = cobro;
    }

    public Pedido(int idMesa, String nombreMesero, Timestamp fechaHora, double importe, boolean cobro) {
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

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
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
    public String toString() {//"["+idPedido+
        return  " Mesa: " + idMesa + " | Mesero: " + nombreMesero + " | Fecha Hora: " + fechaHora + " | Importe: " + importe + " | Cobro: " + cobro;
    }
   
   
}
