package be.atc.modeldb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the stock database table.
 * 
 */
@Entity
@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_stock")
	private int idStock;

	@Column(name="quantite_produit_stock")
	private int quantiteProduitStock;

	@Column(name="stock_is_actif")
	private boolean stockIsActif;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="id_produit")
	private Produit produit;

	public Stock() {
	}

	public int getIdStock() {
		return this.idStock;
	}

	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}

	public int getQuantiteProduitStock() {
		return this.quantiteProduitStock;
	}

	public void setQuantiteProduitStock(int quantiteProduitStock) {
		this.quantiteProduitStock = quantiteProduitStock;
	}

	public boolean getStockIsActif() {
		return this.stockIsActif;
	}

	public void setStockIsActif(boolean stockIsActif) {
		this.stockIsActif = stockIsActif;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}