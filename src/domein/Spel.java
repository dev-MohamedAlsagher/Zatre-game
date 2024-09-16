package domein;

import java.util.ArrayList;

public class Spel {

	public static final String VEREIST_SPEELKANSEN = null;
	public static  ArrayList<Gebruiker> spelers = new ArrayList<>();
//	public  ArrayList<Gebruiker> spelersId = new ArrayList<>();
	public  static ArrayList<String> volgordenew = new ArrayList<String>();
	private Steentje st = new Steentje();
	private String beurt;
	private Bord bord;


	// voor scoreblad

	public Spel() {
		this.bord = new Bord();

	}
	
	public Bord getBord() {
		return this.bord;
	}
	public String getBeurt() {
			return beurt;
		}
	
	public void setBeurt(String beurt) {
			this.beurt = beurt;
	}
		
	public boolean isAfgelopen() {
		// TODO Auto-generated method stub
		if (st.getStenen().size() == 0)
			return true;

		return false;
	}

	// voegt speler toe aan spelende spelers
	public void setSpelendeSpeler(Gebruiker speler) {
		if (!spelers.contains(speler))
			spelers.add(speler);

	}
	

	// toont hoeveel spelers er zijn
	public int getAantalSpelendeSpelers() {
		return spelers.size();
	}

	// toont de spelers die aan het spelen zijn
	public ArrayList<Gebruiker> getSpelendeSpelers() {
		return spelers;

	}
	int randomBeginnendeSpeler;
	// random beginnende speler
	public void beginnendeSpeler() {
		int minimum = 0;
		int max = getAantalSpelendeSpelers() - 1;
		randomBeginnendeSpeler = (int) Math.floor(Math.random() * (max - minimum + 1) + minimum);
	}

	// volgorde spelers

	public ArrayList<String> spelervolgorde() {
		// ArrayList<String> volgordenew = new ArrayList<String>();
		String speler1 = spelers.get(randomBeginnendeSpeler).getGebruikersNaam();
		volgordenew.add(speler1);
		System.out.println(getAantalSpelendeSpelers());
		System.out.println(randomBeginnendeSpeler);
		System.out.println(spelers.get(randomBeginnendeSpeler).getGebruikersNaam());
		if (getAantalSpelendeSpelers() == 2) {
			String speler2;
			if (randomBeginnendeSpeler == 1 && volgordenew.get(0) == spelers.get(randomBeginnendeSpeler).getGebruikersNaam()) {
				speler2 = spelers.get(0).getGebruikersNaam();
				volgordenew.add(speler2);
			} else{
				speler2 = spelers.get(1).getGebruikersNaam();
				volgordenew.add(speler2);
			}

			System.out.println(volgordenew.get(0));
			System.out.println(volgordenew.get(1));
		} else if (getAantalSpelendeSpelers() == 3) {
			String speler2;
			String speler3;
			if (randomBeginnendeSpeler == 1 && volgordenew.get(0) == spelers.get(randomBeginnendeSpeler).getGebruikersNaam()) {
				speler2 = spelers.get(0).getGebruikersNaam();
				volgordenew.add(speler2);
				speler3 = spelers.get(2).getGebruikersNaam();
				volgordenew.add(speler3);
			} else if (randomBeginnendeSpeler == 0
					&& volgordenew.get(0) == spelers.get(randomBeginnendeSpeler).getGebruikersNaam()) {
				speler2 = spelers.get(1).getGebruikersNaam();
				volgordenew.add(speler2);
				speler3 = spelers.get(2).getGebruikersNaam();
				volgordenew.add(speler3);
			} else {
				speler2 = spelers.get(0).getGebruikersNaam();
				volgordenew.add(speler2);
				speler3 = spelers.get(1).getGebruikersNaam();
				volgordenew.add(speler3);
			}
			System.out.println(volgordenew.get(0));
			System.out.println(volgordenew.get(1));
			System.out.println(volgordenew.get(2));

		} else {
			String speler2;
			String speler3;
			String speler4;
			if (randomBeginnendeSpeler == 1 && volgordenew.get(0) == spelers.get(randomBeginnendeSpeler).getGebruikersNaam()) {
				speler2 = spelers.get(0).gebruikersNaam;
				volgordenew.add(speler2);
				speler3 = spelers.get(2).gebruikersNaam;
				volgordenew.add(speler3);
				speler4 = spelers.get(3).gebruikersNaam;
				volgordenew.add(speler4);
			} else if (randomBeginnendeSpeler == 0
					&& volgordenew.get(0) == spelers.get(randomBeginnendeSpeler).getGebruikersNaam()) {
				speler2 = spelers.get(1).gebruikersNaam;
				volgordenew.add(speler2);
				speler3 = spelers.get(2).gebruikersNaam;
				volgordenew.add(speler3);
				speler4 = spelers.get(3).gebruikersNaam;
				volgordenew.add(speler4);
			} else if (randomBeginnendeSpeler == 2
					&& volgordenew.get(0) == spelers.get(randomBeginnendeSpeler).getGebruikersNaam()) {
				speler2 = spelers.get(0).gebruikersNaam;
				volgordenew.add(speler2);
				speler3 = spelers.get(1).gebruikersNaam;
				volgordenew.add(speler3);
				speler4 = spelers.get(3).gebruikersNaam;
				volgordenew.add(speler4);
			} else {
				speler2 = spelers.get(0).gebruikersNaam;
				volgordenew.add(speler2);
				speler3 = spelers.get(1).gebruikersNaam;
				volgordenew.add(speler3);
				speler4 = spelers.get(2).gebruikersNaam;
				volgordenew.add(speler4);
			}
			System.out.println(volgordenew.get(0));
			System.out.println(volgordenew.get(1));
			System.out.println(volgordenew.get(2));
			System.out.println(volgordenew.get(3));

		}

		// Collections.copy(spelers, volgorde); // veranderingen moeten nog gemaakt
		// worden.
		// Collections.shuffle(volgorde);
		return volgordenew;
	}

	public int vorigeSpeler;

	public int getVorigeSpeler() {
		return vorigeSpeler;
	}

	public void setVorigeSpeler(int vorigeSpeler) {
		this.vorigeSpeler = vorigeSpeler;
	}

	public void setSpelendeSpeler() {
		
		for (int i = 0; i < (getAantalSpelendeSpelers()-1); i++) {
			String beurt="";
			if (this.isAfgelopen() == false) {
			if (i==vorigeSpeler) {
				if((i+1)>(getAantalSpelendeSpelers()-1)) {
				setBeurt(volgordenew.get(0));
				this.setVorigeSpeler(0);
				}
				else {
				setBeurt(volgordenew.get(i+1)); 
				this.setVorigeSpeler(i+1);
				}
				}
			else {
				setBeurt(volgordenew.get(i));
				this.setVorigeSpeler(i);
			}
			}else {
				setBeurt(beurt);
				}
		}
		
		 // probleem is tekst is null op spelbord
	}

	public String spelendeSpeler() {
		return getBeurt();

	}
	

	public void verplaats() {

	}

	public void voegSteenToe(int x, int y, int steen) {
			getBord().addSteen(x, y, st.getWaardeSteen(steen));
			st.verwijderSteen(steen);
			
		}
	public int getRandomSteen() {
		return this.st.getRandomSteentje();
		
	}
	public int getWaardeSteen(int steen) {
		return this.st.getWaardeSteen(steen);
	}
		

	/*public int puntenSysteem(int x, int y) {

		getSteenOpBordKolom(grid, x);
		getSteenOpBordRij(grid, y);

		som = som1 + som2;

		if ((som) == 10) {
			punten = 1;
			if (Label.getClassCssMetaData() == black) {
				punten = 2 * 1;
			}
		}

		if ((som) == 11) {
			punten = 2;
			if (Label.getClassCssMetaData() == black) {
				punten = 2 * 2;
			}
		}

		if ((som) == 12) {
			punten = 3;
			if (Label.getClassCssMetaData() == black) {
				punten = 2 * 3;
			}
		}

		return punten;
	}*/


}

