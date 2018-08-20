package be.atc.forms;


import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import be.atc.modeldb.User;
import be.atc.modeldb.Commande;
import be.atc.modeldb.DetailCommande;

public final class CreationCommandeForm {
    private static final String CHAMP_DATE             = "dateCommande";
    private static final String CHAMP_MONTANT          = "prixAchat";
    private static final String CHAMP_MODE_LIVRAISON   = "typeTransport";
    private static final String FORMAT_DATE            = "dd/MM/yyyy HH:mm:ss";

    private String              resultat;
    private Map<String, String> erreurs                = new HashMap<String, String>();

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public void creerCommande( HttpServletRequest request ) {
        /*
         * L'objet métier pour valider la création d'un client existe déjà, il
         * est donc déconseillé de dupliquer ici son contenu ! À la place, il
         * suffit de passer la requête courante à l'objet métier existant et de
         * récupérer l'objet Client créé.
         */
        CreationUserForm userForm = new CreationUserForm();
        User user = userForm.creerUser( request );

        /*
         * Et très important, il ne faut pas oublier de récupérer le contenu de
         * la map d'erreurs créée par l'objet métier CreationClientForm dans la
         * map d'erreurs courante, actuellement vide.
         */
        erreurs = userForm.getErreurs();

        /*
         * Ensuite, il suffit de procéder normalement avec le reste des champs
         * spécifiques à une commande.
         */

        /*
         * Récupération et conversion de la date en String selon le format
         * choisi.
         */
        /*
        DateTime dt = new DateTime(dt);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( FORMAT_DATE );
        String date = dt.toString(  );

        String montant = getValeurChamp( request, CHAMP_MONTANT );
        String modeLivraison = getValeurChamp( request, CHAMP_MODE_LIVRAISON );

        Commande commande = new Commande();

        commande.setUser( user );
*/
      /*  commande.setDateCommande(commande);

        double valeurMontant = -1;
        try {
            valeurMontant = validationMontant( montant );
        } catch ( Exception e ) {
            setErreur( CHAMP_MONTANT, e.getMessage() );
        }
        commande.setMontant( valeurMontant );

        try {
            validationModePaiement( modePaiement );
        } catch ( Exception e ) {
            setErreur( CHAMP_MODE_PAIEMENT, e.getMessage() );
        }
        commande.setModePaiement( modePaiement );

        try {
            validationStatutPaiement( statutPaiement );
        } catch ( Exception e ) {
            setErreur( CHAMP_STATUT_PAIEMENT, e.getMessage() );
        }
        commande.setStatutPaiement( statutPaiement );

        try {
            validationModeLivraison( modeLivraison );
        } catch ( Exception e ) {
            setErreur( CHAMP_MODE_LIVRAISON, e.getMessage() );
        }
        commande.setModeLivraison( modeLivraison );

        try {
            validationStatutLivraison( statutLivraison );
        } catch ( Exception e ) {
            setErreur( CHAMP_STATUT_LIVRAISON, e.getMessage() );
        }
        commande.setStatutLivraison( statutLivraison );

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la création de la commande.";
        } else {
            resultat = "Échec de la création de la commande.";
        }*/
        return;
    }

    private double validationMontant( String montant ) throws Exception {
        double temp;
        if ( montant != null ) {
            try {
                temp = Double.parseDouble( montant );
                if ( temp < 0 ) {
                    throw new Exception( "Le montant doit être un nombre positif." );
                }
            } catch ( NumberFormatException e ) {
                temp = -1;
                throw new Exception( "Le montant doit être un nombre." );
            }
        } else {
            temp = -1;
            throw new Exception( "Merci d'entrer un montant." );
        }
        return temp;
    }

    private void validationModePaiement( String modePaiement ) throws Exception {
        if ( modePaiement != null ) {
            if ( modePaiement.length() < 2 ) {
                throw new Exception( "Le mode de paiement doit contenir au moins 2 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer un mode de paiement." );
        }
    }

    private void validationStatutPaiement( String statutPaiement ) throws Exception {
        if ( statutPaiement != null && statutPaiement.length() < 2 ) {
            throw new Exception( "Le statut de paiement doit contenir au moins 2 caractères." );
        }
    }

    private void validationModeLivraison( String modeLivraison ) throws Exception {
        if ( modeLivraison != null ) {
            if ( modeLivraison.length() < 2 ) {
                throw new Exception( "Le mode de livraison doit contenir au moins 2 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer un mode de livraison." );
        }
    }

    private void validationStatutLivraison( String statutLivraison ) throws Exception {
        if ( statutLivraison != null && statutLivraison.length() < 2 ) {
            throw new Exception( "Le statut de livraison doit contenir au moins 2 caractères." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}