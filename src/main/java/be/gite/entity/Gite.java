package be.gite.entity;

import javax.persistence.*;

@Entity
public class Gite {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idGite;
	private Integer idAdmin;
	private String nom;
	private String adresse1;
	private String adresse2;
	private String description;
	
	public Gite() {
		this.idGite = 0;
		this.idAdmin = 0;
		this.nom = "";
		this.adresse1 = "";
		this.adresse2 = "";
		this.description = "";
	}
	
	public Gite(String nom, String adresse1, String adresse2, String description) {
		this.idGite = 0;
		this.idAdmin = 0;
		this.nom = nom;
		this.adresse1 = adresse1;
		this.adresse2 = adresse2;
		this.description = description;
	}
	
	public Integer getIdGite() {
		return idGite;
	}
	
	public void setIdGite(Integer idGite) {
		this.idGite = idGite;
	}
	
	public Integer getIdAdmin() {
		return idAdmin;
	}
	
	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Gite [idGite=" + idGite + ", idAdmin=" + idAdmin + ", nom=" + nom + ", adresse1=" + adresse1
				+ ", adresse2=" + adresse2 + ", description=" + description + "]";
	}
	
}
