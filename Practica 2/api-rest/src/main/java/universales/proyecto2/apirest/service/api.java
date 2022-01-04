package universales.proyecto2.apirest.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hola")
public class api {

	@GetMapping("/mundo")
	public String respuesta() {
		
		return "Hola mundo desde visual studio code y ahora deberia estar funcionando vamuaver XD";
	}
}
