package gui;

import domein.DomeinController;
import domein.Gebruiker;
import domein.Spel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AanmeldenController {
	private SceneController switch2;
	private DomeinController controller;
	private Gebruiker gb;

	public AanmeldenController(DomeinController controller) {
		this.controller = controller;
		this.switch2 = new SceneController(controller);
		this.gb = new Gebruiker();
	}

	private Spel spel = new Spel();
	String gebruikersnaam1;
	int geboortejaar1;
	int i = 0;
	// <>

	@FXML
	private Button login;
	@FXML
	private Button Spelen;
	@FXML
	private Button gaTerugButton;
	@FXML
	private Label loginFaalt;
	@FXML
	private Label gebruiker1;
	@FXML
	private Label gebruiker2;
	@FXML
	private Label gebruiker3;
	@FXML
	private Label gebruiker4;
	@FXML
	private Label Geboortejaar;

	@FXML
	private Label Gebruikersnaam;

	@FXML
	private Button loginButton;

	@FXML
	private Label loginLabel;

	@FXML
	private TextField gebruikersnaam;

	@FXML
	private TextField geboortejaar;

	@FXML
	private Label loginGelukt;

	public void vertaal() {
		loginButton.setText(DomeinController.vertaal("Login"));
		Geboortejaar.setText(DomeinController.vertaal("geboortejaar"));
		Gebruikersnaam.setText(DomeinController.vertaal("gebruikersnaam"));
		loginLabel.setText(DomeinController.vertaal("Login"));
		gaTerugButton.setText(DomeinController.vertaal("<_Ga_terug"));
	}

	public void gaTerugButton(ActionEvent event) {
		switch2.SwitchToMenu(event);
	}

	/*
	 * public void gaTerugButton(ActionEvent event) { switch2.SwitchToMenu(event); }
	 */
	public void login(ActionEvent event) {

		// aanmelden probleem
		// login werkt met elke geboortejaar dat je invult
		// label kan niet gebruikersnaam tonen

		loginGelukt.setText("");
		loginFaalt.setText("");
		gebruikersnaam1 = gebruikersnaam.getText().toString();
		geboortejaar1 = Integer.parseInt(geboortejaar.getText());
		if (this.controller.meldAan(gebruikersnaam1, geboortejaar1) != null && this.controller
				.meldAan(gebruikersnaam1, geboortejaar1).getSpeelKansen(gebruikersnaam1, geboortejaar1) > 1) {
			Gebruiker nieuweSpeler = new Gebruiker(gebruikersnaam1, geboortejaar1);
			if (!spel.spelers.contains(nieuweSpeler)) {
				this.controller.setSpeler(nieuweSpeler);
				spel.setSpelendeSpeler(nieuweSpeler);
				loginGelukt.setText(DomeinController.vertaal("u_bent_ingelogd"));
				gebruiker1.setText(spel.getSpelendeSpelers().toString());
				gb.speelkansenSpel(gebruikersnaam1, geboortejaar1);
				System.out.println("" + gb.getSpeelKansen(gebruikersnaam1, geboortejaar1));
			} else
				loginFaalt.setText(DomeinController.vertaal("Gebruiker_is_al_ingelogd"));

			if (this.controller.meldAan(gebruikersnaam1, geboortejaar1) == null) {
				loginFaalt.setText(DomeinController.vertaal("Gebruiker_bestaat_niet"));
			}
			if (spel.getAantalSpelendeSpelers() >= 2) {
				Spelen.setVisible(true);
			}
			if (spel.getAantalSpelendeSpelers() == 4) {
				login.setVisible(false);
				loginFaalt.setText(DomeinController.vertaal("Je_kan_max_met_4 spelers_inloggen"));
			}

		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(DomeinController.vertaal("Aanmelden_mislukt"));
			alert.setHeaderText(null);
			alert.setContentText(DomeinController.vertaal("Deze_speler_is_nog_niet_geregistreerd"));
			alert.showAndWait();

		}
	}

	public void Spelen(ActionEvent event) {
		switch2.SwitchToSpel(event);
	}
}
