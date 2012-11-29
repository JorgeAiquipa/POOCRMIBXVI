/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poocrmibxvi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
  * @author jaiquipa
 */
public class ClienteManager {   
   private ArrayList<Cliente> clientes;   
   private ArrayList<Cliente> listar;    
   
   public ClienteManager() {
     clientes = new ArrayList<Cliente>();
     listar = new ArrayList<Cliente>();
   }        
   
  public void validacion(String dni, String apellidoPaterno, String apellidoMaterno, String nombre, String email, String telefono, String celular, String fechaContacto ) throws BusinessException
  {  
        String mensaje = "";
        if (apellidoPaterno==null || apellidoPaterno.isEmpty())
            mensaje += "\nEl apellido paterno no puede ser vacio o nulo";
        if (nombre==null || nombre.isEmpty())
            mensaje += "\nEl nombre no puede ser vacio o nulo";
        if (email==null ||  email.isEmpty())
            mensaje += "\nEl email no puede ser nulo o vacio";        
        if (! mensaje.isEmpty())
         throw new BusinessException(mensaje);      
   }

  public void altaClientes(String dni, String apellidoPaterno, String apellidoMaterno, String nombre, String email, String telefono, String celular, String fechaContacto)   
      throws BusinessException {
      validacion(dni,apellidoPaterno,apellidoMaterno,nombre,email,telefono,celular,fechaContacto);       
      Cliente nuevoRegistro = new Cliente(dni,apellidoPaterno,apellidoMaterno,nombre,email,telefono,celular,fechaContacto);
      clientes.add(nuevoRegistro);        
    } 
   
   public void filtroClientes(String dni, String apellidoPaterno, String apellidoMaterno, String nombre, String email, String telefono, String celular, String fechaContacto) 
    {    
        // Busqueda secuencial por strings  falta comparar mas campos.
        for(Cliente cliente : clientes)        
        {   if(cliente.getDni().compareTo(dni) == 0)
                 listar.add(cliente);
        }                               
         //ordenamos la lista por fecha de vencimiento
        Collections.sort(listar, new Comparator() {    
            public int compare(Object o1, Object o2) {  
                Cliente c1 = (Cliente) o1;  
                Cliente c2 = (Cliente) o2;  
                return c1.getDni().compareToIgnoreCase(c2.getDni());  
            }  
        });      
     }
   
       public int getCantidadClientes() {        
        return clientes.size();
    }
       
    public Cliente buscar(String dni) {
        for(Cliente cliente : clientes)
            if (cliente.getDni().equals(dni))
               return cliente;
        return null;
    } 
           
}