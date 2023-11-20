package bowling;

public class PartieMultiJoueur implements IPartieMultiJoueurs{
	private String[] nomsDesJoueurs;

	public String demarreNouvellePartie(String[] nomsDesJoueurs) throws IllegalArgumentException{
		String prochainJoueur="";
		for (int i=0; i <= nomsDesJoueurs.length; i++ ){
			//prochainJoueur
		}
		return  prochainJoueur;
	}

	public String enregistreLancer(int nombreDeQuillesAbattues) throws IllegalStateException{
		String resultat="";
		return resultat;
	}

	public int scorePour(String nomDuJoueur) throws IllegalArgumentException{
		int scoreJoueur=0;
		return scoreJoueur;
	}
	
}
