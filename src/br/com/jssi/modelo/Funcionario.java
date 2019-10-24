package br.com.jssi.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	private String email;
	
	private String ramal;
	
	private String patrimonioPc;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public String getPatrimonioPc() {
		return patrimonioPc;
	}

	public void setPatrimonioPc(String patrimonioPc) {
		this.patrimonioPc = patrimonioPc;
	}
	
}