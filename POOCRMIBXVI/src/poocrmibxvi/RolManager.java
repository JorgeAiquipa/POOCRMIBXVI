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


public class RolManager {
        private ArrayList<Rol> roles;

    public RolManager() {
           roles = new ArrayList<Rol>();
    }

    private void validarDatos(String nombre, String descripcion, String permisos) throws BusinessException {
        String mensaje = "";
        if(nombre == null || nombre.isEmpty())
            mensaje += "Identificacion no puede ser nula o vacia\n";
        if(descripcion == null || descripcion.isEmpty())
            mensaje += "Identificacion no puede ser nula o vacia\n";
        if(permisos == null || permisos.isEmpty())
            mensaje += "Identificacion no puede ser nula o vacia\n";
        if (!mensaje.isEmpty())
            throw new BusinessException(mensaje);
    }
    
    public void registrar(String nombre, String descripcion, String permisos) throws BusinessException {
        validarDatos(nombre, descripcion, permisos);
        Rol rol = new Rol(nombre, descripcion, permisos);
        roles.add(rol);
    }    
    
    
    
}

