package com.GestionGasolinera.dtos;

import java.util.Calendar;
import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.GestionGasolinera.entities.Combustible;


@Component("RepostajeGasolineraDTO")
public class RepostajeGasolineraDTO {

	/******************************************* ATRIBUTOS *********************************************/
	private UUID repostajeGasolinera_uuid;
	private long repostajeGasolinera_id;
	private Calendar repostajeGasolinera_date;
	private String repostajeGasolinera_dni;
	private String repostajeGasolinera_matricula;
	private double repostajeGasolinera_litros;
	private double repostajeGasolinera_importeTotal;
	
	/******************************************* RELACIONES *********************************************/
	private Combustible combustible;

		
	/******************************************* CONSTRUCTORES *********************************************/
	// constructor factura
	public RepostajeGasolineraDTO(String repostajeGasolinera_dni, String repostajeGasolinera_matricula, double repostajeGasolinera_litros, Combustible combustible) {
		super();
		this.repostajeGasolinera_dni = repostajeGasolinera_dni;
		this.repostajeGasolinera_matricula = repostajeGasolinera_matricula;
		this.repostajeGasolinera_litros = repostajeGasolinera_litros;
		this.combustible = combustible;
	}
	
	// constructor ticket
	public RepostajeGasolineraDTO(double repostajeGasolinera_litros, Combustible combustible) {
		super();
		this.repostajeGasolinera_litros = repostajeGasolinera_litros;
		this.combustible = combustible;
	}

	
	public RepostajeGasolineraDTO() {
		super();
	}

	
	/******************************************* GETTER Y SETTERS *********************************************/
	public UUID getRepostajeGasolinera_uuid() {
		return repostajeGasolinera_uuid;
	}

	public void setRepostajeGasolinera_uuid(UUID repostajeGasolinera_uuid) {
		this.repostajeGasolinera_uuid = repostajeGasolinera_uuid;
	}

	public long getRepostajeGasolinera_id() {
		return repostajeGasolinera_id;
	}

	public void setRepostajeGasolinera_id(long repostajeGasolinera_id) {
		this.repostajeGasolinera_id = repostajeGasolinera_id;
	}

	public Calendar getRepostajeGasolinera_date() {
		return repostajeGasolinera_date;
	}

	public void setRepostajeGasolinera_date(Calendar repostajeGasolinera_date) {
		this.repostajeGasolinera_date = repostajeGasolinera_date;
	}

	public String getRepostajeGasolinera_dni() {
		return repostajeGasolinera_dni;
	}

	public void setRepostajeGasolinera_dni(String repostajeGasolinera_dni) {
		this.repostajeGasolinera_dni = repostajeGasolinera_dni;
	}

	public String getRepostajeGasolinera_matricula() {
		return repostajeGasolinera_matricula;
	}

	public void setRepostajeGasolinera_matricula(String repostajeGasolinera_matricula) {
		this.repostajeGasolinera_matricula = repostajeGasolinera_matricula;
	}

	public double getRepostajeGasolinera_litros() {
		return repostajeGasolinera_litros;
	}

	public void setRepostajeGasolinera_litros(double repostajeGasolinera_litros) {
		this.repostajeGasolinera_litros = repostajeGasolinera_litros;
	}

	public double getRepostajeGasolinera_importeTotal() {
		return repostajeGasolinera_importeTotal;
	}

	public void setRepostajeGasolinera_importeTotal(double repostajeGasolinera_importeTotal) {
		this.repostajeGasolinera_importeTotal = repostajeGasolinera_importeTotal;
	}

	public Combustible getCombustible() {
		return combustible;
	}

	public void setCombustible(Combustible combustible) {
		this.combustible = combustible;
	}
	

	/******************************************* MÉTODOS *********************************************/
	
	
	/******************************************* HashCode y Equals ***********************************/
	@Override
	public int hashCode() {
		return Objects.hash(combustible, repostajeGasolinera_date, repostajeGasolinera_dni, repostajeGasolinera_id,
				repostajeGasolinera_importeTotal, repostajeGasolinera_litros, repostajeGasolinera_matricula,
				repostajeGasolinera_uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RepostajeGasolineraDTO other = (RepostajeGasolineraDTO) obj;
		return Objects.equals(combustible, other.combustible)
				&& Objects.equals(repostajeGasolinera_date, other.repostajeGasolinera_date)
				&& Objects.equals(repostajeGasolinera_dni, other.repostajeGasolinera_dni)
				&& repostajeGasolinera_id == other.repostajeGasolinera_id
				&& Double.doubleToLongBits(repostajeGasolinera_importeTotal) == Double
						.doubleToLongBits(other.repostajeGasolinera_importeTotal)
				&& Double.doubleToLongBits(repostajeGasolinera_litros) == Double
						.doubleToLongBits(other.repostajeGasolinera_litros)
				&& Objects.equals(repostajeGasolinera_matricula, other.repostajeGasolinera_matricula)
				&& Objects.equals(repostajeGasolinera_uuid, other.repostajeGasolinera_uuid);
	}


	/******************************************* ToString *********************************************/
	@Override
	public String toString() {
		return "RepostajeGasolineraDTO ["
					+ "repostajeGasolinera_uuid=" + repostajeGasolinera_uuid + 
					", repostajeGasolinera_id=" + repostajeGasolinera_id + 
					", repostajeGasolinera_date=" + repostajeGasolinera_date + 
					", repostajeGasolinera_dni=" + repostajeGasolinera_dni + 
					", repostajeGasolinera_matricula=" + repostajeGasolinera_matricula + 
					", repostajeGasolinera_litros=" + repostajeGasolinera_litros + 
					", repostajeGasolinera_importeTotal=" + repostajeGasolinera_importeTotal + 
					", combustible=" + combustible + 
				"]";
	}
	
}