/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poocrmibxvi;

/**
 *
 * @author jaiquipa
 */
public class AutenticationUsuario {
    
    
    
    public void Login(String IdUsuario, String contrasenha) throws BusinessException
    {
        String mensaje = "";
        UsuarioManager admusu = new UsuarioManager();           
        Usuario user =  admusu.buscarUsuario(IdUsuario);
        if (user == null){           
            mensaje += "El Usurio " + IdUsuario + " no existe";
            throw new BusinessException(mensaje);
        }
        else
            if (contrasenha.equalsIgnoreCase(contrasenha))
            { 
               mensaje += "Contraseña es incorrecto";
               throw new BusinessException(mensaje);
            }
    }
}
