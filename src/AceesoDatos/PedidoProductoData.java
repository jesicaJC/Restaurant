
package AceesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Pedido;


public class PedidoProductoData {
    
    private Connection con = null; //CARGAR dRUVER Y ESTABLECER LA CONEXION CON LA BASE UNIVERSIDAD
    private ProductoData prodata = new ProductoData();
    private MesaData medata = new MesaData();
    private PedidoData pedata = new PedidoData();
            
            
    public PedidoProductoData() { //constructor va inicializar la variable con
        con = Conexion.getConexion();
        //getConexion es un metodo de la clase Conexion que va a cargar los driver y conectarse con la base
    }
    
    //METODOS
    
    
    
    
    
    
    public List<Pedido> listarPedidoporMesero(String nombre){
      List<Pedido> pedido = new ArrayList<Pedido>();
      String sql = "SELECT * FROM pedido WHERE nombre_mesero = ?";
      
       try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
             while (rs.next()) {
            Pedido p = new Pedido();
            p.setIdPedido(rs.getInt("id_pedido"));
            p.setIdMesa(rs.getInt("id_mesa"));    
            p.setNombreMesero(rs.getString("nombre_mesero"));
            p.setFechaHora(rs.getTimestamp("fecha_hora"));
            p.setImporte(rs.getInt("importe"));
            p.setCobro(rs.getBoolean("cobro"));
            pedido.add(p);
                 System.out.println(p);
             }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener : " + ex.getMessage());
        }
        return pedido;
    }

    
    
    public List<Pedido> listarIgresoTotalXFecha(Timestamp fechaHora){
        List<Pedido> pedido = new ArrayList<>();
      String sql = "SELECT * FROM pedido WHERE fecha_hora = ?";
      
       try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTimestamp(1, fechaHora );
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()) {
            Pedido p = new Pedido();
            p.setIdPedido(rs.getInt("id_pedido"));
            p.setIdMesa(rs.getInt("id_mesa"));    
            p.setNombreMesero(rs.getString("nombre_mesero"));
            p.setFechaHora(rs.getTimestamp("fecha_hora"));
            p.setImporte(rs.getInt("importe"));
            p.setCobro(rs.getBoolean("cobro"));
            pedido.add(p);
                 System.out.println(p);
             }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener : " + ex.getMessage());
        }
        return pedido;
    }
    
    
    public void listarPedidoCobroMeseroDia(){
       
    }
    
    public void listarPedidoFexhaHora(){
       
    }

   
}
