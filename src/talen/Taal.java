package talen;

import java.util.Locale;
import java.util.ResourceBundle;

public class Taal {
	public static ResourceBundle mybundle;
	public static Locale locale;

	public static void kiesTaal(int keuze) {
		if (keuze == 1) {
			Locale.setDefault(new Locale("nl", "BE"));
		} else if (keuze == 2) {
			Locale.setDefault(new Locale("en", "US"));
		
		}

		mybundle = ResourceBundle.getBundle("talen.lang", Locale.getDefault());

	}
	public static String vertaal(String vertaling) {
		return mybundle.getString(vertaling);
	}

}
