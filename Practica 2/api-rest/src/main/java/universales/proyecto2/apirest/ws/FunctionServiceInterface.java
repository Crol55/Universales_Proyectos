package universales.proyecto2.apirest.ws;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import universales.library.dto.practica2.SegurosDto;

@RestController
@RequestMapping("/funciones")
@CrossOrigin
public interface FunctionServiceInterface {

	@PostMapping(path= "/insert/poliza")
    public int insertPolizaFunc(@RequestBody SegurosDto segurosDto);
}
