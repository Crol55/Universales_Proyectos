package universales.proyecto2.apirest.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import universales.library.dto.practica2.CompaniasDto;
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
    public Companias guardar(@RequestBody CompaniasDto companiasDto) {

        Companias companiasData = this.convertDtoToCompanias(companiasDto);
        companiasRepository.save(companiasData);
        
        return companiasData;
    }

    @Override
    public String eliminar(@RequestBody CompaniasDto companiasDto){

        Companias companiaData = this.convertDtoToCompanias(companiasDto);

        Optional <Companias> companiaExistente = companiasRepository.findById(companiaData.getNombreCompania());
        if (companiaExistente.isPresent()){
            companiasRepository.delete(companiaExistente.get());
        }
        return "Successful";
    }


    private Companias convertDtoToCompanias(CompaniasDto companiasDto){

        Companias compania = new Companias(); 
        compania.setNombreCompania(companiasDto.getNombreCompania());
        compania.setClaseVia(companiasDto.getClaseVia());
        compania.setNombreVia(companiasDto.getNombreVia());
        compania.setNumeroVia(companiasDto.getNumeroVia());
        compania.setCodPostal(companiasDto.getCodPostal());
        compania.setTelefonoContratacion(companiasDto.getTelefonoContratacion());
        compania.setNotas(companiasDto.getNotas());

        return compania;
    }
}
