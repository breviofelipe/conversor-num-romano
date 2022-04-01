package br.com.brevio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.brevio.models.Romanos;

@SpringBootTest
class ConversorNumerosRomanosApplicationTests {

	@Test
	void inteiroToRomano() throws IOException {

		assertEquals("MD", Romanos.getValorRomano(1500));
	}

	@Test
	void romanoToInteiro() throws IOException {

		assertEquals(3999, Romanos.getValor("MMMCMXCIX"));
	}
}
