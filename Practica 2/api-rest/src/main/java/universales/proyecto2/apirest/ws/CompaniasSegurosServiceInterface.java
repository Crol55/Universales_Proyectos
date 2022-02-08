package universales.proyecto2.apirest.ws;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import universales.proyecto2.apirest.dto.CompaniasSegurosDto;
import universales.proyecto2.apirest.entity.CompaniasSeguros;


@RestController
@RequestMapping("/companiasSeguros")
@CrossOrigin
public interface CompaniasSegurosServiceInterface {
    

    @GetMapping(path = "/buscar")
    public List<CompaniasSeguros> buscar();

    @PostMapping(path = {"/guardar", "/actualizar"})
    public CompaniasSeguros guardar(@RequestBody CompaniasSegurosDto companiasSegurosDto);

    @PostMapping( path = "/eliminar" )
    public String eliminar(@RequestBody CompaniasSegurosDto companiasSegurosDto);

}
