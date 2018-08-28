package be.atc.modeldb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQueries( { 
	@NamedQuery(name="User.findByID", query="SELECT u FROM User u WHERE u.idUser = :idUser"),
	@NamedQuery(name="User.findByLogin", query="SELECT u FROM User u WHERE u.loginUser = :loginUser"),
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
	
		})

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_user")
	private int idUser;

	@Column(name="adresse_user")
	private String adresseUser;

	@Column(name="boite_postale")
	private String boitePostale;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_naissance")
	private Date dateNaissance;

	private String email;

	@Column(name="login_user")
	private String loginUser;

	@Column(name="mdp_user")
	private String mdpUser;

	private float niss;

	@Column(name="nom_user")
	private String nomUser;

	@Column(name="numero_adresse")
	private String numeroAdresse;

	@Column(name="prenom_user")
	private String prenomUser;

	@Column(name="user_is_actif")
	private boolean userIsActif;

	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="user")
	private List<Commande> commandes;

	//bi-directional many-to-one association to Localite
	@ManyToOne
	@JoinColumn(name="id_localite")
	private Localite localite;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="id_role")
	private Role role;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getAdresseUser() {
		return this.adresseUser;
	}

	public void setAdresseUser(String adresseUser) {
		this.adresseUser = adresseUser;
	}

	public String getBoitePostale() {
		return this.boitePostale;
	}

	public void setBoitePostale(String boitePostale) {
		this.boitePostale = boitePostale;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginUser() {
		return this.loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getMdpUser() {
		return this.mdpUser;
	}

	public void setMdpUser(String mdpUser) {
		this.mdpUser = mdpUser;
	}

	public float getNiss() {
		return this.niss;
	}

	public void setNiss(float niss) {
		this.niss = niss;
	}

	public String getNomUser() {
		return this.nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public String getNumeroAdresse() {
		return this.numeroAdresse;
	}

	public void setNumeroAdresse(String numeroAdresse) {
		this.numeroAdresse = numeroAdresse;
	}

	public String getPrenomUser() {
		return this.prenomUser;
	}

	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}

	public boolean getUserIsActif() {
		return this.userIsActif;
	}

	public void setUserIsActif(boolean userIsActif) {
		this.userIsActif = userIsActif;
	}

	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Commande addCommande(Commande commande) {
		getCommandes().add(commande);
		commande.setUser(this);

		return commande;
	}

	public Commande removeCommande(Commande commande) {
		getCommandes().remove(commande);
		commande.setUser(null);

		return commande;
	}

	public Localite getLocalite() {
		return this.localite;
	}

	public void setLocalite(Localite localite) {
		this.localite = localite;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	

	public User(Role idRole, String nomUser, String prenomUser,Date dateNaissance,String adresseUser, String numeroAdresse, Localite idLocalite,String email,String boitePostale,String loginUser,String mdpUser,float niss, boolean userIsActif) {
	this.role = idRole;
	this.nomUser = nomUser;
	this.prenomUser = prenomUser;
	this.dateNaissance = dateNaissance;
	this.adresseUser = adresseUser;
	this.numeroAdresse = numeroAdresse;
	this.localite = idLocalite;
	this.email = email;
	this.boitePostale = boitePostale;
	this.loginUser= loginUser;
	this.mdpUser = mdpUser;
	this.niss = niss;
	this.userIsActif= userIsActif;
	
	}

}