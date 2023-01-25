package com.GestionGasolinera.dtos;

import com.GestionGasolinera.entities.Combustible;


/**
 * En estos métodos de conversión a dto, sólo necesito recibir aquellos campos que le vaya a pedir al usuario para crear un objeto DAO
 * Estos métodos se volcarán directamente sobre la declaración de un DTO.
 */
public interface IToDTO {

	
	/**
	 * To combustible DTO.
	 *
	 * @param combustible_nombre the combustible nombre
	 * @param combustible_precio the combustible precio
	 * @return the combustible DTO
	 */
	public CombustibleDTO toCombustibleDTO(String combustible_nombre, double combustible_precio);
	
	
	
	/**
	 * To repostaje vehiculo DT O factura.
	 *
	 * @param repostajeVehiculo_dni the repostaje vehiculo dni
	 * @param repostajeVehiculo_matricula the repostaje vehiculo matricula
	 * @param repostajeVehiculo_litros the repostaje vehiculo litros
	 * @param combustible the combustible
	 * @return the repostaje vehiculo DTO
	 */
	public RepostajeVehiculoDTO toRepostajeVehiculoDTO_factura(String repostajeVehiculo_dni, String repostajeVehiculo_matricula, double repostajeVehiculo_litros, Combustible combustible);

	
	
	/**
	 * To repostaje vehiculo DT O ticket.
	 *
	 * @param repostajeVehiculo_litros the repostaje vehiculo litros
	 * @param combustible the combustible
	 * @return the repostaje vehiculo DTO
	 */
	public RepostajeVehiculoDTO toRepostajeVehiculoDTO_ticket(double repostajeVehiculo_litros, Combustible combustible);
	
	
	
	/**
	 * To repostaje gasolinera DT O factura.
	 *
	 * @param repostajeVehiculo_dni the repostaje vehiculo dni
	 * @param repostajeVehiculo_matricula the repostaje vehiculo matricula
	 * @param repostajeVehiculo_litros the repostaje vehiculo litros
	 * @param combustible the combustible
	 * @return the repostaje gasolinera DTO
	 */
	public RepostajeGasolineraDTO toRepostajeGasolineraDTO_factura(String repostajeVehiculo_dni, String repostajeVehiculo_matricula, double repostajeVehiculo_litros, Combustible combustible);
	
	
	
	/**
	 * To repostaje gasolinera DT O ticket.
	 *
	 * @param repostajeVehiculo_litros the repostaje vehiculo litros
	 * @param combustible the combustible
	 * @return the repostaje gasolinera DTO
	 */
	public RepostajeGasolineraDTO toRepostajeGasolineraDTO_ticket(double repostajeVehiculo_litros, Combustible combustible);

}