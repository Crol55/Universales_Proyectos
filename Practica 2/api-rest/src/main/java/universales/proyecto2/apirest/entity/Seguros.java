package universales.proyecto2.apirest.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "SEGUROS")
public class Seguros implements Serializable{
    
    private static final long serialVersionUID = -4136731007764547125L;

    @Id
    @Column(name = "NUMERO_POLIZA")
    private Integer numeroPoliza;

    @Column(name = "RAMO")
    private String ramo;

    @Column(name = "FECHA_INICIO")
    private Date fechaInicio;

    @Column(name = "FECHA_VENCIMIENTO")
    private Date fechaVencimiento;

    @Column(name = "CONDICIONES_PARTICULARES")
    private String condicionesParticulares;

    @Column(name = "OBSERVACIONES")
    private String observaciones;

    @Column(name = "cliente_dni_cl")
    private Integer clienteDniCl;

    
    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(name = "COMPANIAS_SEGUROS", 
        joinColumns = {
            @JoinColumn(name = "SEGUROS_NUMERO_POLIZA")
        }, 
        inverseJoinColumns = {
            @JoinColumn(name = "COMPANIAS_NOMBRE_COMPANIA")
        }
    )
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
