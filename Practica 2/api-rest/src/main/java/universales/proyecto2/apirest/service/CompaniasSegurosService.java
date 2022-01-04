package universales.proyecto2.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import universales.proyecto2.apirest.entity.CompaniasSeguros;
import universales.proyecto2.apirest.repository.CompaniasSegurosRepository;

@RestController
@RequestMapping("/companiasSeguros")
@CrossOrigin
public class CompaniasSegurosService {
    @Autowired
    CompaniasSegurosRepository companiasSegurosRepository;

    @GetMapping(path = "/buscar")
    public List<CompaniasSeguros> buscar(){

        return companiasSegurosRepository.findAll();
    }

    @PostMapping(path = "/guardar")
    public CompaniasSeguros guardar(@RequestBody CompaniasSeguros companiasSegurosData){

        companiasSegurosRepository.save(companiasSegurosData);
        return companiasSegurosData;
    }
}
