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

import com.GestionGasolinera.entities.RepostajeVehiculo;


@Repository("RepostajeVehiculoRepositoryImpl")
public class RepostajeVehiculoRepositoryImpl implements IRepostajeVehiculoRepository {

	/** The entity manager factory. */
	// @PersistenceContext(unitName = "GestionGasolinera", type = PersistenceContextType.EXTENDED)
	@PersistenceUnit(name = "GestionGasolinera")
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionGasolinera");
	
	
	
	/**
	 * List repostaje vehiculo.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	@Override
	public List<RepostajeVehiculo> listRepostajeVehiculo() throws Exception {
		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
						
		// the lowercase c refers to the object
		// :objectID is a parameterized query thats value is set below
		String query = "SELECT rv FROM RepostajeVehiculo rv WHERE rv.id IS NOT NULL";
		    	
		// Issue the query and get a matching Customer
		TypedQuery<RepostajeVehiculo> typedQuery = entityManager.createQuery(query, RepostajeVehiculo.class);
		List<RepostajeVehiculo> listaRepostajesVehiculo = new ArrayList<>();
		
		try {
			// Get matching objects and output
			listaRepostajesVehiculo = typedQuery.getResultList();
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
		    	
		return listaRepostajesVehiculo;
	}



	/**
	 * Find by id repostaje vehiculo.
	 *
	 * @param repostajeVehiculo_id the repostaje vehiculo id
	 * @return the repostaje vehiculo
	 * @throws Exception the exception
	 */
	@Override
	public RepostajeVehiculo findByIdRepostajeVehiculo(long repostajeVehiculo_id) throws Exception {
		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
						
		// the lowercase a refers to the object
		// :objectID is a parameterized query thats value is set below
		String query = "SELECT rv FROM RepostajeVehiculo rv WHERE rv.id = :repostajeVehiculoID";
		    	
		// Issue the query and get a matching Customer
		TypedQuery<RepostajeVehiculo> typedQuery = entityManager.createQuery(query, RepostajeVehiculo.class);
		typedQuery.setParameter("repostajeVehiculoID", repostajeVehiculo_id);
		    	
		RepostajeVehiculo repostajeVehiculo = new RepostajeVehiculo();
		    	
		try {
			// Get matching the object and output
		    repostajeVehiculo = typedQuery.getSingleResult();
		    		
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
		    	
		return repostajeVehiculo;
	}

	
	
	/**
	 * Insert repostaje vehiculo.
	 *
	 * @param repostajeVehiculo the repostaje vehiculo
	 * @throws Exception the exception
	 */
	@Override
	public void insertRepostajeVehiculo(RepostajeVehiculo repostajeVehiculo) throws Exception {
		// The EntityManager class allows operations such as create, read, update, delete
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// Used to issue transactions on the EntityManager
		EntityTransaction entityTransaction = null;
				 
		try {
			// Get transaction and start
		    entityTransaction = entityManager.getTransaction();
		    entityTransaction.begin();
		 
		    // Save the object
		    // entityManager.persist(repostajeVehiculo);
		    entityManager.merge(repostajeVehiculo);		// https://www.baeldung.com/hibernate-detached-entity-passed-to-persist
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