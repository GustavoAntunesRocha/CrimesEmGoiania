package jpa;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.google.gson.Gson;

/**
 * Data Access Object.
 */
public class CrimeDao {

	//"CrimesEmGoiania" é o nome da unidade de persistência no "persistence.xml".
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CrimesEmGoiania");

	public static void inclui(String tipo, String arma, String descricao, String email, String senha, String regiao) {
		// Obter "conexão".
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Crime crime = new Crime();
		crime.setArma(arma);
		crime.setTipo(tipo);
		crime.setDescricao(descricao);
		crime.setEmail(email);
		crime.setSenha(senha);
		crime.setRegiao(regiao);

		// Grava o objeto no banco de dados.
		em.persist(crime);
		em.getTransaction().commit();
		em.close();
	}
	public static void crimeToJson() {
		ArrayList<Crime> crimes = (ArrayList<Crime>) listar();
		Gson gson = new Gson();
		String json = gson.toJson(crimes); 
		FileWriter arq;
		try {
			arq = new FileWriter("chart.json");
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.printf(json);
			arq.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static List<Crime> consultar(String email, String senha) {
		try {
			EntityManager em = emf.createEntityManager();
			String jpql = "SELECT t FROM Crime AS t WHERE t.email =email";
			TypedQuery<Crime> query = em.createQuery(jpql, Crime.class);
			List<Crime> result = query.getResultList();
			List<Crime> crime = new ArrayList<Crime>();
			for (Crime crimes : result) {
				if(crimes.getSenha().equals(senha)) {
					crime.add(crimes);
				}
			}
			return crime;
		}catch (NoResultException e) {
			return null;
		}
		
	}
	public static void alterar(String tipo, String arma, String descricao, String email, String senha) {
	}

	public static void excluir(int id) {
		EntityManager em = emf.createEntityManager();
		Crime crime = em.find(Crime.class, id); 
		em.getTransaction().begin();
		em.remove(crime);
		em.getTransaction().commit();
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
