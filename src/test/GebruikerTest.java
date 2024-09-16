package test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Gebruiker;

class GebruikerTest {

	private Gebruiker gebruiker;

	private static final int geboorteJaarOK = 2001;
	private static final String gebruikersnaamOK = "Benjamin";

	@BeforeEach
	public void beforeEach() {
		gebruiker = new Gebruiker(gebruikersnaamOK, geboorteJaarOK);
	}

	@ParameterizedTest
	@ValueSource(Strings = { "Ronald", "JanDeMan", "Jos123", "ron12" })
	public void maakGebruikersnaam_GeldigeNaam_geenExeption(String juist) {
		Assertions.assertDoesNotThrow(() -> new Gebruiker(juist, geboorteJaarOK));
	}

	@ParameterizedTest
	@ValueSource(Strings = { "", "ben", "jory", "      " })
	public void maakGebruikersnaam_GeldigeNaam_exeption(String fout) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Gebruiker(fout, geboorteJaarOK));
	}

	@ParameterizedTest
	@ValueSource(ints = { 2016, 2000, 1900 })
	public void maakGeboorteJaar_geldigeGeboorteJaar_geenExeption(int juist) {
		Assertions.assertDoesNotThrow(() -> new Gebruiker(gebruikersnaamOK, juist));
	}

	@ParameterizedTest
	@ValueSource(ints = { 2017, 2023, 3001 })
	public void maakGeboorteJaar_geldigeGeboorteJaar_exeption(int fout) {
		Assertions.assertDoesNotThrow(() -> new Gebruiker(gebruikersnaamOK, fout));
	}

	@Test
	public void geefGeboorteJaar_retourneertGeboorteJaar() {
		int geboorteJaar = gebruiker.getGeboorteJaar();
		Assertions.assertEquals(2001, geboorteJaar);
	}

	@Test
	public void geefSpeelKansen_retourneertSpeelKansen() {
		double speelKansen = gebruiker.getSpeelKansen(gebruikersnaamOK, geboorteJaarOK);
		Assertions.assertEquals(5, speelKansen);
	}

	@Test
	public void heeftVoldoendeSpeelkansen_heeftVoldoendeSpeelkansen_retourneerdTrue() {
		Assertions.assertTrue(gebruiker.heeftVoldoendeSpeelkansen("0"));
	}

	@Test
	public void isWinnaar_retourneertTrue() {
		Assertions.assertTrue(gebruiker.isWinnaar(true));
	}

	@Test
	public void isNietWinnaar_retourneertFalse() {
		Assertions.assertFalse(gebruiker.isWinnaar(false));
	}

}
