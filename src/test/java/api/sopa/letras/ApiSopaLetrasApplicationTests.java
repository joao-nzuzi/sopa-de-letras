package api.sopa.letras;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import api.sopa.letras.service.SopaLetrasServiceImpl;
import org.springframework.http.ResponseEntity;

@SpringBootTest
@AutoConfigureMockMvc
class ApiSopaLetrasApplicationTests {

	@Autowired
	SopaLetrasServiceImpl service;

	@Test
	void contextLoads() {
	}

	@Test
	void jogoLocalizaPalavras() throws Exception {
		String palavraTest = "BAIXA";

		ResponseEntity palavra = service.localiza(palavraTest);
		Assertions.assertEquals("Palavra "+palavraTest+ " encontrada na matriz", palavra);
	}

}
