package universales.proyecto2.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import universales.proyecto2.apirest.entity.Companias;

import universales.proyecto2.apirest.repository.CompaniasRepository;

@RestController
@RequestMapping("/companias")
@CrossOrigin
public class CompaniasService {
    
    @Autowired 
    CompaniasRepository companiasRepository; 

    @GetMapping(path = "/buscar")
    public List <Companias> buscar(){
        
        return companiasRepository.findAll();
    }

    @PostMapping(path = "/guardar")
    public Companias guardar(@RequestBody Companias companiasData) {

        companiasRepository.save(companiasData);
        
        return companiasData;
    }
}
