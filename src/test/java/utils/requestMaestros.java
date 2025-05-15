package utils;

public class requestMaestros {

    private String codigoUnico;
    private String codigoSeguridadQr;
    private String valorCompra;
    private String idTransaccion;
    private String terminalId;
    private Long propina;

    public requestMaestros(String codigoUnico, String codigoSeguridadQr, String valorCompra, String idTransaccion, String terminalId, Long propina) {
        this.codigoUnico = codigoUnico;
        this.codigoSeguridadQr = codigoSeguridadQr;
        this.valorCompra = valorCompra;
        this.idTransaccion = idTransaccion;
        this.terminalId = terminalId;
        this.propina = propina;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getCodigoSeguridadQr() {
        return codigoSeguridadQr;
    }

    public void setCodigoSeguridadQr(String codigoSeguridadQr) {
        this.codigoSeguridadQr = codigoSeguridadQr;
    }

    public String getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(String valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public Long getPropina() {
        return propina;
    }

    public void setPropina(Long propina) {
        this.propina = propina;
    }
}
