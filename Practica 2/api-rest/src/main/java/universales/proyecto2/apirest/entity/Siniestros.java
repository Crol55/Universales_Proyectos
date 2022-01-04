package universales.proyecto2.apirest.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SINIESTROS")
public class Siniestros implements Serializable{
    private static final long serialVersionUID = 3217731007764547133L;

    @Id
    @Column(name = "ID_SINIESTRO")
    private Integer idSiniestro;

    @Column(name = "FECHA_SINIESTRO")
    private Date fechaSiniestro;

    @Column(name = "CAUSAS")
    private String causas;

    @Column(name = "ACEPTADO")
    private String aceptado;

    @Column(name = "INDEMNIZACION")
    private String indemnizacion;

    @Column(name = "SEGUROS_NUMERO_POLIZA")
    private Integer segurosNumeroPoliza;

    @Column(name = "PERITOS_DNI_PERITO")
    private Integer peritosDniPerito;

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

    public Integer getSegurosNumeroPoliza() {
        return segurosNumeroPoliza;
    }

    public void setSegurosNumeroPoliza(Integer segurosNumeroPoliza) {
        this.segurosNumeroPoliza = segurosNumeroPoliza;
    }

    public Integer getPeritosDniPerito() {
        return peritosDniPerito;
    }

    public void setPeritosDniPerito(Integer peritosDniPerito) {
        this.peritosDniPerito = peritosDniPerito;
    }

    
}
