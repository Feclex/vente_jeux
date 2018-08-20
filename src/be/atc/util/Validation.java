package be.atc.util;

public class Validation {

	/* Valide l'adresse mail saisie */
	public static void validationEmail( String email ) throws Exception {
	    if ( email != null && email.trim().length() != 0 ) {
	        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir une adresse mail." );
	    }
	}

	/* Valide les mots de passe saisis.	 */
	public static  void validationMotsDePasse( String motdepasse, String confirmation ) throws Exception{
	    if (motdepasse != null && motdepasse.trim().length() != 0 && confirmation != null && confirmation.trim().length() != 0) {
	        if (!motdepasse.equals(confirmation)) {
	            throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
	        } else if (motdepasse.trim().length() < 3) {
	            throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
	        }
	    } else {
	        throw new Exception("Merci de saisir et confirmer votre mot de passe.");
	    }
	}

	/* Valide le nom d'utilisateur saisi.*/
	public static  void validationNom( String login ) throws Exception {
	    if ( login != null && login.trim().length() < 3 ) {
	        throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
	    }
	}
	

}
