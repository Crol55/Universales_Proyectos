package universales.proyecto2.apirest.dto;

import java.util.Date;

import universales.proyecto2.apirest.entity.Seguros;

public class SiniestrosDto {
    
    private Integer idSiniestro;
    private Date fechaSiniestro;
    private String causas;
    private String aceptado;
    private String indemnizacion;
    private Integer peritosDniPerito;
    private Seguros seguro;


    public Seguros getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguros seguro) {
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
