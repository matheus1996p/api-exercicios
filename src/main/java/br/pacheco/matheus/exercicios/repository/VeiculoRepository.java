package br.pacheco.matheus.exercicios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pacheco.matheus.exercicios.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	
	List<Veiculo> findByMarcaAndAnoAndDescricao(String marca, Integer ano, String descricao); 
	
}
