package universales.library.dto.practica2;

import java.io.Serializable;
import java.util.Date;

public class FiltrarPolizaDto implements Serializable{

	private static final long serialVersionUID = 9036511902533615421L;

	private String ramo; 
	private Date fechaVencimiento;
	
	
	public String getRamo() {
		return ramo;
	}
	public void setRamo(String ramo) {
		this.ramo = ramo;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	
	
}
