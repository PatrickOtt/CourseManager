package de.professional_webworkx.blog.coursemanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		stage.setTitle("GUI Demo build with SceneBuilder");
		Parent parent 	= FXMLLoader.load(getClass().getResource("gui.fxml"));
		Scene scene 	= new Scene(parent);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
