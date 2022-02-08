package universales.proyecto2.apirest.ws;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import universales.proyecto2.apirest.dto.CompaniasDto;
import universales.proyecto2.apirest.entity.Companias;


@RestController
@RequestMapping("/companias")
@CrossOrigin
public interface CompaniasServiceInteface {
    

    @GetMapping(path = "/buscar")
    public List <Companias> buscar();

    @PostMapping(path = {"/guardar", "actualizar"})
    public Companias guardar(@RequestBody CompaniasDto companiasDto);

    @PostMapping( path = "/eliminar" )
    public String eliminar(@RequestBody CompaniasDto companiasDto);
    

}
