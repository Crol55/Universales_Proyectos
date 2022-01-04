package universales.proyecto2.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import universales.proyecto2.apirest.entity.Peritos;
import universales.proyecto2.apirest.repository.PeritosRepository;

@RestController
@RequestMapping("/peritos")
@CrossOrigin
public class PeritosService {
    
    @Autowired
    PeritosRepository peritosRepository; 

    @GetMapping(path = "buscar")
    public List<Peritos> buscar(){

        return peritosRepository.findAll();
    }

    @PostMapping(path = "guardar")
    public Peritos guardar(@RequestBody Peritos peritoData){

        this.peritosRepository.save(peritoData);
        return peritoData;
    }

}
