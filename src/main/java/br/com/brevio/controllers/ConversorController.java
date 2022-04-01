package br.com.brevio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.brevio.models.RomanosResponse;
import br.com.brevio.services.ConversorService;

@RestController
@RequestMapping("conversor/v1/")
public class ConversorController {

	@Autowired
	private ConversorService service;

	@GetMapping("romanos")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<RomanosResponse> toRomanos(@RequestParam int valor) {

		return new ResponseEntity<RomanosResponse>(service.converterToRomanos(valor), HttpStatus.OK);
	}

	@GetMapping("arabico")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<RomanosResponse> toArabico(@RequestParam String valor) {
		RomanosResponse converterToArabico = service.converterToArabico(valor);
		return new ResponseEntity<RomanosResponse>(converterToArabico, HttpStatus.OK);
	}

}
