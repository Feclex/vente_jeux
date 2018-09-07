package be.atc.servlets;


import java.io.IOException;
import java.util.ArrayList;
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
import be.atc.modeldb.User;



	@WebServlet("/login")
	public class Login extends HttpServlet{
	  public static final String ATT_USER         = "user";
		    public static final String ATT_FORM         = "form";
		    public static final String ATT_SESSION_USER = "sessionUser";
		    public static final String VUE               = "/Login.jsp";
		

	
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{


    	EntityManager em=EMF.getEM();
    	
    	try {
    		
    		User test=  em.createNamedQuery("User.findByLogin",User.class).setParameter("loginUser",request.getParameter("nom")).getSingleResult();
    		
    		if( test != null && test.getMdpUser().equals(request.getParameter("motdepasse"))) {
        		initSession(request, test);	
        		this.getServletContext().getRequestDispatcher( "/restreint/espacePerso.jsp" ).forward( request, response );
        	}else {
        		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        	}
    		
    		
    	
    	} catch(Exception e){
     	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	    }
	     finally {

          	if(em.getTransaction().isActive()) {
          		em.getTransaction().rollback();
          	}
          	em.close();
	     }	
  
   }

	    
    	  
    	  public void initSession(HttpServletRequest request, User user) {

    	    	// CREATION NEW SESSION WITH NEW USER
    	    	HttpSession session = request.getSession();
    	    	session.setAttribute("logged",true);
    	    	session.setAttribute("user", user);
    	    	List<DetailCommande> listDetailCommande = new ArrayList();
    	    	session.setAttribute("panier",listDetailCommande );
    	    	
    		}

    		public Object getAllUser() {
    			// TODO Auto-generated method stub
    			return null;
    		}
	}
 
    
    
