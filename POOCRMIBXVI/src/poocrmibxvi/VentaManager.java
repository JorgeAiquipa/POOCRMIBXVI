/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poocrmibxvi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class VentaManager {
    private ArrayList<Venta> ventas;
    private ArrayList<Venta> listar;
    
    public VentaManager(){
        ventas = new ArrayList<Venta>();
        listar = new ArrayList<Venta>();
    }
    
    private void validarDatos(String tipo, String concepto, String numero, String fec_emision, String dni_cliente, double subtotal, double igv, double total, String moneda, String fec_ven, String fec_pago) throws BusinessException {
        String mensaje = "";
        if(tipo == null || tipo.isEmpty())
            mensaje += "Tipo no puede ser nulo o vacio\n";
        if(concepto == null || concepto.isEmpty())
            mensaje += "Concepto no puede ser nulo o vacio\n";
        if(numero == null || numero.isEmpty())
            mensaje += "Numero no puede ser nulo o vacio\n";
        if(fec_emision == null || fec_emision.isEmpty())
            mensaje += "Fecha de emision no puede ser nula o vacia\n";
        if(dni_cliente == null || dni_cliente.isEmpty())
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
    
    public Venta buscar(String tipo, String numero) {
        for(Venta venta : ventas)
            if (venta.getTipo().equals(tipo) && venta.getNumero().equals(numero))
               return venta;
        return null;
    } 
    
    public void altaVentas(String tipo, String concepto, String numero, String fec_emision, String dni_cliente, double subtotal, double igv, double total, String moneda, String fec_venc, String fec_pago, String estado, String observaciones) throws BusinessException {
        validarDatos(tipo, concepto, numero, fec_emision, dni_cliente, subtotal, igv, total, moneda, fec_venc, fec_pago);
        validaDuplicidad(tipo, numero);
        Venta venta = new Venta(tipo, concepto, numero, fec_emision, dni_cliente, subtotal, igv, total, moneda, fec_venc, fec_pago, estado, observaciones);
        ventas.add(venta);
    }
    
    public void filtroVentas(String concepto, String numero, String fecha_emision, String dni_cliente, String fec_venc, String fec_pago, String estado){    
        // Busqueda secuencial por strings
        for(Venta venta : ventas){
            if(venta.getConcepto().compareTo(concepto) == 0)
                 listar.add(venta);
        }
        //ordenamos la lista por fecha de vencimiento
        Collections.sort(listar, new Comparator() {    
            public int compare(Object o1, Object o2) {  
                Venta v1 = (Venta) o1;
                Venta v2 = (Venta) o2;
                return v1.getFec_venc().compareToIgnoreCase(v2.getFec_venc());  
            }  
        });      
    }
}
