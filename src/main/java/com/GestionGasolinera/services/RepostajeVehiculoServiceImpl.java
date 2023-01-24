package com.GestionGasolinera.services;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.GestionGasolinera.entities.Combustible;
import com.GestionGasolinera.entities.RepostajeVehiculo;
import com.GestionGasolinera.queries.IRepostajeVehiculoQuery;
import com.GestionGasolinera.queries.RepostajeVehiculoQueryImpl;
import com.GestionGasolinera.tools.Tools;


@Service("RepostajeVehiculoServiceImpl")
public class RepostajeVehiculoServiceImpl implements IRepostajeVehiculoService {

	/** The scanner. */
	public static Scanner scanner = new Scanner(System.in);

	/** The repostaje vehiculo query impl. */
	IRepostajeVehiculoQuery repostajeVehiculoQueryImpl = new RepostajeVehiculoQueryImpl();
	
	/** The combustible service impl. */
	ICombustibleService combustibleServiceImpl = new CombustibleServiceImpl(); // para utilizar el método de seleccionar un combustible, ya que dentro del método de esta clase que crea un repostaje (en los contructores del RepostajeVehiculo, necesitamos recibir un combustible)
	
	
	
	/**
	 * Mostrar lista de repostajes vehiculos.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void mostrarListaDeRepostajesVehiculos() throws Exception {
		List<RepostajeVehiculo> listaRepostajesVehiculo = repostajeVehiculoQueryImpl.listarRepostajesVehiculo();
		
		for (RepostajeVehiculo repostajeVehiculo : listaRepostajesVehiculo) {
			System.out.println(repostajeVehiculo.toString());
		}
	}

	
	
	/**
	 * Mostrar un repostaje vehiculo.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void mostrarUnRepostajeVehiculo() throws Exception {
		System.out.println("\n\nListado de todos los repostajes de vehículos");
		System.out.println("------------------------------");
		mostrarListaDeRepostajesVehiculos();
		
		int repostajeVehiculo_id = Tools.capturaEntero_v3("\n\nIntroduzca un número para mostrar un repostaje de vehículo", 0, 99);
		RepostajeVehiculo repostajeVehiculo = repostajeVehiculoQueryImpl.buscarRepostajeVehiculoPorId(repostajeVehiculo_id);
		System.out.println(repostajeVehiculo.toString());
	}

	
	
	/**
	 * Calcular mostrar importe total combustible vendido.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void calcularMostrarImporteTotalCombustibleVendido() throws Exception {
		List<RepostajeVehiculo> listaRepostajesVehiculo = repostajeVehiculoQueryImpl.listarRepostajesVehiculo();
		double importeTotalCombustibleVendido = 0;
		
		for (RepostajeVehiculo repostajeVehiculo : listaRepostajesVehiculo) {
			importeTotalCombustibleVendido += repostajeVehiculo.getRepostajeVehiculo_importeTotal();
		}
		
		System.out.println("\n\nEl importe total del combustible vendido en repostajes de vehículos es de:\t" + String.format("%.2f", importeTotalCombustibleVendido));	// https://www.baeldung.com/java-number-formatting
	}

	
	
	/**
	 * Seleccionar un repostaje vehiculo.
	 *
	 * @return the repostaje vehiculo
	 * @throws Exception the exception
	 */
	@Override
	public RepostajeVehiculo seleccionarUnRepostajeVehiculo() throws Exception {
		System.out.println("\n\nListado de todos los repostajes de vehículos");
		System.out.println("------------------------------");
		mostrarListaDeRepostajesVehiculos();
		
		int repostajeVehiculo_id = Tools.capturaEntero_v3("\n\nIntroduzca un número para seleccionar un repostaje de vehículo", 0, 99);
		RepostajeVehiculo repostajeVehiculo = repostajeVehiculoQueryImpl.buscarRepostajeVehiculoPorId(repostajeVehiculo_id);
		
		return repostajeVehiculo;
	}

	
	
	/**
	 * Crear un nuevo repostaje vehiculo con ticket.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void crearUnNuevoRepostajeVehiculo_conTicket() throws Exception {
		System.out.print("\n\nIntroduzca la cantidad de litros que desea repostar:\t");
		double repostajeVehiculo_litros = scanner.nextDouble();
		
		System.out.print("\n\nSeleccione el combustible con el que desea repostar");
		Combustible combustible = combustibleServiceImpl.seleccionarUnCombustible();
		
		repostajeVehiculoQueryImpl.insertarRepostajeVehiculo(new RepostajeVehiculo(repostajeVehiculo_litros, combustible));
		System.out.println("\n\nEl nuevo repostaje con ticket se ha registrado correctamente");
		System.out.println("\nNo olvide coger su ticket, y de realizar el repostaje!");
	}

	
	
	/**
	 * Crear un nuevo repostaje vehiculo con factura.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void crearUnNuevoRepostajeVehiculo_conFactura() throws Exception {
		System.out.print("\n\nIntroduzca su DNI:\t");
		String repostajeVehiculo_dni = scanner.next();
		
		System.out.print("\n\nIntroduzca su matrícula:\t");
		String repostajeVehiculo_matricula = scanner.next();
		
		System.out.print("\n\nIntroduzca la cantidad de litros que desea repostar:\t");
		double repostajeVehiculo_litros = scanner.nextDouble();
		
		System.out.print("\n\nSeleccione el combustible con el que desea repostar");
		Combustible combustible = combustibleServiceImpl.seleccionarUnCombustible();
		
		repostajeVehiculoQueryImpl.insertarRepostajeVehiculo(new RepostajeVehiculo(repostajeVehiculo_dni, repostajeVehiculo_matricula, repostajeVehiculo_litros, combustible));
		System.out.println("\n\nEl nuevo repostaje con factura se ha registrado correctamente");
		System.out.println("\nNo olvide coger su factura, y de realizar el repostaje!");
	}
	
}
