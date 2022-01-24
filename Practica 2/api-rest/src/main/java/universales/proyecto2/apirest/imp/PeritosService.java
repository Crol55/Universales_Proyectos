package universales.proyecto2.apirest.imp;

import java.util.List;
import java.util.Optional;

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
    public Peritos guardar(@RequestBody PeritosDto peritosDto){

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

        Peritos perito = new Peritos();
        perito.setDniPerito(peritosDto.getDniPerito());
        perito.setNombrePerito(peritosDto.getNombrePerito());
        perito.setApellidoPerito(peritosDto.getApellidoPerito());
        perito.setApellidoPerito2(peritosDto.getApellidoPerito2());
        perito.setTelefonoContacto(peritosDto.getTelefonoContacto());
        perito.setTelefonoOficina(peritosDto.getTelefonoOficina());
        perito.setClaseVia(peritosDto.getClaseVia());
        perito.setNombreVia(peritosDto.getNombreVia());
        perito.setNumeroVia(peritosDto.getNumeroVia());
        perito.setCodPostal(peritosDto.getCodPostal());
        perito.setCiudad(peritosDto.getCiudad());

        return perito;
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
