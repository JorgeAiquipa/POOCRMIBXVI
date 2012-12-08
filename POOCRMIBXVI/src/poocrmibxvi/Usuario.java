/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poocrmibxvi;

/**
 *
 * @author jaiquipa
 */
public class Usuario {
    private String dni;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String usuario;
    private String email;
    private String fechaIngreso;
    private String cargo;
    //private String rol;
    private String contrasenha;
    private String creadoPor;
    private String creadoFecha;
    private String actualizadoPor;
    private String actualizadoFecha;

    public Usuario(String dni, String nombre, String apellidoPaterno, String apellidoMaterno, String usuario, String email, String fechaIngreso, String cargo, String contrasenha, String creadoPor, String creadoFecha, String actualizadoPor, String actualizadoFecha) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.usuario = usuario;
        this.email = email;
        this.fechaIngreso = fechaIngreso;
        this.cargo = cargo;
        //this.rol = rol;
        this.contrasenha = contrasenha;
        this.creadoPor = creadoPor;
        this.creadoFecha = creadoFecha;
        this.actualizadoPor = actualizadoPor;
        this.actualizadoFecha = actualizadoFecha;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
     * @return the fechaIngreso
     */
    public String getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * @param fechaIngreso the fechaIngreso to set
     */
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the contrasenha
     */
    public String getContrasenha() {
        return contrasenha;
    }

    /**
     * @param contrasenha the contrasenha to set
     */
    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    /**
     * @return the creadoPor
     */
    public String getCreadoPor() {
        return creadoPor;
    }

    /**
     * @param creadoPor the creadoPor to set
     */
    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    /**
     * @return the creadoFecha
     */
    public String getCreadoFecha() {
        return creadoFecha;
    }

    /**
     * @param creadoFecha the creadoFecha to set
     */
    public void setCreadoFecha(String creadoFecha) {
        this.creadoFecha = creadoFecha;
    }

    /**
     * @return the actualizadoPor
     */
    public String getActualizadoPor() {
        return actualizadoPor;
    }

    /**
     * @param actualizadoPor the actualizadoPor to set
     */
    public void setActualizadoPor(String actualizadoPor) {
        this.actualizadoPor = actualizadoPor;
    }

    /**
     * @return the actualizadoFecha
     */
    public String getActualizadoFecha() {
        return actualizadoFecha;
    }

    /**
     * @param actualizadoFecha the actualizadoFecha to set
     */
    public void setActualizadoFecha(String actualizadoFecha) {
        this.actualizadoFecha = actualizadoFecha;
    }
    
    
    
    
}
