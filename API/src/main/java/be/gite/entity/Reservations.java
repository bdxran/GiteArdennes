package be.gite.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Reservations")
public class Reservations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idReservation", unique = true, updatable = false, nullable = false)
	private Integer idReservation;

	@ManyToOne
	@JoinColumn(name = "idAdmin", updatable = false, nullable = true)
	private Admins idAdmin;
	@ManyToOne
	@JoinColumn(name = "idPublique", updatable = false, nullable = true)
	private Publiques idPublique;
	@ManyToOne
	@JoinColumn(name = "idGite", updatable = false, nullable = false)
	private Gites idGite;

	@Column(name = "dateDebut", updatable = true, nullable = false)
	private Date dateDebut;
	@Column(name = "dateFin", updatable = true, nullable = false)
	private Date dateFin;
	@Column(name = "total", updatable = true, nullable = false)
	private Float total;
	@Column(name = "communication", updatable = false, nullable = false)
	private String communication;
	@Column(name = "statut", updatable = true, nullable = false)
	private String statut;

	public Reservations() {
		super();
	}

	public Integer getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}

	public Admins getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Admins idAdmin) {
		this.idAdmin = idAdmin;
	}

	public Publiques getIdPublique() {
		return idPublique;
	}

	public void setIdPublique(Publiques idPublique) {
		this.idPublique = idPublique;
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

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public String getCommunication() {
		return communication;
	}

	public void setCommunication(String communication) {
		this.communication = communication;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "Reservations [idReservation=" + idReservation + ", idAdmin=" + idAdmin + ", idPublique=" + idPublique
				+ ", idGite=" + idGite + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", total=" + total
				+ ", statut=" + statut + "]";
	}
}
