package universales.proyecto2.apirest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "COMPANIAS_SEGUROS")
public class CompaniasSeguros implements Serializable{
    
    private static final long serialVersionUID = 2236731007764547133L;

    @Id
    @Column(name = "ID")
    private Integer id; 

    @Column(name = "SEGUROS_NUMERO_POLIZA")
    private Integer segurosNumeroPoliza;

    @Column(name = "COMPANIAS_NOMBRE_COMPANIA")
    private String companiasNombreCompania;
    
    
}
