package cambiodivisa;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CambioDivisa extends Application {

	TextField dineroTextField;
	TextField dineroTextField2;
	ComboBox<String> divisaComboBox;
	ComboBox<String> divisaComboBox2;
	Button cambiarButton;

	@Override
	public void start(Stage primaryStage) throws Exception {

		dineroTextField = new TextField();
		dineroTextField.setPromptText("0");
		dineroTextField.setMaxWidth(80);

		dineroTextField2 = new TextField();
		dineroTextField2.setPromptText("0");
		dineroTextField2.setMaxWidth(80);
		dineroTextField2.setDisable(true);

		divisaComboBox = new ComboBox<String>();
		divisaComboBox.getItems().addAll("Euro","Dolar","Yen","Libra");
		divisaComboBox.setPromptText("Euro");

		divisaComboBox2 = new ComboBox<String>();
		divisaComboBox2.getItems().addAll("Euro","Dolar","Yen","Libra");
		divisaComboBox2.setPromptText("Dolar");

		cambiarButton = new Button("Cambiar");
		cambiarButton.setDefaultButton(true);
		cambiarButton.setOnAction(e -> onCambioButtonAction(e));

		HBox cambioDivisaBox = new HBox(5, dineroTextField, divisaComboBox);
		cambioDivisaBox.setAlignment(Pos.CENTER);

		HBox cambioDivisaBox2 = new HBox(5, dineroTextField2, divisaComboBox2);
		cambioDivisaBox2.setAlignment(Pos.CENTER);

		HBox botonButton = new HBox(5, cambiarButton);
		botonButton.setAlignment(Pos.CENTER);

		VBox root = new VBox(5,cambioDivisaBox, cambioDivisaBox2, botonButton);
		root.setAlignment(Pos.CENTER);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("Cambio de Divisa");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void onCambioButtonAction(ActionEvent e) {

		String divisaCombo = divisaComboBox.getSelectionModel().getSelectedItem();
		String divisaCombo2 = divisaComboBox2.getSelectionModel().getSelectedItem();
		Double dineroAcambiar = Double.parseDouble(dineroTextField.getText());
		Double dineroAdevolver;
		
		Divisa euro = new Divisa("Euro", 1.0);
		Divisa libra = new Divisa("Libra", 0.8920);
		Divisa dolar = new Divisa("Dolar", 1.0958);
		Divisa yen = new Divisa("Yen", 117.31);

		switch (divisaCombo) {
		case "Euro":
			if (divisaCombo2 == "Dolar") {

				dineroAdevolver = Math.round(Divisa.fromTo(euro, dolar, dineroAcambiar)*100)/100d;
				dineroTextField2.setPromptText(dineroAdevolver.toString());
			}
			else if (divisaCombo2 == "Yen") {

				dineroAdevolver = Math.round(Divisa.fromTo(euro, yen, dineroAcambiar)*100)/100d;
				dineroTextField2.setPromptText(dineroAdevolver.toString());

			}
			else if (divisaCombo2 == "Libra") {

				dineroAdevolver = Math.round(Divisa.fromTo(euro, libra, dineroAcambiar)*100)/100d;
				dineroTextField2.setPromptText(dineroAdevolver.toString());

			}
			break;

		case "Dolar":
			if (divisaCombo2 == "Euro") {

				dineroAdevolver = Math.round(Divisa.fromTo(dolar, euro, dineroAcambiar)*100)/100d;
				dineroTextField2.setPromptText(dineroAdevolver.toString());

			}
			else if (divisaCombo2 == "Yen") {

				dineroAdevolver = Math.round(Divisa.fromTo(dolar, yen, dineroAcambiar)*100)/100d;
				dineroTextField2.setPromptText(dineroAdevolver.toString());

			}
			else if (divisaCombo2 == "Libra") {

				dineroAdevolver = Math.round(Divisa.fromTo(dolar, libra, dineroAcambiar)*100)/100d;
				dineroTextField2.setPromptText(dineroAdevolver.toString());

			}
			break;
			
		case "Yen":
			if (divisaCombo2 == "Euro") {

				dineroAdevolver = Math.round(Divisa.fromTo(yen, euro, dineroAcambiar)*100)/100d;
				dineroTextField2.setPromptText(dineroAdevolver.toString());

			}
			else if (divisaCombo2 == "Dolar") {

				dineroAdevolver = Math.round(Divisa.fromTo(yen, dolar, dineroAcambiar)*100)/100d;
				dineroTextField2.setPromptText(dineroAdevolver.toString());

			}
			else if (divisaCombo2 == "Libra") {

				dineroAdevolver = Math.round(Divisa.fromTo(yen, libra, dineroAcambiar)*100)/100d;
				dineroTextField2.setPromptText(dineroAdevolver.toString());


			}
			break;
			
		case "Libra":
			if (divisaCombo2 == "Euro") {

				dineroAdevolver = Math.round(Divisa.fromTo(libra, euro, dineroAcambiar)*100)/100d;
				dineroTextField2.setPromptText(dineroAdevolver.toString());


			}
			else if (divisaCombo2 == "Dolar") {

				dineroAdevolver = Math.round(Divisa.fromTo(libra, dolar, dineroAcambiar)*100)/100d;
				dineroTextField2.setPromptText(dineroAdevolver.toString());

			}
			else if (divisaCombo2 == "Yen") {

				dineroAdevolver = Math.round(Divisa.fromTo(libra, yen, dineroAcambiar)*100)/100d;
				dineroTextField2.setPromptText(dineroAdevolver.toString());

			}
			break;
		}

	}
	
	public static void main(String[] args) {
		launch(args);

	}

}