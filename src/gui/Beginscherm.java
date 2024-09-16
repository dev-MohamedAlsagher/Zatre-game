package gui;

import java.io.IOException;

import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Beginscherm {
	private SceneController switch2;
	private DomeinController controller;

	@FXML
	private Button beginnen;

	public Beginscherm(DomeinController controller, SceneController switch2) {
		this.controller = controller;
		this.switch2 = switch2;
	}

	public void start(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("beginnen.fxml"));
			loader.setController(this);
			Parent root = loader.load();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void SwitchToTaalScherm(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("taalscherm.fxml"));
			loader.setController(new TaalController(controller));
			Parent root = loader.load();
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}