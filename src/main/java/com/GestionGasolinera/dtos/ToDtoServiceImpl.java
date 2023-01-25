package com.GestionGasolinera.dtos;

import org.springframework.stereotype.Service;

import com.GestionGasolinera.entities.Combustible;

/**
 * En estos métodos de conversión a dto, sólo necesito recibir aquellos campos que le vaya a pedir al usuario para crear un objeto DAO
 * Estos métodos se volcarán directamente sobre la declaración de un DTO.
 */
@Service("ToDtoServiceImpl")
public class ToDtoServiceImpl implements IToDTO {

	
	/**
	 * To combustible DTO.
	 *
	 * @param combustible_nombre the combustible nombre
	 * @param combustible_precio the combustible precio
	 * @return the combustible DTO
	 */
	@Override
	public CombustibleDTO toCombustibleDTO(String combustible_nombre, double combustible_precio) {

		CombustibleDTO combustibleDTO = new CombustibleDTO(combustible_nombre, combustible_precio);
		return combustibleDTO;
	}

	
	
	/**
	 * To repostaje vehiculo DT O factura.
	 *
	 * @param repostajeVehiculo_dni the repostaje vehiculo dni
	 * @param repostajeVehiculo_matricula the repostaje vehiculo matricula
	 * @param repostajeVehiculo_litros the repostaje vehiculo litros
	 * @param combustible the combustible
	 * @return the repostaje vehiculo DTO
	 */
	@Override
	public RepostajeVehiculoDTO toRepostajeVehiculoDTO_factura(String repostajeVehiculo_dni, String repostajeVehiculo_matricula, double repostajeVehiculo_litros, Combustible combustible) {

		RepostajeVehiculoDTO repostajeVehiculoDTO = new RepostajeVehiculoDTO(repostajeVehiculo_dni, repostajeVehiculo_matricula, repostajeVehiculo_litros, combustible);
		return repostajeVehiculoDTO;
	}

	
	
	/**
	 * To repostaje vehiculo DT O ticket.
	 *
	 * @param repostajeVehiculo_litros the repostaje vehiculo litros
	 * @param combustible the combustible
	 * @return the repostaje vehiculo DTO
	 */
	@Override
	public RepostajeVehiculoDTO toRepostajeVehiculoDTO_ticket(double repostajeVehiculo_litros, Combustible combustible) {

		RepostajeVehiculoDTO repostajeVehiculoDTO = new RepostajeVehiculoDTO(repostajeVehiculo_litros, combustible);
		return repostajeVehiculoDTO;
	}

	
	
	/**
	 * To repostaje gasolinera DT O factura.
	 *
	 * @param repostajeVehiculo_dni the repostaje vehiculo dni
	 * @param repostajeVehiculo_matricula the repostaje vehiculo matricula
	 * @param repostajeVehiculo_litros the repostaje vehiculo litros
	 * @param combustible the combustible
	 * @return the repostaje gasolinera DTO
	 */
	@Override
	public RepostajeGasolineraDTO toRepostajeGasolineraDTO_factura(String repostajeVehiculo_dni, String repostajeVehiculo_matricula, double repostajeVehiculo_litros, Combustible combustible) {

		RepostajeGasolineraDTO repostajeGasolineraDTO = new RepostajeGasolineraDTO(repostajeVehiculo_dni, repostajeVehiculo_matricula, repostajeVehiculo_litros, combustible);
		return repostajeGasolineraDTO;
	}

	
	
	/**
	 * To repostaje gasolinera DT O ticket.
	 *
	 * @param repostajeVehiculo_litros the repostaje vehiculo litros
	 * @param combustible the combustible
	 * @return the repostaje gasolinera DTO
	 */
	@Override
	public RepostajeGasolineraDTO toRepostajeGasolineraDTO_ticket(double repostajeVehiculo_litros, Combustible combustible) {

		RepostajeGasolineraDTO repostajeGasolineraDTO = new RepostajeGasolineraDTO(repostajeVehiculo_litros, combustible);
		return repostajeGasolineraDTO;
	}
	
}