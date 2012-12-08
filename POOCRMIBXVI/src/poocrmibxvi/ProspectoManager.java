/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poocrmibxvi;

/**
 *
 * @author jaiquipa
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProspectoManager {
   private ArrayList<Prospecto> prospectos;   
   private ArrayList<Prospecto> listar;

    public ProspectoManager() {
        this.prospectos = new ArrayList<Prospecto>();
        this.listar = new ArrayList<Prospecto>();
    }
       
    public void validacion( String apellidoPaterno,  String nombres, String email ) throws BusinessException
   {  
        String mensaje = "";
        if (apellidoPaterno==null || apellidoPaterno.isEmpty())
            mensaje += "\nEl apellido paterno no puede ser vacio o nulo";
        if (nombres==null || nombres.isEmpty())
            mensaje += "\nEl nombre no puede ser vacio o nulo";
        if (email==null ||  email.isEmpty())
            mensaje += "\nEl email no puede ser nulo o vacio";        
        if (! mensaje.isEmpty())
         throw new BusinessException(mensaje);      
   }
   
    private void validaDuplicidad(String numero) throws BusinessException {
        if (buscar( numero) != null){           
            String mensaje = "Ya esta registrado  : " + numero;
            throw new BusinessException(mensaje);
        }
    }
    
   public void altaProspectos(String dni, String apellidoPaterno, String apellidoMaterno, String nombres, String email, String telefono, String fec_contac)   
      throws BusinessException {
      validacion(apellidoPaterno,nombres,email);
      siExisteCliente(dni);
      Prospecto nuevoRegistro = new Prospecto(dni,apellidoPaterno,apellidoMaterno,nombres,email,telefono,fec_contac);
      prospectos.add(nuevoRegistro);        
    } 
   
   public Prospecto buscar(String numero) {
        for(Prospecto prospecto : prospectos)
            if (prospecto.getDni().equals(numero))
               return prospecto;
        return null;
    } 
    
    public void filtroProspectos(String dni, String apellidoPaterno, String apellidoMaterno, String nombres, String email, String telefono, String celular, String fechaContacto) throws BusinessException
    {    
        // Busqueda secuencial por strings  falta comparar mas campos.
        for(Prospecto prospecto : prospectos)        
        {   if(prospecto.getDni().compareTo(dni) == 0  || prospecto.getApellidoPaterno().compareTo(apellidoPaterno) == 0 || prospecto.getApellidoPaterno().compareTo(apellidoMaterno) == 0  || prospecto.getNombres().compareTo(nombres) == 0 )
                 listar.add(prospecto);
           
        }                               
        if(getCantidadSegunFiltro()>0)
        {
         //ordenamos la lista por fecha de Contacto        
        Collections.sort(listar, new Comparator() {    
            public int compare(Object o1, Object o2) {  
                Prospecto c1 = (Prospecto) o1;  
                Prospecto c2 = (Prospecto) o2;  
                return c1.getFec_contac().compareToIgnoreCase(c2.getFec_contac());  
            }  
        });      
        }
        else 
        {
          String mensaje = "No se encontraron registros para los filtros ingresados " ;
          throw new BusinessException(mensaje);        
         }
        
     }
    
    public void siExisteCliente(String dni) throws BusinessException{
        ClienteManager cm = new ClienteManager();
        Cliente c = cm.buscar(dni);
        if(c == null)
            throw new BusinessException("El cliente ya existe");
    }
   
    public int getCantidadProspectos() {        
        return prospectos.size();
    }
    
    public int getCantidadSegunFiltro() {        
        return listar.size();
    }    
    
    public Boolean eliminarProspecto(Prospecto prospectobsq)
    {
       return  prospectos.remove(prospectobsq);
    }
       
}
