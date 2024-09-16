package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import domein.DomeinController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HoofdSchermController {

	private Stage stage;
	private DomeinController controller;

	public HoofdSchermController(DomeinController controller) {
		this.controller = controller;
	}

	@FXML
	private Button spelen;
	@FXML
	private Button registreren;
	@FXML
	private Button exit;

	public void vertaal() {
		spelen.setText(DomeinController.vertaal("Spelen"));
		registreren.setText(DomeinController.vertaal("Registreren"));
		exit.setText(DomeinController.vertaal("Stoppen"));

	}

	public void SwitchToRegistratie(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("registratie.fxml"));
			RegistratieController rc = new RegistratieController(controller);
			loader.setController(rc);
			Parent root = loader.load();
			rc.vertaal();
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void SwitchToSpelen(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("aanmelden.fxml"));
			AanmeldenController amc = new AanmeldenController(controller);
			loader.setController(amc);
			Parent root = loader.load();
			amc.vertaal();
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void exit(ActionEvent event) {
		Platform.exit();
	}
}
