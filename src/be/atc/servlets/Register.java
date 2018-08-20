package be.atc.servlets;

import java.util.Map;
import be.atc.util.Validation;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


import be.atc.dao.EMF;
import be.atc.dao.EntityFinderImpl;
import be.atc.modeldb.Localite;
import be.atc.modeldb.User;


	@WebServlet("/register")
	public class Register extends HttpServlet{

		public static final String CHAMP_EMAIL = "email";
	    public static final String CHAMP_PASS = "motdepasse";
	    public static final String CHAMP_CONF = "confirmation";
	    public static final String CHAMP_NOM = "login";
	    public static final String ATT_ERREURS  = "erreurs";
	    public static final String ATT_RESULTAT = "resultat";
	// Log4j
	private static final Logger log = Logger.getLogger(Register.class);
    public static final String VUE = "/Register.jsp";
	
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */
    	EntityManager em=EMF.getEM();
    	  
  	  try {	

  	    	List<Localite> localite=  em.createNamedQuery("Localite.findAll",Localite.class).getResultList();
  	    	
  	    	if (localite.isEmpty())
  	    	log.debug("vide");
  	    	else
  	    	{
  	    		request.setAttribute("localites", localite);
  	    		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
  	          
  	    	}
  	    } catch(Exception e)
  	    {
  	    	log.debug("EXCEPTION BATARD");
  	    }
  	     finally {
  	    	 em.close(); 
  	    	 
  	     }
        
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
    	 /* Récupération des champs du formulaire. */
    	  String resultat;
          Map<String, String> erreurs = new HashMap<String, String>();
        String email = request.getParameter( CHAMP_EMAIL );
        String motDePasse = request.getParameter( CHAMP_PASS );
        String confirmation = request.getParameter( CHAMP_CONF );
        String nom = request.getParameter( CHAMP_NOM );
        
        /* Validation du champ email. */


        try {
        	Validation.validationEmail( email );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_EMAIL, e.getMessage() );
        }

        /* Validation des champs mot de passe et confirmation. */
        try {
        	Validation.validationMotsDePasse( motDePasse, confirmation );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_PASS, e.getMessage() );
        }

        /* Validation du champ nom. */
        try {
        	Validation.validationNom( nom );
        } catch ( Exception e ) {
            erreurs.put( CHAMP_NOM, e.getMessage() );
        }

        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Échec de l'inscription.";
        }

        /* Stockage du résultat et des messages d'erreur dans l'objet request */
        request.setAttribute( ATT_ERREURS, erreurs );
        request.setAttribute( ATT_RESULTAT, resultat );
        
        EntityManager em=EMF.getEM();
  	  
    	  try {	

    	    	List<Localite> localite=  em.createNamedQuery("Localite.findAll",Localite.class).getResultList();
    	    	
    	    	if (localite.isEmpty())
    	    	log.debug("vide");
    	    	else
    	    	{
    	    		request.setAttribute("localites", localite);
    	    	}
    	    } catch(Exception e)
    	    {
    	    	log.debug("EXCEPTION BATARD");
    	    }
    	     finally {
    	    	 em.close(); 
    	    	 
    	     }

        /* Transmission de la paire d'objets request/response à notre JSP */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    



    
	

}