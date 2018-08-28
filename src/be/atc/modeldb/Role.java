package be.atc.modeldb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQueries( { 
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r"),
@NamedQuery(name="Role.findByID", query="SELECT r FROM Role r WHERE r.idRole = :idRole")
})
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_role")
	private int idRole;

	@Column(name="nom_role")
	private String nomRole;

	@Column(name="role_is_actif")
	private boolean roleIsActif;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="role")
	private List<User> users;

	public Role() {
	}

	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getNomRole() {
		return this.nomRole;
	}

	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}

	public boolean getRoleIsActif() {
		return this.roleIsActif;
	}

	public void setRoleIsActif(boolean roleIsActif) {
		this.roleIsActif = roleIsActif;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setRole(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setRole(null);

		return user;
	}

}