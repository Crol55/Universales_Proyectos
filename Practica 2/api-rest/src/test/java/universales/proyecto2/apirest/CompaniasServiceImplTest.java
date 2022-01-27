package universales.proyecto2.apirest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import universales.library.dto.practica2.CompaniasDto;
import universales.proyecto2.apirest.entity.Companias;
import universales.proyecto2.apirest.imp.CompaniasService;

@SpringBootTest
class CompaniasServiceImplTest {
	
	@Autowired
	CompaniasService companiasService;
	
	@Test
	void buscar() {
		
		List <Companias> companias = this.companiasService.buscar();
		
		assertNotNull(companias, "correct test");
		
	}
	
	@Test
	void guardar() {
		
		try {
			
			CompaniasDto companiasDto =  new CompaniasDto();
			companiasDto.setNombreCompania("universales_carlos");
			companiasDto.setClaseVia(null);
			companiasDto.setNombreVia(null);
			companiasDto.setNumeroVia(null);
			companiasDto.setCodPostal("7777");
			companiasDto.setTelefonoContratacion("163749");
			companiasDto.setTelefonoSiniestros("1233");
			companiasDto.setNotas("Esta compania es de seguros");
			
			 Companias compania = this.companiasService.guardar(companiasDto);
			 
			 this.companiasService.eliminar(companiasDto);
			 
			 assertNotNull(compania, "Correct test");
			
		} catch (Exception e) {
			fail("Falla en guardar y eliminar"+ e.getMessage());
		}
		
	}
	
	
	
}
