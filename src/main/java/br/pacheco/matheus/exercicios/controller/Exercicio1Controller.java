package br.pacheco.matheus.exercicios.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercicio1")
public class Exercicio1Controller {

	@GetMapping("/votosValidos")
	public Integer percentualVotosValidos(@RequestParam Integer totalEleitores, @RequestParam Integer validos) {
		return (validos * 100) / totalEleitores;
	}
	
	@GetMapping("/votosNulos")
	public Integer percentualVotosNulos(@RequestParam Integer totalEleitores, @RequestParam Integer nulos) {
		return (nulos * 100) / totalEleitores;
	}
	
	@GetMapping("/votosBrancos")
	public Integer percentualVotosBrancos(@RequestParam Integer totalEleitores, @RequestParam Integer brancos) {
		return (brancos * 100) / totalEleitores;
	}
}
