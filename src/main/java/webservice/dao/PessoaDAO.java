package webservice.dao;

import java.util.List;

import javax.persistence.EntityManager;

import webservice.model.Pessoa;

public class PessoaDAO {

	private EntityManager em;

	public PessoaDAO() {

		em = JPA.getEntityManagerFactory().createEntityManager();

	}

	// ==============================================

	// Busca todos os registros
	@SuppressWarnings("unchecked")
	public List<Pessoa> SelectPessoas() {

		em = JPA.getEntityManagerFactory().createEntityManager();

		List<Pessoa> pessoas = em.createQuery("From Pessoa").getResultList();

		em.close();
		
		return pessoas;

	}

	// Busca registo por CPF
	public Pessoa SelectPessoa(String cpf) {

		em = JPA.getEntityManagerFactory().createEntityManager();

		Pessoa p = em.createQuery("SELECT p FROM Pessoa p WHERE cpf = :cpf ", Pessoa.class).setParameter("cpf", cpf).getSingleResult();
		em.close();

		return p;

	}
	
	// Busca registo por Nome
	public Pessoa SelectPessoaNome(String nome) {

		em = JPA.getEntityManagerFactory().createEntityManager();

		Pessoa p = em.createQuery("SELECT p FROM Pessoa p WHERE nome = :nome ", Pessoa.class).setParameter("nome", nome).getSingleResult();
		em.close();

		return p;

	}

	
	// Busca registo por Id
	public Pessoa SelectPessoaId(int id) {

		em = JPA.getEntityManagerFactory().createEntityManager();

		Pessoa p = em.find(Pessoa.class, id);
		em.close();

		return p;

	}

}
