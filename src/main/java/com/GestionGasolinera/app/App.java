package com.GestionGasolinera.app;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;

import com.GestionGasolinera.services.CombustibleServiceImpl;
import com.GestionGasolinera.services.ICombustibleService;
import com.GestionGasolinera.services.IRepostajeGasolineraService;
import com.GestionGasolinera.services.IRepostajeVehiculoService;
import com.GestionGasolinera.services.RepostajeGasolineraServiceImpl;
import com.GestionGasolinera.services.RepostajeVehiculoServiceImpl;
import com.GestionGasolinera.tools.Tools;


@Controller("App")
public class App {
	
	// Create an EntityManagerFactory when you start the application
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionGasolinera");
    
	public static void main(String[] args) throws Exception {
		
		// para las primeras ejecuciones de mi proyecto, necesitaba crear la bbdd e insertar primero los tres combustibles del enunciado, después cambiaré la propiedad de hibernate de autogeneración de las tablas de create a update
		ICombustibleService combustibleService = new CombustibleServiceImpl();
		combustibleService.crearUnNuevoCombustible();	// creamos el combustible Gasoil     con un precio de 1,63
		combustibleService.crearUnNuevoCombustible();	// creamos el combustible Gasolina95 con un precio de 1,70
		combustibleService.crearUnNuevoCombustible();	// creamos el combustible Gasolina98 con un precio de 1,75
		combustibleService.mostrarListaDeCombustibles();	// mostramos los tres combustibles que hemos creado
		
		Scanner scanner = new Scanner(System.in);
		IRepostajeVehiculoService 	repostajeVehiculoService   = new RepostajeVehiculoServiceImpl();
		IRepostajeGasolineraService repostajeGasolineraService = new RepostajeGasolineraServiceImpl();
		
		int opcion = 0;
		
		do {
			opcion = Tools.showMenuAndSelectOption();
			
			switch (opcion) {
				case 0:
					System.out.println("\n\n\tHa elegido la opción 0 de salir.");
					break;
				
				case 1:
					repostajeVehiculoService.crearUnNuevoRepostajeVehiculo_conTicket();
					break;
					
				case 2:
					repostajeVehiculoService.crearUnNuevoRepostajeVehiculo_conFactura();
					break;
					
				case 3:
					repostajeVehiculoService.mostrarListaDeRepostajesVehiculos();
					break;
					
				case 4:
					repostajeVehiculoService.calcularMostrarImporteTotalCombustibleVendido();
					break;
					
				case 5:
					repostajeGasolineraService.crearUnNuevoRepostajeGasolinera_conFactura();
					break;
					
				case 6:
					repostajeGasolineraService.eliminarElUltimoRepostajeGasolinera();
					break;
					
				case 7:
					repostajeGasolineraService.mostrarListaDeRepostajesGasolinera();
					break;
			}
			
		} while (opcion != 0);
		
		Tools.pararPrograma();
		
		scanner.close();
		entityManagerFactory.close();
	}

}