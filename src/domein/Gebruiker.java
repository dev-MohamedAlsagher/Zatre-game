
package domein;

import java.time.LocalDate;
import java.util.Objects;

public class Gebruiker {

	public String gebruikersNaam;
	public int geboorteJaar;
	private int speelKansen = 5;

	private boolean mijnBeurt = false;
	private SpelerRepository sp = new SpelerRepository();

	// constructor met declareren van gebruiker en geboortejaar
	public Gebruiker(String gebruikersNaam, int geboorteJaar) {
		setGebruikersNaam(gebruikersNaam);
		setGeboorteJaar(geboorteJaar);
	}

	public Gebruiker() {
	}

	// retourneert geberuikersNaam
	public String getGebruikersNaam() {
		return gebruikersNaam;
	}

	// controleert of de gebruikersnaam niet leeg is en langer dan 5 tekens
	public void setGebruikersNaam(String gebruikersNaam) {
		if (gebruikersNaam.isBlank() || gebruikersNaam.isEmpty() || gebruikersNaam.length() < 5)
			throw new IllegalArgumentException(
					"Gebruikersnaam is verplicht in te vullen," + " en moet minstens 5 tekens bevatten!");
		this.gebruikersNaam = gebruikersNaam;

	}

	// retourneert geboortejaar
	public int getGeboorteJaar() {
		return this.geboorteJaar;
	}

	// controleert of het geboortejaar mogelijks te hoog of laag is
	// als hun leeftijd 6 jaar of jonger is retourneert er ook een exception
	public void setGeboorteJaar(int geboortejaar) {
		LocalDate current_date = LocalDate.now();
		int current_Year = current_date.getYear();
		int jong = current_Year - 6;
		int oud = current_Year - 100;
		if (geboortejaar > jong)
			throw new IllegalArgumentException("Het geboortejaar is te hoog");
		else if (geboortejaar < oud)
			throw new IllegalArgumentException("Het geboortejaar is niet geldig");
		else if (geboortejaar > current_Year)
			throw new IllegalArgumentException("Je bent te jong");
		this.geboorteJaar = geboortejaar;
	}

	// retourneert speelKansen van databank
	public int getSpeelKansen(String gebruikersnaam, int geboortejaar) {
		return sp.geefSpeelkansen(gebruikersnaam, geboortejaar);

	}

	// update speler. roept this.updatespeelKansen() op in mapper
	public void speelkansenSpel(String gebruikersnaam, int geboortejaar) {
		sp.slaSpeelkansenOp(gebruikersnaam, geboortejaar);
	}

	public int updateSpeelKansen(String gebruikersnaam, int geboortejaar) {
		int speelkansen = getSpeelKansen(gebruikersnaam, geboortejaar);
		int speelkansenspel = speelkansen - 1;
		return speelkansenspel;

	}

	// set altijd op 5 voor nieuwe speler aangemaakt.
	public int setSpeelKansen() {
		return this.speelKansen;
	}

	// toont hoeveel speelkansen de gebruiker nog heeft
	public void toonNaamEnAantalSpelletjes() {
		System.out.printf("Uw naam is %s en u kan nog  %d spel%s spelen", gebruikersNaam, speelKansen,
				speelKansen > 1 ? "letjes" : "letje");

	}

	// controleert of de gebruiker nog genoeg speelkansen heeft om een nieuw spel te
	// spelen
	public boolean heeftVoldoendeSpeelkansen(String vereistSpeelkansen) {
		if (speelKansen > Integer.parseInt(vereistSpeelkansen)) {
			return true;
		} else {
			return false;
		}
	};

	public boolean isWinnaar(boolean uitslag) {
		if (uitslag == true) {
			return true;
		}
		return false;
	}

	public boolean isMijnBeurt() {
		return mijnBeurt;
	}

	public void setMijnBeurt(boolean mijnBeurt) {
		this.mijnBeurt = mijnBeurt;
	}

	@Override
	public String toString() {
		return gebruikersNaam;
	}

	@Override
	public int hashCode() {
		return Objects.hash(geboorteJaar, gebruikersNaam);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gebruiker other = (Gebruiker) obj;
		return geboorteJaar == other.geboorteJaar && Objects.equals(gebruikersNaam, other.gebruikersNaam);
	}

}