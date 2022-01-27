package universales.proyecto2.apirest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import universales.library.dto.practica2.PeritosDto;
import universales.proyecto2.apirest.entity.Peritos;
import universales.proyecto2.apirest.imp.PeritosService;

@SpringBootTest
class PeritosServiceImplTest {

	@Autowired
	PeritosService peritosService;
	
	
	@Test
	void buscar() {
		
		List<Peritos> peritos = this.peritosService.buscar();
		assertNotNull(peritos, "Testeo correcto");
		
	}
	
	@Test
	void guardar() {
		
		PeritosDto peritosDto = new PeritosDto(); 
		peritosDto.setDniPerito(0);
		peritosDto.setNombrePerito("fakename");
		peritosDto.setApellidoPerito("fakeapellido");
		peritosDto.setApellidoPerito2("fakeapelido2");
		peritosDto.setTelefonoContacto(1234);
		peritosDto.setTelefonoOficina(23466);
		peritosDto.setClaseVia(null);
		peritosDto.setNombreVia(null);
		peritosDto.setNumeroVia(23);
		peritosDto.setCodPostal("1839");
		peritosDto.setCiudad("Guatemala");
		
		Peritos perito = this.peritosService.guardar(peritosDto);
		
		this.peritosService.eliminar(peritosDto);
		
		assertNotNull(perito, "Testeo correcto");
	}

	
	
	@Test
	void buscarPeritosPorCiudad() {
		
		List<Peritos> peritos = this.peritosService.buscarPeritosPorCiudad("Guatemala");
		assertNotNull(peritos, "Testeo correcto");
	}
	
	@Test
	void buscarPeritosSinNumeroVia() {
		
		List<Peritos> peritos = this.peritosService.buscarPeritosSinNumeroVia();
		
		assertNotNull(peritos, "Testeo correcto");
	}
}
