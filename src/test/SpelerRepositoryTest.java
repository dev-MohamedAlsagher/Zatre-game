package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Gebruiker;
import domein.SpelerRepository;

class SpelerRepositoryTest {

	private SpelerRepository repository;

	@BeforeEach
	public void beforeEach() {
		repository = new SpelerRepository();
	}

	@Test
	public void voegToe_exception(Gebruiker speler) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> repository.voegToe(speler));

	}

}