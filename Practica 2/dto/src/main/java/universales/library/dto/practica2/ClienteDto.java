package universales.library.dto.practica2;

import java.util.List;

import lombok.Data;

@Data
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
    

    
}
