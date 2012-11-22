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
      Prospecto nuevoRegistro = new Prospecto(dni,apellidoPaterno,apellidoMaterno,nombres,email,telefono,fec_contac);
      prospectos.add(nuevoRegistro);        
    } 
   
   public Prospecto buscar(String numero) {
        for(Prospecto prospecto : prospectos)
            if (prospecto.getDni().equals(numero))
               return prospecto;
        return null;
    } 
    
}
