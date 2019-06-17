package be.gite.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Logs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idLog", updatable = false, nullable = false)
	private Integer idLog;

	@Column(name = "nomClient", updatable = false, nullable = false)
	private String nomClient;
	@Column(name = "prenom", updatable = false, nullable = false)
	private String prenom;
	@Column(name = "adresse1", updatable = false, nullable = false)
	private String adresse1;
	@Column(name = "adresse2", updatable = false, nullable = false)
	private String adresse2;
	@Column(name = "adresse3", updatable = false, nullable = false)
	private String adresse3;
	@Column(name = "numCompte", updatable = false, nullable = false)
	private String numCompte;
	@Column(name = "nomGite", updatable = false, nullable = false)
	private String nomGite;
	@Column(name = "dateDebut", updatable = false, nullable = false)
	private Date dateDebut;
	@Column(name = "dateFin", updatable = false, nullable = false)
	private Date dateFin;
	@Column(name = "communication", updatable = false, nullable = false)
	private String communication;
	@Column(name = "total", updatable = false, nullable = false)
	private Float total;
	@Column(name = "dateLog", updatable = false, nullable = false)
	private Date dateLog;

	public Logs() {
		super();
	}

	public Integer getIdLog() {
		return idLog;
	}

	public void setIdLog(Integer idLog) {
		this.idLog = idLog;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse1() {
		return adresse1;
	}

	public void setAdresse1(String adresse1) {
		this.adresse1 = adresse1;
	}

	public String getAdresse2() {
		return adresse2;
	}

	public void setAdresse2(String adresse2) {
		this.adresse2 = adresse2;
	}

	public String getAdresse3() {
		return adresse3;
	}

	public void setAdresse3(String adresse3) {
		this.adresse3 = adresse3;
	}

	public String getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}

	public String getNomGite() {
		return nomGite;
	}

	public void setNomGite(String nomGite) {
		this.nomGite = nomGite;
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

	public String getCommunication() {
		return communication;
	}

	public void setCommunication(String communication) {
		this.communication = communication;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Logs [idLog=" + idLog + ", nomClient=" + nomClient + ", prenom=" + prenom + ", adresse1=" + adresse1
				+ ", adresse2=" + adresse2 + ", adresse3=" + adresse3 + ", numCompte=" + numCompte + ", nomGite="
				+ nomGite + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", communication=" + communication
				+ ", total=" + total + "]";
	}

}
