package br.com.jssi.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jssi.dao.DAO;
import br.com.jssi.modelo.Impressora;

@ManagedBean
@ViewScoped
public class ImpressoraBean {

	private Impressora impressora = new Impressora();

	public Impressora getImpressora() {
		return impressora;
	}

	public void salvar() {
		if (this.impressora.getId() == null) {
			new DAO<Impressora>(Impressora.class).adiciona(this.impressora);
			this.impressora = new Impressora();
		} else {
			new DAO<Impressora>(Impressora.class).atualiza(impressora);
			this.impressora = new Impressora();
		}
	}

	public List<Impressora> getImpressoras() {
		return new DAO<Impressora>(Impressora.class).listaTodos();
	}

	public void remover(Impressora impressora) {
		System.out.println("Removendo impressora " + impressora.getNomeImpressora());
		new DAO<Impressora>(Impressora.class).remove(impressora);
		this.getImpressoras().remove(impressora);
	}

	public void carregar(Impressora impressora) {
		System.out.println("carregando impressora" + impressora.getNomeImpressora());
		this.impressora = impressora;
	}
}