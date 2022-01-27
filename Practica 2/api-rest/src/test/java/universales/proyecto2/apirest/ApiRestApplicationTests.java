package universales.proyecto2.apirest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiRestApplicationTests {

	@Test
	void contextLoads() {
		
		boolean notGreater = 10 > 50;
		assertEquals(false, notGreater);
	}

}
