package universales.proyecto2.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import universales.proyecto2.apirest.entity.Siniestros;
import universales.proyecto2.apirest.repository.SiniestrosRepository;

@RestController
@RequestMapping("/siniestros")
@CrossOrigin
public class SiniestrosService {
    
    @Autowired 
    SiniestrosRepository siniestrosRepository; 

    @GetMapping(path = {"/buscar", "/actualizar"})
    public List<Siniestros> buscaString() {
        
        return this.siniestrosRepository.findAll();
    }

    @PostMapping(path = {"/guardar", "/actualizar"})
    public Siniestros buscar(@RequestBody Siniestros siniestroData) {
        
        siniestrosRepository.save(siniestroData);
        
        return siniestroData;
    }

    @PostMapping( path = "/eliminar" )
    public String eliminar(@RequestBody Siniestros siniestroData){

        Optional <Siniestros> siniestroExistente = siniestrosRepository.findById(siniestroData.getIdSiniestro());
        if (siniestroExistente.isPresent()){
            siniestrosRepository.delete(siniestroExistente.get());
        }
        return "Successful";
    }
}
