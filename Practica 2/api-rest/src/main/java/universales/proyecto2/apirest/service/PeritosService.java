package universales.proyecto2.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import universales.proyecto2.apirest.dto.PeritosDto;
import universales.proyecto2.apirest.entity.Peritos;
import universales.proyecto2.apirest.repository.PeritosRepository;

@RestController
@RequestMapping("/peritos")
@CrossOrigin
public class PeritosService {
    
    @Autowired
    PeritosRepository peritosRepository; 

    @GetMapping(path = "/buscar")
    public List<Peritos> buscar(){

        return peritosRepository.findAll();
    }

    @PostMapping(path = {"/guardar", "/actualizar"})
    public Peritos guardar(@RequestBody PeritosDto peritosDto){

        Peritos peritoData = this.convertDtoToPeritos(peritosDto);
        this.peritosRepository.save(peritoData);
        return peritoData;
    }

    @PostMapping( path = "/eliminar" )
    public String eliminar(@RequestBody PeritosDto peritosDto){

        Peritos peritoData = this.convertDtoToPeritos(peritosDto);

        Optional <Peritos> peritoExistente = peritosRepository.findById(peritoData.getDniPerito());
        if (peritoExistente.isPresent()){
            peritosRepository.delete(peritoExistente.get());
        }
        return "Successful";
    }

    private Peritos convertDtoToPeritos(PeritosDto peritosDto){

        Peritos perito = new Peritos();
        perito.setDniPerito(peritosDto.getDniPerito());
        perito.setNombrePerito(peritosDto.getNombrePerito());
        perito.setApellidoPerito(peritosDto.getApellidoPerito());
        perito.setApellidoPerito2(peritosDto.getApellidoPerito2());
        perito.setTelefonoContacto(peritosDto.getTelefonoContacto());
        perito.setTelefonoOficina(peritosDto.getTelefonoOficina());
        perito.setClaseVia(peritosDto.getClaseVia());
        perito.setNombreVia(peritosDto.getNombreVia());
        perito.setNumeroVia(peritosDto.getNumeroVia());
        perito.setCodPostal(peritosDto.getCodPostal());
        perito.setCiudad(peritosDto.getCiudad());

        return perito;
    }

    @GetMapping( path = "/buscar/por/ciudad/{ciudad}" )
    public List<Peritos> buscarPeritosPorCiudad(@PathVariable String ciudad){

        return peritosRepository.findByCiudadLike(ciudad);
    }

    @GetMapping( path = "/buscar/sin/numeroVia" )
    public List<Peritos> buscarPeritosSinNumeroVia(){

        return peritosRepository.findByNumeroViaIsNull();
    }
}
