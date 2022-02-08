package universales.proyecto2.apirest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import universales.proyecto2.apirest.dto.CompaniasSegurosDto;
import universales.proyecto2.apirest.entity.CompaniasSeguros;
import universales.proyecto2.apirest.imp.CompaniasSegurosService;

@SpringBootTest
class CompaniasSegurosServiceImplTest {

	@Autowired
	CompaniasSegurosService companiasSegurosService;
	
	
	@Test
	void buscar() {
		List<CompaniasSeguros> cS = this.companiasSegurosService.buscar();
		
		assertNotNull(cS, "correct test");
		
	}
	
	@Test
	void guardar() {
		
		CompaniasSegurosDto companiasSegurosDto =  new CompaniasSegurosDto();
		companiasSegurosDto.setId(0);
		companiasSegurosDto.setSegurosNumeroPoliza(1);
		companiasSegurosDto.setCompaniasNombreCompania("c2");
		
		CompaniasSeguros companiasSeguros = this.companiasSegurosService.guardar(companiasSegurosDto);
		
		this.companiasSegurosService.eliminar(companiasSegurosDto);
		
		assertNotNull(companiasSeguros, "correct test");
	}
	
	
}
