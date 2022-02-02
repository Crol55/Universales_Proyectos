package universales.library.dto.practica2;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class FiltrarPolizaDto implements Serializable{

	private static final long serialVersionUID = 9036511902533615421L;

	private String ramo; 
	private Date fechaVencimiento;
	
	
}
