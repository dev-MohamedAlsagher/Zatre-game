package domein;

import persistentie.Mapper;

public class SpelerRepository {

	private final Mapper mapper;

	// constructor met aanmaken van een mapper
	public SpelerRepository() {
		mapper = new Mapper();
	}

	// voegt speler te aan de mapper
	public void voegToe(Gebruiker speler) {
		if (!bestaatSpeler(speler.getGebruikersNaam(), speler.getGeboorteJaar()))
			mapper.voegToe(speler);
	}

	// controleert of de speler al bestaat
	private boolean bestaatSpeler(String gebruikersnaam, int geboortejaar) {
		return mapper.geefSpeler(gebruikersnaam, geboortejaar) != null;
	}

	// slaat speelkansen op in de mapper
	public void slaSpeelkansenOp(String gebruikersnaam, int geboortejaar) {
		mapper.slaSpeelkansenOp(gebruikersnaam, geboortejaar);
	}

	public int geefSpeelkansen(String Gebruikersnaam, int geboortejaar) {
		return mapper.geefSpeelkansen(Gebruikersnaam, geboortejaar);
	}

}