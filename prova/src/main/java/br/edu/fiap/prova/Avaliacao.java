package br.edu.fiap.prova;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.fiap.prova.common.Questao;

@Stateless
@WebService
public class Avaliacao implements QuestaoBeanRemote {
	
	@PersistenceContext(unitName="Chamado")
	private EntityManager em; 
	@Inject
	QuestaoDAO dao;

	@Override
	public void add(Questao questao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Questao> getAll(){
	 TypedQuery<Questao> query = em.createQuery("select u from Questao u",
			 Questao.class);
	 return query.getResultList();
	 } 

	
    
	/*public List<Questao> getQuestao() {
		
		//System.out.println("questao : " );
		
		List<Questao> questaoLista = dao.listarQuestaos(); 
		
		try {
			for (Questao questao : questaoLista) {
				System.out.println("-------------------------------------");
				System.out.println("CÓDIGO DO ALUNO: " + questao.getId());
				System.out.println("NOME DO ALUNO: " + questao.getDescricao());
				System.out.println("-------------------------------------");
			}
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	
				 return questaoLista; */
		
		
		
	}
//}
