
package AceesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Pedido;import modelo.Producto;
/**
 *
 * @author rafa
 */
public class PedidoData {
    private Connection con = null;
    
    public PedidoData(){
        con = Conexion.getConexion();
    }
    
    public void agregarPedido(Pedido pedi){ 
    
    String sql = "INSERT INTO pedido (id_Pedido, id_mesa, nombre_mesero, importe, cobro) VALUES (?, ?, ?, ? ,?)";
    
    try {
            //preparedStatement envian la setencia anterior
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//que me devuelva la lista de claves generadas
           
            ps.setInt(1,pedi.getIdPedido());
            ps.setInt(2, pedi.getIdMesa());
            ps.setString(3, pedi.getNombreMesero());
            ps.setDouble(4, pedi.getImporte());
            ps.setBoolean(5, pedi.isCobro());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Pedido añadido con éxito.");
            }
            ps.close();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Productos: " + ex.getMessage());
            
        }
    }
    
    public void borrarPedido(int idPedido){
    try {
            String sql = "DELETE FROM pedido WHERE id_pedido = ?";
              
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se eliminó el producto.");
            } else{
                JOptionPane.showMessageDialog(null, "No se encontró el pedido");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pedido");
        }
    }
   
   public void modificarPedido(Pedido pedi){ 
       String sql = "UPDATE pedido SET  id_mesa = ?, nombre_mesero = ?, importe = ?, cobro = ? WHERE id_pedido = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pedi.getIdMesa());
            ps.setString(2, pedi.getNombreMesero());
//            ps.setTimestamp(4, (pedi.getFechaHora()));
            ps.setDouble(3, pedi.getImporte());
            ps.setBoolean(4, pedi.isCobro());
             ps.setInt(5, pedi.getIdPedido());
            
            
            int exito = ps.executeUpdate();//execute devuelve en un entero con la cantidad de filas afectadas
            if (exito == 1) { //va a devolver 1 porque el id es unico
                JOptionPane.showMessageDialog(null, "Pedido modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El Pedido no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido: " + ex.getMessage());
        }
        }

    public List<Pedido> listarPedido() {
        List<Pedido> pedidos = new ArrayList<>();
        try {
//           String sql = "SELECT *"
//           +" FROM pedido,mesa"
//           +" WHERE  pedido.id_pedido=mesa.id_mesa and cobro = 1";
            String sql = "SELECT * FROM pedido WHERE cobro = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt("id_pedido"));
                p.setIdMesa(rs.getInt("id_mesa"));
                p.setNombreMesero(rs.getString("nombre_mesero"));
                p.setFechaHora(rs.getTimestamp("fecha_hora"));
                p.setImporte(rs.getDouble("importe"));
                p.setCobro(rs.getBoolean("cobro"));
                pedidos.add(p);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido: " + ex.getMessage());
        }
        return pedidos;
    }
    
    public Pedido buscarPedido(int id){ 
   Pedido pedido = null;
        String sql = "SELECT  id_mesa, nombre_mesero, importe, cobro from pedido WHERE id_pedido = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(id);
                pedido.setIdMesa(rs.getInt("id_mesa"));
                pedido.setNombreMesero(rs.getString("nombre_mesero"));
                pedido.setImporte(rs.getDouble("importe"));
                pedido.setCobro(true);
            } else {
                System.out.println("No existe el pedido");
            }
            ps.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return pedido;
    }
    
    
}
