package be.atc.modeldb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the produit database table.
 * 
 */
@Entity
@NamedQueries( { 
	@NamedQuery(name="Produit.findByID", query="SELECT u FROM Produit u WHERE u.idProduit = :idProduit"),
	@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p  WHERE p.produitIsActif = true"),
	@NamedQuery(name="Produit.findInactiveProduit", query="SELECT p FROM Produit p WHERE p.produitIsActif = false"),
	@NamedQuery(name="Produit.findByIDInactive", query="SELECT p FROM Produit p WHERE p.idProduit = :idProduit AND p.produitIsActif = false"),
	
		})
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_produit")
	private int idProduit;

	@Column(name="nom_produit")
	private String nomProduit;

	@Column(name="prix_produit")
	private float prixProduit;

	@Column(name="produit_is_actif")
	private boolean produitIsActif;

	@Column(name="stock_produit")
	private int stockProduit;

	//bi-directional many-to-one association to DetailCommande
	@OneToMany(mappedBy="produit")
	private List<DetailCommande> detailCommandes;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="id_categorie")
	private Categorie categorie;

	public Produit() {
	}

	public int getIdProduit() {
		return this.idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public String getNomProduit() {
		return this.nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public float getPrixProduit() {
		return this.prixProduit;
	}

	public void setPrixProduit(float prixProduit) {
		this.prixProduit = prixProduit;
	}

	public boolean getProduitIsActif() {
		return this.produitIsActif;
	}

	public void setProduitIsActif(boolean produitIsActif) {
		this.produitIsActif = produitIsActif;
	}

	public int getStockProduit() {
		return this.stockProduit;
	}

	public void setStockProduit(int stockProduit) {
		this.stockProduit = stockProduit;
	}

	public List<DetailCommande> getDetailCommandes() {
		return this.detailCommandes;
	}

	public void setDetailCommandes(List<DetailCommande> detailCommandes) {
		this.detailCommandes = detailCommandes;
	}

	public DetailCommande addDetailCommande(DetailCommande detailCommande) {
		getDetailCommandes().add(detailCommande);
		detailCommande.setProduit(this);

		return detailCommande;
	}

	public DetailCommande removeDetailCommande(DetailCommande detailCommande) {
		getDetailCommandes().remove(detailCommande);
		detailCommande.setProduit(null);

		return detailCommande;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Produit(String nomProduit,float prixProduit, Categorie idCategorie, boolean produitIsActif, int stockProduit) {
		this.prixProduit = prixProduit;
		this.nomProduit = nomProduit;
		this.categorie = idCategorie;
		this.produitIsActif = produitIsActif;
		this.stockProduit= stockProduit;
	}

}