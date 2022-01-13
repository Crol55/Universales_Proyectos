package universales.proyecto2.apirest.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import universales.proyecto2.apirest.dto.ClienteDto;
import universales.proyecto2.apirest.entity.Cliente;
import universales.proyecto2.apirest.entity.Seguros;
import universales.proyecto2.apirest.repository.ClienteRepository;
import universales.proyecto2.apirest.repository.SegurosRepository;
import universales.proyecto2.apirest.ws.ClienteServiceInterface;


@Component
public class ClienteService implements ClienteServiceInterface{
    
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    SegurosRepository segurosRepository;

    @Override
    public List<Cliente> respuesta(){
        
        return this.clienteRepository.findAll();
    }

    @Override
    public Cliente guardar(@RequestBody ClienteDto clienteDto){

        Cliente clientData = this.convertDtoToCliente(clienteDto);

        List<Seguros> segurosClientList = clientData.getSegurosList(); 
        clientData.setSegurosList(null);

        clienteRepository.save(clientData); 

        for(Seguros seguro: segurosClientList)
            seguro.setClienteDniCl(clientData.getDniCl());
            
        segurosRepository.saveAll(segurosClientList);
        
        return clientData;
    }

    private Cliente convertDtoToCliente(ClienteDto clienteDto){

        Cliente newCliente = new Cliente();
        newCliente.setDniCl(clienteDto.getDniCl());
        newCliente.setNombreCl(clienteDto.getNombreCl());
        newCliente.setApellido1(clienteDto.getApellido1());
        newCliente.setApellido2(clienteDto.getApellido2());
        newCliente.setClaseVia(clienteDto.getClaseVia());
        newCliente.setNombreVia(clienteDto.getNombreVia());
        newCliente.setNumeroVia(clienteDto.getNumeroVia());
        newCliente.setCodPostal(clienteDto.getCodPostal());
        newCliente.setCiudad(clienteDto.getCiudad());
        newCliente.setTelefono(clienteDto.getTelefono());
        newCliente.setObservaciones(clienteDto.getObservaciones());
        newCliente.setSegurosList(clienteDto.getSegurosList());

        return newCliente;
    }

    @Override
    public String eliminar(@RequestBody ClienteDto clienteDto){

        Cliente clientData = this.convertDtoToCliente(clienteDto);
        clienteRepository.deleteById(clientData.getDniCl());
        return "Successful";
    }
    
    @Override
    public List<Cliente> buscarPorCodPostal(@PathVariable String codPostal){
        
        return clienteRepository.findByCodPostal(codPostal);
    }

    @Override
    public List<Cliente> buscarPorApellidos(@PathVariable String apellido1, @PathVariable String apellido2){
        
        return clienteRepository.findByApellido1OrApellido2(apellido1, apellido2);
    }
    
}
