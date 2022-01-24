package universales.library.dto.practica2;

import java.util.List;

public class ClienteDto {
    
    private Integer dniCl;
    private String nombreCl;
    private String apellido1;
    private String apellido2;
    private String claseVia;    
    private String nombreVia;   
    private String numeroVia;
    private String codPostal;
    private String ciudad;
    private String telefono;
    private String observaciones;
    private List<SegurosDto> segurosList;
    

    public Integer getDniCl() {
        return dniCl;
    }

    public void setDniCl(Integer dniCl) {
        this.dniCl = dniCl;
    }

    public String getNombreCl() {
        return nombreCl;
    }

    public void setNombreCl(String nombreCl) {
        this.nombreCl = nombreCl;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<SegurosDto> getSegurosList() {
        return segurosList;
    }

    public void setSegurosList(List<SegurosDto> segurosList) {
        this.segurosList = segurosList;
    }

    
}
