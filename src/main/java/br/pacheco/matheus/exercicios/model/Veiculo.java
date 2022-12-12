package br.pacheco.matheus.exercicios.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "VEICULO")
@Data
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "VEICULO", length = 80, nullable = false)
	private String veiculo;

	@Column(name = "MARCA", length = 80, nullable = false)
	private String marca;

	@Column(name = "DESCRICAO", length = 80, nullable = false)
	private String descricao;

	@Column(name = "ANO")
	private Integer ano;

	@Column(name = "VENDIDO")
	private Boolean vendido;

	@Column(name = "CREATED")
	private Date created;

	@Column(name = "UPDATED")
	private Date updated;

}
