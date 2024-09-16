package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Gebruiker;
import domein.Spel;

class SpelTest {

private Spel spel;
	
	private static final int AantalSpelendeSpelersOK = 4;
	private static final String gebruikersnaamOK = "SpelendeSppeler";
	
	
	@BeforeEach
	public void beforeEach() {
		spel = new Spel();
	}
	@Test
	public void geefAantalSpelendeSpelers_retourneertAantalSpelendeSpelers() {
		int aantalSpelendeSpelers = spel.getAantalSpelendeSpelers();
		Assertions.assertEquals(AantalSpelendeSpelersOK, aantalSpelendeSpelers);
	}
	@Test
	public void aantalSteentjesNul_spelIsAfgelopen_retourneertTrue() {
		Assertions.assertTrue(spel.isAfgelopen());
	}
	@Test
	public void aantalSteentjesNietNul_spelIsNietAfgelopen_retourneertFalse() {
		Assertions.assertFalse(spel.isAfgelopen());
	}

}
