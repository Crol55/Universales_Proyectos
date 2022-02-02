package universales.proyecto2.apirest.imp;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import universales.library.dto.practica2.CompaniasSegurosDto;
import universales.proyecto2.apirest.entity.CompaniasSeguros;
import universales.proyecto2.apirest.repository.CompaniasSegurosRepository;
import universales.proyecto2.apirest.ws.CompaniasSegurosServiceInterface;


@Component
public class CompaniasSegurosService implements CompaniasSegurosServiceInterface{

    @Autowired
    CompaniasSegurosRepository companiasSegurosRepository;

    @Override
    public List<CompaniasSeguros> buscar(){

        return companiasSegurosRepository.findAll();
    }

    @Override
    public CompaniasSeguros guardar(@RequestBody CompaniasSegurosDto companiasSegurosDto){

        CompaniasSeguros companiasSegurosData = this.convertDtoToCompaniasSeguros(companiasSegurosDto);
        companiasSegurosRepository.save(companiasSegurosData);
        return companiasSegurosData;
    }

    @Override
    public String eliminar(@RequestBody CompaniasSegurosDto companiasSegurosDto){

        CompaniasSeguros companiaSeguro = this.convertDtoToCompaniasSeguros(companiasSegurosDto);
        Optional <CompaniasSeguros> seguroExistente = companiasSegurosRepository.findById(companiaSeguro.getId());
        if (seguroExistente.isPresent()){
            companiasSegurosRepository.delete(seguroExistente.get());
        }
        return "Successful";
    }

    private CompaniasSeguros convertDtoToCompaniasSeguros(CompaniasSegurosDto companiasSegurosDto){

        ModelMapper modelMapper = new ModelMapper();
        
        return modelMapper.map(companiasSegurosDto, CompaniasSeguros.class);
    }
}
