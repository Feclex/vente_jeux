package be.atc.modeldb;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the produit database table.
 * 
 */
@Entity
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_produit")
	private int idProduit;

	@Column(name="nom_produit")
	private String nomProduit;

	@Column(name="prix_produit")
	private BigDecimal prixProduit;

	@Column(name="produit_is_actif")
	private boolean produitIsActif;

	//bi-directional many-to-one association to DetailCommande
	@OneToMany(mappedBy="produit")
	private List<DetailCommande> detailCommandes;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="id_categorie")
	private Categorie categorie;

	//bi-directional many-to-one association to Stock
	@OneToMany(mappedBy="produit")
	private List<Stock> stocks;

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

	public BigDecimal getPrixProduit() {
		return this.prixProduit;
	}

	public void setPrixProduit(BigDecimal prixProduit) {
		this.prixProduit = prixProduit;
	}

	public boolean getProduitIsActif() {
		return this.produitIsActif;
	}

	public void setProduitIsActif(boolean produitIsActif) {
		this.produitIsActif = produitIsActif;
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

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setProduit(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setProduit(null);

		return stock;
	}

}