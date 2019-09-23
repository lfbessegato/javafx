package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import model.entities.Person;

public class ViewController implements Initializable {

	// Exemplo de ComboBox
	@FXML
	private ComboBox<Person> cmbPerson;
	
	@FXML
	private Button btnAll;

	// Associada com o objeto ComboBox
	private ObservableList<Person> obsList;

	// Exemplo TextFields
	@FXML // Para Associar com a tela
	private TextField txtNumber1;

	@FXML
	private TextField txtNumber2;

	@FXML
	private Label lblResult;

	@FXML
	private Button btSum;

	@FXML
	public void onBtSumAction() {
		try {
			Locale.setDefault(Locale.US);
			double number1 = Double.parseDouble(txtNumber1.getText());
			double number2 = Double.parseDouble(txtNumber2.getText());

			double sum = number1 + number2;
			lblResult.setText(String.format("%.2f", sum));
		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse Error", e.getMessage(), AlertType.ERROR);
		}

	}

	@FXML
	private Button btTest;

	// Criando a ação de clicar no Botão
	@FXML
	public void onBtTestAction() {
		System.out.println("Click");
		Alerts.showAlert("Alert Title", "Alert Header", "Hello", AlertType.INFORMATION);
	}
	
	@FXML
	public void oncmbPersonAction() {
		//Selecionar o item no ComboBox
		Person person = cmbPerson.getSelectionModel().getSelectedItem();
		System.out.println(person);
	}
	
	@FXML
	public void onBtnAllAction() {
		for (Person person : cmbPerson.getItems()) {
			System.out.println(person);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// url -> Caminho da sua tela
		// ResourceBundle -> Recursos que podem ser usados em sua implementação

		List<Person> list = new ArrayList<>();
		list.add(new Person(1, "Maria", "maria@gmail.com"));
		list.add(new Person(2, "Alex", "alex@gmail.com"));
		list.add(new Person(3, "Bob", "bob@gmail.com"));

		// Instancia a Observable List
		obsList = FXCollections.observableArrayList(list);

		// Carrega os elementos ao ComboBox
		cmbPerson.setItems(obsList);

		Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
			@Override
			protected void updateItem(Person item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};
		cmbPerson.setCellFactory(factory);
		cmbPerson.setButtonCell(factory.call(null));

		// Será executado na inicialização do Controlador
		Constraints.setTextFieldDouble(txtNumber1);
		Constraints.setTextFieldDouble(txtNumber2);
		Constraints.setTextFieldMaxLength(txtNumber1, 5);
		Constraints.setTextFieldMaxLength(txtNumber2, 5);

	}

}
