package universales.proyecto2.apirest.ws;


import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import universales.library.dto.practica2.ClienteDto;
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

    @GetMapping(path = "/busqueda/nativa")
    public List<Map<String, Object>> busquedaNativa();

    @PostMapping( path = "/guardar/nativa" )
    public Cliente guardarNativa(@RequestBody ClienteDto clienteDto);

    @PutMapping( path = "/actualizar/nativa" )
    public Cliente actualizarNativa(@RequestBody ClienteDto clienteDto);

    @DeleteMapping( path = "/eliminar/nativa")
    public Cliente eliminarNativa(@RequestBody ClienteDto clienteDto);
}
