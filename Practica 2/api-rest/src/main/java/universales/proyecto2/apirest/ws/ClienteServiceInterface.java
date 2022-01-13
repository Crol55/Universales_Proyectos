package universales.proyecto2.apirest.ws;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import universales.proyecto2.apirest.dto.ClienteDto;
import universales.proyecto2.apirest.entity.Cliente;


@RestController
@RequestMapping("/cliente")
@CrossOrigin
public interface ClienteServiceInterface {
    
    @GetMapping(path = "/buscar")
    public List<Cliente> respuesta();
    
    @PostMapping( path = {"/guardar", "/actualizar"} )
    public Cliente guardar(@RequestBody ClienteDto clienteDto);

    @PostMapping( path = "/eliminar" )
    public String eliminar(@RequestBody ClienteDto clienteDto);

    @GetMapping(path = "/buscar/codPostal/{codPostal}")
    public List<Cliente> buscarPorCodPostal(@PathVariable String codPostal);

    @GetMapping(path = "/buscar/apellidos/{apellido1}/or/{apellido2}")
    public List<Cliente> buscarPorApellidos(@PathVariable String apellido1, @PathVariable String apellido2);
}
