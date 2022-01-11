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

import universales.proyecto2.apirest.dto.SiniestrosDto;
import universales.proyecto2.apirest.entity.Siniestros;
import universales.proyecto2.apirest.repository.SiniestrosRepository;

@RestController
@RequestMapping("/siniestros")
@CrossOrigin
public class SiniestrosService {
    
    @Autowired 
    SiniestrosRepository siniestrosRepository; 

    @GetMapping(path = {"/buscar", "/actualizar"})
    public List<Siniestros> buscaString() {
        
        return this.siniestrosRepository.findAll();
    }

    @PostMapping(path = {"/guardar", "/actualizar"})
    public Siniestros buscar(@RequestBody SiniestrosDto siniestrosDto) {
        
        Siniestros siniestroData = this.convertDtoToSiniestros(siniestrosDto);
        siniestrosRepository.save(siniestroData);
        
        return siniestroData;
    }

    @PostMapping( path = "/eliminar" )
    public String eliminar(@RequestBody SiniestrosDto siniestrosDto){

        Siniestros siniestroData = this.convertDtoToSiniestros(siniestrosDto);
        Optional <Siniestros> siniestroExistente = siniestrosRepository.findById(siniestroData.getIdSiniestro());
        if (siniestroExistente.isPresent()){
            siniestrosRepository.delete(siniestroExistente.get());
        }
        return "Successful";
    }

    @GetMapping( path = "/buscar/aceptacion/{aceptacion}" )
    public List<Siniestros> buscarPorAceptacion(@PathVariable String aceptacion){
        
        return siniestrosRepository.findByAceptadoLike(aceptacion);
    }

    @GetMapping( path = "/buscar/aceptacionDistinta/{aceptacion}" )
    public List<Siniestros> buscarPorNoAceptacion(@PathVariable String aceptacion){
        
        return siniestrosRepository.findByAceptadoNotLike(aceptacion);
    }

    @GetMapping( path = "/buscar/indemnizacion/{indemnizacion}" )
    public List<Siniestros> buscarPorIndemnizacion(@PathVariable String indemnizacion){
        
        return siniestrosRepository.findByIndemnizacionLike(indemnizacion);
    }

    private Siniestros convertDtoToSiniestros(SiniestrosDto siniestrosDto){

        Siniestros siniestro =  new Siniestros();
        siniestro.setIdSiniestro(siniestrosDto.getIdSiniestro());
        siniestro.setFechaSiniestro(siniestrosDto.getFechaSiniestro());
        siniestro.setCausas(siniestrosDto.getCausas());
        siniestro.setAceptado(siniestrosDto.getAceptado());
        siniestro.setIndemnizacion(siniestrosDto.getIndemnizacion());
        siniestro.setPeritosDniPerito(siniestrosDto.getPeritosDniPerito());
        siniestro.setSeguro(siniestrosDto.getSeguro());

        return siniestro;
    }
}
