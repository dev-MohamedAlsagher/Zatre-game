package gui;

import java.net.URL;
import java.util.ResourceBundle;

import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TaalController {
	private SceneController switch2;
	private DomeinController controller;

	public TaalController(DomeinController controller) {
		this.controller = controller;
		this.switch2 = new SceneController(controller);
	}

	@FXML
	private Button nederlands;
	@FXML
	private Button engels;

	public void nederlands(ActionEvent actionevent1) {
		DomeinController.kiesTaal(1);
		// Stage stage = (Stage) taalHoofdscherm.getScene().getWindow();
		switch2.SwitchToMenu(actionevent1);
		// this.start(stage);
	}

	public void engels(ActionEvent actionevent1) {
		DomeinController.kiesTaal(2);
		// Stage stage = (Stage) taalHoofdscherm.getScene().getWindow();
		switch2.SwitchToMenu(actionevent1);
		// this.start(stage);
	}

}
