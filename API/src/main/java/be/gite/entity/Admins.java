package be.gite.entity;

import javax.persistence.*;
import be.gite.tool.PasswordTool;

@Entity
@Table(name = "Admins")
public class Admins {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAdmin", unique = true, updatable = false, nullable = false)
	private Integer idAdmin;
	@Column(name = "login", unique = true, updatable = false, nullable = false)
	private String login;
	@Column(name = "mdp", updatable = true, nullable = false)
	private String mdp;

	public Admins() {
		super();
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
