package gui;

import java.net.URL;
import java.util.ResourceBundle;

import domein.DomeinController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ScorebladController implements Initializable {
	private DomeinController controller;

	private SceneController switch2 = new SceneController(controller);
	//private SpelbordController sc = new SpelbordController(controller);
	private Scoreblad scoreblad;

	int totaal;

	public ScorebladController(DomeinController controller) {
		this.controller = controller;
		this.switch2 = new SceneController(controller);
	}
	

	@FXML
	private TableColumn<Scoreblad, Integer> Bonus;

	@FXML
	private TableColumn<Scoreblad, Integer> Totaal;
	@FXML
	private TableColumn<Scoreblad, String> maalTwee;
	@FXML
	private TableColumn<Scoreblad, String> somElf;
	@FXML
	private TableColumn<Scoreblad, String> somTien;
	@FXML
	private TableColumn<Scoreblad, String> somTwaalf;
	@FXML
	private TableView<Scoreblad> tabel;
	@FXML
	private TextField totaalScore;
	@FXML
	private Button terugButton;
	@FXML
	private Label hoofding;

	@FXML
	void gaTerug(ActionEvent event) {
		Stage stage = (Stage) terugButton.getScene().getWindow();
		stage.close();
	}

	public void vertaal() {
		hoofding.setText(DomeinController.vertaal("Scoreblad"));
		terugButton.setText(DomeinController.vertaal("<_Ga_terug"));
	}
	

	ObservableList<Scoreblad> list = FXCollections.observableArrayList(new Scoreblad(3, "", "", "", ""),
			new Scoreblad(3, "", "", "", ""), new Scoreblad(3, "", "", "", ""), new Scoreblad(3, "", "", "", ""),
			new Scoreblad(4, "", "", "", ""), new Scoreblad(4, "", "", "", ""), new Scoreblad(4, "", "", "", ""),
			new Scoreblad(4, "", "", "", ""), new Scoreblad(5, "", "", "", ""), new Scoreblad(5, "", "", "", ""),
			new Scoreblad(5, "", "", "", ""), new Scoreblad(5, "", "", "", ""), new Scoreblad(6, "", "", "", ""),
			new Scoreblad(6, "", "", "", ""), new Scoreblad(6, "", "", "", ""), new Scoreblad(6, "", "", "", ""),
			new Scoreblad(6, "", "", "", ""));

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		Bonus.setCellValueFactory(new PropertyValueFactory<Scoreblad, Integer>("Bonus"));
		Totaal.setCellValueFactory(new PropertyValueFactory<Scoreblad, Integer>("Totaal"));
		maalTwee.setCellValueFactory(new PropertyValueFactory<Scoreblad, String>("maalTwee"));
		somElf.setCellValueFactory(new PropertyValueFactory<Scoreblad, String>("somElf"));
		somTien.setCellValueFactory(new PropertyValueFactory<Scoreblad, String>("somTien"));
		somTwaalf.setCellValueFactory(new PropertyValueFactory<Scoreblad, String>("SomTwaalf"));

		
		tabel.setItems(list);

	}
	
	
}
