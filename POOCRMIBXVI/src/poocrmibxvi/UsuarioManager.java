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

public class UsuarioManager {
   private ArrayList<Usuario> usuarios;   
   private ArrayList<Usuario> listar;
   
   public UsuarioManager() {
        this.usuarios = new ArrayList<Usuario>();
        this.listar = new ArrayList<Usuario>();
    }
   
   public void altaUsuario(String dni, String nombre, String apellidoPaterno, String apellidoMaterno, String usuario, String email, String fechaIngreso, String cargo, String contrasenha, String creadoPor, String creadoFecha) throws BusinessException {
      validacion(dni, nombre, apellidoPaterno,  apellidoMaterno, usuario, email, fechaIngreso,  cargo,  contrasenha);       
      Usuario nuevoRegistro = new Usuario(dni, nombre, apellidoPaterno, apellidoMaterno, usuario, email, fechaIngreso, cargo, contrasenha, creadoPor, creadoFecha);
      usuarios.add(nuevoRegistro);        
   }
   public void validacion(String dni, String nombre, String apellidoPaterno, String apellidoMaterno, String usuario, String email, String fechaIngreso, String cargo, String contrasenha ) throws BusinessException
   {  
        String mensaje = "";
        if (dni==null || dni.isEmpty())
            mensaje += "\nEl dni no puede ser vacio o nulo";        
        if (apellidoPaterno==null || apellidoPaterno.isEmpty())
            mensaje += "\nEl apellido paterno no puede ser vacio o nulo";        
        if (apellidoMaterno==null || apellidoMaterno.isEmpty())
            mensaje += "\nEl apellido materno no puede ser vacio o nulo";               
        if (nombre==null || nombre.isEmpty())
            mensaje += "\nEl nombre no puede ser vacio o nulo";
        if (usuario==null || usuario.isEmpty())
            mensaje += "\nEl usuario no puede ser vacio o nulo";        
        if (email==null ||  email.isEmpty())
            mensaje += "\nEl email no puede ser nulo o vacio";        
        if (fechaIngreso==null || fechaIngreso.isEmpty())
            mensaje += "\nLa Fecha de ingreso no puede ser vacio o nulo";
        if (cargo==null || cargo.isEmpty())
            mensaje += "\nEl cargo no puede ser vacio o nulo"; 
        //if (rol==null || rol.isEmpty())
        //    mensaje += "\nEl rol no puede ser vacio o nulo";         
        if (contrasenha==null || contrasenha.isEmpty())
            mensaje += "\nEl contraseña no puede ser vacio o nulo";                         
        if (! mensaje.isEmpty())
         throw new BusinessException(mensaje);      
   }
   
   public Usuario buscar(String dni) {
        for(Usuario usuario : usuarios)
            if (usuario.getDni().equals(dni))
               return usuario;
        return null;
    } 
    
   public Usuario buscarUsuario(String IdUsuario) {
        for(Usuario usuario : usuarios)
            if (usuario.getUsuario().equals(IdUsuario))
               return usuario;
        return null;
    } 
     public int getCantidadUsuarios() {        
        return usuarios.size();
    }
              
}
