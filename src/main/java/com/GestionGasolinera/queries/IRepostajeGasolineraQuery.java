package com.GestionGasolinera.queries;

import java.util.List;

import com.GestionGasolinera.entities.RepostajeGasolinera;


public interface IRepostajeGasolineraQuery {

	
	/**
	 * Listar repostajes gasolinera.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<RepostajeGasolinera> listarRepostajesGasolinera() throws Exception;
	
	
	
	/**
	 * Buscar repostaje gasolinera por id.
	 *
	 * @param repostajeGasolinera_id the repostaje gasolinera id
	 * @return the repostaje gasolinera
	 * @throws Exception the exception
	 */
	public RepostajeGasolinera buscarRepostajeGasolineraPorId(long repostajeGasolinera_id) throws Exception;
	
	
	
	/**
	 * Insertar repostaje gasolinera.
	 *
	 * @param repostajeGasolinera the repostaje gasolinera
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean insertarRepostajeGasolinera(RepostajeGasolinera repostajeGasolinera) throws Exception;
	
	
	
	// no se debe de poder editar un registro
	// public boolean editarRepostajeGasolinera(long repostajeGasolinera_id/*, y demás campos que quisiéramos editar*/) throws Exception;
			
			

	// no se debe de poder eliminar un registro
	// public boolean eliminarRepostajeGasolineraPorId(long repostajeGasolinera_id) throws Exception;
	
	
	
	// En caso de que un operario se equivoque al introducir los datos del llenado de depósito, existe la posibilidad de eliminar el último que se ha realizado.
	/**
	 * Eliminar ultimo repostaje gasolinera.
	 *
	 * @param repostajeGasolinera the repostaje gasolinera
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean eliminarUltimoRepostajeGasolinera(RepostajeGasolinera repostajeGasolinera) throws Exception;
	
}
