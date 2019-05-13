package be.gite.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import be.gite.tool.PasswordTool;

@Entity
@Table(name="Admins")
public class Admins {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idAdmin")
	private Integer idAdmin;
	
	@OneToMany(mappedBy = "idAdmin")
	private Set<Gites> gite = new HashSet<>();
	
	@Column(name="login")
	private String login;
	@Column(name="mdp")
	private String mdp;
	
	public Admins() {
		this.idAdmin = 0;
		this.login = "";
		this.mdp = "";
	}
	
	public Admins(String login, String mdp) {
		this.idAdmin = 0;
		this.login = login;
		this.mdp = mdp;
	}
	
	public Integer getIdAdmin() {
		return idAdmin;
	}
	
	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getMdp() {
		return mdp;
	}
	
	public void setMdp(String mdp) {
		PasswordTool pwd = new PasswordTool();
		this.mdp = pwd.encodePassword(mdp);
	}

	@Override
	public String toString() {
		return "Admins [idAdmin=" + idAdmin + ", login=" + login + ", mdp=" + mdp + "]";
	}
}
