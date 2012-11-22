package poocrmibxvi;

public class GrupoEstudio {
    private String nombre;
    private String descripcion;
    private String academia;
    private String curso;
    private String fecha_inicio;
    private String fecha_fin;
    private String estado;
    private String instructores;
    private String link;
    private String local;
    private String aula;
    private String coordenadas;
    
    public GrupoEstudio(String nombre, String descripcion, String academia, String curso, String fecha_inicio, String fecha_fin, String estado, String instructores, String link, String local, String aula, String coordenadas){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.academia = academia;
        this.curso = curso;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
        this.instructores = instructores;
        this.link = link;
        this.local = local;
        this.aula = aula;
        this.coordenadas = coordenadas;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        this.academia = academia;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getInstructores() {
        return instructores;
    }

    public void setInstructores(String instructores) {
        this.instructores = instructores;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }
}