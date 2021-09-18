package controllers;

import java.io.IOException;	

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class PlacesToGoController {
	 
	 @FXML private HBox placesHbox;
	 
	 @FXML private VBox placesVbox;
	 
	 @FXML private WebView webView;
	 
	 @FXML
	 void placesParks(ActionEvent event) {
		 WebEngine engine = webView.getEngine();
		    engine.load("https://www.google.com/search?q=local+parks");
	 }
	 
	 @FXML
	 void placesTrails(ActionEvent event) {
		 WebEngine engine = webView.getEngine();
		    engine.load("https://www.google.com/search?q=local+trails");
	 }
	 
	 @FXML
	 void placesPsycologists(ActionEvent event) {
		 WebEngine engine = webView.getEngine();
		    engine.load("https://www.google.com/search?q=local+psychologist");
	 }
	 
	 @FXML
	 void placesCounselors(ActionEvent event) {
		 WebEngine engine = webView.getEngine();
		    engine.load("https://www.google.com/search?q=local+counselor");
	 }

	@FXML 
	void goBack(ActionEvent event) {
		try {
			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../views/Main.fxml"));
			//Load the view for the type of machine chosen
			AnchorPane center = (AnchorPane)root.getCenter();
			//Set the center of the border pane depending on the type of machine chosen
			root.setCenter(center);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../assets/styleSheets/application.css").toExternalForm());
			primaryStage.setTitle("Grounded");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(IOException e) {
			System.out.println(e.toString());
		}
	}
}
