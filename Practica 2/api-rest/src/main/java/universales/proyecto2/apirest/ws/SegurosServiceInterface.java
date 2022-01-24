package universales.proyecto2.apirest.ws;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import universales.library.dto.practica2.SegurosDto;
import universales.proyecto2.apirest.entity.Seguros;


@RestController
@RequestMapping("/seguros")
@CrossOrigin
public interface SegurosServiceInterface {
    
    @GetMapping(path = "/buscar")
    public List<Seguros> buscaString();

    @PostMapping(path = {"/guardar", "/actualizar"})
    public Seguros buscar(@RequestBody SegurosDto segurosDto);

    @PostMapping( path = "/eliminar" )
    public String eliminar(@RequestBody SegurosDto segurosDto);

    @GetMapping( path = "/buscar/ramo/{ramo}" )
    public List<Seguros> buscarPorRamoLike(@PathVariable String ramo);

    @GetMapping(path = "/buscar/antesFecha/{fechaInicio}") 
    public List<Seguros> buscarPorFechaInicioAnterior(@PathVariable String fechaInicio) throws ParseException;

    @GetMapping(path = "/buscar/ordenarFechaVencimiento/{ramo}") 
    public List<Seguros> buscarPorVigencia(@PathVariable String ramo);
}
