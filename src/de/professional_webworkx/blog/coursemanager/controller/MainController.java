package de.professional_webworkx.blog.coursemanager.controller;

import java.net.URL;
import java.util.ResourceBundle;

import de.professional_webworkx.blog.coursemanager.model.Course;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
	private TextField priceTF;
	
	@FXML
	private TextArea descriptionTF;
	
	@FXML
	private ListView<Course> courseList;
	
	@Override
	public void initialize(URL location, ResourceBundle bundle) {
		
		resetBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				clearTextFields();
			}

		});
		
		courseList.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// here we have now to handle the mouse button, so only show
				// the popup which is not editable when PRIMARY Button 
				// was clicked
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					int selectedIndex 	= courseList.getSelectionModel().getSelectedIndex();
					Course course = courseList.getItems().get(selectedIndex);
					showPopup(course, false);
				}
			}
		});
		
		ContextMenu contextMenu 	= new ContextMenu();
		MenuItem editItem			= new MenuItem("Edit");
		
		/*
		 * we need the EventHandler on this
		 * menuitem not on the menu ;)
		 */
		editItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Course selectedCourse = courseList.getSelectionModel().getSelectedItem();
				showPopup(selectedCourse, true);
			}
		});
		contextMenu.getItems().add(editItem);
		courseList.setContextMenu(contextMenu);
	}
	
	
	private void showPopup(final Course course, final boolean editable) {
		Stage popupStage 	= new Stage();
		popupStage.setTitle("Course: " + course.getName());

		VBox root 			= new VBox();
		TextField courseName= new TextField(course.getName());
		courseName.setEditable(editable);

		TextArea description= new TextArea(course.getDescription());
		description.setEditable(editable);

		TextField price		= new TextField(course.getPrice() + "EUR");
		price.setEditable(editable);

		root.getChildren().addAll(courseName, description, price);
		Scene scene 		= new Scene(root, 648, 480);
		popupStage.setScene(scene);
		popupStage.show();
	}

	private void clearTextFields() {
		courseNameTF.clear();
		maxParticipantsTF.clear();
		priceTF.clear();
		descriptionTF.clear();
	}
	
	@FXML
	public void handleSaveButton(ActionEvent event) {
		String courseName = courseNameTF.getText();
		String priceText = priceTF.getText();
		String description = descriptionTF.getText();
		int maxParts = 0;
		try {
			maxParts = Integer.parseInt(maxParticipantsTF.getText());
			double price = Double.parseDouble(priceText);
			
			Course course = new Course(courseName, description, maxParts, price);
			courseList.getItems().add(course);
		}catch(NumberFormatException e) {
			maxParts = 10;
		}
		clearTextFields();
	}
}
