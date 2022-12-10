package br.pacheco.matheus.exercicios.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercicio3")
public class Exercicio3Controller {

	
	@GetMapping("/calcularFatorial")
	public String calcularFatorial(@RequestParam Integer numero) {
		String fatorial = numero + "! = ";
		int f = 1;
		
		if(numero >= 2) {
			for(int i = 1; i <= numero; i++) {
				f *= i;
				if(i != numero) {
					fatorial += i + " x ";
				} else {
					fatorial += i;
				}
			}
			
			fatorial += " = " + f;
		} else {
			fatorial += f;
		}
			
		return fatorial;
	}
}
