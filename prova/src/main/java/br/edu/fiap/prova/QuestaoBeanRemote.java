package br.edu.fiap.prova;

import java.util.List;

import javax.ejb.Remote;

import br.edu.fiap.prova.common.Questao;

@Remote
public interface QuestaoBeanRemote {
	void add(Questao questao);
	List<Questao> getAll();
}
