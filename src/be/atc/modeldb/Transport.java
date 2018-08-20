package be.atc.modeldb;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the transport database table.
 * 
 */
@Entity
@NamedQuery(name="Transport.findAll", query="SELECT t FROM Transport t")
public class Transport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_transport")
	private int idTransport;

	@Column(name="prix_transport")
	private BigDecimal prixTransport;

	@Column(name="transport_is_actif")
	private boolean transportIsActif;

	@Column(name="type_transport")
	private String typeTransport;

	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="transport")
	private List<Commande> commandes;

	public Transport() {
	}

	public int getIdTransport() {
		return this.idTransport;
	}

	public void setIdTransport(int idTransport) {
		this.idTransport = idTransport;
	}

	public BigDecimal getPrixTransport() {
		return this.prixTransport;
	}

	public void setPrixTransport(BigDecimal prixTransport) {
		this.prixTransport = prixTransport;
	}

	public boolean getTransportIsActif() {
		return this.transportIsActif;
	}

	public void setTransportIsActif(boolean transportIsActif) {
		this.transportIsActif = transportIsActif;
	}

	public String getTypeTransport() {
		return this.typeTransport;
	}

	public void setTypeTransport(String typeTransport) {
		this.typeTransport = typeTransport;
	}

	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Commande addCommande(Commande commande) {
		getCommandes().add(commande);
		commande.setTransport(this);

		return commande;
	}

	public Commande removeCommande(Commande commande) {
		getCommandes().remove(commande);
		commande.setTransport(null);

		return commande;
	}

}