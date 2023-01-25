package com.GestionGasolinera.dtos;

import com.GestionGasolinera.entities.Combustible;
import com.GestionGasolinera.entities.RepostajeGasolinera;
import com.GestionGasolinera.entities.RepostajeVehiculo;


public interface IToDAO {

	
	/**
	 * Combustible DT oto combustible DAO.
	 *
	 * @param combustibleDTO the combustible DTO
	 * @return the combustible
	 */
	public Combustible combustibleDTOtoCombustibleDAO(CombustibleDTO combustibleDTO);
	
	
	
	/**
	 * Repostaje vehiculo DT oto repostaje vehiculo DAO.
	 *
	 * @param repostajeVehiculoDTO the repostaje vehiculo DTO
	 * @return the repostaje vehiculo
	 */
	public RepostajeVehiculo repostajeVehiculoDTOtoRepostajeVehiculoDAO_factura(RepostajeVehiculoDTO repostajeVehiculoDTO);
	
	
	
	/**
	 * Repostaje vehiculo DT oto repostaje vehiculo DA O ticket.
	 *
	 * @param repostajeVehiculoDTO the repostaje vehiculo DTO
	 * @return the repostaje vehiculo
	 */
	public RepostajeVehiculo repostajeVehiculoDTOtoRepostajeVehiculoDAO_ticket(RepostajeVehiculoDTO repostajeVehiculoDTO);
	
	
	
	/**
	 * Repostaje gasolinera DT oto repostaje gasolinera DAO.
	 *
	 * @param repostajegasolineraDTO the repostajegasolinera DTO
	 * @return the repostaje gasolinera
	 */
	public RepostajeGasolinera repostajeGasolineraDTOtoRepostajeGasolineraDAO_factura(RepostajeGasolineraDTO repostajegasolineraDTO);
	
	
	
	/**
	 * Repostaje gasolinera DT oto repostaje gasolinera DA O ticket.
	 *
	 * @param repostajegasolineraDTO the repostajegasolinera DTO
	 * @return the repostaje gasolinera
	 */
	public RepostajeGasolinera repostajeGasolineraDTOtoRepostajeGasolineraDAO_ticket(RepostajeGasolineraDTO repostajegasolineraDTO);
	
}