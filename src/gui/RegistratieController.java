package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import domein.DomeinController;
import domein.Gebruiker;
import domein.SpelerRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import persistentie.Mapper;

public class RegistratieController {
	private SpelerRepository sp = new SpelerRepository();
	private DomeinController controller;
	private Gebruiker speler = new Gebruiker();
	private SceneController switch2;
	private Mapper mapper = new Mapper();

	public RegistratieController(DomeinController controller) {
		this.controller = controller;
		this.switch2 = new SceneController(controller);
	}

	@FXML
	private Button gaTerugButton;

	@FXML
	private Button registrerenButton;

	@FXML
	private TextField txtGeboortejaar;

	@FXML
	private TextField txtNaam;

	@FXML
	private Label registratiegelukt;

	@FXML

	private Label gebruikersnaam;

	@FXML
	private Label geboortejaar;

	@FXML
	private Label registratie;

	@FXML
	private Label registratiemisgelukt;


	public void gaTerugButton(ActionEvent event) {
		switch2.SwitchToMenu(event);
	}

	public void vertaal() {
		registrerenButton.setText(DomeinController.vertaal("Registreren"));
		geboortejaar.setText(DomeinController.vertaal("geboortejaar"));
		gebruikersnaam.setText(DomeinController.vertaal("gebruikersnaam"));
		registratie.setText(DomeinController.vertaal("Registratie"));
		gaTerugButton.setText(DomeinController.vertaal("gaTerugButton"));

	}

	public void registratieButtonAction(ActionEvent event) {
		String gebruikersnaam = txtNaam.getText().toString();
		int geboortejaar = Integer.parseInt(txtGeboortejaar.getText());
		Gebruiker nieuweSpeler = new Gebruiker(gebruikersnaam, geboortejaar);
		if (mapper.geefSpeler(gebruikersnaam, geboortejaar) != null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(DomeinController.vertaal("Registratie_mislukt"));
			alert.setHeaderText(null);
			alert.setContentText(DomeinController.vertaal("Deze_naam_bestaat_al"));
			alert.showAndWait();
		} else {
			speler.setGebruikersNaam(gebruikersnaam);
			speler.setGeboorteJaar(geboortejaar);
			this.controller.registreerGebruiker(gebruikersnaam, geboortejaar);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(DomeinController.vertaal("Registratie_geslaagd"));
			alert.setHeaderText(null);
			alert.setContentText(DomeinController.vertaal("Uw_gebruikersnaam") + " : " + speler.getGebruikersNaam()
					+ " " + DomeinController.vertaal("Geboortejaar") + " : " + speler.getGeboorteJaar());
			alert.showAndWait();

			// "Uw gebruikersnaam : " + controller.getGebruikersnaam " geboortejaar: "
			// +controller.getGeboortejaar

			switch2.SwitchToMenu(event);

		}

	}

	// todo Registgreren nodig/gebruikt?
	@FXML
	public void registreren(ActionEvent e) throws IOException {
		SceneController switch2 = new SceneController(this.controller);
		String gebruikersnaam = txtNaam.getText().toString();
		int geboortejaar = Integer.parseInt(txtGeboortejaar.getText());
		Gebruiker nieuweSpeler = new Gebruiker(gebruikersnaam, geboortejaar);
		if (this.controller.meldAan(gebruikersnaam, geboortejaar) == null) {
			speler.setGebruikersNaam(gebruikersnaam);
			speler.setGeboorteJaar(geboortejaar);
			this.controller.registreerGebruiker(gebruikersnaam, geboortejaar);
			switch2.SwitchToMenu(e);
			;
		}

		// controller.setSpeler(nieuweSpeler);;
		speler.setGebruikersNaam(txtNaam.getText().toString());
		speler.setGeboorteJaar(Integer.parseInt(txtGeboortejaar.getText()));

		this.controller.registreerGebruiker(speler.getGebruikersNaam(), speler.getGeboorteJaar());
		// sp.voegToe(nieuweSpeler);

	}
}