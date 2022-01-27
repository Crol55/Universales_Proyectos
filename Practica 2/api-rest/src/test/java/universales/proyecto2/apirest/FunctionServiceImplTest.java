package universales.proyecto2.apirest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import universales.library.dto.practica2.SegurosDto;
import universales.proyecto2.apirest.imp.FunctionServiceImp;

@SpringBootTest
class FunctionServiceImplTest {

	@Autowired 
	FunctionServiceImp functionServiceImp; 
	
	@Test
	void insertPolizaFunc () {
		
		SegurosDto segurosDto =  new SegurosDto();
		segurosDto.setNumeroPoliza(0);
		segurosDto.setRamo("Seguro de vida");
		segurosDto.setFechaInicio(new Date());
		segurosDto.setFechaVencimiento(new Date());
		segurosDto.setCondicionesParticulares("");
		segurosDto.setObservaciones("Nuevo seguiro adquirido");
		segurosDto.setClienteDniCl(1);
		
		int res = this.functionServiceImp.insertPolizaFunc(segurosDto);
		assertEquals(0, res);
	}
}
