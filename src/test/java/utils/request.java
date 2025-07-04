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
    private String tipoLlave;
    private String reference;
    private String Usos;
    private String fechaExpiracion;
    private String billingNumber;
    private String mobileNumber;
    private String storeLabel;
    private String loyaltyNumber;
    private String referenceLabel;
    private String customerLabel;
    private String additionalConsumerDataRequest;
    private String rrn;
    private String numeroAutorizacion;

    public request(String codigoUnico, String canal, String terminalId, String idTransaccion, String valorCompra, String tipoOperacion, String condicionIva, long iva, long baseIva, String condicionInc, long inc, String condicionPropina, long propina, String tipoQR, String llave, String tipoLlave, String reference, String usos, String fechaExpiracion, String billingNumber, String mobileNumber, String storeLabel, String loyaltyNumber, String referenceLabel, String customerLabel, String additionalConsumerDataRequest, String rrn, String numeroAutorizacion) {
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
        this.tipoLlave = tipoLlave;
        this.reference = reference;
        Usos = usos;
        this.fechaExpiracion = fechaExpiracion;
        this.billingNumber = billingNumber;
        this.mobileNumber = mobileNumber;
        this.storeLabel = storeLabel;
        this.loyaltyNumber = loyaltyNumber;
        this.referenceLabel = referenceLabel;
        this.customerLabel = customerLabel;
        this.additionalConsumerDataRequest = additionalConsumerDataRequest;
        this.rrn = rrn;
        this.numeroAutorizacion = numeroAutorizacion;
    }
}
