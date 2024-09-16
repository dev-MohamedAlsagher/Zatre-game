package domein;

import persistentie.Mapper;

public class DomeinController {
	private final SpelerRepository spelerRepository;
	private Gebruiker speler;
	private Spel spel;
	private Mapper mapper = new Mapper();

	// constructor met aanmaken van spelerRepository
	public DomeinController() {
		spelerRepository = new SpelerRepository();
		spel = new Spel();
	}

	// registeren van een gebruiker door een nieuwe speler aan te maken en toe te
	// voegen
	public void registreerGebruiker(String gebruikersnaam, int geboortejaar) {
		Gebruiker nieuweSpeler = new Gebruiker(gebruikersnaam, geboortejaar);
		if (meldAan(gebruikersnaam, geboortejaar) == null) {
			setSpeler(nieuweSpeler);
			spelerRepository.voegToe(nieuweSpeler);
		}

	}

	// speler aanmaken
	public void setSpeler(Gebruiker speler) {
		this.speler = speler;

	}
	// spel oproepen
	public Spel getSpel() {
		return spel;
	}

	// taal kiezen nederlands/engels
	public static void kiesTaal(int taalkeuze) {
		talen.Taal.kiesTaal(taalkeuze);
	}

	// alles vertalen naar de gewenste taal
	public static String vertaal(String vertaling) {
		return talen.Taal.vertaal(vertaling);
	}

//	public void registreer(String gebruikersnaam, int geboortejaar) {
//	}

	// retourneert of de speler nog voldoende speelkansen heeft
	public boolean isErVoldoendeSpeelkansen() {
		return speler.heeftVoldoendeSpeelkansen(Spel.VEREIST_SPEELKANSEN);

	}

	// retourneert of het spel is afgelopen of niet
	public boolean isEindeSpel() {
		return spel.isAfgelopen();
	}

	// meld een gebruiker aan als deze nog niet bestaat in de databank
	public Gebruiker meldAan(String gebruikersnaam, int geboortejaar) {
		Gebruiker gevondenSpeler = mapper.geefSpeler(gebruikersnaam, geboortejaar);
		if (gevondenSpeler != null) {
			setSpeler(gevondenSpeler);
		}
		return gevondenSpeler;

	}

	// maakt spel aan
	private void setSpel(Spel spel) {
		this.spel = spel;
	}
	// voeg steen toe aan bord
	public void voegSteenToe(int x, int y, int steen) {
		this.spel.voegSteenToe(x, y, steen);
		
	}
	public int getRandomSteen() {
		return this.spel.getRandomSteen();
		
	}
	public int getWaardeSteen(int steen) {
		return this.spel.getWaardeSteen(steen);
	}

}