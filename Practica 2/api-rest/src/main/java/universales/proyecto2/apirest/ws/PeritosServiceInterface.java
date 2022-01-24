package universales.proyecto2.apirest.ws;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import universales.library.dto.practica2.PeritosDto;
import universales.proyecto2.apirest.entity.Peritos;

@RestController
@RequestMapping("/peritos")
@CrossOrigin
public interface PeritosServiceInterface {
    
    @GetMapping(path = "/buscar")
    public List<Peritos> buscar();

    @PostMapping(path = {"/guardar", "/actualizar"})
    public Peritos guardar(@RequestBody PeritosDto peritosDto);

    @PostMapping( path = "/eliminar" )
    public String eliminar(@RequestBody PeritosDto peritosDto);


    @GetMapping( path = "/buscar/por/ciudad/{ciudad}" )
    public List<Peritos> buscarPeritosPorCiudad(@PathVariable String ciudad);

    @GetMapping( path = "/buscar/sin/numeroVia" )
    public List<Peritos> buscarPeritosSinNumeroVia();
}
