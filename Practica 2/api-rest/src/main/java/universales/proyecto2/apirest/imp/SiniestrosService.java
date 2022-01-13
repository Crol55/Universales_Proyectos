package universales.proyecto2.apirest.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import universales.proyecto2.apirest.dto.SiniestrosDto;
import universales.proyecto2.apirest.entity.Siniestros;
import universales.proyecto2.apirest.repository.SiniestrosRepository;
import universales.proyecto2.apirest.ws.SiniestrosServiceInterface;


@Controller
public class SiniestrosService implements SiniestrosServiceInterface{
    
    @Autowired 
    SiniestrosRepository siniestrosRepository; 

    @Override
    public List<Siniestros> buscaString() {
        
        return this.siniestrosRepository.findAll();
    }

    @Override
    public Siniestros buscar(@RequestBody SiniestrosDto siniestrosDto) {
        
        Siniestros siniestroData = this.convertDtoToSiniestros(siniestrosDto);
        siniestrosRepository.save(siniestroData);
        
        return siniestroData;
    }

    @Override
    public String eliminar(@RequestBody SiniestrosDto siniestrosDto){

        Siniestros siniestroData = this.convertDtoToSiniestros(siniestrosDto);
        Optional <Siniestros> siniestroExistente = siniestrosRepository.findById(siniestroData.getIdSiniestro());
        if (siniestroExistente.isPresent()){
            siniestrosRepository.delete(siniestroExistente.get());
        }
        return "Successful";
    }

    @Override
    public List<Siniestros> buscarPorAceptacion(@PathVariable String aceptacion){
        
        return siniestrosRepository.findByAceptadoLike(aceptacion);
    }

    @Override
    public List<Siniestros> buscarPorNoAceptacion(@PathVariable String aceptacion){
        
        return siniestrosRepository.findByAceptadoNotLike(aceptacion);
    }

    @Override
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
