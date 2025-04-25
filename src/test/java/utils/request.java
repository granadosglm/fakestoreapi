package utils;

public class request {
    private String codigoUnico;
    private String canal;
    private String terminalId;
    private String idTransaccion;
    private String valorCompra;
    private String tipoOperacion;
    private String condicionIva;
    private long iva;
    private long baseIva;
    private String condicionInc;
    private long inc;
    private String condicionPropina;
    private long propina;
    private String tipoQR;
    private String llave;
    private String tipollave;
    private String fechaDeVencimiento;
    private String referencia;
    private long usos;
//    private String billingNumber;
//    private String mobileNumber;
//    private String storeLabel;
//    private String loyaltyNumber;
//    private String referenceLabel;
//    private String customerLabel;
//    private String additionalConsumerDataRequest;

    public request(String codigoUnico, String canal, String terminalId, String idTransaccion, String valorCompra, String tipoOperacion, String condicionIva, long iva, long baseIva, String condicionInc, long inc, String condicionPropina, long propina, String tipoQR, String llave, String tipollave, String fechaDeVencimiento, String referencia, long usos) {
        this.codigoUnico = codigoUnico;
        this.canal = canal;
        this.terminalId = terminalId;
        this.idTransaccion = idTransaccion;
        this.valorCompra = valorCompra;
        this.tipoOperacion = tipoOperacion;
        this.condicionIva = condicionIva;
        this.iva = iva;
        this.baseIva = baseIva;
        this.condicionInc = condicionInc;
        this.inc = inc;
        this.condicionPropina = condicionPropina;
        this.propina = propina;
        this.tipoQR = tipoQR;
        this.llave = llave;
        this.tipollave = tipollave;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.referencia = referencia;
        this.usos = usos;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(String valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getCondicionIva() {
        return condicionIva;
    }

    public void setCondicionIva(String condicionIva) {
        this.condicionIva = condicionIva;
    }

    public long getIva() {
        return iva;
    }

    public void setIva(long iva) {
        this.iva = iva;
    }

    public long getBaseIva() {
        return baseIva;
    }

    public void setBaseIva(long baseIva) {
        this.baseIva = baseIva;
    }

    public String getCondicionInc() {
        return condicionInc;
    }

    public void setCondicionInc(String condicionInc) {
        this.condicionInc = condicionInc;
    }

    public long getInc() {
        return inc;
    }

    public void setInc(long inc) {
        this.inc = inc;
    }

    public String getCondicionPropina() {
        return condicionPropina;
    }

    public void setCondicionPropina(String condicionPropina) {
        this.condicionPropina = condicionPropina;
    }

    public long getPropina() {
        return propina;
    }

    public void setPropina(long propina) {
        this.propina = propina;
    }

    public String getTipoQR() {
        return tipoQR;
    }

    public void setTipoQR(String tipoQR) {
        this.tipoQR = tipoQR;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public String getTipollave() {
        return tipollave;
    }

    public void setTipollave(String tipollave) {
        this.tipollave = tipollave;
    }

    public String getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(String fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public long getUsos() {
        return usos;
    }

    public void setUsos(long usos) {
        this.usos = usos;
    }

}
