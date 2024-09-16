package cui;

import java.util.ArrayList;
import java.util.Scanner;

import domein.DomeinController;
import domein.Gebruiker;
import domein.SpelerRepository;

public class AanmeldenApp {
	private DomeinController dc;
	private Gebruiker speler;
	private SpelerRepository sr;

	public AanmeldenApp(DomeinController dc, MenuApp menuApp) {
		this.dc = dc;
		this.speler = new Gebruiker();
		this.sr = new SpelerRepository();
	}

	public void AanmeldenApp() {
		String Username;
		int geboortejaar;
		int aantal;
		int i;
		do {
			Scanner getal = new Scanner(System.in);
			System.out.println("Met_hoeveel_spelers_wilt_u_spelen(max_4)?" + " : ");
			aantal = getal.nextInt();
			getal.close();
		} while (aantal < 2 || aantal > 4);
		ArrayList<String> spelers = new ArrayList<String>();

		do {

			for (i = 0; i < aantal; i++) {
				Scanner input1 = new Scanner(System.in);
				System.out.println("Gebruikersnaam: ");
				Username = input1.next();
				input1.close();
				Scanner input2 = new Scanner(System.in);
				System.out.println("Geboortejaar: ");
				geboortejaar = input2.nextInt();
				input2.close();

				if (dc.meldAan(Username, geboortejaar) == null) {
					System.out.println("U_bent_ingelogd");
					spelers.add(Username);
				} else
					System.out.println("Er_bestaat_geen_speler_met_deze_gegevens.");
			}

		} while (i != aantal);
		System.out.println("geselecteerde_spelers_zijn" + " : ");
		System.out.print(spelers + " ");

	}
}