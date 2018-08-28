package be.atc.modeldb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the localite database table.
 * 
 */
@Entity
@NamedQueries( { 
@NamedQuery(name="Localite.findAll", query="SELECT l FROM Localite l"),
@NamedQuery(name="Localite.findByID", query="SELECT l FROM Localite l WHERE l.idLocalite = :idLocalite")
})
public class Localite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_localite")
	private int idLocalite;

	@Column(name="code_postale")
	private String codePostale;

	@Column(name="localite_is_actif")
	private boolean localiteIsActif;

	@Column(name="nom_localite")
	private String nomLocalite;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="localite")
	private List<User> users;

	public Localite() {
	}

	public int getIdLocalite() {
		return this.idLocalite;
	}

	public void setIdLocalite(int idLocalite) {
		this.idLocalite = idLocalite;
	}

	public String getCodePostale() {
		return this.codePostale;
	}

	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}

	public boolean getLocaliteIsActif() {
		return this.localiteIsActif;
	}

	public void setLocaliteIsActif(boolean localiteIsActif) {
		this.localiteIsActif = localiteIsActif;
	}

	public String getNomLocalite() {
		return this.nomLocalite;
	}

	public void setNomLocalite(String nomLocalite) {
		this.nomLocalite = nomLocalite;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setLocalite(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setLocalite(null);

		return user;
	}

}