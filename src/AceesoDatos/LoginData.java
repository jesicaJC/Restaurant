
package AceesoDatos;

import modelo.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author rafa
 */
public class LoginData {
    
//    Connection con;
//    PreparedStatement ps;
//    ResultSet rs;
//    Conexion co = new Conexion();
   
    
    
    private Connection con = null; //CARGAR dRiVER Y ESTABLECER LA CONEXION CON LA BASE UNIVERSIDAD

    public LoginData() { //constructor va inicializar la variable con
        con = Conexion.getConexion();
        System.out.println("oups "+con);
        //getConexion es un metodo de la clase Conexion que va a cargar los driver y conectarse con la base
    }
    
    

    public Login logearse(String usuario,String pass){
        Login l = null;
       String sql = "Select * from usuarios where usuario = ? and pass = ?";
       try{
           PreparedStatement ps = con.prepareStatement(sql);
          ps.setString(1, usuario);
          ps.setString(2, pass);
         ResultSet rs = ps.executeQuery();
          if(rs.next()){
              l = new Login();
              l.setUsuario(rs.getString("usuario"));
              l.setPass(rs.getString("pass"));
          
          }
       
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "ERROR" + e.getMessage());
       
       }
     return l;
    }
     public void agregarUsuario(Login lo){ 
    
    String sql = "INSERT INTO usuarios (usuario,pass) VALUES (?, ?)";
    
    try {
            //preparedStatement envian la setencia anterior
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//que me devuelva la lista de claves generadas
            //Remplazo los ? por los datos del alumno que quiero enviar 
              ps.setString(1,lo.getUsuario());
              ps.setString(2,lo.getPass());
            ps.executeUpdate();//ejecuta el preparedStatement armado anterior
            ResultSet rs = ps.getGeneratedKeys();//Obtiene la clave,recibimos un resultset consulta
            if (rs.next()) {
//               
                System.out.println("Exito");
            }
            ps.close();
        } catch (SQLException ex) {
               System.out.println(ex.toString());
            
        }
    }
}
