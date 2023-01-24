package com.GestionGasolinera.queries;

import java.util.List;

import com.GestionGasolinera.entities.RepostajeVehiculo;


public interface IRepostajeVehiculoQuery {

	
	/**
	 * Listar repostajes vehiculo.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<RepostajeVehiculo> listarRepostajesVehiculo() throws Exception;
	
	
	
	/**
	 * Buscar repostaje vehiculo por id.
	 *
	 * @param repostajeVehiculo_id the repostaje vehiculo id
	 * @return the repostaje vehiculo
	 * @throws Exception the exception
	 */
	public RepostajeVehiculo buscarRepostajeVehiculoPorId(long repostajeVehiculo_id) throws Exception;
	
	
	
	/**
	 * Insertar repostaje vehiculo.
	 *
	 * @param repostajeVehiculo the repostaje vehiculo
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean insertarRepostajeVehiculo(RepostajeVehiculo repostajeVehiculo) throws Exception;
	
	
	
	// no se debe de poder editar un registro
	// public boolean editarRepostajeVehiculo(long repostajeVehiculo_id/*, y demás campos que quisiéramos editar*/) throws Exception;
		
		

	// no se debe de poder eliminar un registro
	// public boolean eliminarRepostajeVehiculoPorId(long repostajeVehiculo_id) throws Exception;
}
