package controllers;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
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
    	case "Grounding":
    		fxmlFile = "../views/GroundingList.fxml";
    		changeScreen(event, fxmlFile, "Grounding List");
    		break;
    	case "Articles":
    		fxmlFile = "../views/articles.fxml";
    		changeScreen(event, fxmlFile, "Article Links");
    		break;
    	case "Breathing":
    		fxmlFile = "../views/breathing.fxml";
    		changeScreen(event, fxmlFile, "Breathing Techniques");
    		break;
    	case "Music":
    		fxmlFile = "../views/music.fxml";
    		changeScreen(event, fxmlFile, "Music Player");
    		break;
    	}
    }

    @FXML
    void startProgramRandom(ActionEvent event) {

    }

    void changeScreen(ActionEvent event, String fxmlFile, String title) {
    	if(title.contains("Article")) {
    		final String[] captions = new String[] {
    			"Google",
    			"YouTube",
    			"Twitter",
    			"Phone"
    		};
    		
    		final String[] urls = new String[] {
    			"https://www.google.com",
    			"https://www.youtube.com",
    			"https://www.twitter.com",
    			"https://www.msn.com/en-us/news/politics/f-d-a-vaccine-panel-meeting-on-pfizer-booster-shots/ar-AAOxz5y?ocid=msedgntp"
    		};
    		
    		final Hyperlink[] hpls = new Hyperlink[captions.length];
    		
    		try {
				Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
				BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../views/Main.fxml"));
				//Load the view for the type of options chosen
				AnchorPane center = (AnchorPane)FXMLLoader.load(getClass().getResource(fxmlFile));
				
				final WebView browser = new WebView();
				final WebEngine webEngine = browser.getEngine();
				
				for(int i = 0; i < captions.length; i++) {
					final Hyperlink hpl = hpls[i] = new Hyperlink(captions[i]);
					hpl.setFont(Font.font("Arial", 14));
					final String url = urls[i];
					
					hpl.setOnAction((ActionEvent e) -> {
						webEngine.load(url);
					});
				}
				
				ObservableList<Node> children = center.getChildren();
				System.out.println(children);
				VBox vbox = (VBox)children.get(0);
				ObservableList<Node> vChildren = vbox.getChildren();
				HBox hbox = (HBox)vChildren.get(0);
				hbox.getChildren().addAll(hpls);
				
				vbox.getChildren().addAll(browser);
				
				root.setCenter(center);
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("../assets/styleSheets/application.css").toExternalForm());
				primaryStage.setTitle(title);
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(IOException e) {
				System.out.println(e.toString());
			}
    		
    	} else {
    		try {
				Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
				BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../views/Main.fxml"));
				//Load the view for the type of options chosen
				AnchorPane center = (AnchorPane)FXMLLoader.load(getClass().getResource(fxmlFile));
				//Set the center of the border pane depending on the type of options chosen
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
}
