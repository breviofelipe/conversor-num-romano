package br.com.brevio.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import br.com.brevio.models.Romanos;
import br.com.brevio.models.RomanosResponse;

@Service
public class ConversorService {

	public RomanosResponse converterToRomanos(int valor) {

		try {

			RomanosResponse response = new RomanosResponse();
			String valorRomano = Romanos.getValorRomano(valor);
			response.setMensagem("Valor convertido com sucesso.");
			response.setValor(valorRomano);
			return response;
		} catch (IOException e) {
			RomanosResponse response = new RomanosResponse();
			response.setMensagem(e.getMessage());

			return response;
		}
	}

	public RomanosResponse converterToArabico(String valor) {
		int valorRomano = Romanos.getValor(valor);
		RomanosResponse response = new RomanosResponse();
		response.setMensagem("Valor convertido com sucesso.");
		response.setValor(String.valueOf(valorRomano));
		return response;
	}
}
