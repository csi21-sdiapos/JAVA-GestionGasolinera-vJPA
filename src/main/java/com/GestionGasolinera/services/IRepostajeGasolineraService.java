package com.GestionGasolinera.services;

import com.GestionGasolinera.entities.RepostajeGasolinera;


public interface IRepostajeGasolineraService {

	
	/**
	 * Mostrar lista de repostajes gasolinera.
	 *
	 * @throws Exception the exception
	 */
	public void mostrarListaDeRepostajesGasolinera() throws Exception;
	
	
	
	/**
	 * Mostrar un repostaje gasolinera.
	 *
	 * @throws Exception the exception
	 */
	public void mostrarUnRepostajeGasolinera() throws Exception;
	
	
	
	/**
	 * Seleccionar un repostaje gasolinera.
	 *
	 * @return the repostaje gasolinera
	 * @throws Exception the exception
	 */
	public RepostajeGasolinera seleccionarUnRepostajeGasolinera() throws Exception;
	
	
	
	/**
	 * Crear un nuevo repostaje gasolinera con ticket.
	 *
	 * @throws Exception the exception
	 */
	public void crearUnNuevoRepostajeGasolinera_conTicket() throws Exception;
	
	
	
	/**
	 * Crear un nuevo repostaje gasolinera con factura.
	 *
	 * @throws Exception the exception
	 */
	public void crearUnNuevoRepostajeGasolinera_conFactura() throws Exception;
	
	
	
	// En caso de que un operario se equivoque al introducir los datos del llenado de depósito, existe la posibilidad de eliminar el último que se ha realizado.
	/**
	 * Eliminar el ultimo repostaje gasolinera.
	 *
	 * @throws Exception the exception
	 */
	public void eliminarElUltimoRepostajeGasolinera() throws Exception;
	
}
