package universales.library.dto.practica2;

import java.util.Date;


public class SiniestrosDto {
    
    private Integer idSiniestro;
    private Date fechaSiniestro;
    private String causas;
    private String aceptado;
    private String indemnizacion;
    private Integer peritosDniPerito;
    private SegurosDto seguro;


    public SegurosDto getSeguro() {
        return seguro;
    }

    public void setSeguro(SegurosDto seguro) {
        this.seguro = seguro;
    }

    public Integer getIdSiniestro() {
        return idSiniestro;
    }

    public void setIdSiniestro(Integer idSiniestro) {
        this.idSiniestro = idSiniestro;
    }

    public Date getFechaSiniestro() {
        return fechaSiniestro;
    }

    public void setFechaSiniestro(Date fechaSiniestro) {
        this.fechaSiniestro = fechaSiniestro;
    }

    public String getCausas() {
        return causas;
    }

    public void setCausas(String causas) {
        this.causas = causas;
    }

    public String getAceptado() {
        return aceptado;
    }

    public void setAceptado(String aceptado) {
        this.aceptado = aceptado;
    }

    public String getIndemnizacion() {
        return indemnizacion;
    }

    public void setIndemnizacion(String indemnizacion) {
        this.indemnizacion = indemnizacion;
    }


    public Integer getPeritosDniPerito() {
        return peritosDniPerito;
    }

    public void setPeritosDniPerito(Integer peritosDniPerito) {
        this.peritosDniPerito = peritosDniPerito;
    }
}
