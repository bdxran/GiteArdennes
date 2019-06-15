package be.gite.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Pays")
public class Pays {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code", unique = true, updatable = false, nullable = false)
	private Integer code;

	@Column(name = "nom", unique = true, updatable = false, nullable = false)
	private String nom;

	@OneToMany(mappedBy = "code")
	private Set<Pays> pays = new HashSet<>();

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
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
		return "Pays [code=" + code + ", nom=" + nom + "]";
	}
}
