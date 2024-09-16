package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javafx.scene.input.MouseEvent;

public class Steentje {

	Random rnd = new Random();
	int aantalStenen = 121;

	private ArrayList<Integer> stenen = new ArrayList<Integer>(Arrays.asList(
		1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6,
			1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6,
			1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6,
			1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1 ));

	public ArrayList<Integer> getStenen() {
		return stenen;
	}

	public Integer getRandomSteentje() {
		int random = rnd.nextInt(aantalStenen);
		System.out.println("Rnd:"+aantalStenen);
		return random;
	}
	public Integer getWaardeSteen(int plaats) {
		return stenen.get(plaats);
	}
	public void verwijderSteen(int plaats) {
		stenen.remove(plaats);
		aantalStenen = stenen.size();
		
		System.out.println("Size na verwijderen:"+stenen.size());
	}

}
