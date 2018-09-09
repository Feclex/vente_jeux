package be.atc.servlets;

import java.util.Map;

import be.atc.util.UtilClass;
import be.atc.util.Validation;
import java.io.IOException;
import java.util.Date;
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
import be.atc.modeldb.Localite;
import be.atc.modeldb.Role;
import be.atc.modeldb.User;


@WebServlet("/register")
public class Register extends HttpServlet{

	public static final String CHAMP_NOMUSER = "nom";
	public static final String CHAMP_PRENOMUSER = "prenom";
	public static final String CHAMP_EMAIL = "email";
	public static final String CHAMP_PASS = "motdepasse";
	public static final String CHAMP_CONF = "confirmation";
	public static final String CHAMP_LOGIN = "login";
	public static final String CHAMP_NISS = "niss";
	public static final String CHAMP_LOCALITE = "localite";
	public static final String CHAMP_ROLE = "role";
	public static final String CHAMP_DATE = "dateNaissance";
	public static final String CHAMP_ADRESSE = "adresse";
	public static final String CHAMP_NUMADRESSE = "numeroAdresse";
	public static final String CHAMP_BOITEPOSTALE = "boitePostale";
	public static final String ATT_ERREURS  = "erreurs";
	public static final String ATT_RESULTAT = "resultat";
	public static final String ATT_USER = "user";
	public static final String ATT_FORM = "creationuserform";
	
	 private static final String FORMAT_DATE            = "dd/MM/yyyy HH:mm:ss";
	 
	// Log4j
	private static final Logger log = Logger.getLogger(Register.class);
	public static final String VUE = "/Register.jsp";

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		/* Affichage de la page d'inscription */
		EntityManager em=EMF.getEM();

		List<Localite> localite=  em.createNamedQuery("Localite.findAll",Localite.class).getResultList();
		List<Role> roles = em.createNamedQuery("Role.findAll",Role.class).getResultList();

		
		request.setAttribute("localites", localite);
		request.setAttribute("roles", roles);
		em.close(); 
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}
	

	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		/* Récupération des champs du formulaire. */
		String resultat;
		Map<String, String> erreurs = new HashMap<String, String>();
		
		String email = request.getParameter( CHAMP_EMAIL );
		String motDePasse = request.getParameter( CHAMP_PASS );
		String confirmation = request.getParameter( CHAMP_CONF );
		String login = request.getParameter( CHAMP_LOGIN );
		
		int localiteInt = Integer.parseInt(request.getParameter(CHAMP_LOCALITE));
		
		String nomUser = request.getParameter(CHAMP_NOMUSER);
		String prenomUser = request.getParameter(CHAMP_PRENOMUSER);
		String date = request.getParameter(CHAMP_DATE);
		String adresse = request.getParameter(CHAMP_ADRESSE);
		String numeroAdresse = request.getParameter(CHAMP_NUMADRESSE);
		String boitePostale = request.getParameter(CHAMP_BOITEPOSTALE);



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

		/* Validation du champ login. */
		try {
			Validation.validationTailleChamp( login );
		} catch ( Exception e ) {
			erreurs.put( CHAMP_LOGIN, e.getMessage() );
		}
		
		/* Validation du champ nom. */
		try {
			Validation.validationTailleChamp( nomUser );
		} catch ( Exception e ) {
			erreurs.put( CHAMP_NOMUSER, e.getMessage() );
		}
		
		/* Validation du champ prenom. */
		try {
			Validation.validationTailleChamp( prenomUser );
		} catch ( Exception e ) {
			erreurs.put( CHAMP_PRENOMUSER, e.getMessage() );
		}
		
	
		
		/* Validation du champ adresse. */
		try {
			Validation.validationTailleChamp( adresse );
		} catch ( Exception e ) {
			erreurs.put( CHAMP_ADRESSE, e.getMessage() );
		}

		/* Validation du champ numero adresse. */
		try {
			Validation.validationIsEmpty( numeroAdresse );
		} catch ( Exception e ) {
			erreurs.put( CHAMP_NUMADRESSE, e.getMessage() );
		}
		
		/* Validation du champ niss. */
		try {
			Validation.validationParsingLong ( request.getParameter(CHAMP_NISS) );
		} catch ( Exception e ) {
			erreurs.put( CHAMP_NISS, e.getMessage() );
		}
		
		/* Initialisation du résultat global de la validation. */
		if ( erreurs.isEmpty() ) {
			
			EntityManager em=EMF.getEM();
		
			Role roleUser = em.createNamedQuery("Role.findByID",Role.class).setParameter("idRole",2).getSingleResult();
			Localite localiteUser = em.createNamedQuery("Localite.findByID",Localite.class).setParameter("idLocalite", localiteInt).getSingleResult();
			
			
			
			// Role idRole, String nomUser, String prenomUser,Date dateNaissance,String adresseUser, String numeroAdresse, Localite idLocalite,String email,String boitePostale,String loginUser,String mdpUser,int niss, boolean userIsActif
			User user = new User(roleUser, nomUser,prenomUser,UtilClass.formatterDate(date), adresse,numeroAdresse,localiteUser,email,boitePostale,login,motDePasse, Long.parseLong(request.getParameter(CHAMP_NISS)),true);
			try {
		
				em.getTransaction().begin();
				em.persist(user);
				em.getTransaction().commit();
				resultat = "Succès de l'inscription.";
				request.setAttribute( ATT_RESULTAT, resultat );
				List<Localite> localite=  em.createNamedQuery("Localite.findAll",Localite.class).getResultList();
				List<Role> roles = em.createNamedQuery("Role.findAll",Role.class).getResultList();
				request.setAttribute("localites", localite);
				request.setAttribute("roles", roles);
				this.getServletContext().getRequestDispatcher( "/confirmationRegister.jsp" ).forward( request, response );
			}catch(Exception e) {
				
				e.printStackTrace();
			}finally {
				if(em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
				em.close();	
			}
			
			
			
			
		} else {
		
			EntityManager em=EMF.getEM();
		
			List<Localite> localite=  em.createNamedQuery("Localite.findAll",Localite.class).getResultList();
			List<Role> roles = em.createNamedQuery("Role.findAll",Role.class).getResultList();
			resultat = "Echec l'inscription.";
			request.setAttribute( ATT_RESULTAT, resultat );
			request.setAttribute("localites", localite);
			request.setAttribute("roles", roles);
			request.setAttribute(ATT_ERREURS, erreurs);
			em.close(); 
			
			this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
			
		}
	}


}