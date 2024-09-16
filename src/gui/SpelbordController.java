package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import domein.DomeinController;
import domein.Spel;
import domein.Steentje;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SpelbordController {
	private DomeinController controller;
	private Scoreblad scoreblad;
	private Stage stage;
	private SceneController switch2;
	private Spel spel;
	private ScorebladController sc;
	private int som = 0;

	@FXML
	private Button Scoreblad1;
	@FXML
	private Button Scoreblad2;
	@FXML
	private Button Scoreblad3;
	@FXML
	private Button Scoreblad4;
	@FXML
	private Button stoppen;
	@FXML
	private Button Beginnen;
	@FXML
	private Button skip;
	@FXML
	private ImageView steen1;
	@FXML
	private ImageView steen2;
	@FXML
	private ImageView steen3;
	@FXML
	private Label steen1l;
	@FXML
	private Label steen2l;
	@FXML
	private Label steen3l;
	@FXML
	private ImageView wit;
	@FXML
	private ImageView zwart;
	@FXML
	private Label spelendespeler;
	@FXML
	private Label white;
	@FXML
	private Label black;
	@FXML
	private Label black1;
	@FXML
	private GridPane grid;
	@FXML
	private GridPane steengrid;

	Image s1 = new Image(getClass().getResource("/images/dobbelsteen1.jpeg").toExternalForm(), 59, 49, true, true);
	Image s2 = new Image(getClass().getResource("/images/dobbelsteen2.jpeg").toExternalForm(), 59, 49, true, true);
	Image s3 = new Image(getClass().getResource("/images/dobbelsteen3.jpeg").toExternalForm(), 59, 49, true, true);
	Image s4 = new Image(getClass().getResource("/images/dobbelsteen4.jpeg").toExternalForm(), 59, 49, true, true);
	Image s5 = new Image(getClass().getResource("/images/dobbelsteen5.jpeg").toExternalForm(), 59, 49, true, true);
	Image s6 = new Image(getClass().getResource("/images/dobbelsteen6.jpeg").toExternalForm(), 59, 49, true, true);
	Image blank = new Image(getClass().getResource("/images/blank.jpeg").toExternalForm(), 59, 49, true, true);

	int i = 0;
	int welkeSteen1 = -1;
	int welkeSteen2 = -1;
	int welkeSteen3 = -1;

	public SpelbordController(DomeinController controller) {
		this.controller = controller;
		this.switch2 = new SceneController(controller);
		this.spel = controller.getSpel();
		
	}

	public void vertaal() {
		stoppen.setText(DomeinController.vertaal("Stoppen"));
		Beginnen.setText(DomeinController.vertaal("beginnen"));
		Scoreblad1.setText(DomeinController.vertaal("Scoreblad_1"));
		Scoreblad2.setText(DomeinController.vertaal("Scoreblad_2"));
		Scoreblad3.setText(DomeinController.vertaal("Scoreblad_3"));
		Scoreblad4.setText(DomeinController.vertaal("Scoreblad_4"));
		skip.setText(DomeinController.vertaal("Beurt_overslaan"));

	}

	public void scorebladen() {
		if (spel.getAantalSpelendeSpelers() == 2) {
			Scoreblad3.setVisible(false);
			Scoreblad4.setVisible(false);
		} else if (spel.getAantalSpelendeSpelers() == 3) {
			Scoreblad4.setVisible(false);
		}
	}

	public Image toonImage(int steen) {
		if (steen == 1) {
			return s1;
		} else if (steen == 2) {
			return s2;
		} else if (steen == 3) {
			return s3;
		} else if (steen == 4) {
			return s4;
		} else if (steen == 5) {
			return s5;
		} else if (steen == 6) {
			return s6;
		} else
			return blank;
	}

	public void initialize(URL location, ResourceBundle resources) {

	}

	int som1;

	private Node getSteenOpBordRij(GridPane grid, int row) { // code klopt niet
		grid = target;
		int getal = 0;
		som1 = getal;

		if (node instanceof ImageView) {
			if (lbl.getImage() == s1) {
				getal += 1;
			}

			if (lbl.getImage() == s2) {
				getal += 2;
			}

			if (lbl.getImage() == s3) {
				getal += 3;
			}

			if (lbl.getImage() == s4) {
				getal += 4;
			}

			if (lbl.getImage() == s5) {
				getal += 5;
			}

			if (lbl.getImage() == s6) {
				getal += 6;
			}

//			scoreblad.waardeScorelbad(som1);

		}

		return null;
	}

	int som2;

	private Node getSteenOpBordKolom(GridPane grid, int col) { // code klopt niet
		grid = target;
		int getal = 0;
		som2 = getal;

		if (node instanceof ImageView) {
			if (lbl.getImage() == s1) {
				getal += 1;
			}

			if (lbl.getImage() == s2) {
				getal += 2;
			}

			if (lbl.getImage() == s3) {
				getal += 3;
			}

			if (lbl.getImage() == s4) {
				getal += 4;
			}

			if (lbl.getImage() == s5) {
				getal += 5;
			}

			if (lbl.getImage() == s6) {
				getal += 6;
			}

//			scoreblad.waardeScorelbad(som);

		}

		return null;
	}

	String beurt;

	@FXML
	public void beginnen(ActionEvent e) {
		Beginnen.setVisible(false);
		welkeSteen1 = controller.getRandomSteen();
		welkeSteen2 = controller.getRandomSteen();
		welkeSteen3 = controller.getRandomSteen();
		steen1.setImage(this.toonImage(controller.getWaardeSteen(welkeSteen1)));
		steen2.setImage(this.toonImage(controller.getWaardeSteen(welkeSteen2)));
		steen3.setImage(this.toonImage(controller.getWaardeSteen(welkeSteen3)));
		spel.beginnendeSpeler();
		spel.spelervolgorde();
		beurt = this.spel.volgordenew.get(0);
		spel.setVorigeSpeler(0);
		spelendespeler.setText("" + this.spel.volgordenew.get(0)); // code moet nog geschreven
		// worden

		
	}

	@FXML
	private void dragOver(DragEvent event) {
		//if (event.getDragboard().hasImage()) {
		//	event.acceptTransferModes(TransferMode.ANY);
		//}

	}

	@FXML
	private void dragDropped(DragEvent event) {
		//event.getDragboard().getImage();
	}

	@FXML
	private void dragDetectie1(MouseEvent event) {
		Dragboard db = steen1.startDragAndDrop(TransferMode.MOVE);
		ClipboardContent cb = new ClipboardContent();
		cb.putImage(steen1.getImage());
		db.setContent(cb);

	}

	@FXML
	private void dragDetectie2(MouseEvent event) {
		Dragboard db = steen2.startDragAndDrop(TransferMode.ANY);

		ClipboardContent cb = new ClipboardContent();

		cb.putImage(steen2.getImage());

		db.setContent(cb);

	}

	@FXML
	private void dragDetectie3(MouseEvent event) {
		Dragboard db = steen3.startDragAndDrop(TransferMode.ANY);

		ClipboardContent cb = new ClipboardContent();

		cb.putImage(steen3.getImage());

		db.setContent(cb);

	}

	/*@FXML
	private void dragDone1(DragEvent event) {
		steen1.setImage(blank);

	}

	@FXML
	private void dragDone2(DragEvent event) {
		steen2.setImage(blank);
	}

	@FXML
	private void dragDone3(DragEvent event) {
		
		steen3.setImage(blank);

	}*/

	@FXML
	private void textDragOver(DragEvent event) {
		if (event.getDragboard().hasImage()) {
			event.acceptTransferModes(TransferMode.ANY);
		}
	}

	final GridPane target = grid;
	ImageView lbl;
	int x;
	int y;
	Node node;

	@FXML
	private void textDrop(DragEvent e) {
		boolean success = false;
		int steen = -1;
		node = e.getPickResult().getIntersectedNode();
		if (e.getGestureSource() == this.steen1)
			steen = welkeSteen1;
		else if (e.getGestureSource() == this.steen2)
			steen = welkeSteen2;
		else if (e.getGestureSource() == this.steen3)
			steen = welkeSteen3;

		if (node != target) {
			Integer cIndex = GridPane.getColumnIndex(node);
			Integer rIndex = GridPane.getRowIndex(node);
			x = cIndex == null ? 0 : cIndex;
			y = rIndex == null ? 0 : rIndex;
			try {
				System.out.println(x + " " + y + " " + steen);
				this.controller.voegSteenToe(x, y, steen);
				Image str = e.getDragboard().getImage();
				lbl = new ImageView();
				lbl.setImage(str);
				grid.add(lbl, x, y, 1, 1);
				success = true;
				if (e.getGestureSource() == this.steen1)
					steen1.setImage(blank);
				else if (e.getGestureSource() == this.steen2)
					steen2.setImage(blank);
				else if (e.getGestureSource() == this.steen3)
					steen3.setImage(blank);
				// vorige steen wordt verwijderd dus eentje aftrekken van plaats andere stenen
				if (steen < welkeSteen1)
					welkeSteen1--;
				if (steen < welkeSteen2)
					welkeSteen2--;
				if (steen < welkeSteen3)
					welkeSteen3--;
				//getSteenOpBordKolom(target, x);
				//getSteenOpBordRij(target, y);
				// puntenSysteem();
				// System.out.println(puntenSysteem());
				// sc.getScore();
				
				i++;
			} catch (Exception exept) {
				System.out.println(exept.toString());
			}
			e.setDropCompleted(success);
			e.consume();
		}

		
		// nieuwe code

	}

	@FXML
	public void skip(ActionEvent event) {
		// steen1l.setVisible(false);
		// steen2l.setVisible(false);
		steen3l.setVisible(false);
		welkeSteen1 = controller.getRandomSteen();
		welkeSteen2 = controller.getRandomSteen();
		steen1.setImage(this.toonImage(controller.getWaardeSteen(welkeSteen1)));
		System.out.println(welkeSteen1);
		System.out.println(welkeSteen2);
		steen2.setImage(this.toonImage(controller.getWaardeSteen(welkeSteen2)));

		spel.setSpelendeSpeler();
		spelendespeler.setText("" + spel.spelendeSpeler());
	}

	@FXML
	public void stoppen(ActionEvent event) {
		switch2.SwitchToMenu(event);
	}

	@FXML
	public void SwitchToScoreblad1(ActionEvent event) throws IOException {

		Stage stage;
		Parent root;

		if (event.getSource() == Scoreblad1) {
			stage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("scoreblad.fxml"));
			ScorebladController scr = new ScorebladController(controller);
			loader.setController(scr);
			root = loader.load();
			scr.vertaal();
			stage.setScene(new Scene(root));
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(Scoreblad1.getScene().getWindow());
			stage.showAndWait();
		}
	}

	public void SwitchToScoreblad2(ActionEvent event) throws IOException {

		Stage stage;
		Parent root;

		if (event.getSource() == Scoreblad2) {
			stage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("scoreblad.fxml"));
			ScorebladController scr = new ScorebladController(controller);
			loader.setController(scr);
			root = loader.load();
			scr.vertaal();
			stage.setScene(new Scene(root));
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(Scoreblad2.getScene().getWindow());
			stage.showAndWait();
		}
	}

	public void SwitchToScoreblad3(ActionEvent event) throws IOException {

		Stage stage;
		Parent root;

		if (event.getSource() == Scoreblad3) {
			stage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("scoreblad.fxml"));
			ScorebladController scr = new ScorebladController(controller);
			loader.setController(scr);
			root = loader.load();
			scr.vertaal();
			stage.setScene(new Scene(root));
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(Scoreblad3.getScene().getWindow());
			stage.showAndWait();
		}
	}

	public void SwitchToScoreblad4(ActionEvent event) throws IOException {

		Stage stage;
		Parent root;

		if (event.getSource() == Scoreblad4) {
			stage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("scoreblad.fxml"));
			ScorebladController scr = new ScorebladController(controller);
			loader.setController(scr);
			root = loader.load();
			scr.vertaal();
			stage.setScene(new Scene(root));
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(Scoreblad4.getScene().getWindow());
			stage.showAndWait();
		}

	}

	public void GameOver(ActionEvent event) throws IOException {
		// zou ervoor moeten zorgen dat na 121 steentjes spel stopt.
		// werkt niet
		if (i == 121) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("scoreblad.fxml"));
			ScorebladController scr = new ScorebladController(controller);
			loader.setController(scr);
			Parent root = loader.load();
			scr.vertaal();
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}

		/*
		 * // voor bij demo if (i == 10) { FXMLLoader loader = new
		 * FXMLLoader(getClass().getResource("scoreblad.fxml")); ScorebladController scr
		 * = new ScorebladController(controller); loader.setController(scr); Parent root
		 * = loader.load(); scr.vertaal(); stage = (Stage) ((Node)
		 * event.getSource()).getScene().getWindow(); Scene scene = new Scene(root);
		 * stage.setScene(scene); stage.show(); }
		 */

	}

}
