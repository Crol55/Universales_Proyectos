package universales.proyecto2.apirest.imp;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import universales.library.dto.practica2.SiniestrosDto;
import universales.proyecto2.apirest.entity.Seguros;
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
    public Siniestros guardar(SiniestrosDto siniestrosDto) {
        
        Siniestros siniestroData = this.convertDtoToSiniestros(siniestrosDto);
        siniestrosRepository.save(siniestroData);
        
        return siniestroData;
    }

    @Override
    public String eliminar(SiniestrosDto siniestrosDto){

        
        Optional <Siniestros> siniestroExistente = siniestrosRepository.findById(siniestrosDto.getIdSiniestro());
        if (siniestroExistente.isPresent()){
           
            siniestrosRepository.deleteById(siniestrosDto.getIdSiniestro());
        }
        return "Successful";
    }

    @Override
    public List<Siniestros> buscarPorAceptacion(String aceptacion){
        
        return siniestrosRepository.findByAceptadoLike(aceptacion);
    }

    @Override
    public List<Siniestros> buscarPorNoAceptacion(String aceptacion){
        
        return siniestrosRepository.findByAceptadoNotLike(aceptacion);
    }

    @Override
    public List<Siniestros> buscarPorIndemnizacion(String indemnizacion){
        
        return siniestrosRepository.findByIndemnizacionLike(indemnizacion);
    }

    private Siniestros convertDtoToSiniestros(SiniestrosDto siniestrosDto){

        ModelMapper modelMapper = new ModelMapper(); 
        Siniestros siniestro = modelMapper.map(siniestrosDto, Siniestros.class);
        
        Seguros seguro =  new Seguros();
        seguro.setNumeroPoliza(siniestrosDto.getSeguro().getNumeroPoliza());
        siniestro.setSeguro(seguro);     
        
        return siniestro;
    }
}
