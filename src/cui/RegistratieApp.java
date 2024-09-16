package cui;

import java.util.Scanner;

import domein.DomeinController;
import domein.Gebruiker;

public class RegistratieApp {
	private final DomeinController dc;
	private final MenuApp menu;
	private final Gebruiker speler;

	public RegistratieApp(DomeinController dc, MenuApp menu) {
		this.dc = dc;
		this.menu = menu;
		this.speler = new Gebruiker();

	}

	public void Registratie() {
		Scanner naam = new Scanner(System.in);
		Scanner jaar = new Scanner(System.in);
		String gebruikersnaam = null;
		int geboortejaar = 0;

		System.out.println("------Registratie------");
		System.out.println("Gebruikersnaam: ");

		gebruikersnaam = naam.next();
		speler.setGebruikersNaam(gebruikersnaam);

		System.out.println("Geboortejaar: ");
		geboortejaar = jaar.nextInt();
		speler.setGeboorteJaar(geboortejaar);
		dc.registreerGebruiker(gebruikersnaam, geboortejaar);
		naam.close();
		jaar.close();

		System.out.printf("uw gebruikersnaam : %s geboortejaar: %d%n", speler.getGebruikersNaam(),
				speler.getGeboorteJaar());
		System.out.printf("u heeft %d speelkansen", speler.getSpeelKansen(gebruikersnaam, geboortejaar));

	}
}
