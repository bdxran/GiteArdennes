package be.gite.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Gites")
public class Gites {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idGite", unique = true, updatable = false, nullable = false)
	private Integer idGite; // Primary Key

	@ManyToOne
	@JoinColumn(name = "idAdmin", updatable = true, nullable = false)
	private Admins idAdmin;

	@Column(name = "nom", unique = true, updatable = true, nullable = false)
	private String nom;
	@Column(name = "adresse1", updatable = true, nullable = false)
	private String adresse1;
	@Column(name = "adresse2", updatable = true, nullable = false)
	private String adresse2;
	@Column(name = "description", updatable = true, nullable = false)
	private String description;

	@OneToMany(mappedBy = "idGite")
	private Set<Gites> gite = new HashSet<>();

	public Gites() {
		super();
	}

	public Integer getIdGite() {
		return idGite;
	}

	public void setIdGite(Integer idGite) {
		this.idGite = idGite;
	}

	public Admins getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Admins idAdmin) {
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
		return "Gites [idGite=" + idGite + ", idAdmin=" + idAdmin + ", nom=" + nom + ", adresse1=" + adresse1
				+ ", adresse2=" + adresse2 + ", description=" + description + "]";
	}

}
