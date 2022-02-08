package universales.proyecto2.apirest.ws;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import universales.proyecto2.apirest.dto.SiniestrosDto;
import universales.proyecto2.apirest.entity.Siniestros;


@RestController
@RequestMapping("/siniestros")
@CrossOrigin
public interface SiniestrosServiceInterface {

    @GetMapping(path = {"/buscar"})
    public List<Siniestros> buscaString();

    @PostMapping(path = {"/guardar", "/actualizar"})
    public Siniestros guardar(@RequestBody SiniestrosDto siniestrosDto);

    @PostMapping( path = "/eliminar" )
    public String eliminar(@RequestBody SiniestrosDto siniestrosDto);

    @GetMapping( path = "/buscar/aceptacion/{aceptacion}" )
    public List<Siniestros> buscarPorAceptacion(@PathVariable String aceptacion);

    @GetMapping( path = "/buscar/aceptacionDistinta/{aceptacion}" )
    public List<Siniestros> buscarPorNoAceptacion(@PathVariable String aceptacion);
    
    @GetMapping( path = "/buscar/indemnizacion/{indemnizacion}" )
    public List<Siniestros> buscarPorIndemnizacion(@PathVariable String indemnizacion);

    
}
