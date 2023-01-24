package com.GestionGasolinera.repositories;

import java.util.List;

import com.GestionGasolinera.entities.RepostajeVehiculo;


public interface IRepostajeVehiculoRepository {

	
	/**
	 * List repostaje vehiculo.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<RepostajeVehiculo> listRepostajeVehiculo() throws Exception;
	

	
	/**
	 * Find by id repostaje vehiculo.
	 *
	 * @param repostajeVehiculo_id the repostaje vehiculo id
	 * @return the repostaje vehiculo
	 * @throws Exception the exception
	 */
	public RepostajeVehiculo findByIdRepostajeVehiculo(long repostajeVehiculo_id) throws Exception;
	

	
	/**
	 * Insert repostaje vehiculo.
	 *
	 * @param repostajeVehiculo the repostaje vehiculo
	 * @throws Exception the exception
	 */
	public void insertRepostajeVehiculo(RepostajeVehiculo repostajeVehiculo) throws Exception;
	
	

	// no se debe de poder editar un registro
	// public void editRepostajeVehiculo(long repostajeVehiculo_id/*, y demás campos que quisiéramos editar*/) throws Exception;
	
	

	// no se debe de poder eliminar un registro
	// public void deleteByIdRepostajeVehiculo(long repostajeVehiculo_id) throws Exception;
	
}
