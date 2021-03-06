package universales.proyecto2.apirest.imp;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import universales.proyecto2.apirest.dto.CompaniasDto;
import universales.proyecto2.apirest.entity.Companias;

import universales.proyecto2.apirest.repository.CompaniasRepository;
import universales.proyecto2.apirest.ws.CompaniasServiceInteface;


@Component
public class CompaniasService implements CompaniasServiceInteface{
    
    @Autowired 
    CompaniasRepository companiasRepository; 

    @Override
    public List <Companias> buscar(){
        
        return companiasRepository.findAll();
    }

    @Override
    public Companias guardar(CompaniasDto companiasDto) {

        Companias companiasData = this.convertDtoToCompanias(companiasDto);
        companiasRepository.save(companiasData);
        
        return companiasData;
    }

    @Override
    public String eliminar(CompaniasDto companiasDto){

        Companias companiaData = this.convertDtoToCompanias(companiasDto);

        Optional <Companias> companiaExistente = companiasRepository.findById(companiaData.getNombreCompania());
        if (companiaExistente.isPresent()){
            companiasRepository.delete(companiaExistente.get());
        }
        return "Successful";
    }


    private Companias convertDtoToCompanias(CompaniasDto companiasDto){

        ModelMapper modelMapper = new ModelMapper(); 
        
        return modelMapper.map(companiasDto, Companias.class);
    }
}
