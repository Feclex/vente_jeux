package be.atc.modeldb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the commande database table.
 * 
 */
@Entity
@NamedQuery(name="Commande.findAll", query="SELECT c FROM Commande c")
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_commande")
	private int idCommande;

	@Column(name="commande_is_actif")
	private boolean commandeIsActif;

	@Temporal(TemporalType.DATE)
	@Column(name="date_arrivee")
	private Date dateArrivee;

	@Temporal(TemporalType.DATE)
	@Column(name="date_commande")
	private Date dateCommande;

	@Column(name="num_commande")
	private int numCommande;

	@Column(name="type_transport")
	private String typeTransport;

	//bi-directional many-to-one association to Transport
	@ManyToOne
	@JoinColumn(name="id_transport")
	private Transport transport;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	//bi-directional many-to-one association to DetailCommande
	@OneToMany(mappedBy="commande")
	private List<DetailCommande> detailCommandes;

	public Commande() {
	}

	public int getIdCommande() {
		return this.idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public boolean getCommandeIsActif() {
		return this.commandeIsActif;
	}

	public void setCommandeIsActif(boolean commandeIsActif) {
		this.commandeIsActif = commandeIsActif;
	}

	public Date getDateArrivee() {
		return this.dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public Date getDateCommande() {
		return this.dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public int getNumCommande() {
		return this.numCommande;
	}

	public void setNumCommande(int numCommande) {
		this.numCommande = numCommande;
	}

	public String getTypeTransport() {
		return this.typeTransport;
	}

	public void setTypeTransport(String typeTransport) {
		this.typeTransport = typeTransport;
	}

	public Transport getTransport() {
		return this.transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<DetailCommande> getDetailCommandes() {
		return this.detailCommandes;
	}

	public void setDetailCommandes(List<DetailCommande> detailCommandes) {
		this.detailCommandes = detailCommandes;
	}

	public DetailCommande addDetailCommande(DetailCommande detailCommande) {
		getDetailCommandes().add(detailCommande);
		detailCommande.setCommande(this);

		return detailCommande;
	}

	public DetailCommande removeDetailCommande(DetailCommande detailCommande) {
		getDetailCommandes().remove(detailCommande);
		detailCommande.setCommande(null);

		return detailCommande;
	}
	
	public Commande(int numCommande, String typeTransport, Date dateCommande, boolean commandeIsActif, Date dateArrivee, Transport idTransport, User idUser) 
	{
		this.numCommande = numCommande;
		this.typeTransport = typeTransport;
		this.dateCommande = dateCommande;
		this.commandeIsActif = commandeIsActif;
		this.dateArrivee = dateArrivee;
		this.transport = idTransport;
		this.user = idUser;
	}


}