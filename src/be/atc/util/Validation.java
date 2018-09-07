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

	
	/* Valide le parse*/
	
	public static  void validationParsingLong( String champlong ) throws Exception {
		try {
			long champLongParse = Long.parseLong(champlong);
			 if ( champlong.trim().length() != 11 ) {
			        throw new Exception( "Ce champ doit contenir 11 caractères." );
			    }
			 }
		catch(Exception e){
			 throw new Exception( "Champ est vide" );
		}
	   
	}
	
	public static  void validationParsingInt( String champint ) throws Exception {
		try {
			long champintParse = Integer.parseInt(champint);
			 if ( champint.trim().length() != 0 ) {
			        throw new Exception( "Ce champ doit contenir des chiffres" );
			    }
			 }
		catch(Exception e){
			 throw new Exception( "Champ est vide" );
		}
	   
	}

	/* Valide le champ > 3 caractère.*/
	
	public static  void validationTailleChamp( String champ ) throws Exception {
	    if ( champ != null && champ.trim().length() < 3 ) {
	        throw new Exception( "Ce champ doit contenir au moins 3 caractères." );
	    }
	}
	
	
	/* Valide le champ != vide */
	public static  void validationIsEmpty( String empty ) throws Exception {
	    if ( empty != null && empty.trim().length() <=0 ) {
	        throw new Exception( "Ce champ ne peut pas être vide");
	    }
	}
	
}
