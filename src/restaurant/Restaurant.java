
package restaurant;

import AceesoDatos.*;
import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import modelo.Mesa;
import modelo.Pedido;
import modelo.Producto;


public class Restaurant {

   
    public static void main(String[] args) {
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

 //LISYTAR MESA
//        Mesa mesa = new Mesa();
//        MesaData medata = new MesaData();//Guarda en la base
//
//        for (Mesa me : medata.listarMesa()) {
//            System.out.println(me.toString());
//        }
//-------------------------------------------------------------------------------
                 //AGREGAR PEDIDO
   Pedido pedido = new Pedido( 2, "Paco", LocalDate.of(2023, 10, 11), 1000, true);
   PedidoData pedata = new PedidoData();//Guarda en la base
   pedata.agregarPedido(pedido);


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
 





  
    
//        LocalDateTime r = LocalDateTime.now();
//        System.out.println(r);
//        
//        
//        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd MMMM yyyy");
//        String resultado = formato.format(r);
//        System.out.println(resultado);
//        
//        
//         formato = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm:ss");
//        resultado = formato.format(r);
//        System.out.println(resultado);
    }
    
}


