package universales.proyecto2.apirest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import universales.proyecto2.apirest.dto.SegurosDto;
import universales.proyecto2.apirest.entity.Seguros;
import universales.proyecto2.apirest.imp.SegurosService;

@SpringBootTest
class SegurosServiceImplTest {

	@Autowired
	SegurosService segurosService;
	
	@Test
	void buscar() {
		
		List<Seguros> seguros = this.segurosService.buscar(); 
		
		assertNotNull(seguros, "Correct test");
		
	}
	
	@Test
	void guardar() {
		
		SegurosDto segurosDto =  new SegurosDto();
		segurosDto.setNumeroPoliza(0);
		segurosDto.setRamo("Seguro de vida");
		segurosDto.setFechaInicio(new Date());
		segurosDto.setFechaVencimiento(new Date());
		segurosDto.setCondicionesParticulares("");
		segurosDto.setObservaciones("Nuevo seguiro adquirido");
		segurosDto.setClienteDniCl(1);
	
		
		Seguros seguro = this.segurosService.guardar(segurosDto);
		
		this.segurosService.eliminar(segurosDto);
		assertNotNull(seguro, "Correct Test");
	}
	
	
	@Test
	void buscarPorRamoLike() {
		
		List<Seguros> seguros = this.segurosService.buscarPorRamoLike("Seguro por fallecimiento");
		assertNotNull(seguros, "Correct Test");
		
	}
	
	@Test
	void buscarPorFechaInicioAnterior() {
		
		try {
			List<Seguros> seguros = this.segurosService.buscarPorFechaInicioAnterior("04-01-2022");
			assertNotNull(seguros, "Correct Test");
			
		} catch (Exception e) {
			fail("Failed test"+ e.getMessage());
		}

	}
	
	@Test
	void buscarPorVigencia() {
		
		try {
			List<Seguros> seguros = this.segurosService.buscarPorVigencia("Seguro por fallecimiento");
			assertNotNull(seguros, "Correct Test");
			
		} catch (Exception e) {
			fail("Failed test"+ e.getMessage());
		}
	}
}
