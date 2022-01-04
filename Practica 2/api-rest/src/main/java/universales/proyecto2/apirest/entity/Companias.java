package universales.proyecto2.apirest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    
    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public String getClaseVia() {
        return claseVia;
    }

    public void setClaseVia(String claseVia) {
        this.claseVia = claseVia;
    }

    public String getNombreVia() {
        return nombreVia;
    }

    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }

    public String getNumeroVia() {
        return numeroVia;
    }

    public void setNumeroVia(String numeroVia) {
        this.numeroVia = numeroVia;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getTelefonoContratacion() {
        return telefonoContratacion;
    }

    public void setTelefonoContratacion(String telefonoContratacion) {
        this.telefonoContratacion = telefonoContratacion;
    }

    public String getTelefonoSiniestros() {
        return telefonoSiniestros;
    }

    public void setTelefonoSiniestros(String telefonoSiniestros) {
        this.telefonoSiniestros = telefonoSiniestros;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    } 


    
}
