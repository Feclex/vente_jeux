package be.atc.modeldb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categorie database table.
 * 
 */
@Entity

@NamedQueries( { 
	@NamedQuery(name="Categorie.findByID", query="SELECT c FROM Categorie c WHERE c.idCategorie = :idCategorie AND c.categorieIsActif = true"),
	@NamedQuery(name="Categorie.findAll", query="SELECT c FROM Categorie c WHERE c.categorieIsActif = true"),
	@NamedQuery(name="Categorie.findInactiveCategorie", query="SELECT c FROM Categorie c WHERE c.categorieIsActif = false"),
	@NamedQuery(name="Categorie.findByIDInactive", query="SELECT c FROM Categorie c WHERE c.idCategorie = :idCategorie AND c.categorieIsActif = false"),
	
	
		})

public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_categorie")
	private int idCategorie;

	@Column(name="categorie_is_actif")
	private boolean categorieIsActif;

	@Column(name="nom_categorie")
	private String nomCategorie;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="categorie")
	private List<Produit> produits;

	public Categorie() {
	}

	public int getIdCategorie() {
		return this.idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public boolean getCategorieIsActif() {
		return this.categorieIsActif;
	}

	public void setCategorieIsActif(boolean categorieIsActif) {
		this.categorieIsActif = categorieIsActif;
	}

	public String getNomCategorie() {
		return this.nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Produit addProduit(Produit produit) {
		getProduits().add(produit);
		produit.setCategorie(this);

		return produit;
	}

	public Produit removeProduit(Produit produit) {
		getProduits().remove(produit);
		produit.setCategorie(null);

		return produit;
	}
	
	public Categorie(String nomCategorie, boolean categorieIsActif) {
		this.nomCategorie = nomCategorie;
		this.categorieIsActif= categorieIsActif;	
	}

}