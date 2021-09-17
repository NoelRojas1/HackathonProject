package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainController {

    @FXML private Text appName;
    @FXML private ToggleGroup options;
    @FXML private Button btnStart, btnRandom;

    @FXML
    void startProgram(ActionEvent event) {
    	RadioButton selected = (RadioButton)options.getSelectedToggle();
    	String selection = selected.getText();
    	String fxmlFile = "";
    	
    	switch(selection) {
    	case "Option 1":
    		fxmlFile = "../views/GroundingList.fxml";
    		changeScreen(event, fxmlFile, "Grounding List");
    	}
    }

    @FXML
    void startProgramRandom(ActionEvent event) {

    }

    void changeScreen(ActionEvent event, String fxmlFile, String title) {
    	try {
			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../views/Main.fxml"));
			//Load the view for the type of machine chosen
			AnchorPane center = (AnchorPane)FXMLLoader.load(getClass().getResource(fxmlFile));
			//Set the center of the border pane depending on the type of machine chosen
			root.setCenter(center);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../assets/styleSheets/application.css").toExternalForm());
			primaryStage.setTitle(title);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(IOException e) {
			System.out.println(e.toString());
		}
    }
}
