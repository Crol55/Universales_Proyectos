package universales.proyecto2.apirest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import universales.proyecto2.apirest.dto.ClienteDto;
import universales.proyecto2.apirest.entity.Cliente;
import universales.proyecto2.apirest.imp.ClienteService;

@SpringBootTest
class ClienteServiceImplTest {

	@Autowired
	ClienteService clienteService;
	
	
	@Test
	void guardar() {
		
		try {
			
			ClienteDto clienteDto = new ClienteDto();
			clienteDto.setNombreCl("CarlosTestingFinalFinal");
			clienteDto.setApellido1("lara");
			clienteDto.setApellido2("lara 2");
			clienteDto.setClaseVia(null);
			clienteDto.setNombreVia(null);
			clienteDto.setNumeroVia(null);
			clienteDto.setCodPostal("18010");
			clienteDto.setCiudad("Zacapa");
			clienteDto.setTelefono("1234");
			clienteDto.setObservaciones("Cliente puntual");
			clienteDto.setSegurosList(null);
		
			Cliente clientData = clienteService.guardar(clienteDto);
			
			clienteDto.setDniCl(clientData.getDniCl());
			String response = clienteService.eliminar(clienteDto);
	
			assertEquals("Successful", response);
			
		} catch (Exception e) {
			fail("Guardar o eliminado fallido "+ e.getMessage());
		}
		
	}
	
	@Test
	void buscarPorCodPostal() {
		
		List<Cliente> buscarPorCodPostal = this.clienteService.buscarPorCodPostal("18010");
		
		assertNotNull(buscarPorCodPostal, "correct test");
		
	}
	
	
	@Test
	void buscarPorApellidos() {
		
		List<Cliente> buscarPorApellidos = this.clienteService.buscarPorApellidos("", "");
		
		assertNotNull(buscarPorApellidos, "correct test");
		
	}
	
	
	@Test
	void busquedaNativa() {
		
		List<Map<String, Object>> busquedaNativa = this.clienteService.busquedaNativa();
		assertNotNull(busquedaNativa, "correct test");	
	}
	
	@Test
	void guardarNativa() {
		
		ClienteDto clienteDto = new ClienteDto();
		clienteDto.setDniCl( 111110 );
		clienteDto.setNombreCl("CarlosTestingFinalFinalNativa");
		clienteDto.setApellido1("lara");
		clienteDto.setApellido2("lara 2");
		clienteDto.setClaseVia(null);
		clienteDto.setNombreVia(null);
		clienteDto.setNumeroVia(null);
		clienteDto.setCodPostal("18010");
		clienteDto.setCiudad("Zacapa");
		clienteDto.setTelefono("1234");
		clienteDto.setObservaciones("Cliente puntual");
		clienteDto.setSegurosList(null);
		
		Cliente cliente = null;
		
		cliente = this.clienteService.guardarNativa(clienteDto);
		
		cliente = this.clienteService.actualizarNativa(clienteDto);
		 
		cliente = this.clienteService.eliminarNativa(clienteDto);
		 
		assertNotNull(cliente, "correct test");	
	
	}
	
	
}
