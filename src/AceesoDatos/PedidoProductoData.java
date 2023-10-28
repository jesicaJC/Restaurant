
package AceesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Mesa;
import modelo.Pedido;
import modelo.PedidoProducto;
import modelo.Producto;
/*SELECT pedidoproducto.id_pedido_producto,
mesa.numero,
pedido.nombre_mesero,
producto.nombre_producto,producto.precio
FROM pedidoproducto join mesa on(pedidoproducto.id_pedido_producto=mesa.id_mesa) 
join pedido on (pedidoproducto.id_pedido=pedido.id_pedido) 
join producto on (pedidoproducto.id_pedido_producto=producto.id_Producto);*/

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

   public List<Producto> listar(){
      /*SELECT cantidad,producto.nombre_producto,producto.precio
        FROM pedidoproducto join producto on (pedidoproducto.id_pedido_producto=producto.id_Producto);*/
      List<Producto>  pedido = new ArrayList<>();
       try {
           String sql = "SELECT cantidad,nombre_mesero,precio, "
              + "FROM pedidoproducto,producto "
              + "WHERE pedidoproducto.id_pedido_producto = producto.id_Producto"
                   + "and pedidoproducto.cantidad";
      
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                 Producto pp = new Producto(); 
                pp.setNombreProducto(rs.getString("nombre_producto"));
                pp.setPrecio(rs.getInt("precio"));
                 pedido.add(pp);
                 
//                  PedidoProducto ped = new PedidoProducto();
//                 ped.setCantidad(rs.getInt("cantidad"));
//                 System.out.println(pedido.add(pp));
//                 
             }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener : " + ex.getMessage());
        }
        return pedido;
//    
    }
    
   public void creandoPedidos(){
 /*Una mesa ocupada puede hacer uno o varios pedidos. 
  Los pedidos tienen una lista de productos que, sumados todos los importes unitarios, se obtiene el monto del pedido.
  Inicialmente están pendientes (0) o entregado/pagado (1). 
  Una mesa puede tener entre sus pedidos algunos pagados y otros sin pagar.*/
      
    }  
    
    public void agregarProductoAPedido(int idPedido, int idProducto,int cant){
    /*Un método agregar producto, agrega un producto a un pedido (una lista de productos).
    Quitar producto lo elimina o anula del pedido.*/
         String sql = "INSERT INTO pedidoproducto (id_Pedido, id_Producto, cantidad) VALUES (?, ?, ?)";

    try {
            //preparedStatement envian la setencia anterior
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//que me devuelva la lista de claves generadas
            //Remplazo los ? por los datos 
            ps.setInt(1,idPedido);
            ps.setInt(2, idProducto);
            ps.setInt(3, cant);
         
           
            ps.executeUpdate();//ejecuta el preparedStatement armado anterior
            ResultSet rs = ps.getGeneratedKeys();//Obtiene la clave,recibimos un resultset consulta
            //ResultSet va a venir una especie de matriz con una sola columna(ID), con tantas filas como alumnados haya insertado
            //en este caso solo enviamos un solo alumno y va a tener 1 sola fila.
            if (rs.next()) {
//                produ.setIdProducto(rs.getInt("idProducto"));//nos mandan por parametro un alumno con dni ,apellido etc, nosotros le devolvemos por referencia un ID
                //el ID lo saco del resultSet getInt y el numero de columna osea el numero del id
                System.out.println("Exito");
            }
            ps.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }
    

    public  void eliminarProductoDelPedido(int id){
    try {
            String sql = "DELETE FROM pedidoproducto WHERE id_pedido_producto = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                System.out.println("Exito");
            }
            ps.close();
        } catch (SQLException e) {
            e.getMessage();
        }
    }
    
    //         ***LISTAR***
    
    public List<PedidoProducto>listarVentas(){
       List<PedidoProducto> ventas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pedidoproducto";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PedidoProducto p = new PedidoProducto();
                p.setIdPedidoProducto(rs.getInt("id_pedido_producto"));
                p.setIdPedido(rs.getInt("id_pedido"));
                p.setIdProducto(rs.getInt("id_producto"));
                p.setCantidad(rs.getInt("cantidad"));
                ventas.add(p);
            }
            ps.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return ventas;
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
                
             }
              System.out.println("Exito");
            ps.close();
        } catch (SQLException ex) {
             ex.getMessage();
        }
        return pedido;
    }

    
    
    public List<Pedido> listarIgresoTotalXFecha(Timestamp fechaHora){ //listar ingresos sumando totales de pedidos para una fecha en particular
        List<Pedido> pedido = new ArrayList<>();
        /*SELECT sum(importe) FROM `pedido` WHERE 2023-10-12;*/
      String sql = "SELECT sum(importe) FROM pedido WHERE fecha_hora = ?";
      
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
          ex.getMessage();
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
           ex.getMessage();
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
            ex.getMessage();
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
