package universales.proyecto2.apirest.imp;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import universales.library.dto.practica2.PeritosDto;
import universales.proyecto2.apirest.entity.Peritos;
import universales.proyecto2.apirest.repository.PeritosRepository;
import universales.proyecto2.apirest.ws.PeritosServiceInterface;

@Component
public class PeritosService implements PeritosServiceInterface{
    
    @Autowired
    PeritosRepository peritosRepository; 

    @Override
    public List<Peritos> buscar(){

        return peritosRepository.findAll();
    }

    @Override
    public Peritos guardar( PeritosDto peritosDto){

        Peritos peritoData = this.convertDtoToPeritos(peritosDto);
        this.peritosRepository.save(peritoData);
        return peritoData;
    }

    @Override
    public String eliminar(@RequestBody PeritosDto peritosDto){

        Peritos peritoData = this.convertDtoToPeritos(peritosDto);

        Optional <Peritos> peritoExistente = peritosRepository.findById(peritoData.getDniPerito());
        if (peritoExistente.isPresent()){
            peritosRepository.delete(peritoExistente.get());
        }
        return "Successful";
    }

    private Peritos convertDtoToPeritos(PeritosDto peritosDto){

        

        ModelMapper modelMapper = new ModelMapper(); 
        
        return modelMapper.map(peritosDto, Peritos.class);
    }

    @Override
    public List<Peritos> buscarPeritosPorCiudad(@PathVariable String ciudad){

        return peritosRepository.findByCiudadLike(ciudad);
    }

    @Override
    public List<Peritos> buscarPeritosSinNumeroVia(){

        return peritosRepository.findByNumeroViaIsNull();
    }
}
