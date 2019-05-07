package be.gite.entity;

import javax.persistence.*;

@Entity
@Table(name="Gites")
public class Gites {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idGite", nullable=false)
	private Integer idGite;
	
	@Column(name="idAdmin", nullable=false)
	private Integer idAdmin;
	@Column(name="nom", nullable=false)
	private String nom;
	@Column(name="adresse1", nullable=false)
	private String adresse1;
	@Column(name="adresse2", nullable=false)
	private String adresse2;
	@Column(name="description", nullable=false)
	private String description;
	
	public Gites() {
		super();
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
