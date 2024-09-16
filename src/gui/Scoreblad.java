package gui;

import domein.DomeinController;

public class Scoreblad {

	private String maalTwee = "";
	private String somTien = "";
	private String somElf = "";
	private String SomTwaalf = "";
	private boolean grijs;
	private boolean wit;
	private int Bonus;
	private DomeinController controller;
	private ScorebladController scorecontroller;

	public Scoreblad(int bonus, String maalTwee, String somTien, String somElf, String SomTwaalf) {
		 this.Bonus = bonus;
		 this.maalTwee = maalTwee;
		 this.somTien = somTien;
		 this.somElf = somElf;
		 this.SomTwaalf = SomTwaalf;
	}
	

	public String getMaalTwee() {
		if (!maalTwee.isEmpty())
			return maalTwee;
		return null;
	}

	public String getSomTien() {
		return somTien;
	}

	public String getSomElf() {
		return somElf;
	}

	public String getSomTwaalf() {
		return SomTwaalf;
	}

	public boolean isGrijs() {
		return grijs;
	}

	public boolean isWit() {
		return wit;
	}

	public int getBonus() {
		return Bonus;
	}

	public void waardeScorelbad(int punten) {
		if (punten == 1) {
			this.somTien = "X";
			System.out.println(this.somTien);
		}

		if (punten == 2) {
			this.somElf = "X";
		}

		if (punten == 3) {
			this.somElf = "X";
		}

		if (punten == 4) {
			this.maalTwee = "X";
		}
		if (punten == 6) {
			this.maalTwee = "X";
		}
		if (punten == 8) {
			this.maalTwee = "X";
		}

		scoreblad();

	}

	public void scoreblad() {
		scorecontroller.list
				.add(new Scoreblad(6, "" + getMaalTwee(), "" + getSomTien(), "" + getSomElf(), "" + getSomTwaalf()));
	}

	public int score() {
		int score = 0;
		if (!somTien.isEmpty())
			score++;
		if (!somElf.isEmpty()) {
			score += 2;
		}
		if (!SomTwaalf.isEmpty()) {
			score += 4;
		}
		if (!maalTwee.isEmpty()) {
			score *= 2;
		}

		return score;

	}
}
