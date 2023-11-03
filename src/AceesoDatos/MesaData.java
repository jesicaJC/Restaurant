
package AceesoDatos;

import modelo.Mesa;
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

public class MesaData {
    
    private Connection con = null;
    
    public MesaData(){
        con = Conexion.getConexion();
    }
    
public void agregarMesa(Mesa me){ 
    
    String sql = "INSERT INTO mesa ( numero, estado_mesa, capacidad) VALUES (?, ?, ?)";
    
    try {
            //preparedStatement envian la setencia anterior
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//que me devuelva la lista de claves generadas
           
            ps.setInt(1,me.getNumero());
            ps.setBoolean(2, me.isEstadoMesa());
            ps.setInt(3, me.getCapacidad());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Exito");
            }
            ps.close();
        } catch(SQLException ex){
             ex.getMessage();
        }
    }

public void modificarMesa(Mesa me){ 
       String sql = "UPDATE mesa SET numero = ?, estado_mesa= ?, capacidad = ? WHERE id_mesa = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, me.getNumero());
            ps.setBoolean(2, me.isEstadoMesa());
            ps.setInt(3, me.getCapacidad());
            ps.setInt(4, me.getIdMesa());
            
            int exito = ps.executeUpdate();//execute devuelve en un entero con la cantidad de filas afectadas
            if (exito == 1) { //va a devolver 1 porque el id es unico
                System.out.println("Mesa modificada");
            } else {
                System.out.println("No se encuentra la mesa");
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
      }

// el siguiente metodo borra una mesa por su IdMesa
 public void borrarMesa(int idMesa){
    try {
//            String sql = "DELETE FROM mesa WHERE id_mesa = ?";
          String sql = "UPDATE mesa SET estado_mesa = 0 WHERE id_mesa = ?"; 
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMesa);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se eliminó la mesa.");
            } else{
                JOptionPane.showMessageDialog(null, "No se encontró la mesa");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesa");
        }
    }
 
 public Mesa buscarMesa(int id){ 
   Mesa mesa = null;
        String sql = "SELECT numero, estado_mesa, capacidad FROM mesa WHERE id_mesa = ? AND estado_mesa = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                mesa = new Mesa();
                mesa.setIdMesa(id);
                mesa.setNumero(rs.getInt("numero"));
                mesa.setEstadoMesa(true);
                mesa.setCapacidad(rs.getInt("capacidad"));
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe Mesa");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Mesa: " + ex.getMessage());
        }
        return mesa;
    }
 
 public List<Mesa> listarMesa() {
        List<Mesa> mesa = new ArrayList<>();
        try {
            String sql = "SELECT * FROM mesa WHERE estado_mesa = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mesa m = new Mesa();
                m.setIdMesa(rs.getInt("id_mesa"));
                m.setNumero(rs.getInt("numero"));
                m.setEstadoMesa(rs.getBoolean("estado_mesa"));
                m.setCapacidad(rs.getInt("capacidad"));
                mesa.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Mesa: " + ex.getMessage());
        }
        return mesa;
    }

 
    }


    

