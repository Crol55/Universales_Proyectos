package universales.proyecto2.apirest.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class FiltrarPolizaDto implements Serializable{

	private static final long serialVersionUID = 9036511902533615421L;

	private String ramo; 
	private Date fechaVencimiento;
	
	
}
