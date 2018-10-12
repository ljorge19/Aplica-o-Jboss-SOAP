package br.edu.fiap.prova;


import java.util.List;

import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import br.edu.fiap.prova.common.Questao;


@Remote
public class QuestaoDAO {
	private EntityManager em;

	public QuestaoDAO(EntityManager em) {
		this.em = em;
	}

	public Questao salvar(Questao questao) throws Exception {
	    try {
	      // Inicia uma transação com o banco de dados.
	      em.getTransaction().begin();
	     
	      // Verifica se a pessoa ainda não está salva no banco de dados.
	      if(questao.getId() == null) {
	        //Salva os dados da pessoa.
	        em.persist(questao);
	        System.out.println("incluido com sucesso");
	        JOptionPane.showMessageDialog(null, "incluido com sucesso");
	      } else {
	        //Atualiza os dados da pessoa.
	        questao = em.merge(questao);
	        System.out.println("alterado com sucesso");
	        JOptionPane.showMessageDialog(null, "alterado com sucesso");
	      }
	      // Finaliza a transação.
	      em.getTransaction().commit();
	    } finally {
	      em.close();
	    }
	    return questao;
	  }
	
	public void excluir(Long id) {
	    try {
	      // Inicia uma transação com o banco de dados.
	      em.getTransaction().begin();
	      // Consulta a pessoa na base de dados através do seu ID.
	      Questao questao = em.find(Questao.class, id);
	      System.out.println("Excluindo o questao: " + questao.getDescricao());
	      // Remove a pessoa da base de dados.
	      em.remove(questao);
	      // Finaliza a transação.
	      em.getTransaction().commit();
	    } finally {
	      em.close();
	    }
	  }
	
	 /**
	   * Consulta o pessoa pelo ID.
	   * @param id
	   * @return o objeto Pessoa.
	   */
	  public Questao consultarQuestaoPorId(Long id) {
	    Questao questao = null;
	    try {
	      //Consulta uma pessoa pelo seu ID.
	      questao = em.find(Questao.class, id);
	    } finally {
	      em.close();
	    }
	    return questao;
	  }
	  
	  public List<Questao> listarQuestaos() {
			TypedQuery<Questao> query = em.createQuery("Select a from Questao a", Questao.class);
			return query.getResultList();
		}
	}
