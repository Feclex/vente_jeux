package be.atc.servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.atc.dao.EMF;
import be.atc.modeldb.DetailCommande;
import be.atc.modeldb.Produit;

@WebServlet("/disconnect")
public class Disconnect extends HttpServlet {
	   public static final String VUE = "/login";

	    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	        /* Récupération et destruction de la session en cours */
	        HttpSession session = request.getSession();
	    	List<DetailCommande> panier = (List<DetailCommande>)session.getAttribute("panier");
	    	
	        if(panier != null && panier.isEmpty() == false)
	        {
	        	EntityManager em = EMF.getEM();
		        try {
		        	for(DetailCommande dc : panier)
		            {
		            	Produit produit=  em.createNamedQuery("Produit.findByID",Produit.class).setParameter("idProduit",dc.getProduit().getIdProduit()).getSingleResult();
		            	produit.setStockProduit(produit.getStockProduit()+dc.getQuantiteProduit());
		            	em.getTransaction().begin();
		            	em.merge(produit);
		            	em.getTransaction().commit();
		            }
		        }catch(Exception e) {
		        	
		        }finally {
		        	if(em.getTransaction().isActive()) {
		    			em.getTransaction().rollback();
		    		}
		    		em.close();	
		        	
		        }
	            
	        }

	        session.invalidate();
	  

	        /* Affichage de la page de connexion */
	        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	    }
}