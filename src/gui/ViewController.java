package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class ViewController {
	
	@FXML
	private Button btTest;
	
	//Criando a ação de clicar no Botão
	@FXML
	public void onBtTestAction() {
		System.out.println("Click");
		Alerts.showAlert("Alert Title", "Alert Header", "Hello", AlertType.INFORMATION);
	}

}
