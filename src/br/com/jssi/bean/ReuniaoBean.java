package br.com.jssi.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.jssi.dao.DAO;
import br.com.jssi.modelo.Reuniao;

@ManagedBean
@ViewScoped
public class ReuniaoBean {

	Reuniao reuniao = new Reuniao();

	public Reuniao getReuniao() {
		return reuniao;
	}

	public void salvar() {
		if (this.reuniao.getId() == null) {
			new DAO<Reuniao>(Reuniao.class).adiciona(this.reuniao);
			this.reuniao = new Reuniao();
		} else {
			new DAO<Reuniao>(Reuniao.class).atualiza(reuniao);
			this.reuniao = new Reuniao();
		}
	}

	public List<Reuniao> getReunioes() {
		return new DAO<Reuniao>(Reuniao.class).listaTodos();
	}

	public void remover(Reuniao reuniao) {
		System.out.println("Removendo reunião " + reuniao.getAssunto());
		new DAO<Reuniao>(Reuniao.class).remove(reuniao);
		this.getReunioes().remove(reuniao);
	}

	public void carregar(Reuniao reuniao) {
		System.out.println("carregando reunião" + reuniao.getAssunto());
		this.reuniao = reuniao;
	}
	
	public void realizar(Reuniao reuniao) {
		reuniao.setStatus("Realizada");
		new DAO<Reuniao>(Reuniao.class).atualiza(reuniao);
	}

}
