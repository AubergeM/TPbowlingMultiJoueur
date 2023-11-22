package bowling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MultiPlayerGameTest {
	private PartieMultiJoueur partie;
	private String[] lesJoueurs;

	public void setUp(){
		partie = new PartieMultiJoueur();
		lesJoueurs = new String[]{"Lily Dupont", "Camille Durand"};
	}

	@Test
	void testDemarrerPartie(){
		assertEquals(partie.demarreNouvellePartie(lesJoueurs), "Prochain tir: joueur Lily Durant Boule, tour n° 1, boule n° 1", "Ce n'est pas le bon tour/joueur/lancer");
	}

	@Test
	void testDemarrerPartieSansJoueur(){
		assertThrows(IllegalArgumentException.class, () -> {
			partie.demarreNouvellePartie(new String[]{});
		}, "Une partie ne peux pas commencer sans joueur");
	}


	@Test
	void testEnregistreLancer() {
		partie.demarreNouvellePartie(lesJoueurs);
		// Premier lancer du premier joueur
		assertEquals("Prochain tir: joueur Lily Durant, tour n° 1, boule n° 2", partie.enregistreLancer(9), "Ce n'est pas le bon tour/joueur/lancer");
		// Deuxième lancer du premier joueur
		assertEquals("Prochain tir: joueur Camille Durand, tour n° 1, boule n° 1", partie.enregistreLancer(1), "Ce n'est pas le bon tour/joueur/lancer");
		// Premier lancer du deuxième joueur
		assertEquals("Prochain tir: joueur Lily Durant, tour n° 2, boule n° 1", partie.enregistreLancer(10), "Ce n'est pas le bon tour/joueur/lancer");
		
		for (int i = 0; i < 21; i++) {
			partie.enregistreLancer(10);
		}

		// Vérifier que la partie est terminée
		assertEquals("Partie terminée", partie.enregistreLancer(10), "La partie doit être terminée");
		// Vérifier qu'une exception est levée si on essaie de lancer après la fin de la partie
		assertThrows(IllegalStateException.class, () -> partie.enregistreLancer(1), "On ne doit pas pouvoir lancer après la fin de la partie");
	}
	
}
