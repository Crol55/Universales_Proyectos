package universales.proyecto2.apirest.dto;

import java.util.Date;

import lombok.Data;

@Data
public class SiniestrosDto {
    
    private Integer idSiniestro;
    private Date fechaSiniestro;
    private String causas;
    private String aceptado;
    private String indemnizacion;
    private Integer peritosDniPerito;
    private SegurosDto seguro;

}
