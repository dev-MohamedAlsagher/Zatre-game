package domein;

import java.util.ArrayList;
import java.util.Arrays;

public class Bord {
	private Integer[][] bord = new Integer[13][13];
	private ArrayList<String[]> scorebord = new ArrayList<String[]>();

	public Integer[][] getBord() {
		return bord;
	}

	public void addSteen(int x, int y, Integer waarde) {
		System.out.println(x + " " + y + " " + waarde);
		if (this.bord[6][6] == null) {
			if (x != 6 || y != 6)
				throw new IllegalArgumentException("Eerste steen moet in midden liggen");
			else {
				if (this.bord[x][y] == null) {
					this.bord[x][y] = waarde;
					this.maakScore(x, y, waarde);
				}
			}
		} else if (x == y || (x + y == 12)) {
			System.out.println("H;" + this.somHorizontaal(x, y));
			System.out.println("V;" + this.somVerticaal(x, y));
			if (this.somHorizontaal(x, y) + waarde < 10 && this.somVerticaal(x, y) + waarde < 10)
				throw new IllegalArgumentException("Zwart mag enkel bij som van 10 of meer");
			else if (this.bord[x - 1][y] != null || this.bord[x + 1][y] != null || this.bord[x][y + 1] != null
					|| this.bord[x][y - 1] != null) {
				if (this.somHorizontaal(x, y) + waarde > 12 || this.somVerticaal(x, y) + waarde > 12) {
					throw new IllegalArgumentException("Waarde mag nie hoger zijn dan 12");
				}
				if (this.bord[x][y] == null) {
					this.bord[x][y] = waarde;
					this.maakScore(x, y, waarde);
				} else
					throw new IllegalArgumentException("Hier licht al een steen");
			} else
				throw new IllegalArgumentException("Steen moet naast andere steen liggen");
		} else if (this.bord[x - 1][y] != null || this.bord[x + 1][y] != null || this.bord[x][y + 1] != null
				|| this.bord[x][y - 1] != null) {
			if (this.somHorizontaal(x, y) + waarde > 12 || this.somVerticaal(x, y) + waarde > 12) {
				throw new IllegalArgumentException("Waarde mag nie hoger zijn dan 12");
			}
			if (this.bord[x][y] == null) {
				this.bord[x][y] = waarde;
				this.maakScore(x, y, waarde);
			} else
				throw new IllegalArgumentException("Hier licht al een steen");
		} else
			throw new IllegalArgumentException("Steen moet naast andere steen liggen");
	}

	private void maakScore(int x, int y, Integer waarde) {
		int horWaarde = this.somHorizontaal(x, y) + waarde;
		int verWaarde = this.somVerticaal(x, y) + waarde;
		String is10 = null, is11 = null, is12 = null;
		if (horWaarde == 10 || verWaarde == 10) {
			is10 = "X";
		}
		if (horWaarde == 11 || verWaarde == 11) {
			is11 = "X";
		}
		if (horWaarde == 12 || verWaarde == 12) {
			is12 = "X";
		}
		if (is10 != null || is11 != null || is12 != null) {
			scorebord.add(new String[4]);
			scorebord.get(scorebord.size() - 1)[1] = is10;
			scorebord.get(scorebord.size() - 1)[2] = is11;
			scorebord.get(scorebord.size() - 1)[3] = is12;
			if (x == y || (x + y == 12)) {
				scorebord.get(scorebord.size() - 1)[0] = "X";
			}
			System.out.println("add:"+scorebord.get(scorebord.size() - 1)[0] + scorebord.get(scorebord.size() - 1)[1] +scorebord.get(scorebord.size() - 1)[2]+scorebord.get(scorebord.size() - 1)[3]);
		}
		

	}

	private int somHorizontaal(int x, int y) {
		int som = 0, kolom = x;

		while (kolom > 0 && (this.bord[kolom - 1][y] != null)) {
			som += this.bord[kolom - 1][y];
			kolom--;
		}
		kolom = x;
		while (kolom < 12 && (this.bord[kolom + 1][y] != null)) {
			som += this.bord[kolom + 1][y];
			kolom++;
		}
		return som;
	}

	private int somVerticaal(int x, int y) {
		int som = 0, rij = y;

		while (rij > 0 && (this.bord[x][rij - 1] != null)) {
			som += this.bord[x][rij - 1];
			rij--;
		}
		rij = y;
		while (rij < 12 && (this.bord[x][rij + 1] != null)) {
			som += this.bord[x][rij + 1];
			rij++;
		}
		return som;
	}

}
