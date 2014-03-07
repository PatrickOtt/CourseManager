package de.professional_webworkx.blog.coursemanager.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * This is our MainController class, 
 * here we initialize all components out of our
 * .fxml file and can set ActionLister for example..
 * If you want to get access to these components
 * you can use the @FXML annotation
 * 
 * @author ottp
 *
 */
public class MainController implements Initializable {

	@FXML
	private Button saveBtn;
	@FXML
	private Button resetBtn;
	
	// TextFields
	@FXML
	private TextField courseNameTF;
	
	@FXML
	private TextField maxParticipantsTF;
	
	@FXML
	private ListView<String> courseList;
	
	@Override
	public void initialize(URL location, ResourceBundle bundle) {
		
		resetBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				courseNameTF.clear();
				maxParticipantsTF.clear();
			}
		});
		
	}
	
	@FXML
	public void handleSaveButton(ActionEvent event) {
		System.out.println(courseNameTF.getText());
		int maxParts = 0;
		try {
			maxParts = Integer.parseInt(maxParticipantsTF.getText());
		}catch(NumberFormatException e) {
			maxParts = 10;
		}
		System.out.println(maxParts);
	}
}
