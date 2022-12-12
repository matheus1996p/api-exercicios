package br.pacheco.matheus.exercicios.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.pacheco.matheus.exercicios.model.Veiculo;
import br.pacheco.matheus.exercicios.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculos")
public class Exercicio5Controller {
	
	@Autowired
	private VeiculoRepository veiculoRepository;

	@GetMapping
	public ResponseEntity listarTodos() {
		return new ResponseEntity<>(veiculoRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/buscarPorMarcaAnoDescricao")
	public ResponseEntity listarPorMarcaAnoDescricao(@RequestParam String marca, @RequestParam Integer ano, @RequestParam String descricao) {
		return new ResponseEntity<>(veiculoRepository.findByMarcaAndAnoAndDescricao(marca, ano, descricao), HttpStatus.OK);
	}
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE})
	public ResponseEntity inserirVeiculo(@RequestBody Veiculo veiculo) {
		try {
			Date date = new Date();
			veiculo.setCreated(LocalDateTime.now(ZoneId.of("UTC")));
			veiculo.setUpdated(LocalDateTime.now(ZoneId.of("UTC")));
			return new ResponseEntity<>(veiculoRepository.save(veiculo), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
            return null;
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity atualizarVeiculo(@RequestBody Veiculo novoVeiculo, @PathVariable Long id) {
		try {
			return new ResponseEntity<>(
					veiculoRepository.findById(id).map(veiculo -> {
						veiculo.setCreated(novoVeiculo.getCreated());
						veiculo.setDescricao(novoVeiculo.getDescricao());
						veiculo.setMarca(novoVeiculo.getMarca());
						veiculo.setUpdated(novoVeiculo.getUpdated());
						veiculo.setVeiculo(novoVeiculo.getVeiculo());
						veiculo.setVendido(novoVeiculo.getVendido());
						veiculo.setAno(novoVeiculo.getAno());
						return veiculoRepository.save(veiculo);
					}).orElseGet(() -> {
						novoVeiculo.setId(id);
						return veiculoRepository.save(novoVeiculo);
					}),
					HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
            return null;
		}
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity atualizarMarcaVeiculo(@RequestBody Veiculo novoVeiculo, @PathVariable Long id) {
		try {
			
			Veiculo veiculo = veiculoRepository.findById(id).get();
			
			veiculo.setMarca(novoVeiculo.getMarca());
			
			return new ResponseEntity<>(
					veiculoRepository.save(veiculo),
					HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
            return null;
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity excluirVeiculo(@PathVariable Long id) {
		try {
			return veiculoRepository.findById(id)
			           .map(veiculo -> {
			        	   veiculoRepository.deleteById(id);
			               return ResponseEntity.ok().build();
			           }).orElse(ResponseEntity.notFound().build());
		} catch (Exception e) {
			e.printStackTrace();
            return null;
		}
	}
	
}
