package com.GestionGasolinera.dtos;

import org.springframework.stereotype.Service;

import com.GestionGasolinera.entities.Combustible;
import com.GestionGasolinera.entities.RepostajeGasolinera;
import com.GestionGasolinera.entities.RepostajeVehiculo;


@Service("ToDaoServiceImpl")
public class ToDaoServiceImpl implements IToDAO {

	
	/**
	 * Combustible DT oto combustible DAO.
	 *
	 * @param combustibleDTO the combustible DTO
	 * @return the combustible
	 */
	@Override
	public Combustible combustibleDTOtoCombustibleDAO(CombustibleDTO combustibleDTO) {
		Combustible combustible = new Combustible();
		
		if (combustibleDTO != null) {
			combustible.setCombustible_nombre(combustibleDTO.getCombustible_nombre());
			combustible.setCombustible_precio(combustibleDTO.getCombustible_precio());
		}
		
		return combustible;
	}

	
	
	/**
	 * Repostaje vehiculo DT oto repostaje vehiculo DA O factura.
	 *
	 * @param repostajeVehiculoDTO the repostaje vehiculo DTO
	 * @return the repostaje vehiculo
	 */
	@Override
	public RepostajeVehiculo repostajeVehiculoDTOtoRepostajeVehiculoDAO_factura(RepostajeVehiculoDTO repostajeVehiculoDTO) {
		RepostajeVehiculo repostajeVehiculo = new RepostajeVehiculo();
		
		if (repostajeVehiculoDTO != null) {
			repostajeVehiculo.setRepostajeVehiculo_dni(repostajeVehiculoDTO.getRepostajeVehiculo_dni());
			repostajeVehiculo.setRepostajeVehiculo_matricula(repostajeVehiculoDTO.getRepostajeVehiculo_matricula());
			repostajeVehiculo.setRepostajeVehiculo_litros(repostajeVehiculoDTO.getRepostajeVehiculo_litros());
			repostajeVehiculo.setCombustible(repostajeVehiculoDTO.getCombustible());
		}
		
		return repostajeVehiculo;
	}
	
	
	
	/**
	 * Repostaje vehiculo DT oto repostaje vehiculo DA O ticket.
	 *
	 * @param repostajeVehiculoDTO the repostaje vehiculo DTO
	 * @return the repostaje vehiculo
	 */
	@Override
	public RepostajeVehiculo repostajeVehiculoDTOtoRepostajeVehiculoDAO_ticket(RepostajeVehiculoDTO repostajeVehiculoDTO) {
		RepostajeVehiculo repostajeVehiculo = new RepostajeVehiculo();
		
		if (repostajeVehiculoDTO != null) {
			repostajeVehiculo.setRepostajeVehiculo_litros(repostajeVehiculoDTO.getRepostajeVehiculo_litros());
			repostajeVehiculo.setCombustible(repostajeVehiculoDTO.getCombustible());
		}
		
		return repostajeVehiculo;
	}

	
	
	/**
	 * Repostaje gasolinera DT oto repostaje gasolinera DA O factura.
	 *
	 * @param repostajeGasolineraDTO the repostaje gasolinera DTO
	 * @return the repostaje gasolinera
	 */
	@Override
	public RepostajeGasolinera repostajeGasolineraDTOtoRepostajeGasolineraDAO_factura(RepostajeGasolineraDTO repostajeGasolineraDTO) {
		RepostajeGasolinera repostajeGasolinera = new RepostajeGasolinera();
		
		if (repostajeGasolineraDTO != null) {
			repostajeGasolinera.setRepostajeGasolinera_dni(repostajeGasolineraDTO.getRepostajeGasolinera_dni());
			repostajeGasolinera.setRepostajeGasolinera_matricula(repostajeGasolineraDTO.getRepostajeGasolinera_matricula());
			repostajeGasolinera.setRepostajeGasolinera_litros(repostajeGasolineraDTO.getRepostajeGasolinera_litros());
			repostajeGasolinera.setCombustible(repostajeGasolineraDTO.getCombustible());
		}
		
		return repostajeGasolinera;
	}


	
	/**
	 * Repostaje gasolinera DT oto repostaje gasolinera DA O ticket.
	 *
	 * @param repostajeGasolineraDTO the repostaje gasolinera DTO
	 * @return the repostaje gasolinera
	 */
	@Override
	public RepostajeGasolinera repostajeGasolineraDTOtoRepostajeGasolineraDAO_ticket(RepostajeGasolineraDTO repostajeGasolineraDTO) {
		RepostajeGasolinera repostajeGasolinera = new RepostajeGasolinera();
		
		if (repostajeGasolineraDTO != null) {
			repostajeGasolinera.setRepostajeGasolinera_litros(repostajeGasolineraDTO.getRepostajeGasolinera_litros());
			repostajeGasolinera.setCombustible(repostajeGasolineraDTO.getCombustible());
		}
		
		return repostajeGasolinera;
	}
	
}