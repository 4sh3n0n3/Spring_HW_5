package ru.bagautdinov.fxcalc;

import ru.bagautdinov.beans.controllers.AppController;
import ru.bagautdinov.utils.SpringFXMLLoader;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Calculator");
		AppController ac = (AppController) SpringFXMLLoader.load("/fxml/calc.fxml");
		Scene scene = new Scene((Parent) ac.getView());
        stage.setScene(scene);
        stage.show();
	}
}
