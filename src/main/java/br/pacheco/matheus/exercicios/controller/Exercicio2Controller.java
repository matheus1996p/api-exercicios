package br.pacheco.matheus.exercicios.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercicio2")
public class Exercicio2Controller {

	@GetMapping("/ordenarVetor")
	public Integer[] ordenacaoBubbleSort(@RequestParam Integer[] vetor) {
		int aux = 0;
		int i = 0;
		
		for(i=0; i < vetor.length; i++) {
			for(int j = 0; j < vetor.length - 1; j++) {
				if(vetor[j] > vetor[j + 1]) {
					aux = vetor[j];
					vetor[j] = vetor[j+1];
					vetor[j+1] = aux;
				}
			}
		}
		
		return vetor;
	}
}
