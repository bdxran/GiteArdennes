package be.gite.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Logs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idLog", updatable = false, nullable = false)
	private Integer idLog;
	@Column(name = "idAdmin", updatable = false, nullable = true)
	private Integer idAdmin;
	@Column(name = "idPublique", updatable = false, nullable = true)
	private Integer idPublique;
	@Column(name = "idGite", updatable = false, nullable = false)
	private Integer idGite;
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
	@Column(name = "operation", updatable = false, nullable = false)
	private String operation;

	public Logs() {
		super();
	}

	public Integer getIdLog() {
		return idLog;
	}

	public void setIdLog(Integer idLog) {
		this.idLog = idLog;
	}

	public Integer getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}

	public Integer getIdPublique() {
		return idPublique;
	}

	public void setIdPublique(Integer idPublique) {
		this.idPublique = idPublique;
	}

	public Integer getIdGite() {
		return idGite;
	}

	public void setIdGite(Integer idGite) {
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

	public Date getDateLog() {
		return dateLog;
	}

	public void setDateLog(Date dateLog) {
		this.dateLog = dateLog;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "Logs [idLog=" + idLog + ", idAdmin=" + idAdmin + ", idPublique=" + idPublique + ", idGite=" + idGite
				+ ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", communication=" + communication + ", total="
				+ total + ", dateLog=" + dateLog + ", operation=" + operation + "]";
	}
	
}