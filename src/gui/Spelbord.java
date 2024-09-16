package gui;

import java.io.IOException;

import domein.DomeinController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Spelbord {
	private DomeinController controller;
	private SceneController switch2;

	public Spelbord(DomeinController controller, SceneController switch2) {
		this.controller = controller;
		this.switch2 = switch2;

	}

	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Spelbord.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
		
		
	}

}
