package poocrmibxvi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CompraManager {
    private ArrayList<Compra> compras;
    private ArrayList<Compra> listar;
    
    public CompraManager(){
        compras = new ArrayList<Compra>();
        listar = new ArrayList<Compra>();
    }
    
    private void validarDatos(String tipo, String concepto, String numero, String fec_emision, String empresa, double subtotal, double igv, double total, String moneda, String fec_ven, String fec_pago) throws BusinessException {
        String mensaje = "";
        if(tipo == null || tipo.isEmpty())
            mensaje += "Tipo no puede ser nulo o vacio\n";
        if(concepto == null || concepto.isEmpty())
            mensaje += "Concepto no puede ser nulo o vacio\n";
        if(numero == null || numero.isEmpty())
            mensaje += "Numero no puede ser nulo o vacio\n";
        if(fec_emision == null || fec_emision.isEmpty())
            mensaje += "Fecha de emision no puede ser nula o vacia\n";
        if(empresa == null || empresa.isEmpty())
            mensaje += "Numero no puede ser nulo o vacio\n";
        if(subtotal == 0)
            mensaje += "Numero no puede ser cero\n";
        if(igv == 0)
            mensaje += "IGV no puede ser cero\n";
        if(total == 0)
            mensaje += "Total no puede ser cero\n";
        if(moneda == null || moneda.isEmpty())
            mensaje += "Moneda no puede ser nula o vacia\n";
        if(fec_ven == null || fec_ven.isEmpty())
            mensaje += "Fecha de vencimiento no puede ser nula o vacia\n";
        if(fec_pago == null || fec_pago.isEmpty())
            mensaje += "Fecha de pago no puede ser nula o vacia\n";
        if (!mensaje.isEmpty())
            throw new BusinessException(mensaje);
    }
    
    private void validaDuplicidad(String tipo, String numero) throws BusinessException {
        if (buscar(tipo, numero) != null){           
            String mensaje = "El tipo de documento " + tipo + " con numero " + numero + " ya esta registrado";
            throw new BusinessException(mensaje);
        }
    }
    
    public Compra buscar(String tipo, String numero) {
        for(Compra compra : compras)
            if (compra.getTipo().equals(tipo) && compra.getNumero().equals(numero))
               return compra;
        return null;
    } 
    
    public void altaCompras(String tipo, String concepto, String numero, String fec_emision, String empresa, double subtotal, double igv, double total, String moneda, String fec_venc, String fec_pago, String estado, String observaciones) throws BusinessException {
        validarDatos(tipo, concepto, numero, fec_emision, empresa, subtotal, igv, total, moneda, fec_venc, fec_pago);
        validaDuplicidad(tipo, numero);
        Compra compra = new Compra(tipo, concepto, numero, fec_emision, empresa, subtotal, igv, total, moneda, fec_venc, fec_pago, estado, observaciones);
        compras.add(compra);
    }
    
    public void filtroVentas(String concepto, String numero, String fecha_emision, String empresa, String fec_venc, String fec_pago, String estado){    
        // Busqueda secuencial por strings
        for(Compra compra : compras){
            if(compra.getConcepto().compareTo(concepto) == 0)
                 listar.add(compra);
        }
        //ordenamos la lista por fecha de vencimiento
        Collections.sort(listar, new Comparator() {    
            public int compare(Object o1, Object o2) {  
                Compra c1 = (Compra) o1;
                Compra c2 = (Compra) o2;
                return c1.getFec_venc().compareToIgnoreCase(c2.getFec_venc());  
            }  
        });      
    }
}
