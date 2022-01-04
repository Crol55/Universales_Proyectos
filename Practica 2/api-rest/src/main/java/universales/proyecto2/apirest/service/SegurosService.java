package universales.proyecto2.apirest.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import universales.proyecto2.apirest.entity.Seguros;
import universales.proyecto2.apirest.repository.SegurosRepository;

@RestController
@RequestMapping("/seguros")
@CrossOrigin
public class SegurosService {
    
    @Autowired
    SegurosRepository segurosRepository;


    @GetMapping(path = "/buscar")
    public List<Seguros> buscaString() {
        
        return this.segurosRepository.findAll();
    }

    @PostMapping(path = "/guardar")
    public Seguros buscar(@RequestBody Seguros segurosData) {
        
        segurosRepository.save(segurosData);

        return segurosData;
    }
}