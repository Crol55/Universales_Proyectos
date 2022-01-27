package universales.proyecto2.apirest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import universales.library.dto.practica2.SegurosDto;
import universales.library.dto.practica2.SiniestrosDto;
import universales.proyecto2.apirest.entity.Siniestros;
import universales.proyecto2.apirest.imp.SiniestrosService;


@SpringBootTest
class SiniestrosServiceImplTest {

	@Autowired
	SiniestrosService siniestrosService;
	
	@Test
	void buscar() {
		
		List<Siniestros> siniestros = this.siniestrosService.buscaString();
		assertNotNull(siniestros, "Correct test");
		
	}
	
	@Test
	void guardar() {
		
		SiniestrosDto siniestrosDto = new SiniestrosDto();
		siniestrosDto.setIdSiniestro(0);
		siniestrosDto.setFechaSiniestro(new Date());
		siniestrosDto.setCausas("Sin causa alguna");
		siniestrosDto.setAceptado("si");
		siniestrosDto.setIndemnizacion("si");
		SegurosDto sD = new SegurosDto();
			sD.setNumeroPoliza(300);
		siniestrosDto.setSeguro(sD);
		siniestrosDto.setPeritosDniPerito(104);
		
		Siniestros siniestroData = this.siniestrosService.guardar(siniestrosDto);
		
		this.siniestrosService.eliminar(siniestrosDto);
		
		assertNotNull(siniestroData, "Correct test");
	}
	
	@Test
	void buscarPorAceptacion() {
		
		List<Siniestros> siniestros = this.siniestrosService.buscarPorAceptacion("si");
		assertNotNull(siniestros, "Correct test");
	}
	
	@Test
	void buscarPorNoAceptacion() {
		
		List<Siniestros> siniestros = this.siniestrosService.buscarPorNoAceptacion("no");
		assertNotNull(siniestros, "Correct test");
		
	}
	
	@Test
	void buscarPorIndemnizacion() {
		
		List<Siniestros> siniestros = this.siniestrosService.buscarPorIndemnizacion("si");
		assertNotNull(siniestros, "Correct test");
		
	}
}
