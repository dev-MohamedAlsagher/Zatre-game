package gui;

import domein.DomeinController;
import javafx.application.Application;
import javafx.stage.Stage;

public class StartUp extends Application {

	private DomeinController controller = new DomeinController();

	@Override
	public void start(Stage stage) {

		SceneController switch2 = new SceneController(controller);
		this.controller.kiesTaal(1);
		stage.setTitle("Zatre");
		Beginscherm beginnen = new Beginscherm(controller, switch2);
		beginnen.start(stage);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
