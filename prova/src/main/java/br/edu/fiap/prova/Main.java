package br.edu.fiap.prova;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class Main {
	@Inject
	QuestaoDAO dao;
	
	public static void main(String[] args) {
		
		/*for (Questao questao : dao.) {
			System.out.println("-------------------------------------");
			System.out.println("CÓDIGO DO ALUNO: " + aluno.getId());
			System.out.println("NOME DO ALUNO: " + aluno.getNome());
			System.out.println("-------------------------------------");
		
*/
	}

}
