package com.GestionGasolinera.services;

import com.GestionGasolinera.entities.Combustible;


public interface ICombustibleService {
	
	
	/**
	 * Mostrar lista de combustibles.
	 *
	 * @throws Exception the exception
	 */
	public void mostrarListaDeCombustibles() throws Exception;
	
	

	/**
	 * Mostrar un combustible.
	 *
	 * @throws Exception the exception
	 */
	public void mostrarUnCombustible() throws Exception;
	


	/**
	 * Seleccionar un combustible.
	 *
	 * @return the combustible
	 * @throws Exception the exception
	 */
	public Combustible seleccionarUnCombustible() throws Exception;
	
	

	/**
	 * Crear un nuevo combustible.
	 *
	 * @throws Exception the exception
	 */
	public void crearUnNuevoCombustible() throws Exception;
	
	

	/**
	 * Editar nombre o precio de un combustible.
	 *
	 * @throws Exception the exception
	 */
	public void editarNombrePrecioDeUnCombustible() throws Exception;
	
	
	
	/**
	 * Eliminar un combustible.
	 *
	 * @throws Exception the exception
	 */
	public void eliminarUnCombustible() throws Exception;
	
	
	
	/**
	 * Eliminar un combustible por id.
	 *
	 * @throws Exception the exception
	 */
	public void eliminarUnCombustiblePorId() throws Exception;
	
}
