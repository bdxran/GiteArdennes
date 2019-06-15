package be.gite.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Saisons")
public class Saisons {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSaison", unique = true, updatable = false, nullable = false)
	private Integer idSaison;

	@ManyToOne
	@JoinColumn(name = "idGite", updatable = true, nullable = false)
	private Gites idGite;

	@Column(name = "dateDebut", updatable = true, nullable = false)
	private Date dateDebut;
	@Column(name = "dateFin", updatable = true, nullable = false)
	private Date dateFin;
	@Column(name = "nom", updatable = true, nullable = false)
	private String nom;
	@Column(name = "tarif", updatable = true, nullable = false)
	private Float tarif;

	public Integer getIdSaison() {
		return idSaison;
	}

	public void setIdSaison(Integer idSaison) {
		this.idSaison = idSaison;
	}

	public Gites getIdGite() {
		return idGite;
	}

	public void setIdGite(Gites idGite) {
		this.idGite = idGite;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Float getTarif() {
		return tarif;
	}

	public void setTarif(Float tarif) {
		this.tarif = tarif;
	}

	@Override
	public String toString() {
		return "Saisons [idSaison=" + idSaison + ", idGite=" + idGite + ", dateDebut=" + dateDebut + ", dateFin="
				+ dateFin + ", nom=" + nom + ", tarif=" + tarif + "]";
	}

}
