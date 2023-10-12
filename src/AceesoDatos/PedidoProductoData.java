
package AceesoDatos;

import java.sql.Connection;


public class PedidoProductoData {
    
    private Connection con = null; //CARGAR dRUVER Y ESTABLECER LA CONEXION CON LA BASE UNIVERSIDAD

    public PedidoProductoData() { //constructor va inicializar la variable con
        con = Conexion.getConexion();
        //getConexion es un metodo de la clase Conexion que va a cargar los driver y conectarse con la base
    }
    
    
    
}
