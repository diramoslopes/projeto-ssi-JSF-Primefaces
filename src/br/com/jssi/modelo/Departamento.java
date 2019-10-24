package br.com.jssi.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Departamento {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	private String entidade;
	
	private String chefia;
	
	private String andar;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEntidade() {
		return entidade;
	}

	public void setEntidade(String entidade) {
		this.entidade = entidade;
	}

	public String getChefia() {
		return chefia;
	}

	public void setChefia(String chefia) {
		this.chefia = chefia;
	}

	public String getAndar() {
		return andar;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}
	
	
	
	
}
