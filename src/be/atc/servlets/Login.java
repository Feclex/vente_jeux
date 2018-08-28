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

import org.apache.log4j.Logger;

import be.atc.dao.EMF;
import be.atc.dao.EntityFinderImpl;
import be.atc.modeldb.User;


	@WebServlet("/login")
	public class Login extends HttpServlet{

		  public static final String ATT_USER         = "user";
		    public static final String ATT_FORM         = "form";
		    public static final String ATT_SESSION_USER = "sessionUser";
		    public static final String VUE               = "/Login.jsp";
		
		
	// Log4j
	private static final Logger log = Logger.getLogger(Login.class);
  
	
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Traitement des données du formulaire */

    	  /* Préparation de l'objet formulaire */
        ConnexionForm form = new ConnexionForm();

        /* Traitement de la requête et récupération du bean en résultant */
        User user = form.connecterUser( request );
  	
    	
    	EntityManager em=EMF.getEM();
    	
    	try {
    		
    		User test=  em.createNamedQuery("User.findByLogin",User.class).setParameter("loginUser",request.getParameter("nom")).getSingleResult();
    		
    		if( test != null && test.getMdpUser().equals(request.getParameter("motdepasse"))) {
        		initSession(request, test);	
        		this.getServletContext().getRequestDispatcher( "/restreint/espacePerso.jsp" ).forward( request, response );
        		log.debug("t co lol ") ;
        	}else {
        		// MDP PAS BON
        		// SET REQUEST ERREUR
        		log.debug("mdp pas bon fdp" );
        		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        	}
    		
    		
    	
    	} catch(Exception e){
    		// USER PAS LA
	    	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	    	log.debug("EXCEPTION BATARD");
	    }
	     finally {
	    	 em.close(); 
	    	 
	     }	
  
   }

	    
    	  
    	  public void initSession(HttpServletRequest request, User user) {

    	    	// CREATION NEW SESSION WITH NEW USER
    	    	HttpSession session = request.getSession();
    	    	session.setAttribute("logged",true);
    	    	session.setAttribute("user", user);
    		}

    		public Object getAllUser() {
    			// TODO Auto-generated method stub
    			return null;
    		}
	}
 
    
    
