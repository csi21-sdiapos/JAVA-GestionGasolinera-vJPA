package com.GestionGasolinera.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.GestionGasolinera.entities.RepostajeGasolinera;


@Repository("RepostajeGasolineraRepositoryImpl")
public class RepostajeGasolineraRepositoryImpl implements IRepostajeGasolineraRepository {

	
	/** The entity manager factory. */
	// @PersistenceContext(unitName = "GestionGasolinera", type = PersistenceContextType.EXTENDED)
	@PersistenceUnit(name = "GestionGasolinera")
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionGasolinera");

	
	
	/**
	 * List repostaje gasolinera.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	@Override
	public List<RepostajeGasolinera> listRepostajeGasolinera() throws Exception {
		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
								
		// the lowercase c refers to the object
		// :objectID is a parameterized query thats value is set below
		String query = "SELECT rg FROM RepostajeGasolinera rg WHERE rg.id IS NOT NULL";
				    	
		// Issue the query and get a matching object
		TypedQuery<RepostajeGasolinera> typedQuery = entityManager.createQuery(query, RepostajeGasolinera.class);
		List<RepostajeGasolinera> listaRepostajesGasolinera = new ArrayList<>();
				
		try {
			// Get matching objects and output
			listaRepostajesGasolinera = typedQuery.getResultList();
		}
				    	
		catch(NoResultException ex) {
			ex.printStackTrace();
		}
				    	
		finally {
			// Close EntityManager
			// entityManager.flush();
			// entityManager.clear();
			entityManager.close();
		}
				    	
		return listaRepostajesGasolinera;
	}

	
	
	/**
	 * Find by id repostaje gasolinera.
	 *
	 * @param repostajeGasolinera_id the repostaje gasolinera id
	 * @return the repostaje gasolinera
	 * @throws Exception the exception
	 */
	@Override
	public RepostajeGasolinera findByIdRepostajeGasolinera(long repostajeGasolinera_id) throws Exception {
		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
								
		// the lowercase a refers to the object
		// :objectID is a parameterized query thats value is set below
		String query = "SELECT rg FROM RepostajeGasolinera rg WHERE rg.id = :repostajeGasolineraID";
				    	
		// Issue the query and get a matching object
		TypedQuery<RepostajeGasolinera> typedQuery = entityManager.createQuery(query, RepostajeGasolinera.class);
		typedQuery.setParameter("repostajeGasolineraID", repostajeGasolinera_id);
				    	
		RepostajeGasolinera repostajeGasolinera = new RepostajeGasolinera();
				    	
		try {
			// Get matching the object and output
			repostajeGasolinera = typedQuery.getSingleResult();		    		
		}
		
		catch(NoResultException e) {
			e.printStackTrace();
		}
				    	
		finally {
			// Close EntityManager
			// entityManager.flush();
			// entityManager.clear();
			entityManager.close();
		}
				    	
		return repostajeGasolinera;
	}

	
	
	/**
	 * Insert repostaje gasolinera.
	 *
	 * @param repostajeGasolinera the repostaje gasolinera
	 * @throws Exception the exception
	 */
	@Override
	public void insertRepostajeGasolinera(RepostajeGasolinera repostajeGasolinera) throws Exception {
		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// Used to issue transactions on the EntityManager
		EntityTransaction entityTransaction = null;
						 
		try {
			// Get transaction and start
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
				 
			// Save the object
			// entityManager.persist(repostajeGasolinera);
			entityManager.merge(repostajeGasolinera);		// https://www.baeldung.com/hibernate-detached-entity-passed-to-persist
			entityTransaction.commit();
				            
		} catch (Exception ex) {
			// If there is an exception rollback changes
			if (entityTransaction != null) {
				entityTransaction.rollback();
			}
				            
			ex.printStackTrace();
				        
		} finally {
			// Close EntityManager
			// entityManager.flush();
			// entityManager.clear();
			entityManager.close();
		}
	}
	
}
