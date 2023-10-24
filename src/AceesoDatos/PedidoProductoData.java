
package AceesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Mesa;
import modelo.Pedido;
import modelo.PedidoProducto;
import modelo.Producto;


public class PedidoProductoData {
    
    private Connection con = null; 
    private ProductoData prodata = new ProductoData();
    private MesaData medata = new MesaData();
    private PedidoData pedata = new PedidoData();
    private Mesa mesa =new Mesa();
            
            
    public PedidoProductoData() { //constructor va inicializar la variable con
        con = Conexion.getConexion();
        //getConexion es un metodo de la clase Conexion que va a cargar los driver y conectarse con la base
    }
    
    //METODOS
    
    public List<PedidoProducto> creandoPedidos(){
      /*SELECT pedidoproducto.id_pedido_producto,
mesa.numero,
pedido.nombre_mesero,
producto.nombre_producto,producto.precio
FROM pedidoproducto join mesa on(pedidoproducto.id_pedido_producto=mesa.id_mesa) 
join pedido on (pedidoproducto.id_pedido=pedido.id_pedido) 
join producto on (pedidoproducto.id_pedido_producto=producto.id_Producto);*/
      List<PedidoProducto>  pedido = new ArrayList<>();
//      
//       try {
//           String sql = "SELECT pedido.id_mesa,pedido.nombre_mesero "
//              + "FROM pedidoProducto,pedido,producto "
//              + "WHERE pedidoProducto.id_pedido and pedidoProducto.id_producto = 1";
//      
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//             while (rs.next()) {
//                 
//                 Pedido p = new Pedido();
//            p.setIdMesa(rs.getInt("id_mesa"));    
//            p.setNombreMesero(rs.getString("nombre_mesero"));
//            pedido.add(p);
//            
//                 Producto pr = new Producto();
//                 pr.setNombreProducto(rs.getString("nombre_mesero"));
//                 pr.setPrecio(rs.getInt("precio"));
//                 pedido.add(pr);
//                 
//                 
//             }
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al obtener : " + ex.getMessage());
//        }
        return pedido;
//    
    }
    
    
    
    
    
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

    
    
    public List<Pedido> listarIgresoTotalXFecha(Timestamp fechaHora){ //listar ingresos sumando totales de pedidos para una fecha en particular
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
    
    
    public List<Pedido> listarPedidoCobroMeseroDia(String nombre){//listar pedidos que cobro un mesero en el dia
        List<Pedido> pedido = new ArrayList<>();
      String sql = "SELECT * FROM pedido WHERE nombre_mesero = ? and cobro = 1";
      
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
    
    public List<Pedido> listarPedidoFechaHora(Timestamp fechaHora){//listar pedidos que ha hecho una mesa en una fecha entre horas
        List<Pedido> pedido = new ArrayList<>();
      String sql = "SELECT * FROM pedido WHERE fecha_hora = ? ";
      
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

//     public double calcularSubtotal() {
//        double subtotal = 0;
//        for (Producto producto : this.productos) {
//            subtotal += (producto.getCantidad()) * (producto.getPrecio());
//        }
//        return subtotal;
//     }
//     
//   public double listarIngresosFecha(Timestamp fecha) {
//        double ingresos = 0;
//        for (Pedido pedido : this.pedidos) {
//            if (pedido.getFechaHora().equals(fecha) && pedido.isCobrada()== 1) {
//                ingresos += pedido.calcularSubtotal();
//            }
//        }
//        return ingresos;
//    }
//
//    public double listarIngresosMeseroDia(String mesero, Date fecha) {
//        double ingresos = 0;
//        for (Pedido pedido : this.pedidos) {
//            if (pedido.getNombreMesero().equals(mesero) && pedido.getFechaHora().equals(fecha) && pedido.isCobrada()== 1) {
//                ingresos += pedido.calcularSubtotal();
//            }
//        }
//        return ingresos;
//    }
}
