/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poocrmibxvi;
/**
 *
 * @author jaiquipa
 */
public class Cliente {    
    private String dni;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombre;
    private String email;
    private String telefono;    
    private String celular;
    private String fechaContacto;

    public Cliente(String dni, String apellidoPaterno, String apellidoMaterno, String nombre, String email, String telefono, String celular, String fechaContacto) {
        this.dni = dni;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.celular = celular;
        this.fechaContacto = fechaContacto;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @return the apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @return the fechaContacto
     */
    public String getFechaContacto() {
        return fechaContacto;
    }
                                     
}
