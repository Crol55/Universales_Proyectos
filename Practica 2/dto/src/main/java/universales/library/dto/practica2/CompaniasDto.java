package universales.library.dto.practica2;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CompaniasDto {
    
    private String nombreCompania; 
    private String claseVia; 
    private String nombreVia; 
    private String numeroVia; 
    private String codPostal; 
    private String telefonoContratacion; 
    private String telefonoSiniestros; 
    private String notas;
    private List<SegurosDto> segurosList = new ArrayList<>();
    

}
