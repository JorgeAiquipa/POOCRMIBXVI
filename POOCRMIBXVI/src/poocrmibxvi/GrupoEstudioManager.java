package poocrmibxvi;

import java.util.ArrayList;

public class GrupoEstudioManager {    
    private ArrayList<GrupoEstudio> grupos;
    private ArrayList<GrupoEstudio> listar;
    
    public GrupoEstudioManager(){
        grupos = new ArrayList<GrupoEstudio>();
        listar = new ArrayList<GrupoEstudio>();
    }
    
    private void validarDatos(String nombre, String fecha_inicio, String fecha_fin) throws BusinessException {
        String mensaje = "";
        if(nombre == null || nombre.isEmpty())
            mensaje += "Fecha de pago no puede ser nula o vacia\n";
        if(fecha_inicio == null || fecha_inicio.isEmpty())
            mensaje += "Fecha de pago no puede ser nula o vacia\n";
        if(fecha_fin == null || fecha_fin.isEmpty())
            mensaje += "Fecha de pago no puede ser nula o vacia\n";
        if (!mensaje.isEmpty())
            throw new BusinessException(mensaje);
    }
    
    private void validaDuplicidad(String nombre) throws BusinessException {
        if (buscar(nombre) != null){           
            String mensaje = "El nombre de grupo " + nombre + " ya esta registrado";
            throw new BusinessException(mensaje);
        }
    }
    
    public GrupoEstudio buscar(String nombre) {
        for(GrupoEstudio grupo : grupos)
            if (grupo.getNombre().equals(nombre))
               return grupo;
        return null;
    }
    
    public void registrar(String nombre, String descripcion, String academia, String curso, String fecha_inicio, String fecha_fin, String estado, String instructores, String link, String local, String aula, String coordenadas) throws BusinessException {
        validarDatos(nombre, fecha_inicio, fecha_fin);
        validaDuplicidad(nombre);
        GrupoEstudio grupo = new GrupoEstudio(nombre, descripcion, academia, curso, fecha_inicio, fecha_fin, estado, instructores, link, local, aula, coordenadas);
        grupos.add(grupo);
    }
}