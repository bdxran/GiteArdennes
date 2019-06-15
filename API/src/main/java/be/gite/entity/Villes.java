package be.gite.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Villes")
public class Villes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idVille", unique = true, updatable = false, nullable = false)
	private Integer idVille;

	@ManyToOne
	@JoinColumn(name = "code", updatable = false, nullable = false)
	private Pays code;

	@Column(name = "codePostal", unique = true, updatable = true, nullable = false)
	private Integer codePostal;
	@Column(name = "nom", unique = true, updatable = true, nullable = false)
	private String nom;

	@OneToMany(mappedBy = "idVille")
	private Set<Villes> ville = new HashSet<>();

	public Villes() {
		super();
	}

	public Integer getIdVille() {
		return idVille;
	}

	public void setIdVille(Integer idVille) {
		this.idVille = idVille;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public Pays getCode() {
		return code;
	}

	public void setCode(Pays code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Villes [idVille=" + idVille + ", code=" + code + ", codePostal=" + codePostal + ", nom=" + nom
				+ "]";
	}

}
