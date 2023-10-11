
package AceesoDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Producto;


public class ProductoData { //ABM
    private Connection con = null; //CARGAR dRUVER Y ESTABLECER LA CONEXION CON LA BASE UNIVERSIDAD

    public ProductoData() { //constructor va inicializar la variable con
        con = Conexion.getConexion();
        //getConexion es un metodo de la clase Conexion que va a cargar los driver y conectarse con la base
    }
    
    public void agregarproducto(Producto produ){ 
    
    String sql = "INSERT INTO producto (nombre_producto, precio, stock, estado) VALUES (?, ?, ?, ?)";
    
    try {
            //preparedStatement envian la setencia anterior
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//que me devuelva la lista de claves generadas
            //Remplazo los ? por los datos del alumno que quiero enviar 
              ps.setString(1,produ.getNombreProducto());
            ps.setDouble(2, produ.getPrecio());
            ps.setInt(3, produ.getStock());
            ps.setBoolean(4,produ.isEstado());//Date de sql, valueOf lo convierte a DATE
           
            ps.executeUpdate();//ejecuta el preparedStatement armado anterior
            ResultSet rs = ps.getGeneratedKeys();//Obtiene la clave,recibimos un resultset consulta
            //ResultSet va a venir una especie de matriz con una sola columna(ID), con tantas filas como alumnados haya insertado
            //en este caso solo enviamos un solo alumno y va a tener 1 sola fila.
            if (rs.next()) {
//                produ.setIdProducto(rs.getInt("idProducto"));//nos mandan por parametro un alumno con dni ,apellido etc, nosotros le devolvemos por referencia un ID
                //el ID lo saco del resultSet getInt y el numero de columna osea el numero del id
                JOptionPane.showMessageDialog(null, "Producto añadido con éxito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se añadio el Alumno /Error al acceder a la tabla Alumno: " + ex.getMessage());
            
        }
    }
    
    public void eliminarProducto(int id){
    try {
            String sql = "UPDATE producto SET estado = 0 WHERE id_Producto = ?";
//            String sql = "DELETE FROM producto WHERE idProducto = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se eliminó el producto.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto");
        }
    }
    
    public void modificarProducto(Producto produ){ 
       String sql = "UPDATE producto SET nombre_producto = ?, precio = ?, stock = ?, estado= ? WHERE id_Producto = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, produ.getNombreProducto());
            ps.setDouble(2, produ.getPrecio());
            ps.setInt(3, produ.getStock());
            ps.setBoolean(4, produ.isEstado());
            ps.setInt(5, produ.getIdProducto());
            int exito = ps.executeUpdate();//execute devuelve en un entero con la cantidad de filas afectadas
            if (exito == 1) { //va a devolver 1 porque el id es unico
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El producto no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto: " + ex.getMessage());
        }
    }
    
    public Producto buscarProducto(int id){ 
   Producto producto = null;
        String sql = "SELECT nombre_producto, precio, stock, estado FROM producto WHERE id_Producto = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(id);
                producto.setNombreProducto(rs.getString("nombre_producto"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(true);
//                alumno.setIdAlumno(id);
//                alumno.setDni(rs.getInt("dni"));
//                alumno.setApellido(rs.getString("apellido"));
//                alumno.setNombre(rs.getString("nombre"));
//                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
//                alumno.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe producto");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto: " + ex.getMessage());
        }
        return producto;
    }
    
     public Producto consultarProducto(String nombre) {
Producto produ = null;
        String sql = "SELECT  id_Producto ,nombre_Producto, precio, stock FROM producto WHERE nombre_Producto = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                produ = new Producto();
                produ.setIdProducto(rs.getInt("id_Producto"));
                produ.setNombreProducto(rs.getString("nombre_Producto"));
                produ.setPrecio(rs.getDouble("precio"));
                produ.setStock(rs.getInt("stock"));
                produ.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe el producto");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto: " + ex.getMessage());
        }
        return produ;
    
    }
    
 public List<Producto> listarProducto() {
        List<Producto> productos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM producto WHERE estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("id_Producto"));
                p.setNombreProducto(rs.getString("nombre_producto"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setEstado(rs.getBoolean("estado"));
                productos.add(p);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno: " + ex.getMessage());
        }
        return productos;
    }



}