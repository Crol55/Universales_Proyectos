package universales.library.dto.practica2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class SegurosDto {
    
    private Integer numeroPoliza;
    private String ramo;
    private Date fechaInicio;
    private Date fechaVencimiento;
    private String condicionesParticulares;
    private String observaciones;
    private Integer clienteDniCl;
    private List<CompaniasDto> companiasList = new ArrayList<>();

 
}
