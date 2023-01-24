package com.GestionGasolinera.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GestionGasolinera.entities.RepostajeVehiculo;
import com.GestionGasolinera.repositories.IRepostajeVehiculoRepository;
import com.GestionGasolinera.repositories.RepostajeVehiculoRepositoryImpl;


@Service("RepostajeVehiculoQueryImpl")
public class RepostajeVehiculoQueryImpl implements IRepostajeVehiculoQuery {

	
	/** The repostaje vehiculo repository impl. */
	@Autowired
	IRepostajeVehiculoRepository repostajeVehiculoRepositoryImpl = new RepostajeVehiculoRepositoryImpl();

	
	
	/**
	 * Listar repostajes vehiculo.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public List<RepostajeVehiculo> listarRepostajesVehiculo() throws Exception {
		try {
			return repostajeVehiculoRepositoryImpl.listRepostajeVehiculo();
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al listar los repostajes de vehículos (return null): " + e);
			return null;
		}
	}

	
	
	/**
	 * Buscar repostaje vehiculo por id.
	 *
	 * @param repostajeVehiculo_id the repostaje vehiculo id
	 * @return the repostaje vehiculo
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public RepostajeVehiculo buscarRepostajeVehiculoPorId(long repostajeVehiculo_id) throws Exception {
		try {
			return repostajeVehiculoRepositoryImpl.findByIdRepostajeVehiculo(repostajeVehiculo_id);
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al buscar el repostaje de vehículo (return null): " + e);
			return null;
		}
	}

	
	
	/**
	 * Insertar repostaje vehiculo.
	 *
	 * @param repostajeVehiculo the repostaje vehiculo
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public boolean insertarRepostajeVehiculo(RepostajeVehiculo repostajeVehiculo) throws Exception {
		try {
			repostajeVehiculoRepositoryImpl.insertRepostajeVehiculo(repostajeVehiculo);
			return true;
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al insertar el nuevo repostaje de vehículo: " + e);
			return false;
		}
	}
	
}
