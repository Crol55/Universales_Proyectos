package universales.proyecto2.apirest.entity;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "COMPANIAS")
public class Companias implements Serializable {
    private static final long serialVersionUID = 4136731007764547133L;

    @Id
    @Column(name = "NOMBRE_COMPANIA")
    private String nombreCompania; 

    @Column(name = "CLASE_VIA")
    private String claseVia; 

    @Column(name = "NOMBRE_VIA")
    private String nombreVia; 

    @Column(name = "NUMERO_VIA")
    private String numeroVia; 

    @Column(name = "COD_POSTAL")
    private String codPostal; 

    @Column(name = "TELEFONO_CONTRATACION")
    private String telefonoContratacion; 

    @Column(name = "TELEFONO_SINIESTROS")
    private String telefonoSiniestros; 

    @Column(name = "NOTAS")
    private String notas;

    @JsonIgnore
    @ManyToMany(mappedBy = "companiasList")
    private List<Seguros> segurosList = new ArrayList<>();
    
    
}
