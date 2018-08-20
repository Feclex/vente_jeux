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
    	log.debug(request.getParameter("nom"));
    	log.debug(request.getParameter("motdepasse"));
    	
    	
    	
    	  /* Préparation de l'objet formulaire */
        ConnexionForm form = new ConnexionForm();

        /* Traitement de la requête et récupération du bean en résultant */
        User user = form.connecterUser( request );

        
/*
        
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
      
        if ( form.getErreurs().isEmpty() ) {
        	log.debug("ok");
            
            log.debug(session.getAttribute("user"));
        } else {
        	log.debug("ERREUR");
            session.setAttribute( ATT_SESSION_USER, null );
        }

         Stockage du formulaire et du bean dans l'objet request 
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, user );
        
*/
        
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	EntityManager em=EMF.getEM();
  
    	  try {	

    	    	User test=  em.createNamedQuery("User.findByLogin",User.class).setParameter("loginUser",request.getParameter("nom")).getSingleResult();
    	    	
    	    	if (user==null)
    	    	log.debug("vide");
    	    	else
    	    	{
    	    		/* Récupération de la session depuis la requête */
    	            HttpSession session = request.getSession();
    	            session.setAttribute( "user", test );
    	            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    	    		//response.sendRedirect(request.getContextPath() + "/index.jsp");
    	    		//this.getServletContext().getRequestDispatcher("/register").forward(request, response);
    	    	}
    	    } catch(Exception e)
    	    {
    	    	response.sendRedirect(request.getContextPath() + "#");
    	    	log.debug("EXCEPTION BATARD");
    	    }
    	     finally {
    	    	 em.close(); 
    	    	 
    	     }
    	  
    	
       }
	}
 
    
    
