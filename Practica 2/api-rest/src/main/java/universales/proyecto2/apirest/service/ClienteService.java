package universales.proyecto2.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import universales.proyecto2.apirest.entity.Cliente;
import universales.proyecto2.apirest.entity.Seguros;
import universales.proyecto2.apirest.repository.ClienteRepository;
import universales.proyecto2.apirest.repository.SegurosRepository;


@RestController
@RequestMapping("/cliente")
@CrossOrigin


public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    SegurosRepository segurosRepository;


    @GetMapping(path = "/buscar")
    public List<Cliente> respuesta(){
        
        return this.clienteRepository.findAll();
    }

    @PostMapping( path = {"/guardar", "/actualizar"} )
    public Cliente guardar(@RequestBody Cliente clientData){

        System.out.println(clientData);
        List<Seguros> segurosClientList = clientData.getSegurosList(); 
        clientData.setSegurosList(null);

        clienteRepository.save(clientData); 

        for(Seguros seguro: segurosClientList)
            seguro.setClienteDniCl(clientData.getDniCl());
            
        segurosRepository.saveAll(segurosClientList);
        
        return clientData;
    }

    @PostMapping( path = "/eliminar" )
    public String eliminar(@RequestBody Cliente clientData){

        
        clienteRepository.deleteById(clientData.getDniCl());
        return "Successful";
    }
    
    @GetMapping(path = "/buscar/codPostal/{codPostal}")
    public List<Cliente> buscarPorCodPostal(@PathVariable String codPostal){
        
        return clienteRepository.findByCodPostal(codPostal);
    }

    @GetMapping(path = "/buscar/apellidos/{apellido1}/or/{apellido2}")
    public List<Cliente> buscarPorApellidos(@PathVariable String apellido1, @PathVariable String apellido2){
        
        return clienteRepository.findByApellido1OrApellido2(apellido1, apellido2);
    }
    
}
