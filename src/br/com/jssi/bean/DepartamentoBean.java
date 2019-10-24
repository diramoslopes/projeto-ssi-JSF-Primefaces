package br.com.jssi.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jssi.dao.DAO;
import br.com.jssi.modelo.Departamento;

@ManagedBean
@ViewScoped
public class DepartamentoBean {
	
	private Departamento departamento = new Departamento();

	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void salvar() {
		if (this.departamento.getId() == null) {
			new DAO<Departamento>(Departamento.class).adiciona(this.departamento);
			this.departamento = new Departamento();
		} else {
			new DAO<Departamento>(Departamento.class).atualiza(departamento);
			this.departamento = new Departamento();
		}
	}
	
	public List<Departamento> getDepartamentos(){
		return new DAO<Departamento>(Departamento.class).listaTodos();
	}
	
	public void remover(Departamento departamento) {
		System.out.println("Removendo departamento " + departamento.getNome());
		new DAO<Departamento>(Departamento.class).remove(departamento);
		this.getDepartamentos().remove(departamento);
	}

	public void carregar(Departamento departamento) {
		System.out.println("carregando departamento" + departamento.getNome());
		this.departamento = departamento;
	}
	
}
