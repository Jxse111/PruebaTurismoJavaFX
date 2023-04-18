package org.iesalandalus.programacion.javafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class Main extends Application {
	Turismo turismo;
	
		private static final ObservableList<Turismo> TURISMOS = FXCollections.observableArrayList(
				new Turismo("Seat","Ibiza", 150, "ADC213"));
	@Override
	public void start(Stage escenarioPrincipal) {
		try {
			VBox raiz = new VBox();
			raiz.setPadding(new Insets(40));
			raiz.setSpacing(10);
			
			Label lbTurismo = new Label("Turismos:");
			TableView<Turismo> tvTurismo = new TableView<>();
			TableColumn<Turismo,String> columnaMarca = new TableColumn <>("Marca");
			TableColumn<Turismo,String> columnaModelo = new TableColumn <>("Modelo");
			TableColumn<Turismo,Integer> columnaCilindrada = new TableColumn <>("Cilindrada");
			TableColumn<Turismo,String> columnaMatricula = new TableColumn <>("Matricula");
			tvTurismo.getColumns().add(columnaMarca);
			tvTurismo.getColumns().add(columnaModelo);
			tvTurismo.getColumns().add(columnaCilindrada);
			tvTurismo.getColumns().add(columnaMatricula);
			tvTurismo.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			
			columnaMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
			columnaMarca.setMinWidth(100);
			columnaModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
			columnaModelo.setMinWidth(100);
			columnaCilindrada.setCellValueFactory(new PropertyValueFactory<>("cilindrada"));
			columnaCilindrada.setMinWidth(100);
			columnaMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
			columnaMatricula.setMinWidth(100);
			
			tvTurismo.setItems(TURISMOS);
			
			raiz.getChildren().addAll(lbTurismo,tvTurismo);
			Scene escena = new Scene(raiz,300,250);
			escenarioPrincipal.setTitle("Vista de lista");
			escenarioPrincipal.setScene(escena);
			escenarioPrincipal.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
