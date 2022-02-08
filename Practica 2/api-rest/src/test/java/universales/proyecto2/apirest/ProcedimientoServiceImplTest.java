package universales.proyecto2.apirest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import universales.proyecto2.apirest.dto.FiltrarPolizaDto;
import universales.proyecto2.apirest.dto.SegurosDto;
import universales.proyecto2.apirest.service.ProcedimientoService;

@SpringBootTest
class ProcedimientoServiceImplTest {
	
	@Autowired 
	ProcedimientoService procedimientoService; 
	
	@Test
	void insertPoliza() {
		
		SegurosDto segurosDto =  new SegurosDto();
		segurosDto.setNumeroPoliza(0);
		segurosDto.setRamo("Seguro de vida");
		segurosDto.setFechaInicio(new Date());
		segurosDto.setFechaVencimiento(new Date());
		segurosDto.setCondicionesParticulares("");
		segurosDto.setObservaciones("Nuevo seguiro adquirido");
		segurosDto.setClienteDniCl(1);
		
		int res =  this.procedimientoService.insertarPoliza(segurosDto);
		assertEquals(1, res);
	}
	
	@Test
	void filtrarPoliza() {
		
		SegurosDto segurosDto =  new SegurosDto();
		segurosDto.setFechaInicio(new Date());
		segurosDto.setClienteDniCl(1);
		FiltrarPolizaDto polizaDto = this.procedimientoService.filtrarPoliza(segurosDto);
		
		assertNotNull(polizaDto);
	}

}
