package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Data Access Object.
 */
public class CrimeDao {

	//"CrimesEmGoiania" é o nome da unidade de persistência no "persistence.xml".
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CrimesEmGoiania");

	public static void inclui(String tipo, String arma, String descricao, String email, String senha) {
		// Obter "conexão".
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Crime crime = new Crime();
		crime.setArma(arma);
		crime.setTipo(tipo);
		crime.setDescricao(descricao);
		crime.setEmail(email);
		crime.setSenha(senha);
		

		// Grava o objeto no banco de dados.
		em.persist(crime);
		em.getTransaction().commit();
		em.close();
	}
	
	public static Crime consultar(String email, String senha) {
		try {
			EntityManager em = emf.createEntityManager();
			String jpql = "select t from Crime as t where t.email = email";
			TypedQuery<Crime> query = em.createQuery(jpql, Crime.class);
			Crime crime = query.getSingleResult();
			if(crime.getSenha().equals(senha)) {
				return crime;
			}
			else {
				return null;
			}
		}catch (NoResultException e) {
			return null;
		}
		
	}
	public static void alterar(String tipo, String arma, String descricao, String email, String senha) {
	}

	public static void excluir(String matricula) {
	}

	public static List<Crime> listar() {
		EntityManager em = emf.createEntityManager();
		//Não é SQL! É JPQL.
		String jpql = "from Crime";
		TypedQuery<Crime> query = em.createQuery(jpql, Crime.class);
		List<Crime> result = query.getResultList();
		em.close();
		return result;
	}
}
