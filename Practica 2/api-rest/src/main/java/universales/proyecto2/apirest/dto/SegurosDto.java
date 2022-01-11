package universales.proyecto2.apirest.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import universales.proyecto2.apirest.entity.Companias;

public class SegurosDto {
    
    private Integer numeroPoliza;
    private String ramo;
    private Date fechaInicio;
    private Date fechaVencimiento;
    private String condicionesParticulares;
    private String observaciones;
    private Integer clienteDniCl;
    private List<Companias> companiasList = new ArrayList<>();

    
    public List<Companias> getCompaniasList() {
        return companiasList;
    }

    public void setCompaniasList(List<Companias> companiasList) {
        this.companiasList = companiasList;
    }

    public Integer getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(Integer numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCondicionesParticulares() {
        return condicionesParticulares;
    }

    public void setCondicionesParticulares(String condicionesParticulares) {
        this.condicionesParticulares = condicionesParticulares;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getClienteDniCl() {
        return clienteDniCl;
    }

    public void setClienteDniCl(Integer clienteDniCl) {
        this.clienteDniCl = clienteDniCl;
    } 
}
