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

import lombok.Data;


@Data
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

    
}
