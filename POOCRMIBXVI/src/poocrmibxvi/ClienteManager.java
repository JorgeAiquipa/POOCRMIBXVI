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
      AutenticationUsuario autentica = new AutenticationUsuario();
      int usuAutentica = autentica.getCargaUsuario();
      if(usuAutentica == 1){
        validacion(dni,apellidoPaterno,apellidoMaterno,nombre,email,telefono,celular,fechaContacto);       
        Cliente nuevoRegistro = new Cliente(dni,apellidoPaterno,apellidoMaterno,nombre,email,telefono,fechaContacto);
        clientes.add(nuevoRegistro);  
      }
    } 
   
   public void filtroClientes(String dni, String apellidoPaterno, String apellidoMaterno, String nombre, String email, String telefono, String celular, String fechaContacto) 
    {    
        // Busqueda secuencial por strings  falta comparar mas campos.
        for(Cliente cliente : clientes)        
        {   if(cliente.getDni().compareTo(dni) == 0  || cliente.getApellidoPaterno().compareTo(apellidoPaterno) == 0 || cliente.getApellidoPaterno().compareTo(apellidoMaterno) == 0  || cliente.getNombres().compareTo(nombre) == 0 )
                 listar.add(cliente);
        }                               
         //ordenamos la lista por fecha de vencimiento
        Collections.sort(listar, new Comparator() {    
            public int compare(Object o1, Object o2) {  
                Cliente c1 = (Cliente) o1;  
                Cliente c2 = (Cliente) o2;  
                return c1.getFec_contac().compareToIgnoreCase(c2.getFec_contac());  
            }  
        });      
     }
   
       public int getCantidadClientes() {        
        return clientes.size();
    }
       
    private void validaDuplicidad(String numero) throws BusinessException {
        if (buscar( numero) != null){           
            String mensaje = "Ya esta registrado  : " + numero;
            throw new BusinessException(mensaje);
        }
    }
       
    public Cliente buscar(String dni) {
        for(Cliente cliente : clientes)
            if (cliente.getDni().equals(dni))
               return cliente;
        return null;
    } 
    
    public Boolean eliminarCliente(Cliente clientebsq)
    {
       AutenticationUsuario autentica = new AutenticationUsuario();
       int usuAutentica = autentica.getCargaUsuario();
       if(usuAutentica == 1){
            VentaManager admventa = new VentaManager();
            Venta venta = admventa.buscarVentaDni(clientebsq.getDni());
            if( venta != null)
            {
                return clientes.remove(clientebsq);    
            }
            else
                return false;
       } else {
           return false;
       }
    }
           
    public void convertirAProspecto(Cliente cliente) throws BusinessException
    {
        AutenticationUsuario autentica = new AutenticationUsuario();
        int usuAutentica = autentica.getCargaUsuario();
        if(usuAutentica == 1){
            ProspectoManager AdmProsp = new ProspectoManager();
            if (eliminarCliente(cliente))
            {
               AdmProsp.altaProspectos(cliente.getDni(),
                                       cliente.getApellidoPaterno(),
                                       cliente.getApellidoMaterno(),
                                       cliente.getNombres(),
                                       cliente.getEmail(),
                                       cliente.getTelefono(),
                                       cliente.getFec_contac()); 
            }
            else
                throw new BusinessException(" No se puede convertir el Cliente a Prospecto");
        }        
    }
    
}