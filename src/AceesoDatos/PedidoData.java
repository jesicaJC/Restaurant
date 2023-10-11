/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AceesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import javax.swing.JOptionPane;
import modelo.Pedido;/**
 *
 * @author rafa
 */
public class PedidoData {
    private Connection con = null;
    
    public PedidoData(){
        con = Conexion.getConexion();
    }
    
    public void agregarPedido(Pedido pedi){ 
    
    String sql = "INSERT INTO pedido (id_Pedido,id_Mesa,nombre_Mesero, fecha_Hora, importe, cobrada) VALUES (?, ?, ?, ?, ?, ?)";
    
    try {
            //preparedStatement envian la setencia anterior
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//que me devuelva la lista de claves generadas
           
            ps.setInt(1,pedi.getIdPedido());
            ps.setInt(2, pedi.getIdMesa());
            ps.setString(3, pedi.getNombreMesero());
//          LocalDate lc = alumnoActual.getFechaNacimiento();
//          java.util.Date date = java.util.Date.from(lc.atStartOfDay(ZoneId.systemDefault()).toInstant());
//            ps.setDate(4, Date.valueOf(pedi));
            ps.setDouble(5, pedi.getImporte());
            ps.setBoolean(6, pedi.isCobro());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
//                produ.setIdProducto(rs.getInt("idProducto"));
                JOptionPane.showMessageDialog(null, "Pedido añadido con éxito.");
            }
            ps.close();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Productos: " + ex.getMessage());
            
        }
    }
    
//    public void borrarPedido(int idPedido){
//    try {
//            String sql = "DELETE FROM pedido WHERE idPedido = ?";
//              
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, idPedido);
//            int fila = ps.executeUpdate();
//            if (fila == 1) {
//                JOptionPane.showMessageDialog(null, "Se eliminó el producto.");
//            } else{
//                JOptionPane.showMessageDialog(null, "No se encontró el pedido");
//            }
//            ps.close();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pedido");
//        }
//    }
//    
//   public void modificarPedido(PedidoData pedi){ 
//       String sql = "UPDATE pedido SET idPedido = ?, idMesa = ?, nombreMesero = ?, fechaHora= ?, importe = ?, cobrada = ? WHERE idPedido = ?";
//        PreparedStatement ps = null;
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, pedi.getIdPedido());
//            ps.setInt(2, pedi.getIdMesa());
//            ps.setString(3, pedi.getNombreMesero());
//            ps.setDate(4, Date.valueOf(pedi.getFechaHora()));
//            ps.setDouble(5, pedi.getImporte());
//            ps.setBoolean(6, pedi.isCobrada());
//            
//            int exito = ps.executeUpdate();//execute devuelve en un entero con la cantidad de filas afectadas
//            if (exito == 1) { //va a devolver 1 porque el id es unico
//                JOptionPane.showMessageDialog(null, "Pedido modificado Exitosamente.");
//            } else {
//                JOptionPane.showMessageDialog(null, "El Pedido no existe");
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido: " + ex.getMessage());
//        }
//        }
}
