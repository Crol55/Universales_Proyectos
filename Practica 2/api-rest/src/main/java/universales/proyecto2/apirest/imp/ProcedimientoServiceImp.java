package universales.proyecto2.apirest.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import universales.proyecto2.apirest.dto.FiltrarPolizaDto;
import universales.proyecto2.apirest.dto.SegurosDto;
import universales.proyecto2.apirest.service.ProcedimientoService;
import universales.proyecto2.apirest.ws.ProcedimientoServiceInterface;

@Component
public class ProcedimientoServiceImp implements ProcedimientoServiceInterface{

	@Autowired
	ProcedimientoService procedimientoService;
	@Override
	public int insertPoliza(SegurosDto segurosDto) {
		
		return procedimientoService.insertarPoliza(segurosDto);
	}
	
	@Override
	public FiltrarPolizaDto filtrarPoliza(SegurosDto segurosDto) {
		
		return procedimientoService.filtrarPoliza(segurosDto);
		
	}

	
}
