package universales.proyecto2.apirest.dto;

public class CompaniasSeguros {
    
    private Integer id; 
    
    private Integer segurosNumeroPoliza;

    private String companiasNombreCompania;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSegurosNumeroPoliza() {
        return segurosNumeroPoliza;
    }

    public void setSegurosNumeroPoliza(Integer segurosNumeroPoliza) {
        this.segurosNumeroPoliza = segurosNumeroPoliza;
    }

    public String getCompaniasNombreCompania() {
        return companiasNombreCompania;
    }

    public void setCompaniasNombreCompania(String companiasNombreCompania) {
        this.companiasNombreCompania = companiasNombreCompania;
    }

}
