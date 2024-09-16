package cui;

import java.util.Scanner;

import domein.DomeinController;
import domein.Gebruiker;

public class MenuApp {
	private final DomeinController dc;
	private final RegistratieApp registratie;
	private final Gebruiker speler;
	private AanmeldenApp login;
	private TaalApp taal;

	public MenuApp(DomeinController dc) {

		this.dc = dc;
		this.registratie = new RegistratieApp(dc, this);
		this.login = new AanmeldenApp(dc, this);
		this.speler = new Gebruiker();
		this.taal = new TaalApp();

	}

	public void start() {
		Scanner naam = new Scanner(System.in);
		Scanner jaar = new Scanner(System.in);
		Scanner invoer = new Scanner(System.in);
		int keuze;

		// TaalApp taal = new TaalApp();
		// taal.TaalApp();

		do {

			System.out.println("------MENU------");
			System.out.println("1_-_Spelen");
			System.out.println("2_-_Registratie");
			System.out.println("3_-_Stoppen");
			keuze = invoer.nextInt();

			if (keuze == 1) {

				AanmeldenApp login = new AanmeldenApp(dc, this);
				login.AanmeldenApp();
				break;
			}
			if (keuze == 2) {

				RegistratieApp registratie = new RegistratieApp(dc, this);
				registratie.Registratie();

				break;
			}
			if (keuze == 3) {
				System.out.println("Exit Game");
				break;
			}
		} while (keuze != 3 || keuze < 1 || keuze > 3);

	}
}
