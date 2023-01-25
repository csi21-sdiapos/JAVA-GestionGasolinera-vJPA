package com.GestionGasolinera.services;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.GestionGasolinera.entities.Combustible;
import com.GestionGasolinera.entities.RepostajeGasolinera;
import com.GestionGasolinera.queries.IRepostajeGasolineraQuery;
import com.GestionGasolinera.queries.RepostajeGasolineraQueryImpl;
import com.GestionGasolinera.tools.Tools;


@Service("RepostajeGasolineraServiceImpl")
public class RepostajeGasolineraServiceImpl implements IRepostajeGasolineraService {

	
	/** The scanner. */
	public static Scanner scanner = new Scanner(System.in);

	/** The repostaje gasolinera query impl. */
	IRepostajeGasolineraQuery repostajeGasolineraQueryImpl = new RepostajeGasolineraQueryImpl();
	
	/** The combustible service impl. */
	ICombustibleService combustibleServiceImpl = new CombustibleServiceImpl(); // para utilizar el método de seleccionar un combustible, ya que dentro del método de esta clase que crea un repostaje (en los contructores del RepostajeGasolinera, necesitamos recibir un combustible)

	
	
	@Override
	public void mostrarListaDeRepostajesGasolinera() throws Exception {
		List<RepostajeGasolinera> listaRepostajesGasolinera = repostajeGasolineraQueryImpl.listarRepostajesGasolinera();
		
		for (RepostajeGasolinera repostajeGasolinera : listaRepostajesGasolinera) {
			System.out.println(repostajeGasolinera.toString());
		}
	}

	
	
	@Override
	public void mostrarUnRepostajeGasolinera() throws Exception {
		System.out.println("\n\nListado de todos los repostajes de gasolinera");
		System.out.println("------------------------------");
		mostrarListaDeRepostajesGasolinera();
		
		int repostajeGasolinera_id = Tools.capturaEntero_v3("\n\nIntroduzca un número para mostrar un repostaje de gasolinera", 0, 99);
		RepostajeGasolinera repostajeGasolinera = repostajeGasolineraQueryImpl.buscarRepostajeGasolineraPorId(repostajeGasolinera_id);
		System.out.println(repostajeGasolinera.toString());
	}

	
	
	@Override
	public RepostajeGasolinera seleccionarUnRepostajeGasolinera() throws Exception {
		System.out.println("\n\nListado de todos los repostajes de gasolinera");
		System.out.println("------------------------------");
		mostrarListaDeRepostajesGasolinera();
		
		int repostajeGasolinera_id = Tools.capturaEntero_v3("\n\nIntroduzca un número para seleccionar un repostaje de gasolinera", 0, 99);
		RepostajeGasolinera repostajeGasolinera = repostajeGasolineraQueryImpl.buscarRepostajeGasolineraPorId(repostajeGasolinera_id);
		
		return repostajeGasolinera;
	}

	
	
	@Override
	public void crearUnNuevoRepostajeGasolinera_conTicket() throws Exception {
		System.out.print("\n\nIntroduzca la cantidad de litros para rellenar el tanque de la gasolinera:\t");
		double repostajeGasolinera_litros = scanner.nextDouble();
		
		System.out.print("\n\nSeleccione el combustible con el que va a rrelenar el tanque");
		Combustible combustible = combustibleServiceImpl.seleccionarUnCombustible();
		
		repostajeGasolineraQueryImpl.insertarRepostajeGasolinera(new RepostajeGasolinera(repostajeGasolinera_litros, combustible));
		System.out.println("\n\nEl nuevo llenado del tanque con ticket se ha registrado correctamente");
		System.out.println("\nNo olvide coger su ticket, y de rellenar el tanque!");
	}

	
	
	@Override
	public void crearUnNuevoRepostajeGasolinera_conFactura() throws Exception {
		System.out.print("\n\nIntroduzca su DNI:\t");
		String repostajeGasolinera_dni = scanner.next();
		
		System.out.print("\n\nIntroduzca su matrícula:\t");
		String repostajeGasolinera_matricula = scanner.next();
		
		System.out.print("\n\nIntroduzca la cantidad de litros que va a rellenar:\t");
		double repostajeGasolinera_litros = scanner.nextDouble();
		
		System.out.print("\n\nSeleccione el combustible con el que va a rellenar el tanque");
		Combustible combustible = combustibleServiceImpl.seleccionarUnCombustible();
		
		repostajeGasolineraQueryImpl.insertarRepostajeGasolinera(new RepostajeGasolinera(repostajeGasolinera_dni, repostajeGasolinera_matricula, repostajeGasolinera_litros, combustible));
		System.out.println("\n\nEl nuevo llenado del tanque con factura se ha registrado correctamente");
		System.out.println("\nNo olvide coger su factura, y de rellenar el tanque!");
	}

	
	
	/**
	 * Eliminar el ultimo repostaje gasolinera.
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void eliminarElUltimoRepostajeGasolinera() throws Exception {
		List<RepostajeGasolinera> listaRepostajesGasolinera = repostajeGasolineraQueryImpl.listarRepostajesGasolinera();
		RepostajeGasolinera repostajeGasolinera = listaRepostajesGasolinera.get(listaRepostajesGasolinera.size() - 1);

		repostajeGasolineraQueryImpl.eliminarUltimoRepostajeGasolinera(repostajeGasolinera);
	}

}