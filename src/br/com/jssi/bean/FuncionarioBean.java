package br.com.jssi.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jssi.dao.DAO;
import br.com.jssi.modelo.Funcionario;

@ManagedBean
@ViewScoped
public class FuncionarioBean {

	private Funcionario funcionario = new Funcionario();

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void salvar() {
		if (this.funcionario.getId() == null) {
			new DAO<Funcionario>(Funcionario.class).adiciona(this.funcionario);
			this.funcionario = new Funcionario();
		} else {
			new DAO<Funcionario>(Funcionario.class).atualiza(funcionario);
			this.funcionario = new Funcionario();
		}
	}

	public List<Funcionario> getFuncionarios() {
		return new DAO<Funcionario>(Funcionario.class).listaTodos();
	}

	public void remover(Funcionario funcionario) {
		System.out.println("Removendo funcionario " + funcionario.getNome());
		new DAO<Funcionario>(Funcionario.class).remove(funcionario);
		this.getFuncionarios().remove(funcionario);
	}

	public void carregar(Funcionario funcionario) {
		System.out.println("carregando funcionario" + funcionario.getNome());
		this.funcionario = funcionario;
	}
}