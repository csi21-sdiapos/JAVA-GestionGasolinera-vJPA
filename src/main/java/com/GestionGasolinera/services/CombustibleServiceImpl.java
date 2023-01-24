package com.GestionGasolinera.services;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.GestionGasolinera.entities.Combustible;
import com.GestionGasolinera.queries.CombustibleQueryImpl;
import com.GestionGasolinera.queries.ICombustibleQuery;
import com.GestionGasolinera.tools.Tools;


@Service("CombustibleServiceImpl")
public class CombustibleServiceImpl implements ICombustibleService {

	/** The scanner. */
	public static Scanner scanner = new Scanner(System.in);
	
	/** The combustible query impl. */
	ICombustibleQuery combustibleQueryImpl = new CombustibleQueryImpl();
	

	
	/**
	 * Mostrar lista de combustibles.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void mostrarListaDeCombustibles() throws Exception {
		List<Combustible> listaCombustibles = combustibleQueryImpl.listarCombustibles();
		
		for (Combustible combustible : listaCombustibles) {
			System.out.println(combustible.toString());
		}
	}
	
	

	/**
	 * Mostrar un combustible.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void mostrarUnCombustible() throws Exception {
		System.out.println("\n\nCombustibles disponibles");
		System.out.println("------------------------------");
		mostrarListaDeCombustibles();
		
		int combustible_id = Tools.capturaEntero_v3("\n\nIntroduzca un número para mostrar un combustible", 0, 99);
		Combustible combustible = combustibleQueryImpl.buscarCombustiblePorId(combustible_id);
		System.out.println(combustible.toString());
	}
	
	

	/**
	 * Seleccionar un combustible.
	 *
	 * @return the combustible
	 * @throws Exception the exception
	 */
	@Override
	public Combustible seleccionarUnCombustible() throws Exception {
		System.out.println("\n\nCombustibles disponibles");
		System.out.println("------------------------------");
		mostrarListaDeCombustibles();
		
		int combustible_id = Tools.capturaEntero_v3("\n\nIntroduzca un número para seleccionar un combustible", 0, 99);
		Combustible combustible = combustibleQueryImpl.buscarCombustiblePorId(combustible_id);
		
		return combustible;
	}
	
	

	/**
	 * Crear un nuevo combustible.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void crearUnNuevoCombustible() throws Exception {
		System.out.print("\n\nIntroduzca el nombre del nuevo combustible:\t");
		String combustible_nombre = scanner.next();
		
		System.out.print("\n\nIntroduzca el precio del nuevo combustible:\t");
		double combustible_precio = scanner.nextDouble();
		
		combustibleQueryImpl.insertarCombustible(new Combustible(combustible_nombre, combustible_precio));
		System.out.println("\n\nEl nuevo combustible " + combustible_nombre + " se ha creado correctamente");
	}
	
	

	/**
	 * Editar nombre o precio de un combustible.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void editarNombrePrecioDeUnCombustible() throws Exception {
		System.out.print("\n\nVamos a editar los datos de un combustible");
		Combustible combustible = seleccionarUnCombustible();
		
		System.out.print("\n\nIntroduzca un nuevo nombre para el combustible seleccionado:\t");
		String combustible_nombre = scanner.next();
		
		System.out.print("\n\nIntroduzca el nuevo precio para el combustible seleccionado:\t");
		double combustible_precio = scanner.nextDouble();
		
		combustibleQueryImpl.editarCombustible(combustible.getCombustible_id(), combustible_nombre, combustible_precio);
		System.out.println("\n\nEl combustible selecccionado se ha modificado correctamente");
	}

	

	/**
	 * Eliminar un combustible.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void eliminarUnCombustible() throws Exception {
		System.out.print("\n\nVamos a eliminar un combustible");
		Combustible combustible = seleccionarUnCombustible();
		
		if (Tools.preguntaSiNo("¿Está seguro de que desea eliminar el combustible seleccionado ?")) { // ¿por qué no me funciona bien este método?
			combustibleQueryImpl.eliminarCombustible(combustible);
			System.out.println("\n\nEl combustible seleccionado se ha eliminado correctamente");
		}
		else {
			System.out.println("\n\nEl combustible seleccionado NO se ha eliminado");
		}
	}

	

	/**
	 * Eliminar un combustible por id.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void eliminarUnCombustiblePorId() throws Exception {
		System.out.print("\n\nVamos a eliminar un combustible por su ID");
		System.out.println("\n\nCombustibles disponibles");
		System.out.println("------------------------------");
		mostrarListaDeCombustibles();
		
		int combustible_id = Tools.capturaEntero_v3("\n\nIntroduzca un número para eliminar ese combustible", 0, 99);
		combustibleQueryImpl.eliminarCombustiblePorId(combustible_id);
	}
	
}
