/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poocrmibxvi;

import java.util.ArrayList;

/**
 *
 * @author jaiquipa
 */
public class AutenticationUsuario {    
    private ArrayList<Integer> cargaUsuario;
    
    public void Login(String IdUsuario, String contrasenha, ArrayList <Usuario> User) throws BusinessException
    {
        String mensaje = "";
        validarDatos(IdUsuario,contrasenha);
        UsuarioManager admusu = new UsuarioManager();           
        Usuario user =  admusu.buscarUsuario(User,IdUsuario);
        if (user == null){           
            mensaje += "El Usuario " + IdUsuario + " no existe ";
            throw new BusinessException(mensaje);
        }
        else
            if (contrasenha.equalsIgnoreCase(contrasenha))
            {  mensaje += "Contraseña es incorrecto";
               throw new BusinessException(mensaje);
            } else {
                cargaUsuario.add(1);
            }
    }
    
    private void validarDatos(String usuario, String contrasenha) throws BusinessException {
        String mensaje = "";
        if(usuario == null || usuario.isEmpty())
            mensaje += "El usuario no puede ser nulo o vacio\n";
        if(contrasenha == null || contrasenha.isEmpty())
            mensaje += "La contrasena no puede ser nula o vacia\n";
        if (!mensaje.isEmpty())
            throw new BusinessException(mensaje);
    }
}
