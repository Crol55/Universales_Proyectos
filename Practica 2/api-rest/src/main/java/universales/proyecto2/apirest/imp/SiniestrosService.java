package universales.proyecto2.apirest.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

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
    public String eliminar(@RequestBody SiniestrosDto siniestrosDto){

        Siniestros siniestroData = this.convertDtoToSiniestros(siniestrosDto);
        Optional <Siniestros> siniestroExistente = siniestrosRepository.findById(siniestroData.getIdSiniestro());
        if (siniestroExistente.isPresent()){
            siniestrosRepository.delete(siniestroExistente.get());
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

        Siniestros siniestro =  new Siniestros();
        siniestro.setIdSiniestro(siniestrosDto.getIdSiniestro());
        siniestro.setFechaSiniestro(siniestrosDto.getFechaSiniestro());
        siniestro.setCausas(siniestrosDto.getCausas());
        siniestro.setAceptado(siniestrosDto.getAceptado());
        siniestro.setIndemnizacion(siniestrosDto.getIndemnizacion());
        siniestro.setPeritosDniPerito(siniestrosDto.getPeritosDniPerito());
        
        Seguros seguro =  new Seguros();
        seguro.setNumeroPoliza(siniestrosDto.getSeguro().getNumeroPoliza());
        siniestro.setSeguro(seguro);
        //siniestro.setSeguro(siniestrosDto.getSeguro())s
        
        return siniestro;
    }
}
