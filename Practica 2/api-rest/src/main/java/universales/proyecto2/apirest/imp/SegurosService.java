package universales.proyecto2.apirest.imp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import universales.proyecto2.apirest.dto.SegurosDto;
import universales.proyecto2.apirest.entity.Seguros;
import universales.proyecto2.apirest.repository.SegurosRepository;
import universales.proyecto2.apirest.ws.SegurosServiceInterface;

@Component
public class SegurosService implements SegurosServiceInterface{
    
    @Autowired
    SegurosRepository segurosRepository;


    @Override
    public List<Seguros> buscar() {
        
        return this.segurosRepository.findAll();
    }

    @Override
    public Seguros guardar(SegurosDto segurosDto) {
        
        Seguros segurosData = this.convertDtoToSeguros(segurosDto);
        segurosRepository.save(segurosData);

        return segurosData;
    }

    @Override
    public String eliminar(SegurosDto segurosDto){

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
    public List<Seguros> buscarPorVigencia( String ramo) {
    
        //"23/05/2023"
    
        return segurosRepository.findByRamoLikeOrderByFechaVencimientoDesc(ramo);
    }


    private Seguros convertDtoToSeguros(SegurosDto segurosDto){

        ModelMapper modelMapper = new ModelMapper();
        
        return modelMapper.map(segurosDto, Seguros.class);
    }
    
}
