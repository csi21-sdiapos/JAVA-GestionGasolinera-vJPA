package com.GestionGasolinera.repositories;

import java.util.List;

import com.GestionGasolinera.entities.RepostajeGasolinera;


public interface IRepostajeGasolineraRepository {

	
	/**
	 * List repostaje gasolinera.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<RepostajeGasolinera> listRepostajeGasolinera() throws Exception;
	
	
	
	/**
	 * Find by id repostaje gasolinera.
	 *
	 * @param repostajeGasolinera_id the repostaje gasolinera id
	 * @return the repostaje gasolinera
	 * @throws Exception the exception
	 */
	public RepostajeGasolinera findByIdRepostajeGasolinera(long repostajeGasolinera_id) throws Exception;
	
	
	
	/**
	 * Insert repostaje gasolinera.
	 *
	 * @param repostajeGasolinera the repostaje gasolinera
	 * @throws Exception the exception
	 */
	public void insertRepostajeGasolinera(RepostajeGasolinera repostajeGasolinera) throws Exception;
	
	
	
	// no se debe de poder editar un registro
	// public void editRepostajeGasolinera(long repostajeGasolinera_id/*, y demás campos que quisiéramos editar*/) throws Exception;
		
		

	// no se debe de poder eliminar un registro
	// public void deleteByIdRepostajeGasolinera(long repostajeGasolinera_id) throws Exception;
	
	
	
	// En caso de que un operario se equivoque al introducir los datos del llenado de depósito, existe la posibilidad de eliminar el último que se ha realizado.
	/**
	 * Delete last repostaje gasolinera.
	 *
	 * @param repostajeGasolinera the repostaje gasolinera
	 * @throws Exception the exception
	 */
	public void deleteLastRepostajeGasolinera(RepostajeGasolinera repostajeGasolinera) throws Exception;
}
