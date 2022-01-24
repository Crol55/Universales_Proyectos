package universales.proyecto2.apirest.imp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import universales.library.dto.practica2.SegurosDto;
import universales.proyecto2.apirest.entity.Seguros;
import universales.proyecto2.apirest.repository.SegurosRepository;
import universales.proyecto2.apirest.ws.SegurosServiceInterface;

@Component
public class SegurosService implements SegurosServiceInterface{
    
    @Autowired
    SegurosRepository segurosRepository;


    @Override
    public List<Seguros> buscaString() {
        
        return this.segurosRepository.findAll();
    }

    @Override
    public Seguros buscar(@RequestBody SegurosDto segurosDto) {
        
        Seguros segurosData = this.convertDtoToSeguros(segurosDto);
        segurosRepository.save(segurosData);

        return segurosData;
    }

    @Override
    public String eliminar(@RequestBody SegurosDto segurosDto){

        Seguros seguroData = this.convertDtoToSeguros(segurosDto);

        Optional <Seguros> seguroExistente = segurosRepository.findById(seguroData.getNumeroPoliza());
        if (seguroExistente.isPresent()){
            segurosRepository.delete(seguroExistente.get());
        }
        return "Successful";
    }

    @Override
    public List<Seguros> buscarPorRamoLike(@PathVariable String ramo){
        
        return segurosRepository.findByRamoLike(ramo);
    }

    @Override
    public List<Seguros> buscarPorFechaInicioAnterior(@PathVariable String fechaInicio) throws ParseException{
    
        //"23/05/2023"
        Date date=new SimpleDateFormat("dd-MM-yyyy").parse(fechaInicio); 
        return segurosRepository.findByFechaInicioBefore(date);
    }

    @Override
    public List<Seguros> buscarPorVigencia(@PathVariable String ramo) {
    
        //"23/05/2023"
    
        return segurosRepository.findByRamoLikeOrderByFechaVencimientoDesc(ramo);
    }


    private Seguros convertDtoToSeguros(SegurosDto segurosDto){

        Seguros seguro = new Seguros();
        seguro.setNumeroPoliza(segurosDto.getNumeroPoliza());
        seguro.setRamo(segurosDto.getRamo());
        seguro.setFechaInicio(segurosDto.getFechaInicio());
        seguro.setFechaVencimiento(segurosDto.getFechaVencimiento());
        seguro.setCondicionesParticulares(segurosDto.getCondicionesParticulares());
        seguro.setObservaciones(segurosDto.getObservaciones());
        seguro.setClienteDniCl(segurosDto.getClienteDniCl());

        return seguro;
    }
    
}
