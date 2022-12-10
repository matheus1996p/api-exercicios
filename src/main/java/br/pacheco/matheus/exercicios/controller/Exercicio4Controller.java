package br.pacheco.matheus.exercicios.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercicio4")
public class Exercicio4Controller {

	
	@GetMapping("/calcularSomaMultiplos")
	public Integer calcularSomaMultiplos(@RequestParam Integer numero) {
		int soma = 0;
		List<Integer> multiplos = new ArrayList<Integer>();
		
		for(int i = 0; i < numero; i++) {
			if(i % 5 == 0 || i % 3 == 0) {
				multiplos.add(i);
			}
		}
		
		if(multiplos.size() > 0) {
			for(int i = 0; i < multiplos.size(); i++) {
				soma += multiplos.get(i);
			}
		}
		
		return soma;
	}
}
