package bowling;
import java.util.HashMap;
import java.util.Map;
public class PartieMultiJoueur implements IPartieMultiJoueurs{
	private String[] nomsDesJoueurs;
	private int nbJoueur;
	private int tourJoueurNb;
	private Map<String, PartieMonoJoueur> lesParties;


	private String tourJ(){
		return "Prochain tir: joueur " + nomsDesJoueurs[tourJoueurNb] + ", tour n° " + lesParties.get(nomsDesJoueurs[tourJoueurNb]).numeroTourCourant() + ", boule n° " + lesParties.get(nomsDesJoueurs[tourJoueurNb]).numeroProchainLancer();
	}

	private boolean estTerminee(){
		return lesParties.get(nomsDesJoueurs[nbJoueur-1]).estTerminee();
	}
	
	public String demarreNouvellePartie(String[] nomsDesJoueurs) throws IllegalArgumentException{
		if (nomsDesJoueurs.length == 0) throw new IllegalArgumentException("Il faut au moins 1 joueur");
		
		lesParties = new HashMap<>();
		nbJoueur = nomsDesJoueurs.length;
		tourJoueurNb = 0;
		
		this.nomsDesJoueurs = nomsDesJoueurs;
		for (String nom: nomsDesJoueurs) {
			lesParties.put(nom, new PartieMonoJoueur());
		}
		return tourJ();
	}

	public String enregistreLancer(int nombreDeQuillesAbattues) throws IllegalStateException {
		if (estTerminee()) {
			throw new IllegalStateException("La partie est terminée");
		}

		PartieMonoJoueur partieJoueur = lesParties.get(nomsDesJoueurs[tourJoueurNb]);
		partieJoueur.enregistreLancer(nombreDeQuillesAbattues);

		if (partieJoueur.numeroProchainLancer() == 1 || partieJoueur.estTerminee()) {
			tourJoueurNb = (tourJoueurNb + 1) % nbJoueur;
		}

		return estTerminee() ? "Partie terminée" : tourJ();
	}

	public int scorePour(String nomDuJoueur) throws IllegalArgumentException{
		PartieMonoJoueur partieJoueur = lesParties.get(nomDuJoueur);
		if (partieJoueur == null) throw new IllegalArgumentException("Joueur non trouvé");
		return partieJoueur.score();
	}

	
	
}
