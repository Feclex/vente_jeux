package be.atc.modeldb;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the detail_commande database table.
 * 
 */
@Entity
@Table(name="detail_commande")
@NamedQuery(name="DetailCommande.findAll", query="SELECT d FROM DetailCommande d")
public class DetailCommande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_detail_commande")
	private int idDetailCommande;

	@Column(name="detail_commande_is_actif")
	private boolean detailCommandeIsActif;

	@Column(name="prix_achat")
	private BigDecimal prixAchat;

	@Column(name="quantite_produit")
	private int quantiteProduit;

	//bi-directional many-to-one association to Commande
	@ManyToOne
	@JoinColumn(name="id_commande")
	private Commande commande;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="id_produit")
	private Produit produit;

	public DetailCommande() {
	}

	public int getIdDetailCommande() {
		return this.idDetailCommande;
	}

	public void setIdDetailCommande(int idDetailCommande) {
		this.idDetailCommande = idDetailCommande;
	}

	public boolean getDetailCommandeIsActif() {
		return this.detailCommandeIsActif;
	}

	public void setDetailCommandeIsActif(boolean detailCommandeIsActif) {
		this.detailCommandeIsActif = detailCommandeIsActif;
	}

	public BigDecimal getPrixAchat() {
		return this.prixAchat;
	}

	public void setPrixAchat(BigDecimal prixAchat) {
		this.prixAchat = prixAchat;
	}

	public int getQuantiteProduit() {
		return this.quantiteProduit;
	}

	public void setQuantiteProduit(int quantiteProduit) {
		this.quantiteProduit = quantiteProduit;
	}

	public Commande getCommande() {
		return this.commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}