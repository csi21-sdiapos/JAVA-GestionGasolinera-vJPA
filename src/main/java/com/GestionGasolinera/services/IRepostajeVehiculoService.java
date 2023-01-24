package com.GestionGasolinera.services;

import com.GestionGasolinera.entities.RepostajeVehiculo;


public interface IRepostajeVehiculoService {

	
	/**
	 * Mostrar lista de repostajes vehiculos.
	 *
	 * @throws Exception the exception
	 */
	public void mostrarListaDeRepostajesVehiculos() throws Exception;
	
	
	
	/**
	 * Mostrar un repostaje vehiculo.
	 *
	 * @throws Exception the exception
	 */
	public void mostrarUnRepostajeVehiculo() throws Exception;
	
	
	
	/**
	 * Calcular mostrar importe total combustible vendido.
	 *
	 * @throws Exception the exception
	 */
	public void calcularMostrarImporteTotalCombustibleVendido() throws Exception;
	
	
	
	/**
	 * Seleccionar un repostaje vehiculo.
	 *
	 * @return the repostaje vehiculo
	 * @throws Exception the exception
	 */
	public RepostajeVehiculo seleccionarUnRepostajeVehiculo() throws Exception;
	
	
	
	/**
	 * Crear un nuevo repostaje vehiculo con ticket.
	 *
	 * @throws Exception the exception
	 */
	public void crearUnNuevoRepostajeVehiculo_conTicket() throws Exception;
	
	
	
	/**
	 * Crear un nuevo repostaje vehiculo con factura.
	 *
	 * @throws Exception the exception
	 */
	public void crearUnNuevoRepostajeVehiculo_conFactura() throws Exception;
	
}
