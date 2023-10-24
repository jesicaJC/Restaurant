
package restaurant;

import AceesoDatos.*;
import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import modelo.Mesa;
import modelo.Pedido;
import modelo.PedidoProducto;
import modelo.Producto;
import vistas.Sistema;
import vistas.VistaLogin;


public class Restaurant {

   
    public static void main(String[] args) {
//         VistaLogin vl = new VistaLogin();
//         vl.setVisible(true);
//         vl.setLocationRelativeTo(null);     
        
        
       //Agregar productos   
//Producto producto1 = new Producto("Pizza", 2000, 10, true);
//ProductoData produData = new ProductoData();//Guarda en la base
//produData.agregarproducto(producto1);


//ELIMINA PRODUCTO
//Producto producto1 = new Producto(2,"Pizza", 2000, 10, true);
//ProductoData produData = new ProductoData();//Guarda en la base
//produData.eliminarProducto(2);

// MODIFICA PRODUCTO
//Producto producto1 = new Producto(2,"Pizza con Morrones", 2000, 10, true);
//ProductoData produData = new ProductoData();//Guarda en la base
//produData.modificarProducto(producto1); 

//BUSCAR POR ID
//ProductoData produData = new ProductoData();//Guarda en la base
//Producto productoEncontrado = produData.buscarProducto(1);
// if(productoEncontrado != null){
//System.out.println("Nombre producto: "+ productoEncontrado.getNombreProducto());
//System.out.println("Precio $"+ productoEncontrado.getPrecio());
//System.out.println("Stock: "+ productoEncontrado.getStock());
//}
//LISTAR ALUMNOS
//Producto prod = new Producto();;//Guarda en la base
//ProductoData produData = new ProductoData();
//for(Producto producto:produData.listarAlumnos()){ 
////    System.out.println(alumno.getDni());
////    System.out.println(alumno.getApellido());
////    System.out.println(alumno.getNombre());
//    System.out.println(producto.toString());
//}
//----------------------------------------------------------------------
    //AGREGAR MESA
       
//MesaData medata = new MesaData();
//Mesa mesa = new Mesa(2, true, 5);
//medata.agregarMesa(mesa);
 

//ELIMINA MESA
//Mesa mesa = new Mesa(1,2, true, 5);
//MesaData medata = new MesaData();//Guarda en la base
//medata.borrarMesa(1);

// MODIFICA MESA
//Mesa mesa = new Mesa(2,2, true, 10);
//MesaData medata = new MesaData();//Guarda en la base
//medata.modificarMesa(mesa); 

//BUSCAR POR ID MESA
//MesaData medata = new MesaData();//Guarda en la base
//Mesa mesaEncontrado = medata.buscarMesa(2);
// if( mesaEncontrado != null){
//System.out.println(mesaEncontrado.toString());

//// LISTAR MESA
//        Mesa mesa = new Mesa();
//        MesaData medata = new MesaData();//Guarda en la base
//
//        for (Mesa me : medata.listarMesa()) {
//            System.out.println(me.toString());
//        }
//-------------------------------------------------------------------------------
                 //AGREGAR PEDIDO
//   Pedido pedido = new Pedido( 1, "Paco", 200, true);
//   PedidoData pedata = new PedidoData();//Guarda en la base
////   pedata.agregarPedido(pedido);
//
//              //LISTAR PEDIDOS
//        Pedido pedi = new Pedido();
//        for (Pedido pe : pedata.listarPedido()) {
////            System.out.println(pe.toString());
//        }
        
        
   
             //ELIMINAR PEDIDO
//      pedata.borrarPedido(6);
   

            //MODIFICA MESA
//       Pedido pedi = new Pedido( 5, 2, "Laura", 2500, true);
//       pedata.modificarPedido(pedi);
       
//------------------------------------------------------------------------------

          //LISTAR PEDIDOS POR MESERO
        PedidoProductoData pp = new PedidoProductoData();
//         pp.listarPedidoporMesero("Laura");
         System.out.println("   ");
         //LISTAR PEDIDOS POR INGRESO TOTAL
//         pp.listarIgresoTotalXFecha(Timestamp.valueOf("2023-10-12 17:43:09"));
        System.out.println("   ");
        //LISTAR PEDIDOS COBRADO POR MESERO X DIA
//        pp.listarPedidoCobroMeseroDia("Laura");
        System.out.println("   ");
        //LISTAR PEDIDOS X FECHA HORA
        
     

//       PedidoProducto p = new PedidoProducto(1, 1, 2);
//        System.out.println(p.toString());
    
//        LocalDateTime r = LocalDateTime.now();
//        System.out.println(r);
//        
//        
////        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd MMMM yyyy");
////        String resultado = formato.format(r);
////        System.out.println(resultado);
////        
//        
//        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm:ss");
//        String resultado = formato.format(r);
//        System.out.println(resultado);
    }
    
}


