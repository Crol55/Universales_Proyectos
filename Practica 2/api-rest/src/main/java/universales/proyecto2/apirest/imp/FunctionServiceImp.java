package universales.proyecto2.apirest.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import universales.library.dto.practica2.SegurosDto;
import universales.proyecto2.apirest.service.ProcedimientoService;
import universales.proyecto2.apirest.ws.FunctionServiceInterface;

@Component
public class FunctionServiceImp implements FunctionServiceInterface
{
	@Autowired
	ProcedimientoService procedimientoService; 
	
	@Override
	public int insertPolizaFunc(SegurosDto segurosDto) {
		
		
		return procedimientoService.insertarPolizaFunction(segurosDto);
	}

	
}
