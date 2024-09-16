package cui;

import java.util.Scanner;

import domein.DomeinController;

public class TaalApp {
	static DomeinController dc = new DomeinController();

	public void TaalApp() {
		Scanner input = new Scanner(System.in);
		// taalkeuze doorgeven
		int taalkeuze;
		do {
			System.out.println("------Taal------");
			System.out.println("Kies 1 voor nederlands");
			System.out.println("Kies 2 voor frans ");
			System.out.println("Kies 3 voor engels: ");
			taalkeuze = input.nextInt();
		} while (taalkeuze < 1 && taalkeuze > 2);
		dc.kiesTaal(taalkeuze);
		input.close();
	}
}