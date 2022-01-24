package universales.proyecto2.apirest.ws;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import universales.library.dto.practica2.FiltrarPolizaDto;
import universales.library.dto.practica2.SegurosDto;


@RestController
@RequestMapping("/procedimiento")
@CrossOrigin
public interface ProcedimientoServiceInterface {

	@PostMapping(path = "/insertar/poliza")
	public int insertPoliza( @RequestBody SegurosDto segurosDto);

	@PostMapping(path = "/filtrar/poliza")
	public FiltrarPolizaDto filtrarPoliza(@RequestBody SegurosDto segurosDto);
	
}
