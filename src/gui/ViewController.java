package gui;

import java.util.Locale;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController {
	
	//Exemplo TextFields
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
		}
		catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse Error", e.getMessage(), AlertType.ERROR);
		}
		
		
	}
	
	@FXML
	private Button btTest;
	
	//Criando a ação de clicar no Botão
	@FXML
	public void onBtTestAction() {
		System.out.println("Click");
		Alerts.showAlert("Alert Title", "Alert Header", "Hello", AlertType.INFORMATION);
	}

}
