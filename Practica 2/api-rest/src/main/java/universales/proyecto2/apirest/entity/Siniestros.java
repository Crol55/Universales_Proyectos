package universales.proyecto2.apirest.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
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

    @Column(name = "PERITOS_DNI_PERITO")
    private Integer peritosDniPerito;

    @ManyToOne 
    @JoinColumn(name = "SEGUROS_NUMERO_POLIZA")
    private Seguros seguro;

    

    
}
