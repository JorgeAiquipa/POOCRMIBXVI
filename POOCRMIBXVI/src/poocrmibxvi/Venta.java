package poocrmibxvi;

public class Venta {
    private String concepto;
    private String tipo;
    private String numero;
    private String dni_cliente;
    private String fec_emision;
    private String fec_venc;
    private String fec_pago;
    private String estado;
    private double subtotal;
    private double igv;
    private double total;
    private String moneda;
    private String observaciones;
    
    public Venta(String tipo, String concepto, String numero, String fec_emision, String dni_cliente, double subtotal, double igv, double total, String moneda, String fec_venc, String fec_pago, String estado, String observaciones){
        this.tipo = tipo;
        this.concepto = concepto;
        this.numero = numero;
        this.dni_cliente = dni_cliente;
        this.fec_emision = fec_emision;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.moneda = moneda;
        this.fec_venc = fec_venc;
        this.fec_pago = fec_pago;
	this.estado = estado;
        this.observaciones = observaciones;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmpresa() {
        return dni_cliente;
    }

    public void setEmpresa(String empresa) {
        this.dni_cliente = dni_cliente;
    }

    public String getFec_emision() {
        return fec_emision;
    }

    public void setFec_emision(String fec_emision) {
        this.fec_emision = fec_emision;
    }

    public String getFec_venc() {
        return fec_venc;
    }

    public void setFec_venc(String fec_venc) {
        this.fec_venc = fec_venc;
    }

    public String getFec_pago() {
        return fec_pago;
    }

    public void setFec_pago(String fec_pago) {
        this.fec_pago = fec_pago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
