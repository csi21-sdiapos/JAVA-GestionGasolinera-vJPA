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
@Table(name = "dwh_gg_repostaje_vehiculo", schema = "dwh_gestion_gasolinera")
public class RepostajeVehiculo implements Serializable {

	private static final long serialVersionUID = 1L;


	/******************************************* ATRIBUTOS *********************************************/
	@Column(name = "repostajeVehiculo_uuid", unique = false, nullable = false)
	private UUID repostajeVehiculo_uuid;
	
	@Id
	@Column(name = "repostajeVehiculo_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long repostajeVehiculo_id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "repostajeVehiculo_date", unique = false, nullable = false)
	private Calendar repostajeVehiculo_date;
	
	@Column(name = "repostajeVehiculo_dni", unique = false, nullable = true)
	private String repostajeVehiculo_dni;
	
	@Column(name = "repostajeVehiculo_matricula", unique = false, nullable = true)
	private String repostajeVehiculo_matricula;
	
	@Column(name = "repostajeVehiculo_litros", unique = false, nullable = false)
	private double repostajeVehiculo_litros;

	@Column(name = "repostajeVehiculo_importeTotal", unique = false, nullable = false)
	private double repostajeVehiculo_importeTotal;
	
	/******************************************* RELACIONES *********************************************/
	@ManyToOne(optional = true, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)	
	// si se prefiere configurar como optional=false, después de asociar un combustible a un repostaje (en la creación del repostaje) no podremos después eliminar ese repostaje
	// si se prefiere configurar como carga perezosa (FetchType.LAZY), cuidado con incurrir en este error: https://www.baeldung.com/hibernate-initialize-proxy-exception	// // Caused by: org.postgresql.util.PSQLException: ERROR: update o delete en �dwh_gg_combustibles� viola la llave for�nea �fkadp52mjb688ijko6tnifl2nmr� en la tabla �dwh_gg_repostaje_gasolinera�:  Detail: La llave (combustible_id)=(3) todav�a es referida desde la tabla �dwh_gg_repostaje_gasolinera�.
	private Combustible combustible;
	
	
	/******************************************* CONSTRUCTORES *********************************************/
	// constructor lleno, el cual sería para la factura
	// sin el id, ni el uuid, ni la fecha-hora, porque son automáticos 
	// y sin el importe total, ya que éste se calcula con un método (litros * combustible.precio)
	public RepostajeVehiculo(String repostajeVehiculo_dni, String repostajeVehiculo_matricula, double repostajeVehiculo_litros, Combustible combustible) {
		super();
		this.repostajeVehiculo_uuid = Tools.generarUUID();
		this.repostajeVehiculo_date = Calendar.getInstance();
		this.repostajeVehiculo_dni = repostajeVehiculo_dni;
		this.repostajeVehiculo_matricula = repostajeVehiculo_matricula;
		this.repostajeVehiculo_litros = repostajeVehiculo_litros;
		this.combustible = combustible;
		this.repostajeVehiculo_importeTotal = calcularImporteTotal();
	}
	
	// este constructor sería para los tickets
	public RepostajeVehiculo(double repostajeVehiculo_litros, Combustible combustible) {
		super();
		this.repostajeVehiculo_uuid = Tools.generarUUID();
		this.repostajeVehiculo_date = Calendar.getInstance();
		this.repostajeVehiculo_litros = repostajeVehiculo_litros;
		this.combustible = combustible;
		this.repostajeVehiculo_importeTotal = calcularImporteTotal();
	}

	// constructor vacío
	public RepostajeVehiculo() {
		super();
	}


	/******************************************* GETTER Y SETTERS *********************************************/
	public UUID getRepostajeVehiculo_uuid() {
		return repostajeVehiculo_uuid;
	}

	public void setRepostajeVehiculo_uuid(UUID repostajeVehiculo_uuid) {
		this.repostajeVehiculo_uuid = repostajeVehiculo_uuid;
	}
	
	public long getRepostajeVehiculo_id() {
		return repostajeVehiculo_id;
	}

	public void setRepostajeVehiculo_id(long repostajeVehiculo_id) {
		this.repostajeVehiculo_id = repostajeVehiculo_id;
	}

	public Calendar getRepostajeVehiculo_date() {
		return repostajeVehiculo_date;
	}

	public void setRepostajeVehiculo_date(Calendar repostajeVehiculo_date) {
		this.repostajeVehiculo_date = repostajeVehiculo_date;
	}

	public String getRepostajeVehiculo_dni() {
		return repostajeVehiculo_dni;
	}

	public void setRepostajeVehiculo_dni(String repostajeVehiculo_dni) {
		this.repostajeVehiculo_dni = repostajeVehiculo_dni;
	}

	public String getRepostajeVehiculo_matricula() {
		return repostajeVehiculo_matricula;
	}

	public void setRepostajeVehiculo_matricula(String repostajeVehiculo_matricula) {
		this.repostajeVehiculo_matricula = repostajeVehiculo_matricula;
	}

	public double getRepostajeVehiculo_litros() {
		return repostajeVehiculo_litros;
	}

	public void setRepostajeVehiculo_litros(double repostajeVehiculo_litros) {
		this.repostajeVehiculo_litros = repostajeVehiculo_litros;
	}

	public double getRepostajeVehiculo_importeTotal() {
		return repostajeVehiculo_importeTotal;
	}

	public void setRepostajeVehiculo_importeTotal(double repostajeVehiculo_importeTotal) {
		this.repostajeVehiculo_importeTotal = repostajeVehiculo_importeTotal;
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
		return this.getRepostajeVehiculo_litros() * this.combustible.getCombustible_precio();
	}
	
	
	/******************************************* HashCode y Equals *********************************************/
	@Override
	public int hashCode() {
		return Objects.hash(combustible, repostajeVehiculo_date, repostajeVehiculo_dni, repostajeVehiculo_id,
				repostajeVehiculo_importeTotal, repostajeVehiculo_litros, repostajeVehiculo_matricula,
				repostajeVehiculo_uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RepostajeVehiculo other = (RepostajeVehiculo) obj;
		return Objects.equals(combustible, other.combustible)
				&& Objects.equals(repostajeVehiculo_date, other.repostajeVehiculo_date)
				&& Objects.equals(repostajeVehiculo_dni, other.repostajeVehiculo_dni)
				&& repostajeVehiculo_id == other.repostajeVehiculo_id
				&& Double.doubleToLongBits(repostajeVehiculo_importeTotal) == Double
						.doubleToLongBits(other.repostajeVehiculo_importeTotal)
				&& Double.doubleToLongBits(repostajeVehiculo_litros) == Double
						.doubleToLongBits(other.repostajeVehiculo_litros)
				&& Objects.equals(repostajeVehiculo_matricula, other.repostajeVehiculo_matricula)
				&& Objects.equals(repostajeVehiculo_uuid, other.repostajeVehiculo_uuid);
	}

			
	/******************************************* ToString *********************************************/
	@Override
	public String toString() {
		return "RepostajeVehiculo [" + 
					"repostajeVehiculo_uuid=" + repostajeVehiculo_uuid + 
					", repostajeVehiculo_id=" + repostajeVehiculo_id + 
					", repostajeVehiculo_date=" + repostajeVehiculo_date.getTime() + 
					", repostajeVehiculo_dni=" + repostajeVehiculo_dni + 
					", repostajeVehiculo_matricula=" + repostajeVehiculo_matricula + 
					", repostajeVehiculo_litros=" + repostajeVehiculo_litros + 
					", repostajeVehiculo_importeTotal=" + repostajeVehiculo_importeTotal + 
					", combustible=" + combustible
				+ "]";
	}

}