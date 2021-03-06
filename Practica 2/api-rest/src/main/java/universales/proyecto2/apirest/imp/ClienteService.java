package universales.proyecto2.apirest.imp;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import universales.proyecto2.apirest.dto.ClienteDto;
import universales.proyecto2.apirest.entity.Cliente;
import universales.proyecto2.apirest.entity.Seguros;
import universales.proyecto2.apirest.repository.ClienteRepository;
import universales.proyecto2.apirest.repository.SegurosRepository;
import universales.proyecto2.apirest.service.CatalogService;
import universales.proyecto2.apirest.ws.ClienteServiceInterface;


@Component
public class ClienteService implements ClienteServiceInterface{
    
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    SegurosRepository segurosRepository;

    @Autowired
    CatalogService catalogService;

    @Override
    public List<Cliente> respuesta(){
        
        return this.clienteRepository.findAll();
    }

    @Override
    public Cliente guardar(ClienteDto clienteDto){

        Cliente clientData = this.convertDtoToCliente(clienteDto);

        List<Seguros> segurosClientList = clientData.getSegurosList(); 
        clientData.setSegurosList(null);
        
        clienteRepository.save(clientData); 
           
        if (segurosClientList != null) {
        	
        	for(Seguros seguro: segurosClientList)
                seguro.setClienteDniCl(clientData.getDniCl());
        	
        	segurosRepository.saveAll(segurosClientList);
        }
        
        return clientData;
    }

    @Override
    public String eliminar(ClienteDto clienteDto){

        Cliente clientData = this.convertDtoToCliente(clienteDto);
        clienteRepository.deleteById(clientData.getDniCl());
        return "Successful";
    }
    
    @Override
    public List<Cliente> buscarPorCodPostal(String codPostal){
        
        return clienteRepository.findByCodPostal(codPostal);
    }

    @Override
    public List<Cliente> buscarPorApellidos(String apellido1, String apellido2){
        
        return clienteRepository.findByApellido1OrApellido2(apellido1, apellido2);
    }

    private Cliente convertDtoToCliente(ClienteDto clienteDto){
    
        ModelMapper	modelMapper = new ModelMapper(); 
       
        return modelMapper.map(clienteDto, Cliente.class);
    }

    @Override
    public List<Map<String, Object>> busquedaNativa() {
        
        return this.catalogService.buscarClientes();
    }

    @Override
    public Cliente guardarNativa(ClienteDto clienteDto) {
        
        Cliente cliente = this.convertDtoToCliente(clienteDto);

        this.catalogService.insertCliente(cliente);
        
        return cliente;
    }

    public Cliente actualizarNativa(ClienteDto clienteDto){

        Cliente cliente = this.convertDtoToCliente(clienteDto);

        this.catalogService.updateCliente(cliente.getNombreVia(), cliente.getObservaciones(), cliente.getDniCl());
        
        return cliente;
    }

    @Override
    public Cliente eliminarNativa(ClienteDto clienteDto) {
        
        Cliente cliente = this.convertDtoToCliente(clienteDto);

        this.catalogService.deleteCliente(cliente.getDniCl());

        return cliente;
    }

    
}
