package com.uniquindio.lenguaje.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Aplicacion extends Application{

	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/com/uniquindio/lenguaje/interfaces/InterfazSegundaria.fxml"));
        Scene scene = new Scene(root);
        root.setStyle("-fx-background-color: #FFFFFF");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}
	
}
