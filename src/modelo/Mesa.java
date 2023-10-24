
package modelo;

/**
 *
 * @author rafa
 */
public class Mesa {
    private int idMesa;
    private int numero;
    private boolean estadoMesa;
    private int capacidad;

    public Mesa() {
    }

    public Mesa(int idMesa, int numero, boolean estadoMesa, int capacidad) {
        this.idMesa = idMesa;
        this.numero = numero;
        this.estadoMesa = estadoMesa;
        this.capacidad = capacidad;
    }

    public Mesa(int numero, boolean estadoMesa, int capacidad) {
        this.numero = numero;
        this.estadoMesa = estadoMesa;
        this.capacidad = capacidad;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(boolean estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return  idMesa + ")  Mesa Nº: " + numero +" - Libre:" + estadoMesa + "- capacidad: " + capacidad ;
    }
    
    
}
