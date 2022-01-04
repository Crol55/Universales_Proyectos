package universales.proyecto2.apirest.service;

import java.util.List;

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

    @GetMapping(path = "/buscar")
    public List<Siniestros> buscaString() {
        
        return this.siniestrosRepository.findAll();
    }

    @PostMapping(path = "/guardar")
    public Siniestros buscar(@RequestBody Siniestros siniestroData) {
        
        siniestrosRepository.save(siniestroData);
        
        return siniestroData;
    }
}
