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

import universales.proyecto2.apirest.dto.CompaniasDto;
import universales.proyecto2.apirest.entity.Companias;

import universales.proyecto2.apirest.repository.CompaniasRepository;

@RestController
@RequestMapping("/companias")
@CrossOrigin
public class CompaniasService {
    
    @Autowired 
    CompaniasRepository companiasRepository; 

    @GetMapping(path = "/buscar")
    public List <Companias> buscar(){
        
        return companiasRepository.findAll();
    }

    @PostMapping(path = {"/guardar", "actualizar"})
    public Companias guardar(@RequestBody CompaniasDto companiasDto) {

        Companias companiasData = this.convertDtoToCompanias(companiasDto);
        companiasRepository.save(companiasData);
        
        return companiasData;
    }

    @PostMapping( path = "/eliminar" )
    public String eliminar(@RequestBody CompaniasDto companiasDto){

        Companias companiaData = this.convertDtoToCompanias(companiasDto);

        Optional <Companias> companiaExistente = companiasRepository.findById(companiaData.getNombreCompania());
        if (companiaExistente.isPresent()){
            companiasRepository.delete(companiaExistente.get());
        }
        return "Successful";
    }

    private Companias convertDtoToCompanias(CompaniasDto companiasDto){

        Companias compania = new Companias(); 
        compania.setNombreCompania(companiasDto.getNombreCompania());
        compania.setClaseVia(companiasDto.getClaseVia());
        compania.setNombreVia(companiasDto.getNombreVia());
        compania.setNumeroVia(companiasDto.getNumeroVia());
        compania.setCodPostal(companiasDto.getCodPostal());
        compania.setTelefonoContratacion(companiasDto.getTelefonoContratacion());
        compania.setNotas(companiasDto.getNotas());
        compania.setSegurosList(companiasDto.getSegurosList());

        return compania;
    }
}
