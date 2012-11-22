/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poocrmibxvi;

/**
 *
 * @author Luis Wakai
 */
public class Prospecto {

    private String dni;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private String email;
    private String telefono;
    private String fec_contac;
    
    
    public Prospecto(String dni, String apellidoPaterno, String apellidoMaterno, String nombres, String email, String telefono, String fec_contac) {
        this.dni = dni;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;
        this.email = email;
        this.telefono = telefono;        
        this.fec_contac = fec_contac;    
    }
    
    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return the apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @param apellidoMaterno the apellidoMaterno to set
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @return the nombre
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @return the fec_contac
     */
    public String getFec_contac() {
        return fec_contac;
    }

    /**
     * @param fec_contac the fec_contac to set
     */
    public void setFec_contac(String fec_contac) {
        this.fec_contac = fec_contac;
    }

}
