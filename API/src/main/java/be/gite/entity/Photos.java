package be.gite.entity;

import javax.persistence.*;

@Entity
@Table(name="Photos")
public class Photos {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idPhoto")
	private Integer idPhoto;
	
	@ManyToOne
	@JoinColumn(name="idGite")
	private Gites idGite;
	
	@Column(name="lien", nullable=false)
	private String lien;
	
	public Photos() {
		super();
	}

	public Integer getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(Integer idPhoto) {
		this.idPhoto = idPhoto;
	}

	public Gites getIdGite() {
		return idGite;
	}

	public void setIdGite(Gites idGite) {
		this.idGite = idGite;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	@Override
	public String toString() {
		return "Photos [idPhoto=" + idPhoto + ", idGite=" + idGite + ", lien=" + lien + "]";
	}
	
}
