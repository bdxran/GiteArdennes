package be.gite.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Publiques")
public class Publiques {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPublique", unique = true, updatable = false, nullable = false)
	private Integer idPublique;

	@ManyToOne
	@JoinColumn(name = "idVille", updatable = true, nullable = false)
	private Villes idVille;

	@Column(name = "nom", updatable = false, nullable = false)
	private String nom;
	@Column(name = "prenom", updatable = false, nullable = false)
	private String prenom;
	@Column(name = "mdp", updatable = true, nullable = false)
	private String mdp;
	@Column(name = "adresse1", updatable = true, nullable = false)
	private String adresse1;
	@Column(name = "adresse2", updatable = true, nullable = false)
	private String adresse2;
	@Column(name = "adresse3", updatable = true, nullable = false)
	private String adresse3;
	@Column(name = "telephone", updatable = true, nullable = false)
	private String telephone;
	@Column(name = "email", unique = true, updatable = true, nullable = false)
	private String email;
	@Column(name = "numCompte", unique = true, updatable = true, nullable = false)
	private String numCompte;
	@Column(name = "blacklist", updatable = true, nullable = false)
	private boolean blacklist;
	
	@OneToMany(mappedBy = "idPublique")
	private Set<Publiques> publique = new HashSet<>();

	public Publiques() {
		super();
	}

	public Integer getIdPublique() {
		return idPublique;
	}

	public void setIdPublique(Integer idPublique) {
		this.idPublique = idPublique;
	}

	public Villes getIdVille() {
		return idVille;
	}

	public void setIdVille(Villes idVille) {
		this.idVille = idVille;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}

	public boolean isBlacklist() {
		return blacklist;
	}

	public void setBlacklist(boolean blacklist) {
		this.blacklist = blacklist;
	}

	@Override
	public String toString() {
		return "Publiques [idPublique=" + idPublique + ", idVille=" + idVille + ", nom=" + nom + ", prenom=" + prenom
				+ ", mdp=" + mdp + ", adresse1=" + adresse1 + ", adresse2=" + adresse2 + ", adresse3=" + adresse3
				+ ", telephone=" + telephone + ", email=" + email + ", numCompte=" + numCompte + ", blacklist="
				+ blacklist + "]";
	}

}
