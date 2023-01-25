package com.GestionGasolinera.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GestionGasolinera.entities.RepostajeGasolinera;
import com.GestionGasolinera.repositories.IRepostajeGasolineraRepository;
import com.GestionGasolinera.repositories.RepostajeGasolineraRepositoryImpl;


@Service("RepostajeGasolineraQueryImpl")
public class RepostajeGasolineraQueryImpl implements IRepostajeGasolineraQuery {

	
	/** The repostaje gasolinera repository impl. */
	@Autowired
	IRepostajeGasolineraRepository repostajeGasolineraRepositoryImpl = new RepostajeGasolineraRepositoryImpl();

	
	
	/**
	 * Listar repostajes gasolinera.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public List<RepostajeGasolinera> listarRepostajesGasolinera() throws Exception {
		try {
			return repostajeGasolineraRepositoryImpl.listRepostajeGasolinera();
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al listar los llenados de gasolinera (return null): " + e);
			return null;
		}
	}

	
	
	/**
	 * Buscar repostaje gasolinera por id.
	 *
	 * @param repostajeGasolinera_id the repostaje gasolinera id
	 * @return the repostaje gasolinera
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public RepostajeGasolinera buscarRepostajeGasolineraPorId(long repostajeGasolinera_id) throws Exception {
		try {
			return repostajeGasolineraRepositoryImpl.findByIdRepostajeGasolinera(repostajeGasolinera_id);
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al buscar el llenado de gasolinera (return null): " + e);
			return null;
		}
	}

	
	
	/**
	 * Insertar repostaje gasolinera.
	 *
	 * @param repostajeGasolinera the repostaje gasolinera
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	@Transactional
	@Override
	public boolean insertarRepostajeGasolinera(RepostajeGasolinera repostajeGasolinera) throws Exception {
		try {
			repostajeGasolineraRepositoryImpl.insertRepostajeGasolinera(repostajeGasolinera);
			return true;
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al insertar el nuevo llenado de gasolinera: " + e);
			return false;
		}
	}



	/**
	 * Eliminar ultimo repostaje gasolinera.
	 *
	 * @param repostajeGasolinera the repostaje gasolinera
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	@Override
	public boolean eliminarUltimoRepostajeGasolinera(RepostajeGasolinera repostajeGasolinera) throws Exception {
		try {
			repostajeGasolineraRepositoryImpl.deleteLastRepostajeGasolinera(repostajeGasolinera);
			return true;
		} catch (Exception e) {
			System.out.println("[ERROR] - Error al eliminar el último llenado del tanque: " + e);
			return false;
		}
	}
	
}
