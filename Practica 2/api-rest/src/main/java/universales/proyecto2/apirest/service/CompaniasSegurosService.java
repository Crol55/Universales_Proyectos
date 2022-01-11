package universales.proyecto2.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import universales.proyecto2.apirest.dto.CompaniasSegurosDto;
import universales.proyecto2.apirest.entity.CompaniasSeguros;
import universales.proyecto2.apirest.repository.CompaniasSegurosRepository;

@RestController
@RequestMapping("/companiasSeguros")
@CrossOrigin
public class CompaniasSegurosService {
    @Autowired
    CompaniasSegurosRepository companiasSegurosRepository;

    @GetMapping(path = "/buscar")
    public List<CompaniasSeguros> buscar(){

        return companiasSegurosRepository.findAll();
    }

    @PostMapping(path = {"/guardar", "/actualizar"})
    public CompaniasSeguros guardar(@RequestBody CompaniasSegurosDto companiasSegurosDto){

        CompaniasSeguros companiasSegurosData = this.convertDtoToCompaniasSeguros(companiasSegurosDto);
        companiasSegurosRepository.save(companiasSegurosData);
        return companiasSegurosData;
    }

    @PostMapping( path = "/eliminar" )
    public String eliminar(@RequestBody CompaniasSegurosDto companiasSegurosDto){

        CompaniasSeguros companiaSeguro = this.convertDtoToCompaniasSeguros(companiasSegurosDto);
        Optional <CompaniasSeguros> seguroExistente = companiasSegurosRepository.findById(companiaSeguro.getId());
        if (seguroExistente.isPresent()){
            companiasSegurosRepository.delete(seguroExistente.get());
        }
        return "Successful";
    }

    private CompaniasSeguros convertDtoToCompaniasSeguros(CompaniasSegurosDto companiasSegurosDto){

        CompaniasSeguros companiaSeguro = new CompaniasSeguros();
        companiaSeguro.setId(companiasSegurosDto.getId());
        companiaSeguro.setSegurosNumeroPoliza(companiasSegurosDto.getSegurosNumeroPoliza());
        companiaSeguro.setCompaniasNombreCompania(companiasSegurosDto.getCompaniasNombreCompania());

        return companiaSeguro;
    }
}
