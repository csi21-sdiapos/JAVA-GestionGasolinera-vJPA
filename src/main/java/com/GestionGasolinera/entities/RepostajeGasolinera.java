package com.GestionGasolinera.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.GestionGasolinera.tools.Tools;


@Entity
@Table(name = "dwh_gg_repostaje_gasolinera", schema = "dwh_gestion_gasolinera")
public class RepostajeGasolinera implements Serializable {

	private static final long serialVersionUID = 1L;


	/******************************************* ATRIBUTOS *********************************************/
	@Column(name = "repostajeGasolinera_uuid", unique = false, nullable = false)
	private UUID repostajeGasolinera_uuid;
	
	@Id
	@Column(name = "repostajeGasolinera_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long repostajeGasolinera_id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "repostajeGasolinera_date", unique = false, nullable = false)
	private Calendar repostajeGasolinera_date;
	
	@Column(name = "repostajeGasolinera_dni", unique = false, nullable = true)
	private String repostajeGasolinera_dni;
	
	@Column(name = "repostajeGasolinera_matricula", unique = false, nullable = true)
	private String repostajeGasolinera_matricula;
	
	@Column(name = "repostajeGasolinera_litros", unique = false, nullable = false)
	private double repostajeGasolinera_litros;

	@Column(name = "repostajeGasolinera_importeTotal", unique = false, nullable = false)
	private double repostajeGasolinera_importeTotal;

	
	/******************************************* RELACIONES *********************************************/
	@ManyToOne(optional = true, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)	
	// si se prefiere configurar como optional=false, después de asociar un combustible a un repostaje (en la creación del repostaje) no podremos después eliminar ese repostaje
	// si se prefiere configurar como carga perezosa (FetchType.LAZY), cuidado con incurrir en este error: https://www.baeldung.com/hibernate-initialize-proxy-exception
	private Combustible combustible;
	
	/******************************************* CONSTRUCTORES *********************************************/
	// constructor lleno, el cual sería para la factura
	// sin el id, ni el uuid, ni la fecha-hora, porque son automáticos
	// y sin el importe total, ya que éste se calcula con un método (litros * combustible.precio)
	public RepostajeGasolinera(String repostajeGasolinera_dni, String repostajeGasolinera_matricula, double repostajeGasolinera_litros, Combustible combustible) {
		super();
		this.repostajeGasolinera_uuid = Tools.generarUUID();
		this.repostajeGasolinera_date = Calendar.getInstance();
		this.repostajeGasolinera_dni = repostajeGasolinera_dni;
		this.repostajeGasolinera_matricula = repostajeGasolinera_matricula;
		this.repostajeGasolinera_litros = repostajeGasolinera_litros;
		this.combustible = combustible;
		this.repostajeGasolinera_importeTotal = calcularImporteTotal();
	}
	
	// este constructor sería para los tickets
	public RepostajeGasolinera(double repostajeGasolinera_litros, Combustible combustible) {
		super();
		this.repostajeGasolinera_uuid = Tools.generarUUID();
		this.repostajeGasolinera_date = Calendar.getInstance();
		this.repostajeGasolinera_litros = repostajeGasolinera_litros;
		this.combustible = combustible;
		this.repostajeGasolinera_importeTotal = calcularImporteTotal();
	}

	// constructor vacío
	public RepostajeGasolinera() {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	/******************************************* MÉTODOS *********************************************/
	public double calcularImporteTotal() {
		return this.getRepostajeGasolinera_litros() * this.combustible.getCombustible_precio();
	}
	
	
	/******************************************* HashCode y Equals *********************************************/
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
		RepostajeGasolinera other = (RepostajeGasolinera) obj;
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
		return "RepostajeGasolinera [" + 
					"repostajeGasolinera_uuid=" + repostajeGasolinera_uuid + 
					", repostajeGasolinera_id=" + repostajeGasolinera_id + 
					", repostajeGasolinera_date=" + repostajeGasolinera_date.getTime() + 
					", repostajeGasolinera_dni=" + repostajeGasolinera_dni + 
					", repostajeGasolinera_matricula=" + repostajeGasolinera_matricula + 
					", repostajeGasolinera_litros=" + repostajeGasolinera_litros + 
					", repostajeGasolinera_importeTotal=" + repostajeGasolinera_importeTotal + 
					", combustible=" + combustible 
				+ "]";
	}
	
}