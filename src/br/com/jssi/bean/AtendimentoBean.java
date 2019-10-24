package br.com.jssi.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jssi.dao.DAO;
import br.com.jssi.modelo.Atendimento;

@ManagedBean
@ViewScoped
public class AtendimentoBean {

	Atendimento atendimento = new Atendimento();

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void salvar() {
		if (this.atendimento.getId() == null) {
			new DAO<Atendimento>(Atendimento.class).adiciona(this.atendimento);
			this.atendimento = new Atendimento();
		} else {
			new DAO<Atendimento>(Atendimento.class).atualiza(atendimento);
			this.atendimento = new Atendimento();
		}
	}

	public List<Atendimento> getAtendimentos() {
		return new DAO<Atendimento>(Atendimento.class).listaTodos();
	}

	public void remover(Atendimento atendimento) {
		System.out.println("Removendo atendimento " + atendimento.getMotivo());
		new DAO<Atendimento>(Atendimento.class).remove(atendimento);
		this.getAtendimentos().remove(atendimento);
	}

	public void carregar(Atendimento atendimento) {
		System.out.println("carregando atendimento" + atendimento.getMotivo());
		this.atendimento = atendimento;
	}
	
	public void resolver(Atendimento atendimento) {
		atendimento.setStatus("Resolvido");
		new DAO<Atendimento>(Atendimento.class).atualiza(atendimento);
	}

}
