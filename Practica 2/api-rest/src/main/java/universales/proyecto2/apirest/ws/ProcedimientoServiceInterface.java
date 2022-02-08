package universales.proyecto2.apirest.ws;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import universales.proyecto2.apirest.dto.FiltrarPolizaDto;
import universales.proyecto2.apirest.dto.SegurosDto;


@RestController
@RequestMapping("/procedimiento")
@CrossOrigin
public interface ProcedimientoServiceInterface {

	@PostMapping(path = "/insertar/poliza")
	public int insertPoliza( @RequestBody SegurosDto segurosDto);

	@PostMapping(path = "/filtrar/poliza")
	public FiltrarPolizaDto filtrarPoliza(@RequestBody SegurosDto segurosDto);
	
}
